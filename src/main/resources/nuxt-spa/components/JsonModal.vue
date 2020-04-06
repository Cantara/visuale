<template>
    <pre>
      {{formattedJson}}
    </pre>
</template>

<script>
    export default {
        name: "JsonModal",
      props:{
          text: Object
      },
      computed:{
          formattedJson(){
           return JSON.stringify(this.text, undefined, 4);
          }
      }
    }
</script>

<style scoped>
pre{
  text-align: left;
  overflow-x: scroll;
  overflow-y: scroll;
  max-height: 70vh;
}
</style>
