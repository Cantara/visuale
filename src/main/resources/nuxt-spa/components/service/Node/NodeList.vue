<template>
    <NodeListElement>
      <template v-slot:content>
        <table id="customers">
          <tbody>
          <tr>
            <th></th>
            <th>Name</th>
            <th>Health</th>
            <th>Version</th>
            <th>Uptime</th>
          </tr>
          <tr>
            <td> <NodeTrafficLight :node="node"/></td>
            <td>{{title | truncateText(15)}}</td>
            <td>{{node.is_healthy}}</td>
            <td>{{(node.health[0].hasOwnProperty('version') ? node.health[0].version : 'missing')| truncateText(13)}}</td>
            <td><NodeUptime v-bind:shorten="true" :health="node.health[0]" /></td>
          </tr>
          </tbody>
        </table>
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

<style scoped>

</style>
