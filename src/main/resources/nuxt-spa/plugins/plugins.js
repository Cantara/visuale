import  Vue  from  "vue";

import vClickOutside from "v-click-outside"

Vue.use(vClickOutside);
Vue.config.performance = process.env.NODE_ENV !== 'production'


import frag from 'vue-frag';
Vue.directive('fragment', frag);

import Fragment from "~/components/Fragment";
const components = { Fragment }
Object.entries(components).forEach(([name, component]) => {
  Vue.component(name, component)
})
