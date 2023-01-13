<template>
  <div id="dashboard">
    <div class="container">
      <div class="my-content">
        <div class="heading-container">
          <div id="heading">
            {{ verticalText }}
          </div>
        </div>
        <section class="my-section">
          <groupedServicesOverTag
            :grouped-services-over-tag="services.groupedServicesOverTag"
          />
          <groupTagOverService
            :grouped-tag-over-service="services.groupedTagOverService"
          />
          <Service
            v-for="(service,index) in services.services"
            :key="index"
            :service-type-status="serviceType"
            :title="service.name"
            :service="service"
          >
          </Service>
        </section>
      </div>
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

.heading-container {
  display: flex;
}

#dashboard {
    min-height: 100vh;
    display: flex;
}

.my-content {
  display: flex;
  flex-grow: 1;
}
.my-section {
  padding: 0.5rem;
  display: flex;
  flex-direction: column;
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
  .container {
    display: flex;
    flex-grow: 1;
    flex-direction: column;
  }
}

@media only screen and (max-width: 990px) {

  .my-content {
    flex-direction: column;
  }
  .heading-container {
    flex-direction: column;
  }

  .container {
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
