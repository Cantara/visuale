<template>
  <fragment>
    <div class="service-tag-block" v-for="(value, key) in groupedServicesOverTag">
      <div class="marker">
        <div>
          <div class="title">
            <span>TAG: {{key |truncateText(34)}} </span>
          </div>
        </div>
          <div id="grid" class="content" :style="dashboardHeight(value)">
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
    import{displayNodeTableCondition} from "../preferences";

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
          serviceTagBlockStyling: {

          }
        }
      },
      computed:{
        ...mapState('layout', ['mobile']),
        ...mapGetters({
          dashboardContainerHeight: 'layout/dashboardContainerHeight',
          services: 'getServices',
        }),
      },
      methods:{
        dashboardHeight(services) {
          if (!this.mobile)
            return {
              'max-height': this.dashboardContainerHeight  + 'px',
              display: 'inline-grid',
              'grid-auto-flow': 'column',
              gridTemplateRows: 'repeat(' + this.calculateGridColumn(services) +', auto)'
            };
          return {
            display: 'inline-flex',
            'flex-flow': 'column wrap'
          };
        },

          calculateGridColumn(services){
            let avaiableHeight = this.dashboardContainerHeight;
            let tagHeight = 18.4;
            let usedHeight = tagHeight.valueOf();
            let rowsSum = 0;
            let rows= 0;
            for (let i = 0; i < services.length; i++) {
              let nodesLength = services[i].nodes.length;
              let height = 0;
              if(displayNodeTableCondition(nodesLength))
              {
                let titleHeight = 22.6;
                let nodeHeight = 22.6;
                let serviceTitleHeight = 16.8;
                height = (titleHeight +serviceTitleHeight +(nodesLength * nodeHeight));
              }
              else
                height = 16.8 +  (nodesLength >= 2 ? (74 * Math.ceil(nodesLength /2)) : 74);

              if(height + usedHeight >= avaiableHeight && rows > 0)
              {
                if(!(rowsSum > 0 && rowsSum < rows))
                  rowsSum = rows.valueOf();
                rows =0;
                usedHeight = tagHeight.valueOf();
              }
              else {
                usedHeight += height.valueOf();
                rows++;
              }
            }
            return rowsSum > 0 ? rowsSum : rows;
          }

      },

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
  max-width: 100vw;
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
