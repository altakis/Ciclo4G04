import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import bootswatch from '../node_modules/bootswatch/dist/simplex/bootstrap.css'
import bootstrap from '../node_modules/bootstrap/dist/js/bootstrap.js'

createApp(App,bootswatch,bootstrap).use(router).mount('#app')
