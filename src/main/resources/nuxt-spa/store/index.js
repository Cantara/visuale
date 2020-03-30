import {ServicesMockData} from "../mock_data/ServicesMockData";

export const state = () => ({
  services: ServicesMockData(),

});
export const mutations = {
  setData (state, payload) {
    state.services = payload;
  }
};
export const actions ={
  async fetchData({commit}) {
    return await this.$axios.$get('/status').then((response) => {
      commit ('setData', response);
      return response;
    })
      .catch (error => {
        console.log(error);
        return error.response.data;
      });
  }
};
