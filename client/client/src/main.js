import { createApp } from 'vue'

import App from './App.vue'
import { createRouter, createWebHashHistory } from 'vue-router';
import Vant from 'vant'
import 'vant/lib/index.css'
import login from './components/login.vue'
import register from './components/register.vue'
import Main from './components/Main.vue'
import chat from './components/chat.vue'
import ElementPlus from 'element-plus'
import { createPinia } from 'pinia'
import 'element-plus/dist/index.css'
import './style.css'
const pinia = createPinia()
const routes = [
    { 
      path: '/',
      component: login 
    },
    {
        path: '/Main',
        name: 'Main',
        component: Main,
      },
    { path: '/register', component: register },
    { path: '/chat', name: 'chat', component: chat },
    
  ]
  const router = createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: createWebHashHistory(),
    routes, // `routes: routes` 的缩写
  })
const app = createApp(App)
app.use(router)
app.use(Vant)
app.use(pinia)
app.use(ElementPlus)
app.mount('#app')
