<template>
  <div class="title">
    <slot>
    </slot>
  </div>
</template>

<script>
    export default {
        name: "ServiceTitleElement"
    }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';
  .title {
    display: flex;
    width:100%;
    float: left;
    color: white;
    line-height: 1rem;
  }
  .title > :first-child {
    margin: 0 0 0 0.75em;
    padding: 0 0 0 0.35em;
  }

  .title > .tag-title{
    padding-right: 0.35rem;
  }

  .title > * {
    background: $color--background none repeat scroll 0 0;
  }

  .title > span {
    padding: 0 0 0 0.35em;
    color:$color--service-title;
    line-height: 0.9rem;
  }
</style>
