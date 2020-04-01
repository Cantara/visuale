import {ServicesMockData} from "../mock_data/ServicesMockData";


export const state = () => ({
  services: ServicesMockData(),

});
export const mutations = {
   setData (state, payload) {
   state.services = payload;
  }
};
export const getters = {
  sortedServices(state){
    const service = _.cloneDeep(state.services);
    service.services.sort(function(a, b) {
      const serviceA = a.name.toUpperCase();
      const serviceB = b.name.toUpperCase();
      return (serviceA < serviceB) ? -1 : (serviceA > serviceB) ? 1 : 0;
    });
    return service;
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
