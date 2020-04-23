<template>
  <NodeBoxElement @click="showModal = true">
    <template v-slot:title>
      <NodeTrafficLight :node="node"/> <span>{{title | truncateText(15)}}</span>
    </template>
    <template v-slot:content>
      <ul>
        <li><span class="description">Health: </span><NodeHealthStatus v-bind:healthy="node.is_healthy"/></li>
        <li><span class="description">Ver: </span><NodeVersion :health="node.health[0]"/></li>
        <li><span class="description">Uptime: </span><NodeUptime :health="node.health[0]" /></li>
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
  import NodeHealthStatus from "./NodeHealthStatus";
  import NodeVersion from "./NodeVersion";
  export default {
    name: "Node",
    components:{
      NodeTrafficLight,
      NodeUptime,
      Modal,
      NodeDetailedInfo,
      NodeBoxElement: NodeBoxElement,
      NodeHealthStatus,
      NodeVersion
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
