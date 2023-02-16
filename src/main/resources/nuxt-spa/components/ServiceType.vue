<template>
  <div class="service-type">
    <span>{{ service_type }}</span>
    <svg v-if="service_type ==='CS'" viewBox="0 0 11.94 8.42" class="icon">
      <g id="a3058e62-a7b3-4776-a72a-1ba1b1277294" data-name="Layer 2"><g id="b554b3ae-f38e-4e32-84b5-b07aa6696658" data-name="CS"><path d="M11.94,8.42H0A10.64,10.64,0,0,1,3.53,0Z" /></g></g>
    </svg>
    <svg v-else-if="service_type ==='H2A'" viewBox="0 0 10.81 12.52" class="icon">
      <g id="ab756077-1414-4ae3-a17a-198a52e37171" data-name="Layer 2"><g id="abe10a52-9bf0-47d0-b9cf-7cfa52aac2b5" data-name="H2A"><g id="a9524303-ea0a-43e0-a821-c877da488b31" data-name="H2A"><path d="M10.81,6.26a6.32,6.32,0,0,1-6.27,6.26,5.42,5.42,0,0,1-4.48-1.9l.26-.23L4.39,6.33,0,1.94A6.56,6.56,0,0,1,4.54,0,6.27,6.27,0,0,1,10.81,6.26Z" /></g></g></g>
    </svg>
    <svg v-else-if="service_type === 'ACS'" viewBox="0 0 23.93 23.83" class="icon">
      <g id="eaf167b7-053a-43cb-8cb5-5658d62be563" data-name="Layer 2"><g id="b29e008a-589a-4ac1-af33-b2173f6a7941" data-name="ACS"><g id="ba8f3315-e17e-4845-abfc-915264dfa90e" data-name="ACS"><path d="M12.41,13V23.83A11.74,11.74,0,0,0,20,20.63Z" /><path d="M11.41,23.83V13L3.85,20.65A11.74,11.74,0,0,0,11.41,23.83Z" /><path d="M3.2,3.69A12.05,12.05,0,0,0,0,11.32H10.76Z" /><path d="M0,12v-.23s0,.08,0,.12S0,11.92,0,12Z" /><path d="M0,12.32a12,12,0,0,0,3.13,7.62l7.56-7.62Z" /><path d="M23.4,12.88a11.34,11.34,0,0,1-2.69,6.36l-6.42-6.36H23.4m.53-.5H13.08L20.73,20a11.79,11.79,0,0,0,3.2-7.59Z" /><path d="M20.73,4.55a11.36,11.36,0,0,1,2.67,6.34H14.34l6.39-6.34m0-.72-7.63,7.56H23.93a11.74,11.74,0,0,0-3.18-7.56Z" /><path d="M10.92.54v9L4.53,3.2A11.51,11.51,0,0,1,10.92.54m.5-.54A12,12,0,0,0,3.79,3.18l7.63,7.55V0Z" /><path d="M12.92.53a11.62,11.62,0,0,1,6.39,2.62L12.92,9.49v-9M12.42,0V10.68L20,3.13A12,12,0,0,0,12.42,0Z" /></g></g></g>
    </svg>
    <svg v-else-if="service_type === 'A2A'" viewBox="0 0 24 12.52" class="icon">
      <g id="a5fb74f3-5a69-48f0-a993-4a3572c01630" data-name="Layer 2"><g id="b5b00002-010a-487e-8529-4dd6ce48acb5" data-name="A2A"><g id="b17aa99f-c691-4a9c-adaf-7ecacf2b8562" data-name="A2A"><path d="M24,6.26a6.31,6.31,0,0,1-6.26,6.26,5.44,5.44,0,0,1-4.49-1.9l.27-.23,4.06-4.06L13.19,1.94A6.54,6.54,0,0,1,17.74,0,6.26,6.26,0,0,1,24,6.26Z" /><path d="M10.48,10.39l.27.23a5.43,5.43,0,0,1-4.49,1.9A6.26,6.26,0,0,1,6.26,0a6.54,6.54,0,0,1,4.55,1.94L6.42,6.33Z" /><polygon points="14.51 7.5 14.51 6.58 9.49 6.58 9.49 7.5 8.5 6.24 9.49 4.99 9.49 5.85 14.51 5.85 14.51 4.99 15.5 6.24 14.51 7.5" /></g></g></g>
      </svg>
  </div>
</template>
<script>

    export default {
        name: "ServiceType",
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

<style lang="scss" scoped>
  .icon{
    fill:$color--nested-sub-border;
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
