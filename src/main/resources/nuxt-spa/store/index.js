import {randomMockData} from "../mock_data/ServicesMockData";
import isEqual from "lodash/isEqual"
import cloneDeep from "lodash/cloneDeep"
import {sortServices, addUniqueKeyToNodes} from "../utils/serviceUtils";

export const state = () => ({
  services: {},
  connectionFailedIntervals: 0,
});
export const mutations = {
  setData(state, payload) {
    // if(isEqual(state.services,payload) === false)
    state.services = payload;
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
    const service = cloneDeep(state.services);
    sortServices(service.services);
    //addUniqueKeyToNodes(service.services);
    return service;
  },
  connectionFailed(state) {
    return state.connectionFailedIntervals >= 5
  }
};
export const actions = {
  async fetchData({commit}) {
    if (process.env.NODE_ENV === "development")
    {
     let response =  randomMockData();
      commit('setData', response);
      return response;
    }

    return await this.$axios.$get('/api/status/').then((response) => {
      commit('setData', response);
      commit('resetConnectionFailed');
      return response;
    }).catch(function (error) {
      if (error.response) {
        if (error.response.status === 504)
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
