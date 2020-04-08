import webpack from 'webpack'
export default {
  mode: 'spa',
  /*
  ** Headers of the page
  */
  head: {
    title: process.env.npm_package_name || '',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: process.env.npm_package_description || '' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
  },
  /*
  ** Customize the progress-bar color
  */
  loading:  false,
  /*
  ** Global CSS
  */
  css: [
    '@/assets/styles/main.scss'
  ],
  /*
  ** Plugins to load before mounting the App
  */
  plugins: [
    {  src: "@/plugins/filters.js"},
    {src:"@/plugins/plugins.js", ssr: false}
  ],

  /*
  ** Nuxt.js dev-modules
  */
  buildModules: [
    '@nuxtjs/fontawesome',
  ],
  /*
  ** Nuxt.js modules
  */
  modules: [
    // Doc: https://axios.nuxtjs.org/usage
    '@nuxtjs/axios',
    '@nuxtjs/proxy'
  ],
  /*
  ** Axios module configuration
  ** See https://axios.nuxtjs.org/options
  */
  axios: {
    baseURL:"http://localhost:8080",
    proxy:true,
  },
  proxy: {
    '/api/': { target: 'http://localhost:8080/', pathRewrite: {'^/api/': ''}, changeOrigin: true }
  },
  /*
  ** Build configuration
  */
  build: {
    plugins: [
      new webpack.ProvidePlugin({
        '_': 'lodash'
      })
    ],
    /*
    ** You can extend webpack config here
    */
    extend (config, ctx) {
    }
  }
}
