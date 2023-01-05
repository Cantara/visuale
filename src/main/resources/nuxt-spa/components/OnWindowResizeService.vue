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
          setHeadingPaddingBottom: 'layout/setHeadingPaddingBottom',
          changeMobileState:'layout/changeMobileState',
        }),
        handleResize() {
          const heading = document.getElementById('heading');
          if (heading) {
            this.setHeadingHeight(heading.offsetHeight);
            this.setHeadingPaddingBottom(parseInt(window.getComputedStyle(heading).paddingBottom));
          }
          this.setWindowHeight(window.innerHeight);
          this.changeMobileState(window.innerWidth < 990);
        },

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
