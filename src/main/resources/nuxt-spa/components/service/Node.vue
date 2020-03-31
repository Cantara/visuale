<template>
  <div class="node-block" :style="flexStyle">
    <div class="marker">
      <div>
        <div class="title">
          {{node.ip | truncateText(13)}}
        </div>
        <div class="content">
          <ul>
            <li><span>Health: </span>Ok</li>
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
  export default {
    name: "Node",
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
    padding: 0.11em;
  }

  .marker > div {
    padding: 0 3px;
    margin-top: -0.8em;
    text-align: center;
  }

  .title {
    background: $color--background none repeat scroll 0 0;
    display: inline;
    padding: 0 0.6em;
    margin: 0 0.3em;
    color: white;
  }

  .content {
    padding: 0;
    color: white;
  }
  ul{
    padding:0;
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
