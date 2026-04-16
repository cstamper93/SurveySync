import { createRouter, createWebHashHistory } from 'vue-router'
import ProspectsView from '../views/ProspectsView.vue'
import NewView from '../views/NewView.vue'
import ClientView from '../views/ClientView.vue'
import ProspectDetailsView from '../views/ProspectDetailsView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: ProspectsView
  },
  {
    path: '/new-prospect',
    name: 'new',
    component: NewView
  },
  {
    path: '/clients',
    name: 'clients',
    component: ClientView
  },
  {
    path: '/prospect-details/:id',
    name: 'prospect-details',
    component: ProspectDetailsView
  },
  {
    // path: '/about',
    // name: 'about',
    // // route level code-splitting
    // // this generates a separate chunk (about.[hash].js) for this route
    // // which is lazy-loaded when the route is visited.
    // component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
