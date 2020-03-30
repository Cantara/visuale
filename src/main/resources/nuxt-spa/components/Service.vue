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
          gridTemplateColumns: `repeat(2,minmax(130px,1fr))`
        }
      },
      flexStyle(){
        return {
          flex: `0 0 ${this.autoFlex()}%`
        }
      },
    },
    data() {
      return{}
    },
    methods:{
      autoFlex(){
      return  Math.floor(100 / this.autoGrid());
      },
      autoGrid(){
        let squareRoot = Math.sqrt(this.service.nodes.length);
        if(this.isInt(squareRoot))
          return  squareRoot;
        return Math.round(squareRoot + 1);
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
