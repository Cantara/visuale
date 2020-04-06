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
        return {
          gridTemplateColumns: `repeat(2,10.2rem)`
        }
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
    border: 1px solid white;
  }

  .marker {
    padding: 0;
    margin-top: -0.55em;
    text-align: center;
    display: flex;
    flex-direction: column;
  }

  .title {
    background: $color--background none repeat scroll 0 0;
    display: flex;
    padding: 0 0.6em;
    margin: 0 0.6em;
    float: left;
    color: white;
    line-height: 1rem;
  }

  .title > span {
    padding: 0 0 0 0.35em;
    color:$color--service-title;
  }

  .content {
    padding: 0.50rem;
    display: inline-grid;
    grid-gap: 0.6rem;
  }
</style>
