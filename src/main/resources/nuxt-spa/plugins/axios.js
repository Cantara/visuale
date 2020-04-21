
  export default function ({ $axios, redirect }) {
  $axios.onRequest(config => {
    config.params = config.params || {};
    config.params['accessToken'] = process.env.accessToken;
    return config;
  })
}
