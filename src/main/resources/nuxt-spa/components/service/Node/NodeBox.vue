<template>
  <NodeBoxElement @click="showModal = true">
    <template v-slot:title>
      <NodeTrafficLight :node="node"/> <span>{{title | truncateText(15)}}</span>
    </template>
    <template v-slot:content>
      <ul>
        <li><span>Healthy: </span>{{node.is_healthy}}</li>
        <li><span>Ver: </span>{{(node.health[0].hasOwnProperty('version') ? node.health[0].version : 'missing')| truncateText(13)}}</li>
        <li><span>Uptime: </span><NodeUptime :health="node.health[0]" /></li>
      </ul>
    </template>
    <template v-slot:modal>
      <Modal  v-if="showModal" :title="node.ip" @close="showModal = false">
        <NodeDetailedInfo :text="node"></NodeDetailedInfo>
      </Modal>
    </template>
  </NodeBoxElement>
</template>

<script>
  import NodeBoxElement from "./NodeBox/NodeBoxElement";
  import NodeTrafficLight from "./NodeTrafficLight";
  import NodeUptime from "./NodeUptime";
  import Modal from "../../Modal";
  import NodeDetailedInfo from "./NodeDetailedInfo";
  export default {
    name: "Node",
    components:{
      NodeTrafficLight,
      NodeUptime,
      Modal,
      NodeDetailedInfo,
      NodeBoxElement: NodeBoxElement
    },
    data() {
      return {
        showModal: false
      }
    },
    computed:{
      title(){
        if(this.node.hasOwnProperty('ip'))
          return this.node.ip;
        if(this.node.hasOwnProperty('name'))
          return this.node.name;
        return 'Missing'
        }
    },
    props: {
      node: {
        required: true,
        type: Object
      }
    }
  }
</script>
<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';
  span{
    color: $color--description!important;
    font-weight:400;
  }
</style>

