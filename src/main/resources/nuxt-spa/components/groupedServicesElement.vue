<template>
  <fragment>
    <div class="service-tag-block">
      <div class="marker">
        <div>
          <TitleElement :is-grouped="true">
            <slot name="title" />
          </TitleElement>
        </div>
        <slot name="content" />
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
