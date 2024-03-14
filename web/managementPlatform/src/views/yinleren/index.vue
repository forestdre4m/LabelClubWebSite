<template>
	<div>
		<el-form :inline="true" :model="formInline" class="user-search" style="float:right">
			<el-form-item label=""><el-input size="small" style="width: 100px;" v-model="formInline.username" placeholder="输入用户名"></el-input></el-form-item>
			<el-form-item label=""><el-input size="small" style="width: 100px;" v-model="formInline.uid" placeholder="输入uid"></el-input></el-form-item>
			
			<el-form-item>
				<el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
			</el-form-item>
		</el-form>
		<el-form :inline="true" :model="formInline" class="user-search">
			<el-form-item>
				<el-upload class="upload-demo" style="float: left; padding-right: 10px;" action='http://localhost:9999/xueshengxinxi/upload' :headers='headers' :show-file-list='false' :on-success='handleDaoruSuccess' :before-upload='beforeDaoruUpload' ><el-button size="small" type="info" icon="el-icon-sell" @click="daoru()" v-if="userInfo.roles[0] == 'guanliyuan'">导入</el-button></el-upload>
				<el-button size="small" type="primary" icon="el-icon-plus" @click="handleEdit()" >添加</el-button>
				<el-button size="small" type="success" icon="el-icon-s-data" @click="daochu()" v-if="userInfo.roles[0] == 'guanliyuan'">导出</el-button>
				<el-button size="small" type="danger" icon="el-icon-delete" @click="handleDeleteList()" v-if="userInfo.roles[0] == 'guanliyuan'">批量删除</el-button>
				
			</el-form-item>
		</el-form>
		
		<el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="拼命加载中" @selection-change="handleSelectionChange">
			<el-table-column align="center" type="selection" width="60"></el-table-column>
			<el-table-column sortable prop="username" label="用户名"></el-table-column>
			<el-table-column sortable prop="uid" label="uid"></el-table-column>
			<el-table-column sortable prop="email" label="邮箱"></el-table-column>
			<el-table-column align="center" sortable prop="sex" label="性别" ><template slot-scope="scope"><el-button size="mini" type="success" @click="editxingbie(scope.$index, scope.row)"  v-if="scope.row.sex == true">男</el-button><el-button size="mini" type="warning" @click="editxingbie(scope.$index, scope.row)"  v-else  >女</el-button></template></el-table-column><el-table-column align='center' prop='icon' label='头像' width='120'><template slot-scope='scope'><el-image :src='scope.row.icon' style='height:70px'  v-if="scope.row.icon"/><img src="../../../static/images/guanli.jpg" style='height:70px' v-else/></template></el-table-column>
			
			<el-table-column align="center" label="操作" min-width="160">
				<template slot-scope="scope">
					
					<!--liangbuan-->
					<el-button size="mini" type="success" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan' "></el-button>
					<el-button size="mini" type="danger" icon="el-icon-delete" @click="deleteYinleren(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan' "></el-button>
					<el-button size='mini' type='primary' icon="el-icon-s-grid" @click="handleDetail(scope.$index, scope.row)"></el-button>
					
				</template>
			</el-table-column>
		</el-table>
		<Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>
		
		<el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click="closeDialog">
			<el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
				<el-form-item  label="用户名" prop="username"><el-input size="small" v-model="editForm.username" auto-complete="off" placeholder="请输入用户名" style='width:50%'></el-input></el-form-item>
		
		<el-form-item  label="uid" prop="uid"><el-input size="small" v-model="editForm.uid" auto-complete="off" placeholder="请输入uid" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="邮箱" prop="email"><el-input size="small" v-model="editForm.email" auto-complete="off" placeholder="请输入邮箱" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="性别" prop="sex"><el-radio v-model="editForm.sex" :label=true>男</el-radio><el-radio v-model="editForm.sex" :label=false>女</el-radio></el-form-item>
		<el-form-item  label="年龄" prop="age"><el-input type="textarea" size="small" v-model="editForm.age" auto-complete="off" placeholder="请输入年龄" style='width:100%'></el-input></el-form-item>
		<el-form-item  label="签名" prop="text"><el-input type="textarea" size="small" v-model="editForm.text" auto-complete="off" placeholder="请输入签名" style='width:100%'></el-input></el-form-item>
		<el-form-item  label='头像' prop='icon'><el-upload class='avatar-uploader' action='http://localhost:9999/files/upload' :headers='headers' :show-file-list='false' :on-success='handleTouxiangSuccess' :before-upload='beforeTouxiangUpload'><img v-if='editForm.icon' :src='editForm.icon' class='avatar'><i v-else class='el-icon-plus avatar-uploader-icon'></i></el-upload></el-form-item>
		
				
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button size="small" @click="closeDialog">取消</el-button>
				<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">保存</el-button>
			</div>
		</el-dialog>
			
			
			<el-dialog :title="title" :visible.sync="detailFormVisible" width="60%" @click="closeDialogdetail">
			<table width="100%" border="0"  align="center" cellpadding="3" cellspacing="1" class="table table-striped table-bordered table-hover">
								<tr>
									<td width='11%' height=44>用户名：</td><td width='39%'>{{editForm.username}}</td>
