import  Vue  from  "vue";

import vClickOutside from "v-click-outside"
import FloatingVue from 'floating-vue'

Vue.use(FloatingVue)
Vue.use(vClickOutside);
Vue.config.performance = process.env.NODE_ENV !== 'production'


import frag from 'vue-frag';
Vue.directive('fragment', frag);

import Fragment from "~/components/Fragment";
import 'floating-vue/dist/style.css'

const components = { Fragment }
Object.entries(components).forEach(([name, component]) => {
  Vue.component(name, component)
})
