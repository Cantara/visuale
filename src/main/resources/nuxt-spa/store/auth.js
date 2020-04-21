export const state = () => ({
  authToken: ''
});

export const mutations = {
  setToken (state, token) {
    state.authToken = token;
  },
};
