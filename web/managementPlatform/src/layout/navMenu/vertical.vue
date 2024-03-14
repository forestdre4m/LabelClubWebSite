
<template>
	<div >
			<el-menu :collapse="collapse" class="aside" router v-if="cx=='厂牌'">
			<el-menu-item index="/home" :class="{active: $route.name === '主页'}">
				<i class="el-icon-s-home"></i>
				<span slot="title">&#12288主页</span>
			</el-menu-item>
			<el-submenu index="1">
				<template slot="title">
					<i class="el-icon-user-solid"></i>
					<span>&#12288个人资料管理</span>
				</template>
				<el-menu-item-group>
					<el-menu-item index="/changpai_updt2/1" :class="{active: $route.name === '修改个人资料'}">
						<i class="el-icon-s-unfold"></i>
						<span slot="title">修改个人资料</span>
					</el-menu-item>
				</el-menu-item-group>
<el-menu-item-group>
					<el-menu-item index="/resetPass" :class="{active: $route.name === '修改密码'}">
						<i class="el-icon-s-unfold"></i>
						<span slot="title">修改密码</span>
					</el-menu-item>
				</el-menu-item-group>

			</el-submenu>

<el-submenu index="3">
				<template slot="title">
					<i class="el-icon-user-solid"></i>
					<span>&#12288音频稿件管理</span>
				</template>
				<el-menu-item-group>
					<el-menu-item index="/yinpingaojian/1" :class="{active: $route.name === '音频稿件查询'}">
						<i class="el-icon-s-unfold"></i>
						<span slot="title">音频稿件查询</span>
					</el-menu-item>
				</el-menu-item-group>

			</el-submenu>
				<el-submenu index="2">
					<template slot="title">
						<i class="el-icon-user-solid"></i>
						<span>&#12288稿件审核管理</span>
					</template>
					<el-menu-item-group>
						<el-menu-item index="/yinpingaojian_gaojianshenhe/1" :class="{active: $route.name === '稿件审核添加'}">
							<i class="el-icon-s-unfold"></i>
							<span slot="title">稿件审核添加</span>
						</el-menu-item>
					</el-menu-item-group>
					<el-menu-item-group>
						<el-menu-item index="/gaojianshenhe/1" :class="{active: $route.name === '稿件审核查询'}">
							<i class="el-icon-s-unfold"></i>
							<span slot="title">稿件审核查询</span>
						</el-menu-item>
					</el-menu-item-group>

				</el-submenu>
<!--zxzncd-->
<!--youxqiaxntaixxinwxen-->
<!--jisacsicshu-->
<!--yoxuqiaxntaid-->
		</el-menu><el-menu :collapse="collapse" class="aside" router v-if="cx=='管理员'">
			<el-menu-item index="/home" :class="{active: $route.name === '主页'}">
				<i class="el-icon-s-home"></i>
				<span slot="title">&#12288主页</span>
			</el-menu-item>
			<el-submenu index="1">
				<template slot="title">
					<i class="el-icon-user-solid"></i>
					<span>&#12288系统用户管理</span>
				</template>
				<el-menu-item-group>
					<el-menu-item index="/guanliyuan/1" :class="{active: $route.name === '管理员用户'}">
						<i class="el-icon-s-unfold"></i>
						<span slot="title">管理员用户</span>
					</el-menu-item>
				</el-menu-item-group>
<el-menu-item-group>
					<el-menu-item index="/resetPass" :class="{active: $route.name === '修改密码'}">
						<i class="el-icon-s-unfold"></i>
						<span slot="title">修改密码</span>
					</el-menu-item>
				</el-menu-item-group>

			</el-submenu>

<!--<el-submenu index="3">-->
<!--				<template slot="title">-->
<!--					<i class="el-icon-user-solid"></i>-->
<!--					<span>&#12288变幻图设置</span>-->
<!--				</template>-->
<!--				<el-menu-item-group>-->
<!--					<el-menu-item index="/bianhuantu/1" :class="{active: $route.name === '变幻图设置'}">-->
<!--						<i class="el-icon-s-unfold"></i>-->
<!--						<span slot="title">变幻图设置</span>-->
<!--					</el-menu-item>-->
<!--				</el-menu-item-group>-->

<!--			</el-submenu>-->

<el-submenu index="5">
				<template slot="title">
					<i class="el-icon-user-solid"></i>
					<span>&#12288音乐人管理</span>
				</template>
				<el-menu-item-group>
					<el-menu-item index="/yinleren/1" :class="{active: $route.name === '音乐人查询'}">
						<i class="el-icon-s-unfold"></i>
						<span slot="title">音乐人查询</span>
					</el-menu-item>
				</el-menu-item-group>

			</el-submenu>
<el-submenu index="6">
				<template slot="title">
					<i class="el-icon-user-solid"></i>
					<span>&#12288厂牌管理</span>
				</template>
				<el-menu-item-group>
					<el-menu-item index="/changpai/1" :class="{active: $route.name === '厂牌查询'}">
						<i class="el-icon-s-unfold"></i>
						<span slot="title">厂牌查询</span>
					</el-menu-item>
				</el-menu-item-group>

			</el-submenu>
