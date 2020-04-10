<template>
    <div></div>
</template>
<script>
  import { mapActions } from 'vuex'
  import {pollingIntervalInMilliseconds} from "../preferences";

  export default {
        name: "PollingService",
      data() {
        return {
          polling: null,
          interval: pollingIntervalInMilliseconds(),
        }
      },
      methods: {
        startAutoPoller () {
          this.fetchData();
          this.polling = setInterval(() => {
            this.fetchData();
          }, this.interval)
        },
        ...mapActions([
          'fetchData'
        ]),
      },
      beforeDestroy () {
        clearInterval(this.polling)
      },
      created () {
        this.startAutoPoller();
      }
    }
</script>

<style scoped>

</style>
