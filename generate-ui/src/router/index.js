import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/project',
    name: 'Project',
    component: () => import('@/views/project/project.vue')
  },
  {
    path: '/',
    name: '',
    component: () => import('@/layout'),
    children: [
      { path: "/", redirect: "/project" },
      {
        path: "/home",
        name: "首页",
        component: () => import("@/views/databaseManage/databaseManage.vue")
      },
      {
        path: "/projectPath",
        name: "项目地址",
        component: () => import("@/views/project/projectPath.vue")
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
