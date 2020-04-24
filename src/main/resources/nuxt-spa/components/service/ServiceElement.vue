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

  export default {
    name: "ServiceElement",
    props: {
      service: {
        type: Object,
        required: true
      }
    },
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
      borderStatus() {
        /*   if(this.service.healthy_nodes >= 3)
             return 'border--color-success';
           if(this.service.healthy_nodes === 2)
             return 'border--color-normal';
           if(this.service.healthy_nodes === 1)
             return 'border--color-warning';*/
        if (this.service.healthy_nodes === 0)
          return 'border--color-danger';
      }
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
