<template>
  <div class="title" :class="isGrouped ? 'group-title' : ''">
    <slot>
    </slot>
  </div>
</template>

<script>
    export default {
        name: "ServiceTitleElement",
      props:{
          isGrouped: {
            type:Boolean,
            required:false,
            default:false
          }
      }
    }
</script>

<style lang="scss" scoped>

  .title {
    display: flex;
    width:100%;
    float: left;
    color: white;
    line-height: 1rem;
  }
  .group-title > :first-child {
    margin-left: 1.65rem!important;
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
