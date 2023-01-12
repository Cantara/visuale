<template>
  <div id="dashboard">
    <div class="my-container">
      <div class="heading-container">
        <div id="heading">
          {{ verticalText }}
          </div>
          <div>
            <GroupedServicesOverTag
              :grouped-services-over-tag="services.groupedServicesOverTag"
            />
          </div>
      </div>
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
import GroupedServicesOverTag from "../components/GroupedServicesOverTag";
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
    GroupedServicesOverTag
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

#dashboard {
    min-height: 100vh;
    display: flex;
}

.heading-container {
  display: flex;
  flex-grow: 1;
}

@media only screen and (min-width: 991px) {
  #dashboard {
    overflow-x: auto;
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
  .my-container {
    display: flex;
    flex-grow: 1;
    flex-direction: column;
  }
}

@media only screen and (max-width: 990px) {

  .heading-container {
    flex-direction: column;
  }

  .my-container {
    display: flex;
    flex-grow: 1;
    flex-direction: row;
  }

  #dashboard {
    text-align: center;
    overflow-y: auto;
  }

  #heading {
    /* padding: 0.35em 0.7em; */
    height: 2em;
    color: $color--description;
    padding: 0.5rem;
    display: flex;
    font-size: 24px;
    text-align: center;
    background-color: darken(teal, 5%);
  }
}

</style>
