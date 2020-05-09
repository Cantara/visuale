<template>
    <ServiceElement :service="service">
      <template v-slot:title>
        <ServiceBattery :healthy_nodes="service.healthy_nodes"/>
        <span class="tag-title">{{title|truncateText(34)}}</span>
        <ServiceType v-if="serviceTypeStatus" :service_type="service.service_type"></ServiceType>
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
  import ServiceType from "./ServiceType";
  export default {
    name: "Service",
    components:{
      ServiceBattery,
      ServiceElement,
      Node,
      ServiceType
    },
    props:{
      service: {
        required: true,
        type: Object,
      },
      title: {
        required:false,
        type:String
      },
      serviceTypeStatus:{
        required: false,
        type:Boolean,
        default:false,
      }
    },
    mounted() {
     // window.addEventListener('resize', this.handleResize);
     // this.handleResize();
    },
    beforeDestroy() {
    //  window.removeEventListener('resize', this.handleResize);
    },
  }
</script>
<style scoped>

</style>
