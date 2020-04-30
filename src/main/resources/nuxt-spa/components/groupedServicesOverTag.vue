<template>
  <fragment>
    <div class="service-tag-block" v-for="(value, key) in groupedServicesOverTag">
      <div class="marker">
        <div>
          <div class="title">
            <span>TAG: {{key |truncateText(34)}} </span>
          </div>
        </div>
        <div class="content">
          <Service v-for="(service,index) in value" :key="index" :service="service">
          </Service>
        </div>
      </div>
    </div>
  </fragment>
</template>

<script>
    import ServiceElement from "./service/ServiceElement";
    import Service from "./Service";
    export default {
        name: "groupedServicesOverTag",
      components: {ServiceElement,Service},
      props: {
        groupedServicesOverTag: {
          required:false,
          type:Object ,
        }
      },

    }
</script>

<style lang="scss" scoped>
  @import '~/assets/styles/variables/_variables.scss';

  .service-tag-block {
    margin: 0.35em;
    border: 1px solid $color--border;
  }
.content{
  padding: 0.5rem 0.35rem;

  display: inline-flex;
  flex-direction: column;
}
  .marker {
    padding: 0;
    margin-top: -0.6em;
    text-align: center;
    display: flex;
    flex-direction: column;
  }

  .title {
    background: $color--background none repeat scroll 0 0;
    display: flex;
    padding: 0 0.35em;
    margin: 0 0.75em;
    float: left;
    color: white;
    line-height: 1rem;
  }

  .title > span {
    padding: 0 0 0 0.35em;
    color:$color--service-title;
    line-height: 0.9rem;
  }
</style>
