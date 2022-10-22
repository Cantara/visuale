<template>
  <span>
    <font-awesome-icon v-if="getProbedFrom==='Public'" :icon="faPublic" class="normal"/>
    <font-awesome-icon v-else-if="getProbedFrom==='Intranet'" :icon="faIntranet" class="normal"/>
    <font-awesome-icon v-else-if="getProbedFrom==='DMZ'" :icon="faDMZ" class="normal"/>
    <font-awesome-icon v-else-if="getProbedFrom==='Agent'" :icon="faAgent" class="normal"/>
  </span>
</template>

<script>
import {isNullOrUndefined} from "../../../utils/typeUtils";
import {
  faGlobeAmericas, faNetworkWired, faServer, faTowerBroadcast
} from '@fortawesome/free-solid-svg-icons'

export default {
  name: "NodeProbedFrom",
  props: {
    health: {
      required: false,
      type: Object | undefined
    }
  },
  computed: {
    faPublic() {
      return faGlobeAmericas;
    },
    faIntranet() {
      return faNetworkWired;
    },
    faDMZ() {
      return faServer;
    },
    faAgent() {
      return faTowerBroadcast;
    },
    getProbedFrom() {
      console.log("health: " + this.health);
      if (isNullOrUndefined(this.health)) {
        return 'Agent';
      }
      return this.health.hasOwnProperty('probed_from') ? this.health.probed_from : 'Agent';
    }
  }
}
</script>

