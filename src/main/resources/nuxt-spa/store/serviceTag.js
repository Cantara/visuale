export const state = () => ({
  tagStrategy: ''
});

export const mutations = {
  setStrategy (state, strategy) {
    state.tagStrategy = strategy;
  },
};