<td  rowspan=5 align=center><el-upload class='avatar-uploader'  :headers='headers' :show-file-list='false'  ><img v-if='editForm.icon' :src='editForm.icon' class='avatar'><i v-else class='el-icon-plus avatar-uploader-icon'></i></el-upload></td></tr><tr>
<td width='11%' height=44>密码：</td><td width='39%'>{{editForm.password}}</td>
</tr><tr>
<td width='11%' height=44>uid：</td><td width='39%'>{{editForm.uid}}</td>
</tr><tr>
<td width='11%' height=44>邮箱：</td><td width='39%'>{{editForm.email}}</td>
</tr><tr>
<td width='11%' height=44>性别：</td><td width='39%'><div v-if="editForm.sex==1">男</div><div v-else>女</div></td>
</tr><tr>



<td width='11%' height=100  >年龄：</td><td width='39%' colspan=2 height=100 >{{editForm.age}}</td></tr><tr><td width='11%' height=100  >签名：</td><td width='39%' colspan=2 height=100 >{{editForm.text}}</td></tr>
							</table>
			


			<div slot="footer" class="dialog-footer">
				<el-button size="small" @click="closeDialogdetail">关闭</el-button>

			</div>
		</el-dialog>
	</div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import { yinlerenList, yinlerenSave, yinlerenDelete,yinlerenEdit,yinlerenDeleteList } from '@/api/yinleren/yinlerenApi';


