export const state = () => ({
  windowHeight: window.innerHeight,
  headingHeight: 0,
});
export const mutations = {
  setWindowHeight(state, payload) {
    state.windowHeight = payload;
  },
  setHeadingHeight(state, payload) {
    state.headingHeight = payload;
  }
};
export const getters = {
  dashboardContainerHeight: state => {
    return state.windowHeight - state.headingHeight;
  }
};
