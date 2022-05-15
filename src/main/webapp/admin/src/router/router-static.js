import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import shetuanhuodong from '@/views/modules/shetuanhuodong/list'
    import discussremaishangpin from '@/views/modules/discussremaishangpin/list'
    import jiaoshi from '@/views/modules/jiaoshi/list'
    import shezhang from '@/views/modules/shezhang/list'
    import storeup from '@/views/modules/storeup/list'
    import forum from '@/views/modules/forum/list'
    import huodongshenqing from '@/views/modules/huodongshenqing/list'
    import shangpinfenlei from '@/views/modules/shangpinfenlei/list'
    import discussbiaobaiqiang from '@/views/modules/discussbiaobaiqiang/list'
    import biaobaiqiang from '@/views/modules/biaobaiqiang/list'
    import messages from '@/views/modules/messages/list'
    import remaishangpin from '@/views/modules/remaishangpin/list'
    import orders from '@/views/modules/orders/list'
    import kaoshichengji from '@/views/modules/kaoshichengji/list'
    //import classroom from '@/views/modules/classroom/list'
    import config from '@/views/modules/config/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '校园公告',
        component: news
      }
      ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
      ,{
	path: '/shetuanhuodong',
        name: '社团活动',
        component: shetuanhuodong
      }
      ,{
	path: '/discussremaishangpin',
        name: '热卖商品评论',
        component: discussremaishangpin
      }
      ,{
	path: '/jiaoshi',
        name: '教师',
        component: jiaoshi
      }
      ,{
	path: '/shezhang',
        name: '社长',
        component: shezhang
      }
      ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/forum',
        name: '交流论坛',
        component: forum
      }
      ,{
	path: '/huodongshenqing',
        name: '活动申请',
        component: huodongshenqing
      }
      ,{
	path: '/shangpinfenlei',
        name: '商品分类',
        component: shangpinfenlei
      }
      ,{
	path: '/discussbiaobaiqiang',
        name: '表白墙评论',
        component: discussbiaobaiqiang
      }
      ,{
	path: '/biaobaiqiang',
        name: '表白墙',
        component: biaobaiqiang
      }
      ,{
	path: '/messages',
        name: '投诉建议',
        component: messages
      }
      ,{
	path: '/remaishangpin',
        name: '热卖商品',
        component: remaishangpin
      }
      ,{
        path: '/orders/:status',
        name: '订单管理',
        component: orders
      }
      ,{
	path: '/kaoshichengji',
        name: '考试成绩',
        component: kaoshichengji
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
