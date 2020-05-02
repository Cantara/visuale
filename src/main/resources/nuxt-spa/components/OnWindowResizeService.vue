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
          setheadingPaddingBottom: 'layout/setHeadingPaddingBottom',
          changeMobileState:'layout/changeMobileState',
        }),
        handleResize() {
          const heading = document.getElementById('heading');
          this.setheadingPaddingBottom(parseInt(window.getComputedStyle(heading).paddingBottom));
          this.setWindowHeight(window.innerHeight);
          this.setHeadingHeight(heading.offsetHeight);
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
