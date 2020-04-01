<template>
    <div>
      <font-awesome-icon  :class="trafficStatus" :icon="faCircle"/>
    </div>
</template>

<script>
  import {
    faCircle
  } from '@fortawesome/free-solid-svg-icons'
    export default {
        name: "NodeTrafficLight",
      props:{
        node: {
          required: true,
          type: Object
        },
      },
      computed:{
        faCircle(){
          return faCircle;
        },
        trafficStatus(){
          if(this.node.is_healthy && !this.node.is_unstable)
          {
            return 'success';
          }
         if(this.node.is_healthy && this.node.is_unstable)
            return 'warning';
         if(!this.node.is_healthy)
          {
            console.log('danger');
            return 'danger';
          }

        }
      }
    }
</script>

<style scoped>
  div {
    display: inline;
    font-size:1rem;
  }
</style>
