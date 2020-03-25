<template>
    <div class="node-block">
<div class="marker">
  <div>
    <div class="title">
      {{node.ip}}
    </div>
    <div class="content">
      Health
    </div>
  </div>

</div>
    </div>
</template>

<script>
    export default {
        name: "Node",
      props:{
          node:{
            required: true,
            type:Object
          }
      }
    }
</script>

<style scoped>
  .node-block {
    border: 2px solid black;
  }

  .marker > div {
    padding: 0 3px;
    margin-top: -0.8em;
  }

  .title {
    background: white none repeat scroll 0 0;
    display: inline-block;
    padding: 0 2px;
    margin: 0 2em;
  }
  .content{
    padding:1em;

  }
</style>
