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
        if(this.service.name.length > 13)
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
  @import '~/assets/styles/variables/_variables.scss';


  .service-block {
    margin: 0em 0.55em 1em 0.75em;
    border: 1px solid $color--border;
    width: 22.6rem;
    height: 10rem;
  }
  
@media only screen and (min-width: 320px) and (max-width: 374px) {
    .service-block {
      width:  20.3rem  !important;
      height: auto !important;
    }
    .content{
      display: initial !important;
    }
  }

 @media only screen and (min-width: 375px) and (max-width: 424px) {
    .service-block {
      width:  23.6rem  !important;
      height: auto !important;
    }
  }

  @media only screen and (min-width: 425px) and (max-width: 769px) {
    .service-block {
      width:  27.6rem  !important;
      height: auto !important;
    }
  }

  @media only screen and (min-width: 426px) and (max-width: 769px) {
    .service-block {
      width:  25.3rem !important;
      height: 10rem !important;
    }
  }

  @media only screen and (min-width: 1024px) and (max-width:1439px) {
    .service-block {
      width: 22.6rem !important;
      height: 10rem !important;
    }
  }

  @media only screen and (min-width: 1440px) and (max-width:2559px)  {
    .service-block {
      width:  23.9rem !important;
      height: 10rem !important;
    }
  }

  @media only screen and (min-width: 2560px) {
      .service-block {
        width:  24.6rem !important;
        height: 10rem !important;
      }
  }
  
   .marker {
    padding: 0;
    margin-top: -0.6em;
    text-align: center;
    display: flex;
    flex-direction: column;
  }

</style>
