<template>
    <div>
      <font-awesome-icon v-if="isPowerOffActive" class="healthy"  :icon="faPowerOff"/>
      <font-awesome-icon v-else :class="trafficStatus" :icon="faCircle"/>
    </div>
</template>

<script>
  import {
    faCircle,
    faPowerOff
  } from '@fortawesome/free-solid-svg-icons'
    export default {
        name: "NodeTrafficLight",
      props:{
        node: {
          required: true,
          type: Object
        },
      },
      data(){
          return{
            runningSince: null,
            timer: null,
            minutesSince :0
          }
      },
      computed:{
        faCircle(){
          return faCircle;
        },
        faPowerOff(){
          return faPowerOff;
        },
        isPowerOffActive(){
          return (this.minutesSince < 10)
        },
        health(){
          return this.node.health[0];
        },
        trafficStatus(){
          if(this.node.is_healthy && !this.node.is_unstable)
            return 'success';
         if(this.node.is_healthy && this.node.is_unstable)
            return 'warning';
         if(!this.node.is_healthy)
            return 'danger';
        }
      },
      methods: {
        startTimer () {
          this.minutesSince = this.calculateMinuteSince(this.runningSince);
          this.timer = setInterval(() => {
            this.minutesSince = this.calculateMinuteSince(this.runningSince)
          }, 60000)
        },
        calculateMinuteSince(runningSince) {
          let d1 = new Date();
          let d2 = new Date(runningSince);
          return Math.floor((d1 - d2) / (1000 * 60));
        }
      },
      mounted: function () {
        this.runningSince = this.health['running_since'];
        this.startTimer();
      },
      watch: {
        health: {
          handler() {
            this.runningSince = this.health['running_since'];
          },
          deep: true
        }
      },
      beforeDestroy () {
        clearInterval(this.timer)
      }
    }
</script>

<style scoped>
  div {
    font-size:0.7rem;
  }
</style>
