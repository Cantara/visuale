<template>
  <NodeBoxElement @click="showModal = true" :healthy_nodes="healthy_nodes">
    <template v-slot:title>
      <NodeTrafficLight :node="node"/> <span>{{title | truncateText(15)}}</span>
    </template>
    <template v-slot:content>
      <ul>
        <li><span class="description">Health: </span><NodeHealthStatus v-bind:healthy="node.is_healthy"/><NodeGoodCitizen :health="node.health"></NodeGoodCitizen></li>
        <li><span class="description">Ver: </span><NodeVersion v-bind:text-length="13" :health="node.health[0]"/></li>
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
  import NodeTrafficLight from "./NodeStatus";
  import NodeUptime from "./NodeUptime";
  import Modal from "../../Modal";
  import NodeDetailedInfo from "./NodeDetailedInfo";
  import NodeHealthStatus from "./NodeHealthStatus";
  import NodeVersion from "./NodeVersion";
  import NodeGoodCitizen from "~/components/service/Node/NodeGoodCitizen";
  export default {
    name: "Node",
    components:{
      NodeTrafficLight,
      NodeUptime,
      Modal,
      NodeDetailedInfo,
      NodeBoxElement: NodeBoxElement,
      NodeHealthStatus,
      NodeVersion,
      NodeGoodCitizen
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
      },
      healthy_nodes: {
        required:true,
        type: Number | undefined
      }
    }
  }
</script>
