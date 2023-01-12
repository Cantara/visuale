<template>
  <fragment>
  <grouped-services-element v-for="(value, key) in groupedServicesOverTag" :key="key">
    <template #title>
      <span class="">
        TAG: {{ key | truncateText(34) }}
        </span>
    </template>
    <template #content>
    <div class="align-left">
      <div id="" class="my-content">
        <Service
          v-for="(service,index) in value"
          :key="index"
          :service-type-status="serviceType"
          :title="service.name"
          :service="service"
        >
        </Service>
      </div>
    </div>
    </template>
  </grouped-services-element>
  </fragment>
</template>

<script>
// import ServiceElement from "./service/ServiceElement";
import Service from "./Service";
import groupedServicesElement from "./groupedServicesElement";
import {mapGetters,mapState} from 'vuex'; //eslint-disable-line
import groupedServiceGridCalculator from "./groupedServiceGridCalculatorMixin";

export default {
  name: "GroupedServicesOverTag",
  components: {
    // ServiceElement,
    Service,
    groupedServicesElement
  },
  mixins: [
    groupedServiceGridCalculator
  ],
  props: {
    groupedServicesOverTag: {
      required: false,
      type: Object,
      default() {
        return {}
      }
    },
  },
  mounted() {
  },
  computed: {
    ...mapGetters({services: 'getServices'}),
    ...mapState(['serviceType']),
  },
}

</script>

<style lang="scss" scoped>


  .service-tag-block {
    margin: 0.5em;
    border: 1px solid $color--border;
  }

  .my-content{
    padding: 0.5rem 0.35rem;
    max-width: 100vw;
  }

  .marker {
    padding: 0;
    margin-top: -0.6em;
    text-align: center;
  }

  .title {
    background: $color--background none repeat scroll 0 0;

    /* old version */
    /* display: flex; */
    /* float: left; */
    display: inline-flex;
    padding: 0 0.35em;
    margin: 0 0.75em;

    color: white;
    line-height: 1rem;
  }

  .title > span {
    padding: 0 0.35em;
    color:$color--service-title;
    line-height: 0.9rem;
  }
</style>
