<template>
  <ServiceElement :service="service">
    <template v-slot:title>
      <ServiceBattery :service="service"/><span>{{service.name |truncateText(34)}} </span>
    </template>
    <template v-slot:content>
      <NodeTable v-if="service.nodes.length >= 5" :nodes="service.nodes"></NodeTable>
      <NodeBox v-else v-for="(node,index) in service.nodes" :key="index" :node="node"></NodeBox>
    </template>
  </ServiceElement>
</template>
<script>
  import NodeBox from "./service/Node/NodeBox";
  import ServiceBattery from "./service/ServiceBattery";
  import ServiceElement from "./service/ServiceElement";
  import NodeTable from "./service/Node/NodeTable";
  export default {
    name: "Service",
    components:{
      NodeBox,
      ServiceBattery,
      ServiceElement,
      NodeTable
    },
    props:{
      service: {
        required: true,
        type: Object,
      }
    }
  }
</script>
