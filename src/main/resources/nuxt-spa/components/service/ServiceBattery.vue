<template>
    <div>
      <font-awesome-icon v-if="nodesLength >= 3" class="success" :icon="faBatteryFull"/>
      <font-awesome-icon v-else-if="nodesLength === 2" class="normal" :icon="faBatteryHalf"/>
      <font-awesome-icon v-else-if="nodesLength === 1" class="warning"  :icon="faBatteryQuarter"/>
      <font-awesome-icon v-else-if="nodesLength === 0" class="danger" :icon="faBatteryEmpty"/>
    </div>
</template>

<script>
  import {
    faBatteryQuarter,
    faBatteryEmpty,
    faBatteryHalf,
    faBatteryFull,
  } from '@fortawesome/free-solid-svg-icons'
    export default {
        name: "ServiceBattery",
      props:{
        healthy_nodes: {
          required: true,
          type: Number
        },
      },
      computed:{
          nodesLength(){
            return this.healthy_nodes;
          },
        faBatteryFull(){
          return faBatteryFull;
        },
        faBatteryHalf(){
          return faBatteryHalf;
        },
        faBatteryQuarter(){
          return faBatteryQuarter;
        },
        faBatteryEmpty(){
          return faBatteryEmpty;
        },
      }
    }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';
div {
  display: inline;
  font-size:1.2rem;
}
</style>
