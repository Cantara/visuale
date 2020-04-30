<template>
<div>
  <NodeTable v-if="isNodeTableConditionMet" :service="service"></NodeTable>
  <NodeBox v-else v-for="(node,index) in service.nodes" :key="index" :node="node" :healthy_nodes="service.healthy_nodes"></NodeBox>
</div>
</template>
<script>
  import NodeTable from "./Node/NodeTable";
  import NodeBox from "./Node/NodeBox";
  import {displayNodeTableCondition} from "../../preferences";
    export default {
        name: "Node",
      components:{
          NodeTable,
        NodeBox
      },
      props:{
          service: {
            required:true,
            type:Object
          }
      },
      computed:{
        isNodeTableConditionMet(){
          return displayNodeTableCondition(this.service.nodes.length);
        }
      },
    }
</script>

<style scoped>

</style>
