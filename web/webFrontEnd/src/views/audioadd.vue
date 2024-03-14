<template>
  <div id="details">
    <!-- 头部 -->
    <div class="page-header">
      <div class="title" style="font-size: 14px;">
        <p>首页>> 音频稿件列表 >> 投稿 </p>
      </div>
    </div>
    <div class="main">
      <div class="content">
        <el-form label-width="150px" ref="editForm" :model="editForm" :rules="rules">
          <el-form-item  style="display: none" label="aid" prop="aid"><el-input size="small" v-model="editForm.aid" auto-complete="off" placeholder="请输入aid" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="厂牌名称" prop="labelname"><el-input size="small" v-model="editForm.labelname" auto-complete="off" placeholder="请输入厂牌名称" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="作品名" prop="audioname"><el-input size="small" v-model="editForm.audioname" auto-complete="off" placeholder="请输入作品名" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="作者" prop="author"><el-input size="small" v-model="editForm.author" auto-complete="off" placeholder="请输入作者" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label='文件' prop='audio'><el-upload class='avatar-uploader' action='/api/files/front/uploadfile' :headers='headers' :show-file-list='false' :on-success='handleFileSuccess' ><el-button>上传</el-button></el-upload></el-form-item>
		<el-form-item  label="流派" prop="genre"><el-input size="small" v-model="editForm.genre" auto-complete="off" placeholder="请输入流派" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="稿件备注/联系方式" prop="remark"><el-input type="textarea" size="small" v-model="editForm.remark" auto-complete="off" placeholder="请输入稿件备注/联系方式，以便厂牌进行后续跟进" style='width:100%'></el-input></el-form-item>
		<el-form-item  label="上传时间" prop="udt"><el-input size="small" v-model="editForm.udt" auto-complete="off" placeholder="请输入上传时间" style='width:50%'></el-input></el-form-item>
		

        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">提交</el-button>
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
		labelID:'',
label:'',
          currentTime: '',
        rules: {
          audioname: [{ required: true, message: '请输入作品名', trigger: 'blur' },
				],
				
        },
        editForm: {
          avater:'',
          labelname:'',


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
      mounted() {
          let date = new Date();
          let year = date.getFullYear();
          let month = date.getMonth() + 1;
          let day = date.getDate();
          let hour = date.getHours();
          let minute = date.getMinutes();
          let second = date.getSeconds();
          this.currentTime = year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;
          this.editForm.qiandaoshijian= this.currentTime;
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
      this.editForm.aid = this.getProjectNum() + Math.floor(Math.random() * 10000);
      let id = this.$route.params.id;this.getDetails(id);
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
      getDetails(id){
			this.$axios
                .get("/api/front/getlabeldetail/"+id,)
                .then(res => {
                  this.label = res.data.data;
                  this.editForm.labelname = this.label.labelname;
                    this.editForm.udt= this.currentTime;
                  this.editForm.author= this.userInfo.username;
                })
                .catch(err => {
                  return Promise.reject(err);
                });
			
		},
      // eslint-disable-next-line no-unused-vars
      handleFileSuccess(res, file) {
				if(res.code == "0") {
					this.editForm.wenjian = "/files/download/"+res.data.id
					this.$message({
						type: 'success',
						message: '文件上传成功！'
					})
				}
				else {
					this.$message({
						type: 'info',
						message: res.msg
					})
				}
			},
			download(data){
			location.href = data.file;
		},
				
      submitForm(editData) {
        this.$refs[editData].validate(valid => {
          if (valid) {
            // eslint-disable-next-line no-empty
            if(this.editForm.id){
            }else {
              this.$axios
                      .post("/api/front/postaudio/",this.editForm)
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
