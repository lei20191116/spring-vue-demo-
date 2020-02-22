import Vue from 'vue'

import VueRouter from 'vue-router'
import UserManage from "../views/UserManage.vue"
import AddUser from "../views/AddUser.vue"
import UserUpdate from "../views/UserUpdate.vue"

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    name: "用户管理",
    component:() => import("../views/index.vue"),
    show:true,
    redirect:"/UserManage",
    children: [
      {
        path:"/UserManage",
        name:"查询用户",
        component:UserManage
      },
      {
        path:"/AddUser",
        name:"添加用户",
        component:AddUser
      }
    ]
  },
  {
    path:"/UserUpdate",
    show:false,
    component:UserUpdate
  }

 
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
