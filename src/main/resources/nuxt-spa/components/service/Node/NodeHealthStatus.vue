<template>
  <font-awesome-icon :class="healthy ? 'healthy' : 'unhealthy'" :icon="healthy ? faSeedling : faHeartBroken"/>
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
