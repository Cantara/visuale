<template>
  <fragment>
    <div class="service-tag-block">
      <div class="marker">
        <div>
          <ServiceTitleElement>
            <slot name="title">
            </slot>
          </ServiceTitleElement>
        </div>
        <slot name="content">

        </slot>
      </div>
    </div>
  </fragment>
</template>

<script>
  import ServiceTitleElement from "./ServiceTitleElement";
    export default {
        name: "groupedServicesElement",
      components: {
        ServiceTitleElement
      }
    }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';

  .service-tag-block {
    margin: 0.5em;
    border: 1px solid $color--border;
  }

  .content{
    padding: 0.25em 0.5rem 0.5rem;
    max-width: 100vw;
  }

  .marker {
    padding: 0;
    margin-top: -0.6em;
    text-align: center;
  }
</style>
