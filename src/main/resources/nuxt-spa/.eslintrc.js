module.exports = {
  root: true,
  env: {
    browser: true,
    node: true,
    jest: true
  },
  parserOptions: {
    parser: "@babel/eslint-parser",
    sourceType: "module",
    buildModules: ['@nuxtjs/eslint-module'],
    requireConfigFile: false
  },
  extends: [
    '@nuxtjs',
    'plugin:nuxt/recommended'
  ],
  plugins: [
  ],
  // add your custom rules here
  rules: {
    "quotes": "off",
    "indent": "off",
    "key-spacing": "off",
    "semi": "off",
    "space-before-function-paren": "off",
    "no-trailing-spaces": "off",
    "no-multiple-empty-lines": "off",
    "comma-spacing":"off",
    "space-before-blocks": "off",
    "object-curly-spacing": "off",
    "comma-dangle": "off",
    "arrow-parens": "off",
    "quote-props":"off",
    "no-use-before-define": "off",
    "padded-blocks": "off",
    "no-multi-spaces": "off",
    "vue/no-unused-components": "warn",
    "spaced-comment": "off",
    "no-unused-vars":"warn",
    "brace-style": "off",
    "curly": "off",
    "vue/max-attributes-per-line": "off",
    "vue/html-indent": "off",
    'no-console': 'off',
    'vue/no-unused-vars':'warn',
    'camelcase':'off',
    'vue/return-in-computed-property':'warn',
    'no-useless-escape': 'off',
    'vue/html-self-closing': 'off',
    'no-mixed-operators': 'off',
    'vue/order-in-components': 'off',
    'vue/multi-word-component-names': 'off',

  }
}
