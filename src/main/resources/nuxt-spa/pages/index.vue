<template>
  <div id="dashboard">
    <h1 id="heading">{{services.name}}</h1>
    <PollingService></PollingService>
    <OnWindowResizeService></OnWindowResizeService>
    <div class="container" :style="dashboardHeight">
      <groupedServicesOverTag :grouped-services-over-tag="services.groupedServicesOverTag"></groupedServicesOverTag>
      <groupTagOverService :grouped-tag-over-service="services.groupedTagOverService" ></groupTagOverService>
      <Service :service-type-status="serviceType" :title="service.name" v-for="(service,index) in services.services" :key="index" :service="service"></Service>
    </div>
    <ServerExceptionHandling></ServerExceptionHandling>
  </div>
</template>

<script>
  import {mapState, mapGetters,mapMutations} from 'vuex';
  import Service from "../components/Service";
  import PollingService from "../components/PollingService";
  import OnWindowResizeService from "../components/OnWindowResizeService";
  import ServerExceptionHandling from "../components/serverExceptionHandling/ServerExceptionHandling";
import groupedServicesOverTag from "../components/groupedServicesOverTag";
  import GroupTagOverService from "../components/groupTagOverService";
  export default {

    components: {
      GroupTagOverService,
      Service,
      PollingService,
      OnWindowResizeService,
      ServerExceptionHandling,
      groupedServicesOverTag
    },
    computed: {
      ...mapState('layout', ['mobile']),
      ...mapState(['serviceType']),
      ...mapGetters({
        dashboardContainerHeight: 'layout/dashboardContainerHeight',
        services: 'getServices',
      }),
      dashboardHeight() {
        if (!this.mobile)
          return {
            'height': this.dashboardContainerHeight + 'px',
          };
      }
    },
    methods:{
      ...mapMutations({
        setToken: 'auth/setToken',
        setStrategy: 'setStrategy',
        setServiceType: 'setServiceType'
      })
    },
    created(){
      let params = this.$route.query;
      for (const key of Object.keys(params)) {
        const keyValue = params[key];
        if(keyValue !== null && keyValue.length > 0)
        {
          if(key.toLowerCase() === 'accesstoken')
            this.setToken(keyValue);
          if(key.toLowerCase() === 'ui_extension')
            this.setStrategy(keyValue);
          if(key.toLowerCase() === 'servicetype')
            this.setServiceType(keyValue === 'true');
        }
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';

  @media only screen and (min-width: 991px) {
    #dashboard {
      min-height: 100vh;
      overflow-x: auto;
    }
  }
  @media only screen and (max-width: 990px) {
    #dashboard {
      text-align: center;
      overflow-y:auto;
      height:100vh;
    }
  }
  .container {
    margin: 0 auto;
    display: inline-flex;
    max-width: 100vw;
    flex-flow: column wrap;
    padding: 0 0.7em 0.7em;
  }
  h1 {
    padding: 0.35em 0.7em;
    height: 2em;
    color: $color--description;
    display: inline-block;
  }
</style>
