<template>
  <div class="background">
    <StoreMediator/>
    <PollingService/>
    <OnWindowResizeService/>
    <ServerExceptionHandling/>
    <nuxt />
    <footer>
 <!--     Created by:
      Marius Årnes - https://github.com/appartiff
      Totto - https://github.com/totto-->
    </footer>

  </div>
</template>
<script>
  import PollingService from "../components/PollingService";
  import OnWindowResizeService from "../components/OnWindowResizeService";
  import ServerExceptionHandling from "../components/serverExceptionHandling/ServerExceptionHandling";
  import StoreMediator from "../components/StoreMediator";
  export default {
    errorCaptured(error, vm, info) {
      console.log(error, vm, info);
      return false;
    },
    components:{
      PollingService,
      OnWindowResizeService,
      ServerExceptionHandling,
      StoreMediator
    }
  }
</script>
<style lang="scss" scoped>

  .background {
    background-color: $color--background;
  }
  @media only screen and (max-width: 990px) {
    .background {
      padding-bottom: 2rem;
    }
  }



</style>
<style>
html {
  font-family: 'Source Sans Pro', -apple-system, BlinkMacSystemFont, 'Segoe UI',
    Roboto, 'Helvetica Neue', Arial, sans-serif;
  font-size: 14px;
  word-spacing: 1px;
  -ms-text-size-adjust: 100%;
  -webkit-text-size-adjust: 100%;
  -moz-osx-font-smoothing: grayscale;
  -webkit-font-smoothing: antialiased;
  box-sizing: border-box;
}

*,
*:before,
*:after {
  box-sizing: border-box;
  margin: 0;
}
</style>
