<template>
	<div class="personal">
		<el-form label-width="100px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="aid" prop="aid"><el-input size="small" v-model="editForm.aid" auto-complete="off" placeholder="请输入aid" style='width:50%'></el-input></el-form-item>		<el-form-item  label="厂牌名称" prop="changpaimingcheng"><el-input size="small" v-model="editForm.changpaimingcheng" auto-complete="off" placeholder="请输入厂牌名称" style='width:50%' disabled></el-input></el-form-item>		<el-form-item  label="作品名" prop="zuopinming"><el-input size="small" v-model="editForm.zuopinming" auto-complete="off" placeholder="请输入作品名" style='width:50%'></el-input></el-form-item>		<el-form-item  label="作者" prop="zuozhe"><el-input size="small" v-model="editForm.zuozhe" auto-complete="off" placeholder="请输入作者" style='width:50%' disabled></el-input></el-form-item>		<el-form-item  label='文件' prop='wenjian'><el-upload class='avatar-uploader' action='http://localhost:9999/files/uploadwenjian' :headers='headers' :show-file-list='false' :on-success='handleWenjianSuccess' ><el-button>上传</el-button></el-upload></el-form-item>		<el-form-item  label="流派" prop="liupai"><el-input size="small" v-model="editForm.liupai" auto-complete="off" placeholder="请输入流派" style='width:50%'></el-input></el-form-item>		<el-form-item  label="稿件备注" prop="gaojianbeizhu"><el-input type="textarea" size="small" v-model="editForm.gaojianbeizhu" auto-complete="off" placeholder="请输入稿件备注" style='width:100%'></el-input></el-form-item>		<el-form-item  label="上传时间" prop="shangchuanshijian"><el-input size="small" v-model="editForm.shangchuanshijian" auto-complete="off" placeholder="请输入上传时间" style='width:50%'></el-input></el-form-item>		
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">添加</el-button>
		</div>
	</div>
</template>

<script>
	import {yinpingaojianEdit, yinpingaojianSave,yinpingaojianDetail} from "@/api/yinpingaojian/yinpingaojianApi";
	import {Session} from "@/utils/storage";
import {changpaiDetail,changpaiEdit} from "../../api/changpai/changpaiApi";
//xiabiaoduan1
export default {
	name: 'personal',
	data() {
		return {
			rules: {
				//yztssssss1
			},
			editForm: {
				avater:'',
				changpaimingcheng:'',				
			},
			username:'',
			cx:'',
			//xiabiaoduan2
		};
	},
	created() {
		if (!Session.get('userInfo')) return false;
		this.userInfo = Session.get('userInfo');
		this.username=localStorage.getItem("username");
		this.cx=localStorage.getItem("cx");
		let id = this.$route.params.id;
		//xiabiaoduan3
		this.getUserInfo(id);
	},
	computed: {
		headers(){
			return {"token":Session.get("token")}
		},
	},
	methods:{
		getUserInfo(id){
			changpaiDetail(id).then(res=>{
				if(res.code == '0'){
					this.changpai = res.data
					this.editForm.changpaimingcheng = this.changpai.changpaimingcheng;				
					this.editForm.zuozhe= this.userInfo.yonghuming;
					this.editForm.aid = this.getProjectNum() + Math.floor(Math.random() * 10000);
					
				}
			})
		},
		getProjectNum () {
			const projectTime = new Date() // 当前中国标准时间
			const Year = projectTime.getFullYear() // 获取当前年份 支持IE和火狐浏览器.
			const Month = projectTime.getMonth() + 1 // 获取中国区月份
			const Day = projectTime.getDate() // 获取几号
			var CurrentDate = Year
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
		//xia2sui1
		// 编辑、增加页面保存方法
		submitForm(editData) {
			
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						
					}else {
						yinpingaojianSave(this.editForm).then(res => {
							if (res.code == '0') {
								
								this.$message({
									type: 'success',
									message: '添加成功！'
								})
							} else {
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
		
		handleWenjianSuccess(res, file) {
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
			location.href = data.wenjian;
		},				//youscwexnjiaxn
		//xiabiaoduan4
	}
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
