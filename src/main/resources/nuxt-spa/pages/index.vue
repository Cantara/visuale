<template>
  <div id="dashboard" :class="isMobile ? '' : 'desktop-dashboard'">

    <h1 id="heading">{{services.name}}</h1>
    <PollingService></PollingService>
    <OnWindowResizeService></OnWindowResizeService>
    <div class="container" :style="dashboardHeight">
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
    ...mapState('layout', ['mobile']),
    ...mapGetters({
      dashboardContainerHeight: 'layout/dashboardContainerHeight',
      services: 'sortedServices',
    }),
    isMobile(){
      return this.mobile;
    },
    dashboardHeight () {
      if(!this.mobile)
        return {
        'height': this.dashboardContainerHeight + 'px',
      };
      return {
        'padding-top': '2em',
      }

    }
  }
}
</script>

<style lang="scss" scoped >
  @import '~/assets/styles/variables/_variables.scss';
  #dashboard{

  }
  .desktop-dashboard {
    min-height: 100vh;
  }
.container {
  margin: 0 auto;
  display: inline-flex;
  max-width: 100vw;
  flex-flow: column wrap;
  padding: 0 0.7em 0.7em;
}
  h1{
    padding: 0.35em 0.7em;
    height:2em;
    color: $color--description;
  }
</style>
