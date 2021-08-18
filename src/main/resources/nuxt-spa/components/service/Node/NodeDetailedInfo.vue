<template>
    <pre v-html="formattedJson">
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
            //removes artifically created key to keep data raw again.
            let formattedText = {...this.text};
            delete formattedText['key'];
            let json = JSON.stringify(formattedText,undefined,4);
            json.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;')
            return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function (match) {
              var cls = 'number';
              if (/^"/.test(match)) {
                if (/:$/.test(match)) {
                  cls = 'key';
                } else {
                  cls = 'string';
                }
              } else if (/true|false/.test(match)) {
                cls = 'boolean';
              } else if (/null/.test(match)) {
                cls = 'null';
              }
              return '<span class="' + cls + '">' + match + '</span>';
            });
          }
      }
    }
</script>

<style lang="scss">

pre{
  text-align: left;
  overflow-x: scroll;
  overflow-y: scroll;
  max-height: 70vh;
  padding:10px;
  color: $color--description;
  .boolean {
    color: $color--json-boolean;
  }
  .string {
    color: $color--json-string;
  }
  .number {
    color: $color--json-number;
  }
  .key {
    color:$color--description-lighter;
  }

}

</style>
