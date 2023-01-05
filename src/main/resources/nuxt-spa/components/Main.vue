<template>
  <div id="dashboard">
    <pre id="heading">{{ verticalText }}</pre>
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
      services: 'getServices',
    }),
    dashboardHeight() {
      if (!this.mobile)
        return {
          'height': this.dashboardContainerHeight + 'px',
        };
    },
    verticalText() {
      if (this.mobile)
      {
        return this.getServicesName.toUpperCase()
      }
      else {
        let text = "";
        for (let char of this.getServicesName.toUpperCase().split('')) {
          text += char + '\n';
        }
        return text;
      }
    },
    getServicesName()  {
      if (this.services === undefined || this.services.name === undefined )
        return "SERVICE UNDEFINED";
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

  #heading {
    display: inline-flex;
    max-width: 3vw;
    color: $color--description;
    font-size: 24px;
    background-color: darken(teal, 5%);
    overflow: hidden;
  }
}

@media only screen and (max-width: 990px) {
  #dashboard {
    text-align: center;
    overflow-y: auto;
    height: 100vh;
  }

  #heading {
    padding: 0.35em 0.7em;
    height: 2em;
    color: $color--description;
    display: block;
    font-size: 24px;
    text-align: center;
    background-color: darken(teal, 5%);
  }
}

.container {
  margin: 0 auto;
  display: inline-flex;
  max-width: 100vw;
  flex-flow: column wrap;
  padding: 0 0.7em 0.7em;
}

</style>
