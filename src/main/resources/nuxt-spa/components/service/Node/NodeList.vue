<template>
    <NodeListElement>
      <template v-slot:content>
          <tr v-for="(node,index) in nodes" :key="index">
            <td> <NodeTrafficLight :node="node"/></td>
            <td>{{title(node) | truncateText(15)}}</td>
            <td>{{node.is_healthy}}</td>
            <td>{{(node.health[0].hasOwnProperty('version') ? node.health[0].version : 'missing')| truncateText(13)}}</td>
            <td><NodeUptime v-bind:shorten="true" :health="node.health[0]" /></td>
          </tr>
      </template>
      <template v-slot:modal>
        <Modal  v-if="showModal" :title="node.ip" @close="showModal = false">
          <NodeDetailedInfo :text="node"></NodeDetailedInfo>
        </Modal>
      </template>
    </NodeListElement>
</template>

<script>
  import NodeListElement from "./NodeList/NodeListElement";
  import NodeDetailedInfo from "./NodeDetailedInfo";
  import NodeTrafficLight from "./NodeTrafficLight";
  import NodeUptime from "./NodeUptime";
  import Modal from "../../Modal";
    export default {
        name: "NodeList",
      components:{
          NodeListElement,
        Modal,
        NodeDetailedInfo,
        NodeTrafficLight,
        NodeUptime
      },
      methods:{
        title(node){
          if(node.hasOwnProperty('ip'))
            return node.ip;
          if(node.hasOwnProperty('name'))
            return node.name;
          return 'Missing'
        }
      },
      props: {
        nodes: {
          required: true,
          type: Array
        }
      }
    }
</script>

<style scoped>

</style>
