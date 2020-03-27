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

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';
  .service-block {
    border: 2px solid white;
  }

  .marker > div {
    padding: 0 3px;
    margin-top: -0.8em;
  }

  .title {
    background: $color--background none repeat scroll 0 0;
    display: inline-block;
    padding: 0 0.6em;
    margin: 0 0.6em;
    color: white;
  }
  .content{
    padding:1em;
    display:grid;
    grid-gap: 1em;
    grid-template-columns: repeat(2, 1fr);
    grid-template-rows: repeat(2, 1fr);
  }
</style>
