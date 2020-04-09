<template>
  <div class="background">
    <nuxt />
    <footer>
 <!--     Created by:
      Marius Årnes - https://github.com/appartiff
      Totto - https://github.com/totto-->
    </footer>
  </div>
</template>
<script>
  export default {
    errorCaptured(error, vm, info) {
      console.log(error, vm, info);
      return false;
    },
  }
</script>
<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';
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

.button--green {
  display: inline-block;
  border-radius: 4px;
  border: 1px solid #3b8070;
  color: #3b8070;
  text-decoration: none;
  padding: 10px 30px;
}

.button--green:hover {
  color: #fff;
  background-color: #3b8070;
}

.button--grey {
  display: inline-block;
  border-radius: 4px;
  border: 1px solid #35495e;
  color: #35495e;
  text-decoration: none;
  padding: 10px 30px;
  margin-left: 15px;
}

.button--grey:hover {
  color: #fff;
  background-color: #35495e;
}
</style>
