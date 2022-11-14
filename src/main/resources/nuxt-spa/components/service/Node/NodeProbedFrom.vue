<template>
  <span v-if="getProbedFrom==='Public'">
    <VTooltip>
      <font-awesome-icon  :icon="faPublic" class="normal"/>
      <template #popper>
        Probed from Public
      </template>
    </VTooltip>
  </span>
  <span v-else-if="getProbedFrom==='Intranet'">
    <VTooltip>
      <font-awesome-icon  :icon="faIntranet" class="normal"/>
      <template #popper>
        Probed from Intranet
      </template>
    </VTooltip>
  </span>
  <span v-else-if="getProbedFrom==='DMZ'">
    <VTooltip>
      <font-awesome-icon  :icon="faDMZ" class="normal"/>
      <template #popper>
        Probed from DMZ
      </template>
    </VTooltip>
  </span>
  <span v-else-if="getProbedFrom==='Agent'">
    <VTooltip>
      <font-awesome-icon  :icon="faAgent" class="normal"/>
      <template #popper>
        Probed from Agent
      </template>
    </VTooltip>
  </span>
  <span v-else>
    <VTooltip>
      <font-awesome-icon  :icon="faPublic" class="normal"/>
      <template #popper>
        Probed from not-set
      </template>
    </VTooltip>
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
      if (isNullOrUndefined(this.health)) {
        return 'Agent';
      }
      return this.health.hasOwnProperty('probed_from') ? this.health.probed_from : 'Agent';
    }
  }
}
</script>

