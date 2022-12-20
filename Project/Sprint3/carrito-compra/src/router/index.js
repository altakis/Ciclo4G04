import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/parametro-departamento',
    name: 'registro-departamento',
    component: () => import('../views/parameter/DepartmentView.vue')
  },
  {
    path: '/parametro-ciudad',
    name: 'registro-ciudad',
    component: () => import('../views/parameter/CityView.vue')
  },
  {
    path: '/seguridad-usuario',
    name: 'registro-usuario',
    component: () => import('../views/security/UserView.vue')
  },
  {
    path: '/seguridad-persona',
    name: 'registro-persona',
    component: () => import('../views/security/PersonView.vue')
  },
  {
    path: '/acceso-rol',
    name: 'registro-rol',
    component: () => import('../views/access/RolView.vue')
  },
  {
    path: '/acceso-permiso',
    name: 'registro-permiso',
    component: () => import('../views/access/PermissionView.vue')
  },
  {
    path: '/acceso-rolUser',
    name: 'registro-rolUser',
    component: () => import('../views/access/UserRolView.vue')
  },
  {
    path: '/acceso-rolPermiso',
    name: 'registro-rolPermiso',
    component: () => import('../views/access/RolPermissionView.vue')
  }

]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
