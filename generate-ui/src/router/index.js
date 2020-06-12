import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Project',
    component: () => import('@/views/project/project.vue')
  },
  {
    path: '/home',
    name: 'Layout',
    component: () => import('@/layout'),
    children: [
      { path: "/home", redirect: "/home/home" },
      {
        path: "/home/home",
        name: "首页",
        component: () => import("@/views/Home.vue")
      },
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
