
  export default function ({store, $axios}) {
  $axios.onRequest(config => {
    config.params = config.params || {};
    let authToken = store.state.auth.authToken;

    if (authToken !== null && authToken.length > 0)
      config.params['accessToken'] = authToken;
    return config;
  })
}
