<template>
  <fragment>
    <div class="service-tag-block" v-for="(value, key) in groupedServicesOverTag">
      <div class="marker">
        <div>
          <div class="title">
            <span>TAG: {{key |truncateText(34)}} </span>
          </div>
        </div>

          <div class="content" :style="dashboardContainerHeight">
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
        /*!
      * (c) 2018 Chris Ferdinandi, MIT License, https://gomakethings.com
      */
        isOutOfViewport(elem) {
          const bounding = elem.getBoundingClientRect();
          // Check if it's out of the viewport on each side
          const out = {};
          out.top = bounding.top < 0;
          out.left = bounding.left < 0;
          out.bottom = bounding.bottom > (window.innerHeight || document.documentElement.clientHeight);
          out.right = bounding.right > (window.innerWidth || document.documentElement.clientWidth);
          out.any = out.top || out.left || out.bottom || out.right;
          out.all = out.top && out.left && out.bottom && out.right;
          return out;
        }

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
}
  .marker {

    padding: 0;
    margin-top: -0.6em;
    text-align: center;
    display: flex;
    flex-direction: column;
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
