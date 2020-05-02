<template>

  <div class="service-block" :class="borderStatus">
    <div class="marker">
      <div>
        <div class="title">
          <slot name="title">
          </slot>
        </div>
      </div>
        <div class="content" :style="gridStyle">
          <slot name="content">
          </slot>
        </div>
    </div>
    <slot name="modal">

    </slot>
  </div>
</template>

<script>
  import {displayNodeTableCondition} from "../../preferences";
  import borderStatusMixin from "../borderStatusMixin";
  export default {
    name: "ServiceElement",
    props: {
      service: {
        type: Object,
        required: true
      }
    },
    mixins:[borderStatusMixin],
    computed: {
      gridStyle() {
        if(this.isNodeTableConditionMet)
          return {
            paddingTop:'0.5rem',
          };
        else
        return {
          gridTemplateColumns: `repeat(2,10.2rem)`,
          padding:'0.5rem',
          display:'inline-grid',
          gridGap:'0.6rem'
        };
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
    margin: 0.35em;
    border: 1px solid $color--border;
    width:22.1rem;
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
    display: flex;
    padding: 0 0.35em;
    margin: 0 0.75em;
    float: left;
    color: white;
    line-height: 1rem;
  }

  .title > span {
    padding: 0 0 0 0.35em;
    color:$color--service-title;
    line-height: 0.9rem;
  }
</style>
