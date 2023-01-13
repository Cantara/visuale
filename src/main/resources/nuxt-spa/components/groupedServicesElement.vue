<template>
  <fragment>
    <div class="service-tag-block">
      <div class="marker">
        <div>
          <TitleElement :isGrouped="true">
            <slot name="title">
            </slot>
          </TitleElement>
        </div>
        <slot name="content">

        </slot>
      </div>
    </div>
  </fragment>
</template>

<script>
  import TitleElement from "./TitleElement";
    export default {
        name: "groupedServicesElement",
      components: {
        TitleElement
      }
    }
</script>

<style lang="scss" scoped>


  .service-tag-block {
    display: flex;
    margin: 0.5em;
    border: 1px solid $color--border;
  }

  .content{
    padding: 0.25em 0.5rem 0.5rem;
  }

  .marker {
    padding: 0;
    margin-top: -0.6em;
    text-align: center;
  }
</style>
