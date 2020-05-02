<template>
  <fragment>
    <div class="service-tag-block" v-for="(value, key) in groupedServicesOverTag">
      <div class="marker">
        <div>
          <div class="title">
            <span>TAG: {{key |truncateText(34)}} </span>
          </div>
        </div>
          <div class="content" :style="dashboardHeight">
            <Service v-for="(service,index) in value" :key="index" :service="service">
            </Service>
          </div>
      </div>
    </div>
  </fragment>
</template>

<script>
    import ServiceElement from "./service/ServiceElement";
    import Service from "./Service";
    import {mapGetters,mapState} from 'vuex';
    export default {
        name: "groupedServicesOverTag",
      components: {ServiceElement,Service},
      props: {
        groupedServicesOverTag: {
          required:false,
          type:Object ,
        }
      },
      data() {
        return {
          servicesXPosition: {},
        }
      },
      computed:{
        ...mapState('layout', ['mobile']),
        ...mapGetters({
          dashboardContainerHeight: 'layout/dashboardContainerHeight',
          services: 'getServices',
        }),
        dashboardHeight() {
          if (!this.mobile)
            return {
              'max-height': this.dashboardContainerHeight  + 'px',
            };
        }
      },
      methods:{

      },
      watch:{

      }

    }

</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';

  .service-tag-block {
    margin: 0.35em;
    border: 1px solid $color--border;

  }

.content{
  padding: 0.5rem 0.35rem;
  display:inline-flex;
  flex-flow: column wrap;
  max-width: 100vw;
  display: inline-grid;
  grid-auto-flow: column;
  grid-template-rows: repeat(3, auto);
}
  .marker {
    padding: 0;
    margin-top: -0.6em;
    text-align: center;
  }

  .title {
    background: $color--background none repeat scroll 0 0;

   //old version
   // display: flex;
    //  float: left;
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
