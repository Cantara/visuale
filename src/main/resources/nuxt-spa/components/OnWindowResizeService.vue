<template>
    <div>
    </div>
</template>

<script>
  import { mapMutations } from 'vuex'
    export default {
      name: "OnWindowResizeService",
      methods:{
        ...mapMutations({
          setWindowHeight: 'layout/setWindowHeight',
          setHeadingHeight: 'layout/setHeadingHeight'
        }),
        handleResize() {
          var heading = document.getElementById('heading').offsetHeight;
          this.setWindowHeight(window.innerHeight);
          this.setHeadingHeight(heading);
        }
      },
      mounted() {
        window.addEventListener('resize', this.handleResize);
        this.handleResize();
      },
      beforeDestroy() {
        window.removeEventListener('resize', this.handleResize);
      },

    }
</script>

<style scoped>

</style>
