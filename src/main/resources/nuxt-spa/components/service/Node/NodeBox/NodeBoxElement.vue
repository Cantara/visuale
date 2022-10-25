<template>

  <div @click="$emit('click')" class="node-block" :class="borderStatus">
    <div class="marker">
      <div>
        <div class="title">
          <slot name="title">
          </slot>
        </div>
      </div>
      <div class="content">
        <slot name="content">

        </slot>
      </div>
      <div class="origin" style="margin-left: 120px;margin-top: -40px;">
        <slot name="origin">

        </slot>
      </div>
    </div>
    <slot name="modal">

    </slot>
  </div>
</template>

<script>
import borderStatusMixin from '../../../borderStatusMixin'
export default {
  name: "NodeElement",
  props:{
    healthy_nodes: {
      required:true,
      type: Number | undefined
    }
  },
  mixins:[
    borderStatusMixin]
  ,

}
</script>

<style lang="scss" scoped>



.node-block {
  border: 1px solid $color--nested-sub-border;
  border-radius: 10px;
  height: 55px;
}


.marker {
  padding: 0;
  margin-top: -0.55em;
  text-align: center;
  display: flex;
  flex-direction: column;
}

.title {
  background: $color--background none repeat scroll 0 0;
  display: flex;
  padding: 0 0.35em;
  margin: 0 0.75em;
  color: white;
  line-height: 1rem;
  float: left;
  font-size: 0.9rem;
}

.title > span {
  padding: 0 0 0 0.35em;
  color:$color--node-title;
}

.content {
  padding: 0;
  color: white;
  text-align: left;
}

ul {
  padding: 0 0.2em 0.3em 0.3em;
  list-style: none;
  text-align: left;
  font-size: 0.9rem;
  display: inline-block;
}

li {
  color: white;
}

span {
  font-weight: 400;
}

td {
  color: $color--description;
  text-align: right;
}

th {
  text-align: left;
}
</style>
<template>

  <div @click="$emit('click')" class="node-block" :class="borderStatus">
    <div class="marker">
      <div>
        <div class="title">
          <slot name="title">
          </slot>
        </div>
      </div>
      <div class="content">
        <slot name="content">

        </slot>
      </div>
      <div class="origin" style="margin-left: 120px;margin-top: -40px;">
        <slot name="origin">

        </slot>
      </div>
    </div>
    <slot name="modal">

    </slot>
  </div>
</template>

<script>
import borderStatusMixin from '../../../borderStatusMixin'
export default {
  name: "NodeElement",
  props:{
    healthy_nodes: {
      required:true,
      type: Number | undefined
    }
  },
  mixins:[
    borderStatusMixin]
  ,

}
</script>

<style lang="scss" scoped>



.node-block {
  border: 1px solid $color--nested-sub-border;
  border-radius: 10px;
  height: 55px;
}


.marker {
  padding: 0;
  margin-top: -0.55em;
  text-align: center;
  display: flex;
  flex-direction: column;
}

.title {
  background: $color--background none repeat scroll 0 0;
  display: flex;
  padding: 0 0.35em;
  margin: 0 0.75em;
  color: white;
  line-height: 1rem;
  float: left;
  font-size: 0.9rem;
}

.title > span {
  padding: 0 0 0 0.35em;
  color:$color--node-title;
}

.content {
  padding: 0;
  color: white;
  text-align: left;
}

ul {
  padding: 0 0.2em 0.3em 0.3em;
  list-style: none;
  text-align: left;
  font-size: 0.9rem;
  display: inline-block;
}

li {
  color: white;
}

span {
  font-weight: 400;
}

td {
  color: $color--description;
  text-align: right;
}

th {
  text-align: left;
}
</style>
