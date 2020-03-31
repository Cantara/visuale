
export const state = () => ({
  services: {},

});
export const mutations = {
  setData (state, payload) {
    state.services = payload;
  }
};
export const actions ={
  async fetchData({commit}) {

    return await this.$axios.$get('/api/status').then((response) => {
      commit ('setData', response);
      return response;
    })
      .catch (error => {
        console.log(error);
        return error.response.data;
      });
  }
};
