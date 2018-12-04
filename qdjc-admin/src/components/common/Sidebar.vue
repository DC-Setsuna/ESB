<template>
  <el-menu :default-active="onRoutes" id="el-menu-vertical-demo" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b" :router="true">
    <el-menu-item index="service-admin">
      <i class="el-icon-menu"></i>
      <span slot="title">服务管理</span>
    </el-menu-item>
    <el-menu-item index="route-admin">
      <i class="el-icon-menu"></i>
      <span slot="title">路由管理</span>
    </el-menu-item>
    <el-menu-item index="system">
      <i class="el-icon-menu"></i>
      <span slot="title">系统用户</span>
    </el-menu-item>
    <el-menu-item index="log">
      <i class="el-icon-setting"></i>
      <span slot="title">日志</span>
    </el-menu-item>
    <el-submenu index="/">
      <template slot="title">
        <i class="el-icon-location"></i>
        <span>系统监控</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="mq-admin">MQ监控</el-menu-item>
        <!-- <el-menu-item index="/">队列管理器状态</el-menu-item> -->
      </el-menu-item-group>
      <el-menu-item-group>
        <el-menu-item index="ws-admin">WS监控</el-menu-item>
        <!-- <el-menu-item index="/">队列管理器状态</el-menu-item> -->
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>
<script>
export default {
  name: 'homepage',
  data() {
    return {

    }
  },
  computed: {
    onRoutes() {
      return this.$route.path.replace('/', '');
    }
  }
}

</script>
<style>
#el-menu-vertical-demo {
  position: fixed;
  top: 50px;
  left: 0;
  width: 200px;
  height: calc(100% - 50px);
}

</style>
