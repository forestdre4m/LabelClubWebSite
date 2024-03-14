<template>
	<div class="personal">
		<el-form label-width="80px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="用户名" prop="yonghuming"><el-input size="small" v-model="editForm.username" auto-complete="off" placeholder="请输入用户名" style='width:25%'></el-input></el-form-item>
		
		<el-form-item  label="uid" prop="uid"><el-input size="small" v-model="editForm.uid" auto-complete="off" placeholder="请输入uid" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="邮箱" prop="email"><el-input size="small" v-model="editForm.email" auto-complete="off" placeholder="请输入邮箱" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="性别" prop="sex"><el-radio v-model="editForm.sex" :label=true>男</el-radio><el-radio v-model="editForm.sex" :label=false>女</el-radio></el-form-item>
		<el-form-item  label="年龄" prop="age"><el-input type="textarea" size="small" v-model="editForm.age" auto-complete="off" placeholder="请输入年龄" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="签名" prop="text"><el-input type="textarea" size="small" v-model="editForm.text" auto-complete="off" placeholder="请输入签名" style='width:50%'></el-input></el-form-item>
		<el-form-item  label='头像' prop='icon'><el-upload class='avatar-uploader' action='http://localhost:9999/files/upload' :headers='headers' :show-file-list='false' :on-success='handleTouxiangSuccess' :before-upload='beforeTouxiangUpload'><img v-if='editForm.icon' :src='editForm.icon' class='avatar'><i v-else class='el-icon-plus avatar-uploader-icon'></i></el-upload></el-form-item>
		
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">更新</el-button>
		</div>
	</div>
</template>

<script>
	import {yinlerenEdit, yinlerenSave,yinlerenDetail} from "@/api/yinleren/yinlerenApi";
	import {Session} from "@/utils/storage";

export default {
	name: 'personal',
	data() {
		return {
			rules: {
				username: [{ required: true, message: '请输入用户名', trigger: 'blur' },
				],
				password: [{ required: true, message: '请输入密码', trigger: 'blur' },
				],
				uid: [{ required: true, message: '请输入uid', trigger: 'blur' },
				],
				
			},
			editForm: {
				avater:''
			},
		};
	},
	created() {
		this.getDetail()
	},
	computed: {
		headers(){
			return {"token":Session.get("token")}
		},
	},
	methods:{
		getDetail(){
			if (!Session.get('userInfo')) return false;
			this.userInfo = Session.get('userInfo');
			console.log(this.userInfo);
			yinlerenDetail(this.userInfo.id).then(res=>{
				if (res.code == '0') {
					this.editForm = res.data;
				}
			}).catch(err => {
				if(err){
					this.$message.error(err)
				}else {
					this.$message.error('操作失败，请稍后再试！')
				}
			})
		},
		
		// 编辑、增加页面保存方法
		submitForm(editData) {
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						yinlerenEdit(this.editForm).then(res => {
							if (res.code == '0') {
								this.getDetail()
								this.$message({
									type: 'success',
									message: '个人信息修改成功！'
								})
								this.$store.dispatch('userInfos/setUserInfos',this.editForm);
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
					}else {
						yinlerenSave(this.editForm).then(res => {
							if (res.code == '0') {
								this.getDetail()
								this.$message({
									type: 'success',
									message: '个人信息添加成功！'
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
		handleTouxiangSuccess(res, file) {
				if(res.code == "0") {
					this.editForm.icon = "/files/download/"+res.data.id
				}
			},
			beforeTouxiangUpload(file) {
				const isJPG = file.type === 'image/jpeg';
				const isLt2M = file.size / 1024 / 1024 < 2;

				if (!isJPG) {
					this.$message.error('上传图片只能是 JPG 格式!');
				}
				if (!isLt2M) {
					this.$message.error('上传图片大小不能超过 2MB!');
				}
				return isJPG && isLt2M;
			},
				
	}
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
