<template>
<span>{{getVersion| truncateText(15)}}</span>
</template>

<script>
    export default {
        name: "NodeVersion",
      props: {
          health: {
            required:true,
            type: Object
          }
      },
      computed: {
          getVersion(){
            return this.health.hasOwnProperty('version') ? this.health.version : 'missing';
          }
      }
    }
</script>

<style scoped>

</style>
