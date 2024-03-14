<template>
  <div id="details">
    <!-- 头部 -->
    <div class="page-header">
      <div class="title" style="font-size: 14px;">
        <p>首页>> 音乐人列表 >> 音乐人添加 </p>
      </div>
    </div>
    <div class="main">
      <div class="content">
        <el-form label-width="150px" ref="editForm" :model="editForm" :rules="rules">
          <el-form-item  label="用户名" prop="username"><el-input size="small" v-model="editForm.username" auto-complete="off" placeholder="请输入用户名" style='width:50%'></el-input></el-form-item>
		
		<el-form-item  label="uid" prop="uid"><el-input size="small" v-model="editForm.uid" auto-complete="off" placeholder="请输入uid" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="邮箱" prop="email"><el-input size="small" v-model="editForm.email" auto-complete="off" placeholder="请输入邮箱" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="性别" prop="sex"><el-radio v-model="editForm.sex" :label=true>男</el-radio><el-radio v-model="editForm.sex" :label=false>女</el-radio></el-form-item>
		<el-form-item  label="年龄" prop="age"><el-input type="textarea" size="small" v-model="editForm.age" auto-complete="off" placeholder="请输入年龄" style='width:100%'></el-input></el-form-item>
		<el-form-item  label="签名" prop="text"><el-input type="textarea" size="small" v-model="editForm.text" auto-complete="off" placeholder="请输入签名" style='width:100%'></el-input></el-form-item>
		<el-form-item  label='头像' prop='icon'><el-upload class='avatar-uploader' action='http://localhost:9999/files/upload' :headers='headers' :show-file-list='false' :on-success='handleIconSuccess' :before-upload='beforeIconUpload'><img v-if='editForm.icon' :src='editForm.icon' class='avatar'><i v-else class='el-icon-plus avatar-uploader-icon'></i></el-upload></el-form-item>
		

        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">添加</el-button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>

  export default {
    data() {
      return {
        dis: false, // 控制“加入购物车按钮是否可用”
		username:'',
        cx:'',
		//lbdqxx
        rules: {
          username: [{ required: true, message: '请输入用户名', trigger: 'blur' },
				],
				password: [{ required: true, message: '请输入密码', trigger: 'blur' },
				],
				uid: [{ required: true, message: '请输入uid', trigger: 'blur' },
				],

        },
        editForm: {
          avater:'',
          //lbdqyy

        },
      };
    },
    watch: {
      // eslint-disable-next-line no-unused-vars
      '$route' (to, from) {
        // 路由发生变化页面刷新
        this.$router.go(0);
      }
    },
    created() {
      if (localStorage.getItem("user")) {
            // 如果已经登录，设置vuex登录状态
            //this.setUser(JSON.parse(localStorage.getItem("user")));
			this.userInfo=JSON.parse(localStorage.getItem("user"));
            this.username = localStorage.getItem("username");
            this.cx = localStorage.getItem("cx");
        }
      //sesxsionduxqu
      // lbdqzz
    },
    methods: {
      getProjectNum () {
        const projectTime = new Date() // 当前中国标准时间
        const Year = projectTime.getFullYear() // 获取当前年份 支持IE和火狐浏览器.
        const Month = projectTime.getMonth() + 1 // 获取中国区月份
        const Day = projectTime.getDate() // 获取几号
        let CurrentDate = Year;
        if (Month >= 10) { // 判断月份和几号是否大于10或者小于10
          CurrentDate += Month
        } else {
          CurrentDate += '0' + Month
        }
        if (Day >= 10) {
          CurrentDate += Day
        } else {
          CurrentDate += '0' + Day
        }
        return CurrentDate
      },
      //qixuzhijixsuan3
      // lbdquu
      submitForm(editData) {
        this.$refs[editData].validate(valid => {
          if (valid) {
            // eslint-disable-next-line no-empty
            if(this.editForm.id){
            }else {
              this.$axios
                      .post("/api/front/postartist/",this.editForm)
                      .then(res => {
                        if (res.data.code == '0') {
                          this.$message({
                            type: 'success',
                            message: '添加成功！'
                          })
                        }

						else {
                          this.$message({
                            type: 'info',
                            message: res.msg
                          })
                        }
                      }).catch(err => {
                if(err){
                  this.$message.error(err)
                }else {
                  this.$message.error('操作失败，请稍后再试！')
                }
              })
            }
          } else {
            return false
          }
        })
      },
    }
  };
</script>
<style>
  @import "../assets/css/index.scss";
  /* 头部CSS */
  #details .page-header {
    height: 64px;
    margin-top: -20px;
    z-index: 4;
    background: #fff;
    border-bottom: 1px solid #e0e0e0;
    -webkit-box-shadow: 0 5px 5px rgba(0, 0, 0, 0.07);
    box-shadow: 0 5px 5px rgba(0, 0, 0, 0.07);
  }
  #details .page-header .title {
    width: 1225px;
    height: 64px;
    line-height: 64px;
    font-size: 18px;
    font-weight: 400;
    color: #212121;
    margin: 0 auto;
  }
  #details .page-header .title p {
    float: left;
  }

  #details .page-header .title .list li {
    float: left;
    margin-left: 20px;
  }
  #details .page-header .title .list li a {
    font-size: 14px;
    color: #616161;
  }
  #details .page-header .title .list li a:hover {
    font-size: 14px;
    color: #ff6700;
  }
  /* 头部CSS END */

  /* 主要内容CSS */
  #details .main {
    width: 1225px;
    height: 560px;
    padding-top: 30px;
    margin: 0 auto;
  }

  #details .main .content {
    float: left;
    margin-left: 25px;
    width: 640px;
  }

  #details .main .content .pro-list span {
    line-height: 30px;
    color: #616161;
  }

  #details .main .content .pro-policy li {
    float: left;
    margin-right: 20px;
    color: #b0b0b0;
  }
  /* 主要内容CSS END */
</style>
