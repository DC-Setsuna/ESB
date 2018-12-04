import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/page/Login'
import home from '@/components/common/Home'
import routeAdmin from '@/components/page/RouteAdmin'
import serviceAdmin from '@/components/page/ServiceAdmin'
import log from '@/components/page/Log'
import mqAdmin from '@/components/page/MqAdmin'
import wsAdmin from '@/components/page/WsAdmin'
import system from '@/components/page/System'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/home',
      component: home,
      children: [
        {
          path: "/service-admin",
          component: serviceAdmin
        },
        {
          path: "/route-admin",
          component: routeAdmin
        },
        {
          path: "/log",
          component: log
        },
        {
          path: "/mq-admin",
          component: mqAdmin
        },
        {
          path: "/ws-admin",
          component: wsAdmin
        },
        {
          path: "/system",
          component: system
        }
      ]
    },
    {
      path: '/login',
      component: login
    }
  ]
})
