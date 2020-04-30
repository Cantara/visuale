<template>
  <ServiceElement :service="service">
    <template v-slot:title>
      <ServiceBattery :healthy_nodes="service.healthy_nodes"/><span>{{service.name |truncateText(34)}} </span>
    </template>
    <template v-slot:content>
      <Node :service="service"></Node>
    </template>
  </ServiceElement>
</template>
<script>
  import ServiceBattery from "./service/ServiceBattery";
  import ServiceElement from "./service/ServiceElement";
  import Node from "./service/Node";
  export default {
    name: "Service",
    components:{
      ServiceBattery,
      ServiceElement,
      Node
    },
    props:{
      service: {
        required: true,
        type: Object,
      }
    }
  }
</script>