import {Session} from "@/utils/storage";
import axios from 'axios';
export default {
	name: 'user',
	data() {
		return {
			loading: false, //是显示加载
			title: '',
			
			editFormVisible: false, //控制编辑页面显示与隐藏
			detailFormVisible: false,
			
			
			editForm: {
			},
			user:[],
			username:'',
			cx:'',
			
			rules: {
				username: [{ required: true, message: '请输入用户名', trigger: 'blur' },
				],
				password: [{ required: true, message: '请输入密码', trigger: 'blur' },
				],
				uid: [{ required: true, message: '请输入uid', trigger: 'blur' },
				],
				
			},
			
			formInline: {
				page: 1,
				limit: 10,
			},
			
			
			listData: [],
			yinlerens:[],
			
			checkmenu: [],
			pageparm: {
				currentPage: 1,
				pageSize: 10,
				total: 0
			}
		};
	},
	computed:{
		headers(){
			return {"token":Session.get("token")}
		}
	},
	watch: {
			'$route' (to, from) {
				// 路由发生变化页面刷新
				this.$router.go(0);
			}
		},
	components: {
		Pagination
	},
	created() {
		
		if (!Session.get('userInfo')) return false;
		this.userInfo = Session.get('userInfo');
		this.username=localStorage.getItem("username");
		this.cx=localStorage.getItem("cx");
		
		this.getdata(this.formInline)
		
	},
	methods: {
		handleShenheList(){
				const yinlerens = this.yinlerens;
				if(yinlerens.length == 0){
					this.$message({
						type: 'error',
						message: '请至少选择一项'
					})
				}else {
					this.$confirm('确定要批量审核吗?', '信息', {
						confirmButtonText: '确定',
						cancelButtonText: '取消',
						type: 'warning'
					}).then(() => {
						yinlerens.forEach(item=> {
							let data = {...item, issh: 1}
							yinlerenEdit(data).then(res => {})
						})
						this.getdata(this.formInline)
						this.$message({
							type: 'success',
							message: '批量审核成功！'
						})
					}).catch(() => {
						this.$message({
							type: 'info',
							message: '已取消批量审核'
						})
					})
				}
			},
		getdata(parameter) {
			yinlerenList(parameter)
					.then(res => {
						this.loading = false
						if (res.success == false) {
							this.$message({
								type: 'info',
								message: res.msg
							})
						} else {
							this.listData = res.data.list
							
							
							
							// 分页赋值
							this.pageparm.currentPage = this.formInline.current
							this.pageparm.pageSize = this.formInline.currentNum
							this.pageparm.total = res.data.total
						}
					})
					.catch(err => {
						this.loading = false
						this.$message.error('菜单加载失败，请稍后再试！')
					})
		},
		
		// 分页插件事件
		callFather(parm) {
			this.formInline.current = parm.currentPage
			this.getdata(this.formInline)
		},
		
		// 搜索事件
		search() {
			this.getdata(this.formInline)
		},
		//显示编辑界面
		handleEdit: function (index, row) {
			this.editFormVisible = true
			if (row != undefined && row != 'undefined') {
				this.title = '修改音乐人'
				this.editForm = row
			} else {
				this.title = '添加音乐人'
				this.editForm = {}
				
				
				//zixdonxgbianxhao1
			}
		},
		daochu(){
			axios.get('/artist/getExcel', {
				responseType: 'blob',
				headers: { token: Session.get("token"), 'Content-Type': 'application/x-download' }
			}).then((res) => {
				if (res.status === 200) {
					var a = document.createElement('a')
					var blob = new Blob([res.data], { type: 'application/vnd.ms-excel' })
					var href = window.URL.createObjectURL(blob)
					a.href = href
					a.download = '音乐人.xlsx'
					document.body.appendChild(a)
					a.click() 
					document.body.removeChild(a) 
					window.URL.revokeObjectURL(href)
				}
			}).catch((err) => {
				console.log(err)
			})
		},
		handleDaoruSuccess(res, file) {
				if(res.code == "0") {
					this.$message({
						type: 'success',
						message: '导入成功!'
					})
					this.getdata(this.formInline);
				}
			},
		beforeDaoruUpload(file) {
			const isJPG = file.type === 'application/vnd.ms-excel';
			if (!isJPG) {
				this.$message.error('上传只能是 excel 格式!');
			}
			return isJPG;
		},
		//zixdonxgbianxhao2
		
		handleDetail: function (index, row) {
			this.detailFormVisible = true
			if (row != undefined && row != 'undefined') {
				this.title = '音乐人详细'
				this.editForm = row
			}
			
		},
		closeDialogdetail() {
				this.getdata(this.formInline)
				this.detailFormVisible = false
			},
		//liangbuedit
		// 编辑、增加页面保存方法
		submitForm(editData) {
			
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						yinlerenEdit(this.editForm).then(res => {
							this.editFormVisible = false
							
							this.loading = false
							if (res.code == '0') {
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: '音乐人修改成功！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							this.editFormVisible = false
							this.loading = false
							this.getdata(this.formInline)
						if(err){
								this.$message.error(err)
							}else {
								this.$message.error('操作失败，请稍后再试！')
							}
						})
					}else {
						yinlerenSave(this.editForm).then(res => {
							this.editFormVisible = false
							this.loading = false
							if (res.code == '0') {
								
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: '音乐人添加成功！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							this.editFormVisible = false
							this.loading = false
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
		// 删除公司
		deleteYinleren(index, row) {
			this.$confirm('确定要删除吗?', '信息', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			}).then(() => {
				yinlerenDelete(row.id).then(res => {
					if (res.code == '0') {
						this.$message({
								type: 'success',
							message: '音乐人已删除!'
						})
						this.getdata(this.formInline)
					} else {
						this.$message({
							type: 'info',
							message: res.msg
						})
					}
				}).catch(err => {
					this.loading = false
					this.$message.error('操作失败，请稍后再试')
				})
			}).catch(() => {
				this.$message({
					type: 'info',
					message: '已取消删除'
				})
			})
		},
		handleSelectionChange(val){
			this.yinlerens = val;
		},
		handleDeleteList(){
			const yinlerens = this.yinlerens;
			if(yinlerens.length == 0){
				this.$message({
					type: 'error',
					message: '请至少选择一项进行删除'
				})
			}else {
				this.$confirm('确定要批量删除吗?', '信息', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					yinlerenDeleteList(yinlerens).then(res => {
						if (res.code == '0') {
							this.$message({
								type: 'success',
								message: '批量删除成功!'
							})
							this.getdata(this.formInline)
						} else {
							this.$message({
								type: 'info',
								message: res.msg
							})
						}
					}).catch(err => {
						this.loading = false
						this.$message.error('操作失败，请稍后再试')
					})
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					})
				})
			}
		},
		editxingbie(index,row){
			let data = {...row,sex:!row.sex}
			yinlerenEdit(data).then(res => {
				this.editFormVisible = false
				this.loading = false
				if (res.code == '0') {
					this.getdata(this.formInline)
					this.$message({
						type: 'success',
						message: '性别修改成功！'
					})
				} else {
					this.$message({
						type: 'info',
						message: res.msg
					})
				}
			}).catch(err => {
				this.editFormVisible = false
				this.loading = false
				if(err){
					this.$message.error(err)
				}else {
					this.$message.error('操作失败，请稍后再试！')
				}
			})
		},
		//xuaxnzeshxifou
		
		
		
		handleTouxiangSuccess(res, file) {
				if(res.code == "0") {
					this.editForm.touxiang = "/files/download/"+res.data.id
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
				
		//youscwexnjiaxn
		// 关闭编辑、增加弹出框
		closeDialog() {
			this.getdata(this.formInline)
			this.editFormVisible = false
		}
	},
};
</script>

<style scoped lang="scss">
	@import './index.scss';
	::v-deep .el-table th{
		background-color: #f5e0c1;
	}
	::v-deep .el-table thead{
		color: #3399ff;
		font-weight: 500;
	}
	::v-deep .el-table tr{
		background-color: #f9ffe2;
	}
	::v-deep .el-table__body tr.current-row>td{
		background:#bd93f9;
	}
</style>
