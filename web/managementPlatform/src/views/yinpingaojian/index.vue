<template>
	<div>
		<el-form :inline="true" :model="formInline" class="user-search" style="float:right">
			<el-form-item label=""><el-input size="small" style="width: 100px;" v-model="formInline.labelname" placeholder="输入厂牌名称"></el-input></el-form-item>
			<el-form-item label=""><el-input size="small" style="width: 100px;" v-model="formInline.audioname" placeholder="输入作品名"></el-input></el-form-item>
			<el-form-item label=""><el-input size="small" style="width: 100px;" v-model="formInline.author" placeholder="输入作者"></el-input></el-form-item>
			<el-form-item label=""><el-input size="small" style="width: 100px;" v-model="formInline.genre" placeholder="输入流派"></el-input></el-form-item>
			
			<el-form-item>
				<el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
			</el-form-item>
		</el-form>
		<el-form :inline="true" :model="formInline" class="user-search">
			<el-form-item>
				<el-upload class="upload-demo" style="float: left; padding-right: 10px;" action='http://localhost:9999/xueshengxinxi/upload' :headers='headers' :show-file-list='false' :on-success='handleDaoruSuccess' :before-upload='beforeDaoruUpload' ><el-button size="small" type="info" icon="el-icon-sell" @click="daoru()" v-if="userInfo.roles[0] == 'guanliyuan'">导入</el-button></el-upload>
				
				<el-button size="small" type="success" icon="el-icon-s-data" @click="daochu()" v-if="userInfo.roles[0] == 'guanliyuan'">导出</el-button>
				<el-button size="small" type="danger" icon="el-icon-delete" @click="handleDeleteList()" v-if="userInfo.roles[0] == 'guanliyuan'">批量删除</el-button>
				
			</el-form-item>
		</el-form>
		
		<el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="拼命加载中" @selection-change="handleSelectionChange">
			<el-table-column align="center" type="selection" width="60"></el-table-column>
			<el-table-column sortable prop="labelname" label="厂牌名称"></el-table-column>
			<el-table-column sortable prop="audioname" label="作品名"></el-table-column>
			<el-table-column sortable prop="author" label="作者"></el-table-column>
			<el-table-column align='center' sortable prop='file' label='文件' width='120'><template slot-scope='scope'><el-button @click="download(scope.row)">下载</el-button></template></el-table-column>
			<el-table-column sortable prop="genre" label="流派"></el-table-column>
			<el-table-column sortable prop="udt" label="上传时间"></el-table-column>
			
			<el-table-column align="center" label="操作" min-width="160">
				<template slot-scope="scope">
					
					<!--liangbuan-->
					<el-button size="mini" type="success" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == 'yinleren'"></el-button>
					<el-button size="mini" type="danger" icon="el-icon-delete" @click="deleteYinpingaojian(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == 'yinleren'"></el-button>
					<el-button size='mini' type='primary' icon="el-icon-s-grid" @click="handleDetail(scope.$index, scope.row)"></el-button>
					
				</template>
			</el-table-column>
		</el-table>
		<Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>
		
		<el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click="closeDialog">
			<el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
				<el-form-item  label="aid" prop="aid"><el-input size="small" v-model="editForm.aid" auto-complete="off" placeholder="请输入aid" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="厂牌名称" prop="labelname"><el-input size="small" v-model="editForm.labelname" auto-complete="off" placeholder="请输入厂牌名称" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="作品名" prop="audioname"><el-input size="small" v-model="editForm.audioname" auto-complete="off" placeholder="请输入作品名" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="作者" prop="author"><el-input size="small" v-model="editForm.author" auto-complete="off" placeholder="请输入作者" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label='文件' prop='file'><el-upload class='avatar-uploader' action='http://localhost:9999/files/uploadwenjian' :headers='headers' :show-file-list='false' :on-success='handleWenjianSuccess' ><el-button>上传</el-button></el-upload></el-form-item>
		<el-form-item  label="流派" prop="genre"><el-input size="small" v-model="editForm.genre" auto-complete="off" placeholder="请输入流派" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="稿件备注" prop="remark"><el-input type="textarea" size="small" v-model="editForm.remark" auto-complete="off" placeholder="请输入稿件备注" style='width:100%'></el-input></el-form-item>
		<el-form-item  label="上传时间" prop="udt"><el-input size="small" v-model="editForm.udt" auto-complete="off" placeholder="请输入上传时间" style='width:50%'></el-input></el-form-item>
		
				
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button size="small" @click="closeDialog">取消</el-button>
				<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">保存</el-button>
			</div>
		</el-dialog>
			
			
			<el-dialog :title="title" :visible.sync="detailFormVisible" width="60%" @click="closeDialogdetail">
			<table width="100%" border="0"  align="center" cellpadding="3" cellspacing="1" class="table table-striped table-bordered table-hover">
								<tr>
									<td width='11%' height='40px'>aid：</td><td width='39%'>{{editForm.aid}}</td>
     <td width='11%' height='40px'>厂牌名称：</td><td width='39%'>{{editForm.labelname}}</td></tr><tr>
     <td width='11%' height='40px'>作品名：</td><td width='39%'>{{editForm.audioname}}</td>
     <td width='11%' height='40px'>作者：</td><td width='39%'>{{editForm.author}}</td></tr><tr>
     <td width='11%' height='40px'>文件：</td><td width='39%' height='40px'><el-button size="small" @click="download(editForm)">点此下载</el-button></td>
     <td width='11%' height='40px'>流派：</td><td width='39%'>{{editForm.genre}}</td></tr><tr>
     <td width='11%' height='40px'>稿件备注：</td><td width='39%'>{{editForm.remark}}</td>
     <td width='11%' height='40px'>上传时间：</td><td width='39%'>{{editForm.udt}}</td>
     </tr>
							</table>
			


			<div slot="footer" class="dialog-footer">
				<el-button size="small" @click="closeDialogdetail">关闭</el-button>

			</div>
		</el-dialog>
	</div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import { yinpingaojianList, yinpingaojianSave, yinpingaojianDelete,yinpingaojianEdit,yinpingaojianDeleteList } from '@/api/yinpingaojian/yinpingaojianApi';


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
				audioname: [{ required: true, message: '请输入作品名', trigger: 'blur' },
				],
				
			},
			
			formInline: {
				page: 1,
				limit: 10,
			},
			
			
			listData: [],
			yinpingaojians:[],
			
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
		if(this.userInfo.roles[0] == 'changpai'){this.formInline.labelname= this.userInfo.labelname;}
		if(this.userInfo.roles[0] == 'yinleren'){this.formInline.author= this.username;}
		
		this.getdata(this.formInline)
		
	},
	methods: {
		handleShenheList(){
				const yinpingaojians = this.yinpingaojians;
				if(yinpingaojians.length == 0){
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
						yinpingaojians.forEach(item=> {
							let data = {...item, issh: 1}
							yinpingaojianEdit(data).then(res => {})
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
			yinpingaojianList(parameter)
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
				this.title = '修改音频稿件'
				this.editForm = row
			} else {
				this.title = '添加音频稿件'
				this.editForm = {}
				this.editForm.zuozhe= this.username;
				
				this.editForm.aid = this.getProjectNum() + Math.floor(Math.random() * 10000);
			}
		},
		daochu(){
			axios.get('/audio/getExcel', {
				responseType: 'blob',
				headers: { token: Session.get("token"), 'Content-Type': 'application/x-download' }
			}).then((res) => {
				if (res.status === 200) {
					var a = document.createElement('a')
					var blob = new Blob([res.data], { type: 'application/vnd.ms-excel' })
					var href = window.URL.createObjectURL(blob)
					a.href = href
					a.download = '音频稿件.xlsx'
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
		
		handleDetail: function (index, row) {
			this.detailFormVisible = true
			if (row != undefined && row != 'undefined') {
				this.title = '音频稿件详细'
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
						yinpingaojianEdit(this.editForm).then(res => {
							this.editFormVisible = false
							
							this.loading = false
							if (res.code == '0') {
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: '音频稿件修改成功！'
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
						yinpingaojianSave(this.editForm).then(res => {
							this.editFormVisible = false
							this.loading = false
							if (res.code == '0') {
								
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: '音频稿件添加成功！'
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
		deleteYinpingaojian(index, row) {
			this.$confirm('确定要删除吗?', '信息', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			}).then(() => {
				yinpingaojianDelete(row.id).then(res => {
					if (res.code == '0') {
						this.$message({
								type: 'success',
							message: '音频稿件已删除!'
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
			this.yinpingaojians = val;
		},
		handleDeleteList(){
			const yinpingaojians = this.yinpingaojians;
			if(yinpingaojians.length == 0){
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
					yinpingaojianDeleteList(yinpingaojians).then(res => {
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
		//xuaxnzeshxifou
		
		
		
		
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
			location.href = data.file;
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
