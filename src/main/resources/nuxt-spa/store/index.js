import {ServicesMockData} from "../mock_data/ServicesMockData";


export const state = () => ({
  services: {},
  connectionFailedIntervals: 0

});
export const mutations = {
   setData (state, payload) {
   state.services = payload;
  },
  incrementConnectionFailed(state){
     state.connectionFailedIntervals++;
  },
  resetConnectionFailed(state){
     state.connectionFailedIntervals = 0;
  }
};
export const getters = {
  sortedServices(state){
    if(state.services.services === undefined)
      return {services:[]};
    const service = _.cloneDeep(state.services);
    service.services.sort(function(a, b) {
      const serviceA = a.name.toUpperCase();
      const serviceB = b.name.toUpperCase();
      return (serviceA < serviceB) ? -1 : (serviceA > serviceB) ? 1 : 0;
    });
    return service;
  },
  connectionFailed(state){
    return state.connectionFailedIntervals >= 5
  }
};
export const actions ={
  async fetchData({commit}) {

    return await this.$axios.$get('/api/status').then((response) => {
      commit('setData', response);
      commit('resetConnectionFailed');
      return response;
    }).catch(function (error) {
        if (error.response) {
          if(error.response.status === 504)
            commit('incrementConnectionFailed');
          //server responded
        } else {
          // no response was received
          console.log(error.request);
          commit('incrementConnectionFailed');
        }
      });
  }
};
