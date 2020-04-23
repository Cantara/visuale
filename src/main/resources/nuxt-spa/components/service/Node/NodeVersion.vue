<template>
<span>{{getVersion| truncateText(textLength)}}</span>
</template>

<script>
    export default {
        name: "NodeVersion",
      props: {
          health: {
            required:true,
            type: Object
          },
        textLength: {
            required:true,
            type: Number
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
