<template>
<span>{{getVersion| truncateText(textLength)}}</span>
</template>

<script>
 import {isNullOrUndefined} from "../../../utils/typeUtils";

 export default {
        name: "NodeVersion",
      props: {
          health: {
            required:true,
            type: Object | undefined
          },
        textLength: {
            required:true,
            type: Number
        }
      },
      computed: {
          getVersion(){
            if(isNullOrUndefined(this.health))
              return 'missing';
            return this.health.hasOwnProperty('version') ? this.health.version : 'missing';
          }
      }
    }
</script>

<style scoped>

</style>
