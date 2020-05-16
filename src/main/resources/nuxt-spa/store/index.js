import {randomMockData} from "../mock_data/ServicesMockData";
import {sortingManager} from '../services/sortingManager';
export const state = () => ({
  services: {},
  connectionFailedIntervals: 0,
  tagStrategy: '',
  serviceType: false,
  environment: process.env.NODE_ENV,
});
export const mutations = {
  setStrategy (state, strategy) {
    state.tagStrategy = strategy;
  },
  setData(state, payload) {
    state.services = payload;
  },
  setServiceType(state,payload){
    state.serviceType = payload;
  },
  incrementConnectionFailed(state) {
    state.connectionFailedIntervals++;
  },
  resetConnectionFailed(state) {
    state.connectionFailedIntervals = 0;
  }
};
export const getters = {
  getServices(state) {
    if (state.services.services === undefined)
      return {services: []};
    return sortingManager(state.tagStrategy,state.services);
  },
  connectionFailed(state) {
    return state.connectionFailedIntervals >= 5
  }
};
export const actions = {
  async fetchData({commit,state}) {
    if (state.environment=== "development")
    {
     let response =  randomMockData();
      commit('setData', response);
      return response;
    }
    return await this.$axios.$get('/api/status/').then((response) => {
      commit('setData', response);
      return response;
    }).catch(function (error) {
      if (error.response) {
        if (error.response.status === 504)
          commit('incrementConnectionFailed');
      } else {
        console.log(error.request);
        commit('incrementConnectionFailed');
      }
    });
  }
};
