import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'

export default new Vuex.Store({
  state: {
  	// api: 'http://localhost:8080',
    // api: 'http://10.232.90.68:8080', 
    api: '', 
    platform: [
      { value: 'DDXP', label: '数据交换平台' },
      { value: 'ADXP', label: '生产运行平台' },
      { value: 'MDXP', label: '管理运行平台' },
      { value: 'SDXP', label: '安全运行平台' },
      { value: 'FDXP', label: '服务运行平台' }
    ],
    system: {
      MDXP: [
        { value: 'HR', label: '人力资源管理系统' },
        { value: 'PAM', label: '资产管理系统' },
        { value: 'FINM', label: '财务管理系统' },
        { value: 'SMS', label: '安全信息管理系统' }
      ]
    },
    serviceType: [
    	{ value: 'M', label: 'MQ' },
    	{ value: 'W', label: 'WebService' }
    ]
  },
  mutations: {

  }
})
