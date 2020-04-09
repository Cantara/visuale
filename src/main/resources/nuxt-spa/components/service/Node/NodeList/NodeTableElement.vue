<template>
  <div>
    <div class="marker">
      <div class="content">
        <table>
          <tbody>
          <tr>
            <th></th>
            <th>Name</th>
            <th>Health</th>
            <th>Version</th>
            <th>Uptime</th>
          </tr>
        <slot name="content">

        </slot>
          </tbody>
        </table>
      </div>
    </div>
    <slot name="modal">

    </slot>
  </div>
</template>

<script>
    export default {
        name: "NodeListElement"
    }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';

  .node-block{
    width: 22rem;
    padding-top: 0.5rem;
  }
  .marker {
    padding: 0;
    margin-top: -0.55em;
    text-align: center;
    display: flex;
    flex-direction: column;
  }

  .content {
    padding: 0;
    color: white;
    text-align: left;
  }
table{
  border-collapse: collapse;
  width:100%;
}
td,th {
  padding: 0.2em;
  font-size: 0.9rem;
  text-align: center;
}
  td {

    border: 1px solid #ddd;
    font-weight:400;
    color:white!important;
  }
  td:last-child {
    border-right:none;
  }
  td:first-child{
    border-left:none;
  }
  tr:last-child > td {
    border-bottom:none;
  }
  th {
    font-weight:700;
    color: $color--description!important;
  }
</style>
