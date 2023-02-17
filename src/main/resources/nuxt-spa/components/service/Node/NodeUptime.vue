<template>
  <span>{{ getRunningSince }}
    <font-awesome-icon v-if="isGasPumpActive" class="warning" :icon="faGasPump"/>
  </span>
</template>

<script>
import {faGasPump, faPowerOff} from '@fortawesome/free-solid-svg-icons'
import {isNullOrUndefined} from "../../../utils/typeUtils";

export default {
  name: "NodeUptime",
  props: {
    health: {
      required: true,
      type: Object | undefined
    },
    shorten: {
      required: false,
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      runningSince: null,
      timer: null,
      minutesSince: 0
    }
  },
  computed: {
    faGasPump() {
      return faGasPump;
    },
    getRunningSince() {
      if (isNullOrUndefined(this.health))
        return 'missing';
      if (!this.health.hasOwnProperty('running_since'))
        return 'missing';
      if (this.minutesSince < 60)
        // small m since it means minutes, Uppercase M means Months
        return this.minutesSince + (this.shorten ? 'm' : ' Minutes');
      if (this.minutesSince < 1440)
        return Math.floor(this.minutesSince / 60) + (this.shorten ? 'H' : ' Hours');
      // less than 30 days -> show in days
      if (this.minutesSince < 1440 * 30)
        return Math.floor(this.minutesSince / 60 / 24) + (this.shorten ? 'D' : ' Days');
      // less than 100 days -> show in weeks
      if (this.minutesSince < 1440 * 100)
        return Math.floor(this.minutesSince / 60 / 24 / 7) + (this.shorten ? 'W' : ' Weeks');
      // more or equal 100 days -> show in months
      // TODO for enhanced fun calculate real months by subtracting from "now"
      if (this.minutesSince < 1440 * 365)
        return Math.floor(this.minutesSince / 60 / 24 / 30) + (this.shorten ? 'M' : ' Months');
      // more or equal 365 days -> show in years
      if (this.minutesSince >= 1440 * 365)
        return (this.minutesSince / 60 / 24 / 365).toFixed(1) + (this.shorten ? 'Y' : ' Years');
    },
    isGasPumpActive() {
      return (this.minutesSince > 10080)
    },
  },
  methods: {
    startTimer() {
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
  beforeDestroy() {
    clearInterval(this.timer)
  }

}
</script>
<style scoped>
span {
  color: white;
}
</style>
