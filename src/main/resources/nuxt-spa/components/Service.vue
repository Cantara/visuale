<template>
  <div class="service-block">
    <div class="marker">
      <div>
        <div class="title">
          {{service.name}}
        </div>
        <div class="content">
          <Node v-for="(node,index) in service.nodes" :key="index" :node="node"></Node>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import Node from "./service/Node";
  export default {
    name: "Service",
    components:{
      Node
    },
    props:{
      service: {
        required: true,
        type: Object,
      }
    }
  }
</script>

<style scoped>
  .service-block {
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
    display:grid;
    grid-gap: 20px 20px;
    grid-template-columns: repeat(2, 1fr);
    grid-template-rows: repeat(2, 1fr);
  }
</style>
