<template>
  <div class="node-block" :style="flexStyle">
    <div class="marker">
      <div>
        <div class="title">
        <NodeTrafficLight :node="node"/> <span>{{node.ip | truncateText(14)}}</span>
        </div>
        <div class="content">
          <ul>
            <li><span>Healthy: </span>{{node.is_healthy}}</li>
            <li><span>Ver: </span>{{(node.health[0].hasOwnProperty('version') ? node.health[0].version : 'missing')| truncateText(12)}}</li>
            <li><span>Uptime: </span>{{daysSince}} Days <font-awesome-icon v-if="daysSince > 7" class="warning"  :icon="faGasPump"/></li>
          </ul>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
  import { faGasPump } from '@fortawesome/free-solid-svg-icons'
  import NodeTrafficLight from "./node/NodeTrafficLight";
  export default {
    name: "Node",
    components:{
      NodeTrafficLight
    },
    props: {
      node: {
        required: true,
        type: Object
      },
      flexStyle: {
        required: false,
        type: Object
      }
    },
    computed:{
      faGasPump(){
        return faGasPump;
      },
      daysSince(){
        return this.getDaysSince(this.node.health[0]['running since']);
      }
    },
    methods: {
      getDaysSince(date2) {
        let d1 = new Date();
        let d2 = new Date(date2);
        return Math.floor((d1 - d2) / (1000 * 3600 * 24));
      }

    }
  }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';



  .node-block {
    border: 2px solid white;
    border-radius: 10px;
  }

  .marker > div {
    padding: 0;
    margin-top: -0.7em;
    text-align: center;
  }

  .title {
    background: $color--background none repeat scroll 0 0;
    display: flex;
    padding: 0 0.6em;
    margin: 0 0.6em;
    color: white;
    line-height: 1rem;
    float: left;
  }
  .title >span {
    padding: 0 0.35em;
  }

  .content {
    padding: 0;
    color: white;
  }
  ul{
    padding: 0 0.2em 0.3em 0.3em;
    list-style:none;
    text-align:left;
    font-size:0.9rem;
  }
  li {
    color:white;
    font-weight: 700;
  }
  span{
    color: $color--description!important;
    font-weight:400;
  }
  td {
    color: $color--description;
    text-align: right;
  }

  th {
    text-align: left;
  }
</style>
