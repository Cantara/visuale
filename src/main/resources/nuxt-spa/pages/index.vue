<template>
  <div>
    <PollingService></PollingService>
    <div class="container">
      <Service v-for="(service,index) in services.services" :key="index" :service="service"></Service>
    </div>
  </div>

</template>

<script>
import {mapState} from 'vuex';
import Service from "../components/Service";
import PollingService from "../components/PollingService";
export default {

  components: {
    Service,
    PollingService
  },
  computed:{
    ...mapState(['services'])
  }
}
</script>

<style>
.container {
  margin: 0 auto;
  min-height: 100vh;
  display: flex;
  flex-flow: column wrap;
  padding: 1em;
  height:100vh;
}
</style>
