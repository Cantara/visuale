
function sortServicesByName(payload) {
  payload.sort(function(a, b) {
    const serviceA = a.name.toUpperCase();
    const serviceB = b.name.toUpperCase();
    return (serviceA < serviceB) ? -1 : (serviceA > serviceB) ? 1 : 0;
  });

}

export const state = () => ({
  services: {},

});
export const mutations = {
  setData (state, payload) {
   sortServicesByName(payload.services);
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
