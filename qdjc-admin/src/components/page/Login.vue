<template>
  <el-dialog title="管理运行平台管理系统" :visible="true" :show-close="false" width="600px">
    <el-form label-position="right" label-width="80px" :rules="loginRules" :model="formLabelLogin" ref="formLabelLogin">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="formLabelLogin.username" auto-complete="off" spellcheck="false"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="formLabelLogin.password" type="password" auto-complete="off" spellcheck="false" @keyup.enter.native="submit"></el-input>
      </el-form-item>
      <el-form-item>
        <el-checkbox v-model="formLabelLogin.remember">记住密码</el-checkbox>
        <span style="margin-left:20px;color:#bbb;">密码有效时间为24小时</span>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="submit">确 定</el-button>
    </div>
  </el-dialog>
</template>
<script>
export default {
  data() {
    return {
      formLabelLogin: {
        username: '',
        password: '',
        remember: true
      },
      loginRules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submit: function() {
      if (this.formLabelLogin.username === 'admin' && this.formLabelLogin.password === 'admin') {
        localStorage.setItem('username', this.formLabelLogin.username);
        this.$router.push('/service-admin');
      } else {
        this.$message.error('用户名或密码错误')
      }

    }
  }
}

</script>
<style>


</style>
