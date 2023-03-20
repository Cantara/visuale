<template>
  <div>
  <div class="service-block"  :class="borderStatus">
    <div class="marker">
      <div>
        <ServiceTitleElement>
          <slot name="title">

          </slot>
        </ServiceTitleElement>
      </div>
        <div class="content" :style="gridStyle">
          <slot name="content">
          </slot>
        </div>
    </div>
    <slot name="modal">

    </slot>
  </div>
  </div>
</template>

<script>
  import {displayNodeTableCondition} from "../../preferences";
  import ServiceTitleElement from "../TitleElement";
  import borderStatusMixin from "../borderStatusMixin";
  export default {
    name: "ServiceElement",
    props: {
      service: {
        type: Object,
        required: true
      }
    },
    components:{
      ServiceTitleElement
    },
    mixins:[borderStatusMixin],
    computed: {
      gridStyle() {
        if(this.isNodeTableConditionMet)
          return {
            paddingTop:'0.5rem',
            width:'22.4rem',
          };
        else
        return {
          gridTemplateColumns: 'repeat('+this.nodeBoxWidth+',10.4rem)',
          padding:'0.5rem',
          display:'inline-grid',
          gridGap:'0.6rem'
        };
      },
      nodeBoxWidth(){
        if(this.service.name.length >= 7)
          return 2;
        return this.service.nodes.length > 1 ? 2 : 1;
      },
      isNodeTableConditionMet(){
       return displayNodeTableCondition(this.service.nodes.length);
      },
      //required for borderstatus mixin
      healthy_nodes(){
        return this.service.healthy_nodes;
      },
    }
  }
</script>

<style lang="scss" scoped>



  .service-block {
    margin: 0.35em;
    border: 1px solid $color--nested-border;
   // width:22.1rem;
  }

  .marker {
    padding: 0;
    margin-top: -0.6em;
    text-align: center;
    display: flex;
    flex-direction: column;
  }

</style>
