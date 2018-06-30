module.exports = {
  env: {
    es6: true,
    node: true,
    browser: true
  },
  extends: ['eslint:recommended', 'plugin:react/recommended'],
  parser: 'babel-eslint',
  parserOptions: {
    ecmaFeatures: {
      experimentalObjectRestSpread: true,
      jsx: true
    },
    sourceType: 'module'
  },
  plugins: [
    'react'
  ],
  rules: {
    'linebreak-style': ['error', 'unix'],
    quotes: ['error', 'single'],
    semi: ['error', 'never'],
    'no-constant-condition': [0],
    indent: ['error', 2],
    'no-unused-vars': ['warn', { 'args': 'none' }],
    'keyword-spacing': ['error', { 'before': true, 'after': true }],
    'space-before-blocks': 'error',
    'key-spacing': ['error', { 'beforeColon': false }],
    'object-curly-spacing': ['error', 'always', {
      'arraysInObjects': false,
      'objectsInObjects': false
    }],
    'no-console': ['warn']
  }
}
