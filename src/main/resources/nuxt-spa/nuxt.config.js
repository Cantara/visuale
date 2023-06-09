export default {
  ssr:false,
  target:'static',
  // router: {
  //   base: '/appsss/'
  // },
  /*
  ** Headers of the page
  */
  router: {
    middleware: 'query-parameters'
  },
  head: {
    title: process.env.npm_package_name || '',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: process.env.npm_package_description || '' },
      {'http-equiv': "refresh", content:"1800"}
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ],
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
    {src:"@/plugins/plugins.js", ssr: false},
    {src:"@/plugins/axios.js"}
  ],
  /*
  ** Nuxt.js dev-modules
  */
  buildModules: [
    '@nuxtjs/fontawesome',
    "@nuxtjs/style-resources",
  ],
  /*
  ** Nuxt.js modules
  */
  modules: [
    // Doc: https://axios.nuxtjs.org/usage
    '@nuxtjs/axios',
    '@nuxtjs/proxy',

  ],

  styleResources: {
    scss: [
      "~assets/styles/variables/_variables.scss",
    ]
  },
  /*
  ** Axios module configuration
  ** See https://axios.nuxtjs.org/options
  */
  axios: {
    baseURL:"https://visuale.cantara.no/",
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

    ],
    postcss: {
      preset: {
        autoprefixer: {
          grid: true
        },
        features: {
          "custom-properties": false
        }
      }
    },
    babel: {
      presets(env, [preset, options]) {
        return [
          ["@babel/preset-env", {
            ...options,
            useBuiltIns: "usage"
          }]
        ]
      }
    },
    /*
    ** You can extend webpack config here
    */
    extend (config, ctx) {
    }
  }
}
