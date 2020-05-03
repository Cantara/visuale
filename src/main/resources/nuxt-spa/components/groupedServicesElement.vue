<template>
  <fragment>
    <div class="service-tag-block">
      <div class="marker">
        <div>
          <div class="title">
            <slot name="title">
            </slot>
          </div>
        </div>
        <slot name="content">

        </slot>
      </div>
    </div>
  </fragment>
</template>

<script>
    export default {
        name: "groupedServicesElement"
    }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';

  .service-tag-block {
    margin: 0.5em;
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
