<template>
    <div>
    </div>
</template>

<script>
  import {mapMutations} from 'vuex';
    export default {
        name: "StoreMediator",
      created() {
        this.unsubscribe = this.$store.subscribe((mutation, state) => {
          switch (mutation.type) {
            case 'setData':
              this.resetConnectionFailed();
          }
        });
      },
      methods:{
        ...mapMutations({
          resetConnectionFailed: 'resetConnectionFailed',
        })
      },
      beforeDestroy() {
        this.unsubscribe();
      },
    }
</script>

<style scoped>

</style>
