export const state = () => ({
  windowHeight: window.innerHeight,
  headingHeight: 0,
  headingPaddingBottom:0,
  mobile: false,
});
export const mutations = {
  setWindowHeight(state, payload) {
    state.windowHeight = payload;
  },
  setHeadingHeight(state, payload) {
    state.headingHeight = payload;
  },
  setHeadingPaddingBottom(state,payload){
    state.headingPaddingBottom = payload;
  },
  changeMobileState(state, payload)
  {
    state.mobile = payload;
  }
};
export const getters = {
  dashboardContainerHeight: state => {
    return state.windowHeight - (state.headingHeight+ state.headingPaddingBottom);
  }
};
