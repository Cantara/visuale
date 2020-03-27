<template>
  <div class="container">
    <Service v-for="(service,index) in services.services" :key="index" :service="service"></Service>
  </div>
</template>

<script>
import {mapState} from 'vuex';
import Service from "../components/Service";
export default {

  components: {
    Service
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
  justify-content: center;
  align-items: center;
  text-align: center;
}
</style>
