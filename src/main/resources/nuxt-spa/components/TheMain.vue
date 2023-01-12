<template>
  <div id="dashboard">
    <div class="container">
      <div>
        <div id="heading">{{ verticalText }}</div>
      </div>
      <!-- <groupedServicesOverTag -->
      <!--   :grouped-services-over-tag="services.groupedServicesOverTag" -->
      <!-- > -->
      <!-- </groupedServicesOverTag> -->
      <!-- <groupTagOverService -->
      <!--   :grouped-tag-over-service="services.groupedTagOverService" -->
      <!-- > -->
      <!-- </groupTagOverService> -->
      <!-- <Service -->
      <!--   v-for="(service,index) in services.services" -->
      <!--   :key="index" -->
      <!--   :service-type-status="serviceType" -->
      <!--   :title="service.name" -->
      <!--   :service="service" -->
      <!-- > -->
      <!-- </Service> -->
    </div>
  </div>
</template>

<script>
import {mapState, mapGetters, mapMutations} from 'vuex';
import Service from "../components/Service";
import groupedServicesOverTag from "../components/groupedServicesOverTag";
import GroupTagOverService from "../components/groupTagOverService";

export default {
  name: "TheMain",
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
      if (!this.mobile) {
        return {
          'height': this.dashboardContainerHeight + 'px'
        };
      } else {
        return {}
      }
    },
    verticalText() {
      return this.getServicesName.toUpperCase();
    },
    getServicesName()  {
      if (this.services === undefined || this.services.name === undefined)
        return "THIS SERVICE DASHBOARD NAME IS UNDEFINED";
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
    overflow-x: auto;
    min-height: 100vh;
  }

  #heading {
    display: flex;

    padding: 0.5rem;
    writing-mode: vertical-rl;
    text-orientation: upright;
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
  }

  #heading {
    /* padding: 0.35em 0.7em; */
    height: 2em;
    color: $color--description;
    display: flex;
    font-size: 24px;
    text-align: center;
    background-color: darken(teal, 5%);
  }
}

.container {
  margin: 0 auto;
  display: flex;
  flex-grow: 1;
  flex-direction: column;
  /* max-width: 100vw; */
  /* min-height: 100vh; */
  /* flex-flow: column wrap; */
  /* padding: 0 0.7em 0.7em; */
}

</style>
