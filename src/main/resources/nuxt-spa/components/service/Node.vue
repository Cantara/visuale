<template>
    <div class="node-block" :style="flexStyle">
<div class="marker">
  <div>
    <div class="title">
      {{node.ip}}
    </div>
    <div class="content">
      <table>
        <tr>
          <td>Health: </td>
          <th>Ok</th>
        </tr>
        <tr>
          <td>Version: </td>
          <th>{{node.health[0].version}}</th>
        </tr>
      </table>
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
          },
        flexStyle:{
            required:false,
          type:Object
        }
      }
    }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';
  .node-block {
    border: 2px solid white;
    border-radius: 10px;
    padding: 0.1em;
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
    margin: 0 0.6em;
    color:white;
  }
  .content{
    padding:0;
    color:white;
  }
  td {
    color:$color--description;
    text-align: right;
  }
  th{
    text-align:left;
  }
</style>
