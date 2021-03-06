export default {
  // Global page headers (https://go.nuxtjs.dev/config-head)
  head: {
    title: 'default-nuxt-project',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
  },

  // Global CSS (https://go.nuxtjs.dev/config-css)
  css: [
    'element-ui/lib/theme-chalk/index.css',
    'view-design/dist/styles/iview.css',
    'element-tiptap/lib/index.css',

],

  // Plugins to run before rendering page (https://go.nuxtjs.dev/config-plugins)
  plugins: [
    {src:'@/plugins/element-ui',ssr:true},
    {src:'@/plugins/iview-ui',ssr:true},
    {src:'@/plugins/vue-lazy-load',ssr:false},
    {src:'@/plugins/element-tiptap',ssr:false},
    {src:'@/plugins/js-cookie',ssr:false},
  ],

  // Auto import components (https://go.nuxtjs.dev/config-components)
  components: true,
  router: {
    middleware: ['metaTitle'],
  },

  // Modules for dev and build (recommended) (https://go.nuxtjs.dev/config-modules)
  buildModules: [
    // https://go.nuxtjs.dev/eslint
    // '@nuxtjs/eslint-module'
  ],

  // Modules (https://go.nuxtjs.dev/config-modules)
  modules: [
    // https://go.nuxtjs.dev/axios
    '@nuxtjs/axios'
  ],

  // Axios module configuration (https://go.nuxtjs.dev/config-axios)
  axios: {},

  // Build Configuration (https://go.nuxtjs.dev/config-build)
  build: {
    transpile: [/^element-ui/,/^iview-ui/,/^element-tiptap/]
  }

}
