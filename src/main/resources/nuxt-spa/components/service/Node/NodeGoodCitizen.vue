<template>
<span v-if="isHelpingCitizen">
     <font-awesome-icon :icon="faHandsHelping" style="color:#7B5BDE"/>
</span>
</template>

<script>
import {
  faHandsHelping, faHeartBroken, faSeedling
} from '@fortawesome/free-solid-svg-icons'
export default {
  name: "NodeGoodCitizen",
  computed:{
    isHelpingCitizen(){
      return JSON.stringify(this.health).includes('_sla');
    },
    faHandsHelping(){
      return faHandsHelping;
    },
  },
  props: {
    health:{
      required:false,
      type:Array
    }
  },

}
</script>

<style scoped>

</style>
