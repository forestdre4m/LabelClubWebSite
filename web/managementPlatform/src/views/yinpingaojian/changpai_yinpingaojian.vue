<template>
	<div>
		<el-form :inline="true" :model="formInline" class="user-search" style="float:right">
			<el-form-item label=""><el-input size="small" style="width: 100px;" v-model="formInline.labelname" placeholder="输入厂牌名称"></el-input></el-form-item>
			<el-form-item label=""><el-input size="small" style="width: 100px;" v-model="formInline.genre" placeholder="输入流派标签"></el-input></el-form-item>
			
			<el-form-item>
				<el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
			</el-form-item>
		</el-form>
		<el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="拼命加载中" @selection-change="handleSelectionChange">
			<el-table-column align="center" type="selection" width="60"></el-table-column>
			<el-table-column sortable prop="username" label="用户名"></el-table-column>
			<el-table-column sortable prop="lid" label="lid"></el-table-column>
			<el-table-column sortable prop="labelname" label="厂牌名称"></el-table-column>
			<el-table-column sortable prop="email" label="邮箱"></el-table-column>
			<el-table-column sortable prop="place" label="地点"></el-table-column>
			<el-table-column sortable prop="doe" label="成立日期"></el-table-column>
			<el-table-column sortable prop="genre" label="流派标签"></el-table-column>
			<el-table-column align='center' prop='labelpic' label='厂牌图片' width='120'><template slot-scope='scope'><el-image :src='scope.row.labelpic' style='height:70px'  v-if="scope.row.labelpic"/><img src="../../../static/images/guanli.jpg" style='height:70px' v-else/></template></el-table-column>
			
			<el-table-column align="center" label="操作" min-width="160">
				<template slot-scope="scope">
					<el-button size="mini"  type="danger" @click="addSalary(scope.$index, scope.row)">添加音频稿件</el-button>
				</template>
			</el-table-column>
		</el-table>
		<Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>
		
		
		
	</div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import { changpaiList} from '@/api/changpai/changpaiApi';

import {Session} from "@/utils/storage";
export default {
	name: 'user',
	data() {
		return {
			loading: false, //是显示加载
			title: '',
			editFormVisible: false, //控制编辑页面显示与隐藏
			editForm: {
			},
			user:[],
			rules: {
				
			},
			formInline: {
				page: 1,
				limit: 10,
			},
			
			
			listData: [],
			changpais:[],
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
				this.$router.go(0);
			}
		},
	components: {
		Pagination
	},
	created() {
		this.getdata(this.formInline)
		if (!Session.get('userInfo')) return false;
		this.userInfo = Session.get('userInfo');
	},
	methods: {
		getdata(parameter) {
			changpaiList(parameter)
					.then(res => {
						this.loading = false
						if (res.success == false) {
							this.$message({
								type: 'info',
								message: res.msg
							})
						} else {
							this.listData = res.data.list
							
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
		//qixuzhijixsuan3
		callFather(parm) {
			this.formInline.current = parm.currentPage
			this.getdata(this.formInline)
		},
		search() {
			this.getdata(this.formInline)
		},
		
		addSalary(index,row){
				this.$router.push({
					name:'yinpingaojianAdd',
					params:{
						id:row.id
					}
				})
			},
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
