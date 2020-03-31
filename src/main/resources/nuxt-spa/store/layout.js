export const state = () => ({
  windowHeight:window.innerHeight,

});
export const mutations = {
  setWindowHeight (state, payload) {
    state.windowHeight = payload;
  }
};
