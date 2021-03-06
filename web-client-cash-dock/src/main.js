import Vue from 'vue'
import Vuelidate from 'vuelidate'
import App from './App.vue'
import Paginate from 'vuejs-paginate'
import router from './router'
import store from './store'
import dateFilter from '@/filters/date.filter'
import currencyFilter from '@/filters/currency.filter'
import localizeFilter from '@/filters/localize.filter'
import messagePlugin from '@/utils/message.plugin'
import Loader from "@/components/app/Loader";
import './registerServiceWorker'
import 'materialize-css/dist/js/materialize.min'
import tooltipDirective from "@/directives/tooltip.directive"

Vue.config.productionTip = false

Vue.use(messagePlugin)
Vue.use(Vuelidate)
Vue.filter('date', dateFilter)
Vue.filter('currency', currencyFilter)
Vue.filter('localize', localizeFilter)
Vue.component('Loader', Loader)
Vue.directive('tooltip', tooltipDirective)
Vue.component('Paginate', Paginate)

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
