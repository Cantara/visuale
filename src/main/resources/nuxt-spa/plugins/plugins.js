import  Vue  from  "vue";

import vClickOutside from "v-click-outside"
import Fragment from 'vue-fragment'

Vue.use(vClickOutside);
Vue.config.performance = process.env.NODE_ENV !== 'production'

Vue.use(Fragment.Plugin)
