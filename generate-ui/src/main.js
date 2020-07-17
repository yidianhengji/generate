import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import '@/styles/reset.styl'
import '@/styles/font/css/font-awesome.min.css'
import AElDialog from './components/Dialog/AElDialog.js'
Vue.use(ElementUI)
Vue.use(AElDialog)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
