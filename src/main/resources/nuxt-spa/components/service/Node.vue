<template>
  <div @click="showModal = true" class="node-block" :style="flexStyle">
    <div class="marker">
      <div>
        <div class="title">
        <NodeTrafficLight :node="node"/> <span>{{title | truncateText(15)}}</span>
        </div>
        <div class="content">
          <ul>
            <li><span>Healthy: </span>{{node.is_healthy}}</li>
            <li><span>Ver: </span>{{(node.health[0].hasOwnProperty('version') ? node.health[0].version : 'missing')| truncateText(13)}}</li>
            <li><NodeUptime :health="node.health[0]" /></li>
          </ul>
        </div>
      </div>
    </div>
    <Modal  v-if="showModal" :title="node.ip" @close="showModal = false">
      <JsonModal :text="node"></JsonModal>
    </Modal>
  </div>
</template>

<script>
  import NodeTrafficLight from "./node/NodeTrafficLight";
  import NodeUptime from "./node/NodeUptime";
  import Modal from "../Modal";
  import JsonModal from "../JsonModal";
  export default {
    name: "Node",
    components:{
      NodeTrafficLight,
      NodeUptime,
      Modal,
      JsonModal
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
      flexStyle: {
        required: false,
        type: Object
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';



  .node-block {
    border: 1px solid white;
    border-radius: 10px;
  }

  .marker > div {
    padding: 0;
    margin-top: -0.7em;
    text-align: center;
  }

  .title {
    background: $color--background none repeat scroll 0 0;
    display: flex;
    padding: 0 0.6em;
    margin: 0 0.6em;
    color: white;
    line-height: 1rem;
    float: left;
    font-size: 0.9rem;
  }
  .title >span {
    padding: 0 0 0 0.35em;
  }

  .content {
    padding: 0;
    color: white;
  }
  ul{
    padding: 0 0.2em 0.3em 0.3em;
    list-style:none;
    text-align:left;
    font-size:0.9rem;
  }
  li {
    color:white;
    font-weight: 700;
  }
  span{
    color: $color--description!important;
    font-weight:400;
  }
  td {
    color: $color--description;
    text-align: right;
  }

  th {
    text-align: left;
  }
</style>
