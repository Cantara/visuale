<template>
  <ServiceElement :service="service">
    <template v-slot:title>
      <ServiceBattery :service="service"/><span>{{service.name |truncateText(34)}} </span>
    </template>
    <template v-slot:content>
      <Node v-for="(node,index) in service.nodes" :key="index" :node="node"></Node>
    </template>
  </ServiceElement>
</template>
<script>
  import Node from "./service/Node";
  import ServiceBattery from "./service/ServiceBattery";
  import ServiceElement from "./service/ServiceElement";
  export default {
    name: "Service",
    components:{
      Node,
      ServiceBattery,
      ServiceElement
    },
    props:{
      service: {
        required: true,
        type: Object,
      }
    }
  }
</script>
