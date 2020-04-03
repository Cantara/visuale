<template>
  <div class="service-block">
    <div class="marker" :class="borderStatus">
      <div>
        <div class="title">
          <slot name="title">

          </slot>
        </div>
        <div>
          <div class="content" :style="gridStyle">
            <slot name="content">

            </slot>
          </div>
        </div>
      </div>
    </div>
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
          gridTemplateColumns: `repeat(2,minmax(143px,1fr))`
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
  }

  .marker {
    border: 1px solid white;
    display: inline-block;
  }

  .marker > div {
    display: block;
    padding: 0;
    margin-top: -0.7em;
    text-align: center;
  }

  .title {
    background: $color--background none repeat scroll 0 0;
    display: flex;
    padding: 0 0.6em;
    float: left;
    margin: 0 0.3em;
    color: white;
    line-height: 1rem;
  }

  .title > span {
    padding: 0 0.7em;
  }

  .content {
    padding: 0.55em;
    display: inline-grid;
    grid-gap: 0.6em;

  }
</style>
