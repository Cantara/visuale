<template>
  <ServiceElement :service="service">
    <template v-slot:title>
      <ServiceBattery :healthy_nodes="service.healthy_nodes"/><span>{{service.name |truncateText(34)}} </span>
    </template>
    <template v-slot:content>
      <NodeTable v-if="isNodeTableConditionMet" :service="service"></NodeTable>
      <NodeBox v-else v-for="(node,index) in service.nodes" :key="index" :node="node"></NodeBox>
    </template>
  </ServiceElement>
</template>
<script>
  import NodeBox from "./service/Node/NodeBox";
  import ServiceBattery from "./service/ServiceBattery";
  import ServiceElement from "./service/ServiceElement";
  import NodeTable from "./service/Node/NodeTable";
  import {displayNodeTableCondition} from "../preferences";
  export default {
    name: "Service",
    components:{
      NodeBox,
      ServiceBattery,
      ServiceElement,
      NodeTable
    },
    computed:{
      isNodeTableConditionMet(){
        return displayNodeTableCondition(this.service.nodes.length);
      }
    },
    props:{
      service: {
        required: true,
        type: Object,
      }
    }
  }
</script>
