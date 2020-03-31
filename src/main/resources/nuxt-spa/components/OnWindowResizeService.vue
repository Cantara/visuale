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
          setHeadingHeight: 'layout/setHeadingHeight',
          changeMobileState:'layout/changeMobileState'
        }),
        handleResize() {
          var heading = document.getElementById('heading').offsetHeight;
          this.setWindowHeight(window.innerHeight);
          this.setHeadingHeight(heading);
          this.changeMobileState(window.innerWidth < 990);
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
