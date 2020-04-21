<template>
  <div>
  <div id="modal" v-click-outside="close" class="visible">
    <div class="modal-content">
      <div class="header">
        <h2>{{title}}</h2>
      </div>
      <div class="body">
        <slot></slot>
    </div>
    </div>
  </div>
    <div class="overlay">
      <div class="close" v-if="!this.closeDisabled">
        <font-awesome-icon :icon="faTimes"/>
      </div>
    </div>
  </div>
</template>

<script>
  import { faTimes } from '@fortawesome/free-solid-svg-icons'
    export default {
        name: "Modal",
      props:{
          title:String,
        closeDisabled: Boolean
      },
      computed:{
          faTimes(){
            return faTimes;
          }
      },
      methods:{
          close(){
            if(!this.closeDisabled)
              this.$emit('close');
          },
        handleEscape(event){
          if (event.key === 'Escape' || event.keyCode === 27) {
          this.close();
          }
        }
      },
      mounted() {
        window.addEventListener('keydown',this.handleEscape);
      },
      beforeDestroy() {
          window.removeEventListener('keydown',this.handleEscape)
      }
    }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';

  #modal {
    left: 50%;
    margin: -250px 0 0 -32%;
    opacity: 0;
    position: absolute;
    top: -50%;
    visibility: hidden;
    width: 65%;
    transition: all .4s ease-in-out;
    -moz-transition: all .4s ease-in-out;
    -webkit-transition: all .4s ease-in-out
  }
  @media (max-width: 768px) {
   #modal{
     width: 100%;
     margin: -250px 0 0 -50%;
   }
  }

  .visible {
    opacity: 1!important;
    top: 50%!important;
    visibility: visible!important;
  }

  #modal h2 {
    margin: 0;
    color: $color--description;
  }
  #modal .body, #modal .header, #modal {

  }
  .body {

  }
  .header {
padding:10px;
    background:  $color--background-darker;
  }

  .modal-content {
    position: relative;
    z-index: 20;
    border-radius: 5px;
  }

  #modal .body {
    background: $color--background;
  }

  .overlay {
    background-color: #000;
    background: rgba(0,0,0,.8);
    height: 100%;
    left: 0;
    position: fixed;
    top: 0;
    width: 100%;
    z-index: 10
  }
  .close{
    top: 0;
    right: 0;
    z-index: 20;
    margin:0.5em;
    position: absolute;
    color:white;
    font-size:2rem;
    text-align:center;
  }
</style>
