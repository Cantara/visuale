<template>
  <div id="dashboard">
    <h1 id="heading">{{services.name}}</h1>
    <PollingService></PollingService>
    <OnWindowResizeService></OnWindowResizeService>
    <div class="container" :style="dashboardHeight">
      <Service v-for="(service,index) in services.services" :key="index" :service="service"></Service>
    </div>
    <ServerExceptionHandling></ServerExceptionHandling>
  </div>
</template>

<script>
  import {mapState, mapGetters} from 'vuex';
  import Service from "../components/Service";
  import PollingService from "../components/PollingService";
  import OnWindowResizeService from "../components/OnWindowResizeService";
  import ServerExceptionHandling from "../components/serverExceptionHandling/ServerExceptionHandling";

  export default {

    components: {
      Service,
      PollingService,
      OnWindowResizeService,
      ServerExceptionHandling
    },
    computed: {
      ...mapState('layout', ['mobile']),
      ...mapGetters({
        dashboardContainerHeight: 'layout/dashboardContainerHeight',
        services: 'sortedServices',
      }),
      dashboardHeight() {
        if (!this.mobile)
          return {
            'height': this.dashboardContainerHeight + 'px',
          };
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';

  @media only screen and (min-width: 991px) {
    #dashboard {
      min-height: 100vh;
    }
  }

  .container {
    margin: 0 auto;
    display: inline-flex;
    max-width: 100vw;
    flex-flow: column wrap;
    padding: 0 0.7em 0.7em;
  }

  @media only screen and (min-width: 990px) {
    .container {
      padding-top: 1em;
    }
  }
  h1 {
    padding: 0.35em 0.7em;
    height: 2em;
    color: $color--description;
  }
</style>
