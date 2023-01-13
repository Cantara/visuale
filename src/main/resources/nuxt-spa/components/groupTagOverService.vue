<template>
  <fragment>
    <grouped-services-element v-for="(value, key) in groupedTagOverService" :key="key">
      <template v-slot:title>
        <span class="tag-title">SERVICE: {{key |truncateText(34)}} </span>
      </template>
      <template v-slot:content>
        <div class="align-left">
          <div class="content">
            <Service :service-type-status="serviceType" :title="'TAG: '+tagTitle(service.service_tag)" v-for="(service,key) in value" :key="key" :service="service">
            </Service>
          </div>
        </div>
      </template>
    </grouped-services-element>
  </fragment>
</template>

<script>
  import ServiceElement from "./service/ServiceElement";
  import Service from "./Service";
  import groupedServicesElement from "./groupedServicesElement";
  import {mapGetters,mapState} from 'vuex';
  import groupedServiceGridCalculator from "./groupedServiceGridCalculatorMixin";
    export default {
        name: "groupTagOverService",
      components: {ServiceElement,Service,groupedServicesElement},
      mixins:[groupedServiceGridCalculator],
      props: {
        groupedTagOverService: {
          required:false,
          type:Object ,
        }
      },
      computed:{
        ...mapGetters({
          services: 'getServices',
        }),
        ...mapState(['serviceType']),
      },
      methods:{
          tagTitle(name){
            return name.length === 0? 'NOTAG' : name;
          }
      }
    }
</script>

<style scoped>
  .content{
    padding: 0.5rem 0.35rem;
    display: flex;
    flex-wrap: wrap;
    /* max-width: 100vw; */
}
</style>
