<template>
  <div class="service-block">
      <div class="marker">
        <div>
          <div class="title">
            {{service.name}}
          </div>
          <div>
            <div class="content"  :style="gridStyle">
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
          gridTemplateColumns: `repeat(${this.autoGrid()},minmax(130px,1fr))`
        }
      },
    },
    data() {
      return{}
    },
    methods:{
      autoGrid(){
        return this.service.nodes.length === 1 ? 1 :2;
      },
      isInt(n) {
        return n % 1 === 0;
      },
    }
  }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';
  .service-block{
  }
  .service-block {

    margin: 0.35em;
  }
  .marker{
    border: 2px solid white;
    display:inline-block;
  }

  .marker > div {
    display: block;
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
    padding:0.55em;
    display: inline-grid;
    grid-gap: 0.55em;

  }
</style>
