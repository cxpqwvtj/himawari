// const path = require('path')
const webpack = require('webpack')
const HtmlWebpackPlugin = require('html-webpack-plugin')
const CopyWebpackPlugin = require('copy-webpack-plugin')

const DEBUG = !(process.env.NODE_ENV === 'production')
// const VERBOSE = process.argv.includes('--verbose')
const HOT_DEPLOY = !!process.env.HOT_DEPLOY
let CONTEXT_PATH = `${(process.env.CONTEXT_PATH || '')}`

const hotMiddlewareScript = 'webpack-hot-middleware/client?path=/__webpack_hmr&timeout=20000&reload=true'

module.exports = {
  mode: DEBUG ? 'development' : 'production',
  context: __dirname + '/web/src/main/client',
  entry: {
    'js/bundle': [...(HOT_DEPLOY ? [hotMiddlewareScript] : []), './index.js']
  },
  output: {
    path: __dirname + '/web/src/main/resources/static',
    filename: 'assets/[name].js',
    publicPath: ''
  },
  resolve: {
    extensions: ['.js', '.jsx']
  },
  devtool: DEBUG ? 'inline-source-map' : false,
  plugins: [
    new webpack.DefinePlugin({
      'process.env.CONTEXT_PATH': `"${CONTEXT_PATH}"`,
      'process.env.NODE_ENV': `"${process.env.NODE_ENV || (DEBUG ? 'development' : 'production')}"` 
    }),
    ...(HOT_DEPLOY ? [new webpack.HotModuleReplacementPlugin()] : []),
    ...(DEBUG ? [] : [new webpack.optimize.AggressiveMergingPlugin()]),
    new HtmlWebpackPlugin({
      title: 'himawari',
      template: 'index.ejs',
      filename: '../templates/index.html'
    }),
    new CopyWebpackPlugin([
      { from: 'assets' }
    ])
  ],
  optimization: {
    splitChunks: {
      cacheGroups: {
        commons: {
          test: /node_modules/,
          name: 'js/vendor',
          chunks: 'all',
          minSize: 1
        }
      },
    },
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: ['babel-loader']
      },
      {
        test: /\.js|jsx$/,
        exclude: /(node_modules)/,
        loader: 'eslint-loader',
        options: {
          failOnError: true
        }
      },
      {
        test: /\.ejs$/,
        loader: 'ejs-loader'
      }
    ]
  }
}
