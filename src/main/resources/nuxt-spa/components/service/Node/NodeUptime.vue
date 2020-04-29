<template>
  <span>{{getRunningSince}} <font-awesome-icon v-if="isGasPumpActive" class="warning"  :icon="faGasPump"/></span>
</template>

<script>
  import { faGasPump } from '@fortawesome/free-solid-svg-icons'
  import {isNullOrUndefined} from "../../../utils/typeUtils";

  export default {
    name: "NodeUptime",
    props: {
      health: {
        required: true,
        type: Object | undefined
      },
      shorten: {
        required:false,
        type:Boolean,
        default:false
      }
    },
    data() {
      return {
        runningSince: null,
        timer: null,
        minutesSince :0
      }
    },
    computed: {
      faGasPump(){
        return faGasPump;
      },
      getRunningSince() {
        if(isNullOrUndefined(this.health))
          return 'missing';
        if(!this.health.hasOwnProperty('running since'))
          return 'missing';
        if(this.minutesSince < 60)
          //small m since  it means minutes, Uppercase M means Months
          return this.minutesSince +  (this.shorten ? 'm' :' Minutes');
        if(this.minutesSince < 1440)
          return Math.floor(this.minutesSince / 60) + (this.shorten ? 'H' : ' Hours');
        if(this.minutesSince < 144000)
          return Math.floor(this.minutesSince / 60 / 24) + (this.shorten ? 'D' : ' Days');
        if(this.minutesSince >= 144000)
          return Math.floor(this.minutesSince / 60 / 24 / 7) + (this.shorten ? 'W' : ' Weeks');
      },
      isGasPumpActive(){
        return (this.minutesSince > 10080)
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
      this.startTimer();
    },
    watch: {
      health: {
        handler() {
          this.runningSince = this.health['running since'];
        },
        deep: true,
        immediate:true
      }
    },
    beforeDestroy () {
      clearInterval(this.timer)
    }

  }
</script>
<style scoped>
  span {
    color:white;
  }
</style>
