<template>
    <Modal v-bind:close-disabled="true" v-if="connectionFailed" title="Connection to server is lost... attempting to reconnect"></Modal>
</template>

<script>
  import Modal from "../Modal";
  import {mapGetters} from 'vuex';
    export default {
        name: "ServerExceptionHandling",
      components:{
          Modal
      },
      computed:{
        ...mapGetters(['connectionFailed']),
      }
    }
</script>

<style scoped>

</style>
