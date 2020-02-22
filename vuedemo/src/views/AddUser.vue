<template>
  <div>
    <el-form style="width: 50%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
  <el-form-item label="用户名" prop="name">
    <el-input v-model="ruleForm.name"></el-input>
  </el-form-item>
 <el-form-item label="密码" prop="password">
    <el-input type="password"  v-model="ruleForm.password" autocomplete="off"></el-input>
  </el-form-item>

  <el-form-item>
    <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
    <el-button @click="resetForm('ruleForm')">重置</el-button>
  </el-form-item>
</el-form>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        ruleForm: {
          name: '',
          password: '',
        },
        rules: {
          name: [
            { required: true, message: '用户名不能为', trigger: 'blur' },
            { min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '密码不能为空', trigger: 'blur' },
            { min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: 'blur' }
          ],
          
        }
      };
    },
    methods: {

      submitForm(formName) {
        const _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.post('http://localhost:8181/user/save',this.ruleForm).then(function(resp){
                console.log(resp)
                if(resp.data == "success"){

                    _this.$alert('《'+_this.ruleForm.name+'》添加成功', '消息', {
                    confirmButtonText: '确定',
                    callback: action => {
                      _this.$router.push('/UserManage')
                    }
                  });
                  
                  
                  
                }
            })
            
          } else {
            
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>