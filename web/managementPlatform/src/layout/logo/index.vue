<template>
	<div style="color: yellow;background-color: black" >
		<img src="../../assets/header.png" alt="" width="40" height="40" style="margin: 5px 30px 10px 20px;float: left" />
    <div class="misName">{{ getThemeConfig.globalTitle }}</div>
		<div style="float: right; margin-right: 16px">
			<!--日期-->
			<div class="font" v-html="day"></div>
			<!--头像-->
<!--			<div class="headerStr">-->
<!--			-->
<!--			</div>-->
			<!--用户名-->
			<div style="float: right;margin-right: 20px;margin-top: 18px;color: white">
				<el-dropdown  @command="onDropdownCommand">
          <span class="el-dropdown-link">
            {{username}}[{{cx}}]<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
					<el-dropdown-menu slot="dropdown" >
						<el-dropdown-item icon="el-icon-setting" command="editPassword">修改密码</el-dropdown-item>

						<el-dropdown-item icon="el-icon-switch-button" divided command="logOut">退出登录</el-dropdown-item>
					</el-dropdown-menu>
				</el-dropdown>
			</div>
		</div>
		<password ref="edit_password"></password>
	</div>
</template>

<script>

	import { Session} from '@/utils/storage.js';
export default {
	name: 'layoutLogo',
	data() {
		return {
			userInfo: {},
			username:'',
			cx:'',
		};
	},
	created() {
		this.initUserInfo();
		// 获取浏览器localStorage，判断用户是否已经登录

		//this.fetchCarouselData();
	},
	computed: {
		// 获取布局配置信息
		getThemeConfig() {
			return this.$store.state.themeConfig.themeConfig;
		},
		// 设置 logo 是否显示
		// setShowLogo() {
		// 	let { isCollapse, layout } = this.$store.state.themeConfig.themeConfig;
		// 	return !isCollapse || layout === 'classic' || document.body.clientWidth < 1000;
		// },
	},
	methods: {
		// logo 点击实现菜单展开/收起
		onThemeConfigChange() {
			if (this.$store.state.themeConfig.themeConfig.layout === 'transverse') return false;
			this.$store.state.themeConfig.themeConfig.isCollapse = !this.$store.state.themeConfig.themeConfig.isCollapse;
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
		onDropdownCommand(path) {
			if (path === 'logOut') {
				setTimeout(() => {
					this.$msgbox({
						closeOnClickModal: false,
						closeOnPressEscape: false,
						title: this.$t('message.user.logOutTitle'),
						message: this.$t('message.user.logOutMessage'),
						showCancelButton: true,
						confirmButtonText: this.$t('message.user.logOutConfirm'),
						cancelButtonText: this.$t('message.user.logOutCancel'),
						beforeClose: (action, instance, done) => {
							if (action === 'confirm') {
								instance.confirmButtonLoading = true;
								instance.confirmButtonText = this.$t('message.user.logOutExit');
								setTimeout(() => {
									done();
									setTimeout(() => {
										instance.confirmButtonLoading = false;
									}, 300);
								}, 700);
							} else {
								done();
							}
						},
					}).then(() => {
						// 清除缓存/token等
						Session.clear();
						// 使用 reload 时，不需要调用 resetRoute() 重置路由
						window.location.reload();
					})
							.catch(() => {});
				}, 150);
			} else if (path === 'editPassword') {
				this.$router.push({
					name:'resetPass',

				})
				// window.open('https://gitee.com/lyt-top/vue-next-admin');
			} else {
				this.$router.push(path);
			}
		},
	},
};
</script>

<style scoped>
	/* 旋转的关闭按钮*/
  /* 旋转的关闭按钮*/
  .font {
		font-size: 18px;
		margin-right: 80px;
		line-height: 60px;
		float: left;
	}

  .misName {
		margin-left: 50px;
		float: left;
		font-size: 24px;
		line-height: 60px
	}

	.el-dropdown-link {
		font-size: 17px;
		cursor: pointer;
		color: white;
	}
	.el-icon-arrow-down {
		font-size: 17px;
	}

  /*打开默哀模式时*/
	/deep/ .el-switch__label.is-active {
		/*filter:progid:DXImageTransform.Microsoft. BasicImage(grayscale=1); -webkit-filter: grayscale(100%);*/
		color: #fff !important;
	}
	/*关闭默哀模式时*/
	/deep/ .el-switch__label--left {
		color: white !important;
	}
</style>
