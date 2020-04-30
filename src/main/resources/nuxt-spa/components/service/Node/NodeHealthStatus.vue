<template>
  <span>
    <font-awesome-icon v-if="healthy" class="healthy" :icon="faSeedling"/>
    <font-awesome-icon v-else class="unhealthy" :icon="faHeartBroken"/>
  </span>
</template>

<script>
  import {
    faSeedling,
    faHeartBroken
  } from '@fortawesome/free-solid-svg-icons'
    export default {
        name: "NodeHealthStatus",
      props: {
          healthy:{
            required:false,
            type:Boolean
          }
      },
      computed:{
        faSeedling(){
            return faSeedling;
        },
        faHeartBroken(){
          return faHeartBroken
        }
      }
    }
</script>

<style scoped>

</style>
