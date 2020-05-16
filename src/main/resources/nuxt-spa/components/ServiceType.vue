<template>
  <div class="service-type">
    <span>{{service_type}}</span>
    <CS class="icon" v-if="service_type ==='CS'"></CS>
    <H2A class="icon" v-else-if="service_type ==='H2A'"></H2A>
    <ACS class="icon" v-else-if="service_type === 'ACS'"></ACS>
    <A2A class="icon" v-else-if="service_type === 'A2A'"></A2A>
  </div>
</template>
<script>

  import CS from '~/static/CS.svg';
  import A2A from '~/static/A2A.svg';
  import ACS from '~/static/ACS.svg';
  import H2A from '~/static/H2A.svg';

    export default {
        name: "ServiceType",
      components:{
          CS,A2A,ACS,H2A
      },
      props: {
        service_type: {
          required:false,
          type:String,
          default:'',
        }
      },
      computed:{

      }
    }
</script>

<style scoped>
  .icon{
    fill:#A9D2FD;
    height:1em;
  }
  .service-type {
    margin: 0 0.75em 0 0;
    margin-left: auto!important;
    padding: 0 0.35em!important;

  }
  span {
    vertical-align: top;
  }
</style>
