<template>
	<div class="personal">
		<el-form label-width="80px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="用户名" prop="username"><el-input size="small" v-model="editForm.username" auto-complete="off" placeholder="请输入用户名" style='width:25%'></el-input></el-form-item>
		
		<el-form-item  label="lid" prop="lid"><el-input size="small" v-model="editForm.lid" auto-complete="off" placeholder="请输入lid" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="厂牌名称" prop="labelname"><el-input size="small" v-model="editForm.labelname" auto-complete="off" placeholder="请输入厂牌名称" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="邮箱" prop="email"><el-input size="small" v-model="editForm.email" auto-complete="off" placeholder="请输入邮箱" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="地点" prop="place"><el-input size="small" v-model="editForm.place" auto-complete="off" placeholder="请输入地点" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="成立日期" prop="doe"><el-date-picker type="date" value-format="yyyy-MM-dd" size="small" v-model="editForm.doe" style='width:25%'/></el-form-item>
		<el-form-item  label="流派标签" prop="genre"><el-input size="small" v-model="editForm.genre" auto-complete="off" placeholder="请输入流派标签" style='width:25%'></el-input></el-form-item>
		<el-form-item  label='厂牌图片' prop='labelpic'><el-upload class='avatar-uploader' action='http://localhost:9999/files/upload' :headers='headers' :show-file-list='false' :on-success='handleChangpaitupianSuccess' :before-upload='beforeChangpaitupianUpload'><img v-if='editForm.labelpic' :src='editForm.labelpic' class='avatar'><i v-else class='el-icon-plus avatar-uploader-icon'></i></el-upload></el-form-item>
		
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">更新</el-button>
		</div>
	</div>
</template>

<script>
	import {changpaiEdit, changpaiSave,changpaiDetail} from "@/api/changpai/changpaiApi";
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
				lid: [{ required: true, message: '请输入lid', trigger: 'blur' },
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
			changpaiDetail(this.userInfo.id).then(res=>{
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
						changpaiEdit(this.editForm).then(res => {
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
						changpaiSave(this.editForm).then(res => {
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
		handleChangpaitupianSuccess(res, file) {
				if(res.code == "0") {
					this.editForm.labelpic = "/files/download/"+res.data.id
				}
			},
			beforeChangpaitupianUpload(file) {
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
