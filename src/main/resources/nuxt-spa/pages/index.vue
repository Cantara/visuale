<template>
  <div class="dashboard">
    <h1>{{services.name}}</h1>
    <PollingService></PollingService>
    <OnWindowResizeService></OnWindowResizeService>
    <div class="container">
      <Service v-for="(service,index) in services.services" :key="index" :service="service"></Service>
    </div>
  </div>

</template>

<script>
import {mapState} from 'vuex';
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
    ...mapState(['services'])
  }
}
</script>

<style lang="scss" scoped >
  @import '~/assets/styles/variables/_variables.scss';
  .dashboard{
    min-height: 100vh;
  }
.container {
  margin: 0 auto;
  display: flex;
  flex-flow: column wrap;
  padding: 0 1em 1em;
  height:100%;
}
  h1{
    padding: 0.25em 1em;
    color: $color--description;
  }
</style>
