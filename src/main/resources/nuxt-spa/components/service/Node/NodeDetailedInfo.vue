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
            //removes artificially created key to keep data raw again.
            let formattedText = {...this.text};
            delete formattedText['key'];
            let json = JSON.stringify(formattedText,undefined,4);
            json.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;')
            return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)|(\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2})/g, function (match) {
              let cls = 'number';
              if (/(\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2})/.test(match)) {
                let idx = 0;
                while (idx !== -1) {
                  idx = match.search(/(\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2})/);
                  if (idx === -1)
                    break;

                  let date = match.substring(idx, idx+19);
                  date = date.replace("T", " ");
                  match = match.substring(0, idx) + date + match.substring(idx + 27, match.length);
                }
                cls = 'date';
              } else if (/^"/.test(match)) {
                 if (/:$/.test(match)) {
                  cls = 'key';
                } else {
                  cls = 'string';
                }
              } else if (/true|false/.test(match)) {
                cls = 'boolean';
              }  else if (/null/.test(match)) {
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
  overflow-x: hidden;
  overflow-y: auto;
  overflow-wrap: break-word;
  max-height: 70vh;
  padding: 10px;
  white-space: pre-wrap;       /* css-3 */
  word-wrap: break-word;       /* Internet Explorer 5.5+ */
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
  .date {
    color: $color--json-date;
  }
  .key {
    color:$color--description-lighter;
  }

}

</style>
