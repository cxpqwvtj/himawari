var webpack = require('webpack')
var webpackDevMiddleware = require('webpack-dev-middleware')
var webpackHotMiddleware = require('webpack-hot-middleware')
var proxy = require('http-proxy-middleware')
var config = require('../../../webpack.config')
var moment = require('moment')
var clearConsole = require('react-dev-utils/clearConsole')
var openBrowser = require('react-dev-utils/openBrowser')
var isInteractive = process.stdout.isTTY

const LOG_DATE_FORMAT = 'YYYY-MM-DD HH:mm:ss.SSS'

var app = new (require('express'))()
var port = 3000

var compiler = webpack(config)
app.use(webpackDevMiddleware(compiler, { noInfo: true, publicPath: config.output.publicPath }))
app.use(webpackHotMiddleware(compiler))
if (process.env.USE_PROXY === 'false') {
  app.post('/api/trail/create', function(req, res) {
    console.log(`${moment().format(LOG_DATE_FORMAT)} [${(req.method + '    ').slice(0, 4)}] ${req.url}`) // eslint-disable-line no-console
    //res.status(500)
    res.json({})
  })
  app.get('/api*', function(req, res) {
    console.log(`${moment().format(LOG_DATE_FORMAT)} [${(req.method + '    ').slice(0, 4)}] ${req.url}`) // eslint-disable-line no-console
    res.json({})
    //res.json({error: {message: 'エラーです'}})
  })
  app.post('/api*', function(req, res) {
    console.log(`${moment().format(LOG_DATE_FORMAT)} [${(req.method + '    ').slice(0, 4)}] ${req.url}`) // eslint-disable-line no-console
    res.json({})
  })
} else {
  const appSrv = proxy({target: 'http://localhost:8080', changeOrigin: false})
  app.use('/api', appSrv)
  app.use('/login', appSrv)
  app.use('/logout', appSrv)
}

app.get('/**', function(req, res) {
  console.log(`${moment().format(LOG_DATE_FORMAT)} [${(req.method + '    ').slice(0, 4)}] ${req.url}`) // eslint-disable-line no-console
  res.setHeader('Content-Type', 'text/html')
  res.send(compiler.outputFileSystem.readFileSync(compiler.outputPath + '/index.html'))
})

app.listen(port, function(error) {
  if (error) {
    console.error(error) // eslint-disable-line no-console
  } else {
    clearConsole()
    console.info('==> 🌎  Listening on port %s. Open up http://localhost:%s/ in your browser.', port, port) // eslint-disable-line no-console
    if (isInteractive) {
      openBrowser(`http://localhost:${port}/`)
    }
  }
})