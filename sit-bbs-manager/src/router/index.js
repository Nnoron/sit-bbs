import Vue from 'vue'
import Router from 'vue-router'
import ArticleManager from '@/views/ArticleManager'
import Home from '@/views/Home'
import MyInfo from '@/views/MyInfo'
import CommentManager from '@/views/CommentManager'
import FileManager from '@/views/FileManager'
import UserManager from '@/views/UserManager'
import Statistics from '@/views/Statistics'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      redirect: '/Home'
    },
    {
      path: '/Home',
      name: Home,
      component: Home
    },
    {
      path: '/ArticleManager',
      name: ArticleManager,
      component: ArticleManager
    },
    {
      path: '/MyInfo',
      name: MyInfo,
      component: MyInfo
    },
    {
      path: '/CommentManager',
      name: CommentManager,
      component: CommentManager
    },
    {
      path: '/FileManager',
      name: FileManager,
      component: FileManager
    },
    {
      path: '/UserManager',
      name: UserManager,
      component: UserManager
    },
    {
      path: '/Statistics',
      name: Statistics,
      component: Statistics
    },
  ]
})
