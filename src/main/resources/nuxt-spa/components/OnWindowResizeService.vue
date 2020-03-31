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
          setHeight: 'layout/setWindowHeight' // map `this.add()` to `this.$store.commit('increment')`
        }),
        handleResize() {
          this.setHeight(window.innerHeight);
        }
      },
      created() {
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
