<template>
  <div id="dashboard">
    <h1 id="heading">{{services.name}}</h1>
    <PollingService></PollingService>
    <OnWindowResizeService></OnWindowResizeService>
    <div class="container" :style="{ height:dashboardContainerHeight+ 'px'}">
      <Service v-for="(service,index) in services.services" :key="index" :service="service"></Service>
    </div>
  </div>

</template>

<script>
import {mapState,mapGetters} from 'vuex';
import Service from "../components/Service";
import PollingService from "../components/PollingService";
import OnWindowResizeService from "../components/OnWindowResizeService";
export default {

  components: {
    Service,
    PollingService,
    OnWindowResizeService
  },
  computed:{
    ...mapState(['services']),
    ...mapGetters({
      dashboardContainerHeight: 'layout/dashboardContainerHeight',
    }),
  }
}
</script>

<style lang="scss" scoped >
  @import '~/assets/styles/variables/_variables.scss';
  #dashboard{
    min-height: 100vh;
  }
.container {
  margin: 0 auto;
  display: flex;
  flex-flow: column wrap;
  padding: 0 1em 1em;
}
  h1{
    padding: 0.25em 1em;
    height: 2em;
    color: $color--description;
  }
</style>
