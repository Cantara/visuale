<template>
  <div class="service-block">
    <div>
      <div class="marker">
        <div>
          <div class="title">
            {{service.name}}
          </div>
          <div class="content" :style="gridStyle">
            <Node v-for="(node,index) in service.nodes" :key="index" :node="node"></Node>
          </div>
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
    },
    computed: {
      gridStyle() {
        return {
          gridTemplateColumns: `repeat(${this.autoGrid()},1fr)`
        }
      },
    },
    data() {
      return {
      }
    },
    methods:{
      autoGrid(){
        return  Math.round(Math.sqrt(this.service.nodes.length));
        return Math.round(this.service.nodes.length / 2);
      },

    },
  }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';
  .service-block > div {
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
  }
</style>
