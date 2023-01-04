<template>
  <div id="dashboard">
    <h1 v-if="mobile" id="heading">{{ services.name }}</h1>
    <pre v-else id="heading">{{ verticalText }}</pre>
    <div class="container" :style="dashboardHeight">
      <groupedServicesOverTag :grouped-services-over-tag="services.groupedServicesOverTag"></groupedServicesOverTag>
      <groupTagOverService :grouped-tag-over-service="services.groupedTagOverService"></groupTagOverService>
      <Service :service-type-status="serviceType" :title="service.name" v-for="(service,index) in services.services"
               :key="index" :service="service"></Service>
    </div>
  </div>
</template>

<script>
import {mapState, mapGetters, mapMutations} from 'vuex';
import Service from "../components/Service";
import groupedServicesOverTag from "../components/groupedServicesOverTag";
import GroupTagOverService from "../components/groupTagOverService";

export default {
  name: "main",
  head() {
    return {
      title:  this.services.name,
      meta: [
        {
          hid: 'description',
          name: 'description',
        }
      ]
    }
  },
  components: {
    GroupTagOverService,
    Service,
    groupedServicesOverTag
  },
  computed: {
    ...mapState('layout', ['mobile']),
    ...mapState(['serviceType']),
    ...mapGetters({
      dashboardContainerHeight: 'layout/dashboardContainerHeight',
      services: 'getServices'
    }),
    dashboardHeight() {
      if (!this.mobile)
        return {
          'height': this.dashboardContainerHeight + 'px',
        };
    },
    verticalText: function() {
      if (!this.mobile) {
        let verticalText = "";
        for (let char of this.services.name.split('')) {
          verticalText += char + '\n';
        }
        return verticalText;
      }
      return this.services.name;
    }
  },
  methods: {
    ...mapMutations({
      setToken: 'auth/setToken',
      setStrategy: 'setStrategy',
      setServiceType: 'setServiceType'
    }),
  },

}
</script>

<style lang="scss" scoped>


@media only screen and (min-width: 991px) {
  #dashboard {
    min-height: 100vh;
    overflow-x: auto;
  }
}

@media only screen and (max-width: 990px) {
  #dashboard {
    text-align: center;
    overflow-y: auto;
    height: 100vh;
  }
}

.container {
  margin: 0 auto;
  display: inline-flex;
  max-width: 100vw;
  flex-flow: column wrap;
  padding: 0 0.7em 0.7em;
}


@media only screen and (min-width: 991px) {
  pre {
    display: inline-flex;
    max-width: 3vw;
    color: white;
    font-size: 24px;
    background-color: darken(teal, 5%);
  }
}

@media only screen and (max-width: 990px) {
  h1 {
    padding: 0.35em 0.7em;
    height: 2em;
    color: $color--description;
    display: block;
  }
}

</style>
