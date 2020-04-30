<template>

    <div class="marker">
      <div class="content">
        <table>
          <tbody :class="borderStatus">
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
      <slot name="modal">

      </slot>
    </div>
</template>

<script>
  import borderStatusMixin from '../../../borderStatusMixin'
    export default {
        name: "NodeListElement",
      props:{
        healthy_nodes: {
          required:true,
          type: Number | undefined
        }
      },
      mixins:[borderStatusMixin],
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

  .border--color-danger  td,.border--color-danger  th {
    border-color: $color--danger!important;
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

  font-size: 0.9rem;
  text-align: center;
}
  td {
    padding: 0.2em;
    border: 1px solid $color--border;
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
    padding: 0.2em 0;
    color: $color--description!important;
  }
</style>
