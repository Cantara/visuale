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
  display: grid;
  grid-template-columns: repeat(8, 1fr);
  grid-template-rows: repeat(4, 1fr);
  grid-gap: 2em;
  grid-auto-flow: dense;
  padding: 2em;
  height:100vh;
}
</style>