<el-submenu index="7">
				<template slot="title">
					<i class="el-icon-user-solid"></i>
					<span>&#12288音频稿件管理</span>
				</template>
				<el-menu-item-group>
					<el-menu-item index="/yinpingaojian/1" :class="{active: $route.name === '音频稿件查询'}">
						<i class="el-icon-s-unfold"></i>
						<span slot="title">音频稿件查询</span>
					</el-menu-item>
				</el-menu-item-group>

			</el-submenu>
<el-submenu index="8">
				<template slot="title">
					<i class="el-icon-user-solid"></i>
					<span>&#12288稿件审核管理</span>
				</template>
				<el-menu-item-group>
					<el-menu-item index="/gaojianshenhe/1" :class="{active: $route.name === '稿件审核查询'}">
						<i class="el-icon-s-unfold"></i>
						<span slot="title">稿件审核查询</span>
					</el-menu-item>
				</el-menu-item-group>

			</el-submenu>
<!--zxzncd-->

<!--jisacsicshu-->
<!--yoxuqiaxntaid-->
		</el-menu><el-menu :collapse="collapse" class="aside" router v-if="cx=='音乐人'">
			<el-menu-item index="/home" :class="{active: $route.name === '主页'}">
				<i class="el-icon-s-home"></i>
				<span slot="title">&#12288主页</span>
			</el-menu-item>
			<el-submenu index="1">
				<template slot="title">
					<i class="el-icon-user-solid"></i>
					<span>&#12288个人资料管理</span>
				</template>
				<el-menu-item-group>
					<el-menu-item index="/yinleren_updt2/1" :class="{active: $route.name === '修改个人资料'}">
						<i class="el-icon-s-unfold"></i>
						<span slot="title">修改个人资料</span>
					</el-menu-item>
				</el-menu-item-group>
<el-menu-item-group>
					<el-menu-item index="/resetPass" :class="{active: $route.name === '修改密码'}">
						<i class="el-icon-s-unfold"></i>
						<span slot="title">修改密码</span>
					</el-menu-item>
				</el-menu-item-group>

			</el-submenu>

<el-submenu index="3">
				<template slot="title">
					<i class="el-icon-user-solid"></i>
					<span>&#12288音频稿件管理</span>
				</template>

<el-menu-item-group>
					<el-menu-item index="/yinpingaojian/1" :class="{active: $route.name === '音频稿件查询'}">
						<i class="el-icon-s-unfold"></i>
						<span slot="title">音频稿件查询</span>
					</el-menu-item>
				</el-menu-item-group>

			</el-submenu><el-submenu index="2">
		<template slot="title">
			<i class="el-icon-user-solid"></i>
			<span>&#12288稿件审核管理</span>
		</template>
		<el-menu-item-group>
			<el-menu-item index="/gaojianshenhe/1" :class="{active: $route.name === '稿件审核查询'}">
				<i class="el-icon-s-unfold"></i>
				<span slot="title">稿件审核查询</span>
			</el-menu-item>
		</el-menu-item-group>

	</el-submenu>
<!--zxzncd-->
<!--youxqiaxntaixxinwxen-->
<!--jisacsicshu-->
<!--yoxuqiaxntaid-->
		</el-menu>

	</div>
</template>

<script>
	import { Session, Local } from '@/utils/storage.js';
	export default {
		name: "Aside",
		data () {
			return {
				collapse: false,
				level: -1,
				username:'',
				cx:'',
			}
		},
		created() {
			this.initUserInfo();
			// 获取浏览器localStorage，判断用户是否已经登录


		},
		methods: {
			isCollapse () {
				this.collapse = !this.collapse;
				this.$emit('collapse', this.collapse);
			},
			initUserInfo() {
				if (!Session.get('userInfo')) return false;
				this.userInfo = Session.get('userInfo');
				//if (localStorage.getItem("user")) {
				// 如果已经登录，设置vuex登录状态
				//this.setUser(JSON.parse(localStorage.getItem("user")));

				this.username=localStorage.getItem("username");
				this.cx=localStorage.getItem("cx");
				//}
				//this.userInfo.time = formatDate(new Date(this.userInfo.time), 'YYYY-mm-dd HH:MM:SS');
			},
		},
		mounted() {
			this.userInfo = JSON.parse(localStorage.userInfo);
			this.level = this.userInfo.level;
		}
	}
</script>
<style scoped>
	.el-submenu .el-menu-item {
		margin-left: 61px;

	}
	/deep/.el-submenu__icon-arrow
	{
		right: 70px;
	}
	/*子导航栏时的样式*/
	/deep/ .el-submenu .el-menu-item {
		min-width: 80px !important;
		width: 164px;
		height: 40px;
		margin-bottom: 5px !important;
		margin-left: 40px !important;
		line-height: 40px;
		text-align: center;
		border-radius: 55px;
	}
	/*/deep/ .el-menu-item.is-active {*/
	/*background-color: #409EFF;*/
	/*color: white;*/
	/*}*/
	/deep/ .el-menu-item-group__title {
		padding: 0;
	}
	.el-menu {
		border: 0;
		/*background-image: linear-gradient(#4777e7, rgba(90,139,255,0.68));*/
	}

	.active {
		background-color: #409EFF;
		color: white;
	}
</style>
