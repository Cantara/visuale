<template>
  <ServiceElement :service="service">
    <template v-slot:title>
      <ServiceBattery :service="service"/><span>{{service.name |truncateText(34)}} </span>
    </template>
    <template v-slot:content>
      <NodeList v-if="service.nodes.length >= 6" :nodes="service.nodes"></NodeList>
      <NodeBox v-else v-for="(node,index) in service.nodes" :key="index" :node="node"></NodeBox>
    </template>
  </ServiceElement>
</template>
<script>
  import NodeBox from "./service/Node/NodeBox";
  import ServiceBattery from "./service/ServiceBattery";
  import ServiceElement from "./service/ServiceElement";
  import NodeList from "./service/Node/NodeList";
  export default {
    name: "Service",
    components:{
      NodeBox: NodeBox,
      ServiceBattery,
      ServiceElement,
      NodeList: NodeList
    },
    props:{
      service: {
        required: true,
        type: Object,
      }
    }
  }
</script>
