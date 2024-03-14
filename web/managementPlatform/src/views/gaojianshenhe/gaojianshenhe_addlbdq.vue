<template>
	<div class="personal">
		<el-form label-width="100px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="投稿人" prop="author"><el-input size="small" v-model="editForm.author" auto-complete="off" placeholder="请输入投稿人" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="厂牌名称" prop="labelname"><el-input size="small" v-model="editForm.labelname" auto-complete="off" placeholder="请输入厂牌名称" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="作品名" prop="audioname"><el-input size="small" v-model="editForm.audioname" auto-complete="off" placeholder="请输入作品名" style='width:50%' disabled></el-input></el-form-item>
		
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">添加</el-button>
		</div>
	</div>
</template>

<script>
	import {gaojianshenheEdit, gaojianshenheSave,gaojianshenheDetail} from "@/api/gaojianshenhe/gaojianshenheApi";
	import {Session} from "@/utils/storage";
import {yinpingaojianDetail,yinpingaojianEdit} from "../../api/yinpingaojian/yinpingaojianApi";
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
				author:'',
				audioname:'',
				
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
			yinpingaojianDetail(id).then(res=>{
				if(res.code == '0'){
					this.audio = res.data
					this.editForm.author = this.audio.author;
					this.editForm.audioname = this.audio.audioname;
				

					this.editForm.labelname= this.userInfo.labelname;
				
				}
			})
		},
		
		//qixuzhijixsuan3
		//xia2sui1
		// 编辑、增加页面保存方法
		submitForm(editData) {
			
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						
					}else {
						gaojianshenheSave(this.editForm).then(res => {
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
		
		//youscwexnjiaxn
		//xiabiaoduan4
	}
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
