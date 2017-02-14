var webpack = require('webpack')
var HtmlWebpackPlugin = require('html-webpack-plugin')
var CopyWebpackPlugin = require('copy-webpack-plugin')

const DEBUG = !(process.env.NODE_ENV === 'production')
const VERBOSE = process.argv.includes('--verbose')
const HOT_DEPLOY = !!process.env.HOT_DEPLOY
let CONTEXT_PATH = `${(process.env.CONTEXT_PATH || '')}`

module.exports = {
  context: __dirname + '/src/main/client',
  entry: {
    'js/bundle': [...(HOT_DEPLOY ? ['webpack-hot-middleware/client?path=/__webpack_hmr&timeout=20000&reload=true'] : []), './index.js']
  },
  output: {
    path: __dirname + '/src/main/resources/static',
    filename: 'assets/[name].js',
    publicPath: `${CONTEXT_PATH}/`
  },
  resolve: {
    extensions: ['.js', '.jsx']
  },
  devtool: DEBUG ? 'cheap-source-map' : false,
  plugins: [
    new webpack.DefinePlugin({
      'process.env.CONTEXT_PATH': `"${CONTEXT_PATH}"`,
      'process.env.NODE_ENV': `"${process.env.NODE_ENV || (DEBUG ? 'development' : 'production')}"` 
    }),
    ...(HOT_DEPLOY ? [new webpack.HotModuleReplacementPlugin()] : []),
    ...(DEBUG ? [] : [new webpack.optimize.AggressiveMergingPlugin(),
      new webpack.optimize.UglifyJsPlugin({ compress: { screw_ie8: true, warnings: VERBOSE } })
    ]),
    new HtmlWebpackPlugin({
      title: 'himawari',
      template: 'index.ejs'
    }),
    new CopyWebpackPlugin([
      { from: 'assets'}
    ])
  ],
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: ['babel-loader']
      },
      {
        test: /\.html$/,
        loader: 'file?name=[name].[ext]'
      }
    ]
  }
}
