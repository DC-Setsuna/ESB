<template>
  <div class="header">
    <div class="logo">管理运行平台ESB管理与监控系统</div>
    <div class="user-info">
      <el-dropdown trigger="click" @command="handleCommand">
        <span class="el-dropdown-link">
                    <img class="user-logo" src="../../../static/img/img.jpg">
                    {{username}}
                </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="loginout">退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      name: 'Admin'
    }
  },
  computed: {
    username() {
      let username = localStorage.getItem('username');
      return username ? username : this.name;
    }
  },
  methods: {
    handleCommand(command) {
      if (command == 'loginout') {
        localStorage.removeItem('username')
        this.$router.push('/login');
      }
    }
  }
}

</script>
<style scoped>
.header {
  position: fixed;
  box-sizing: border-box;
  width: 100%;
  height: 50px;
  font-size: 22px;
  line-height: 50px;
  color: #fff;
  background-color: #3b3e41;
  top: 0;
}

.header .logo {
  float: left;
  width: 400px;
  text-align: center;
}

.user-info {
  float: right;
  padding-right: 50px;
  font-size: 16px;
  color: #fff;
}

.user-info .el-dropdown-link {
  position: relative;
  display: inline-block;
  padding-left: 50px;
  color: #fff;
  cursor: pointer;
  vertical-align: middle;
}

.user-info .user-logo {
  position: absolute;
  left: 0;
  top: 7.5px;
  width: 35px;
  height: 35px;
  border-radius: 50%;
}

.el-dropdown-menu__item {
  text-align: center;
}

</style>
