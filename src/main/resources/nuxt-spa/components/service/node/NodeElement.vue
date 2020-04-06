<template>
  <div @click="$emit('click')" class="node-block">
    <div class="marker">
      <div>
        <div class="title">
          <slot name="title">
          </slot>
        </div>
      </div>
      <div class="content">
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
    name: "NodeElement"
  }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';


  .node-block {
    border: 1px solid white;
    border-radius: 10px;
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
    color: white;
    line-height: 1rem;
    float: left;
    font-size: 0.9rem;
  }

  .title > span {
    padding: 0 0 0 0.35em;
    color:$color--node-title;
  }

  .content {
    padding: 0;
    color: white;
  }

  ul {
    padding: 0 0.2em 0.3em 0.3em;
    list-style: none;
    text-align: left;
    font-size: 0.9rem;
  }

  li {
    color: white;
    font-weight: 700;
  }

  span {
    color: $color--description !important;
    font-weight: 400;
  }

  td {
    color: $color--description;
    text-align: right;
  }

  th {
    text-align: left;
  }
</style>
