<template>
  <div>


    <div class="header" style="position: fixed; opacity: 0.9; top: 0;">
      <div class="top hidden-sm hidden-xs">
        <div class="wrap">
          <!--          <div class="greet">欢迎来到xxx页面！</div>-->

          <div class="greet">
            <li v-if="!this.$store.getters.getUser" style="float:left">
              <el-button type="text" @click="login" style="color: #fff;
    display: inline-block;
    text-transform: uppercase;
    text-decoration: none;
    background: #dc9a26;
    text-align: center;
    padding: 6px 30px;
    font-weight: bold;">登录
              </el-button>
              <span class="sep">|</span>
              <el-button type="text" @click="register = true" style="color: #fff;
    display: inline-block;
    text-transform: uppercase;
    text-decoration: none;
   background: #dc9a26;
    text-align: center;
    padding: 6px 30px;
    font-weight: bold;">注册
              </el-button>
            </li>
            <li v-else>
              <font color="black">用户{{ username }}，身份:【{{ cx }}】</font>&nbsp;
              <el-button type="text" @click="logout" style="color: #fff;
    display: inline-block;
    text-transform: uppercase;
    text-decoration: none;
   background: #dc9a26;
    text-align: center;
    padding: 6px 30px;
    font-weight: bold;">退出
              </el-button>
              <router-link :to="`/Collect/`" class="el-button el-button--text" style="color: #fff;
    display: inline-block;
    text-transform: uppercase;
    text-decoration: none;
     background:#dc9a26;
    text-align: center;
    padding: 6px 30px;
    font-weight: bold;">
                我的收藏
              </router-link>
              <el-popover placement="top" width="180" v-model="visible">
                <p>确定退出登录吗？</p>
                <div style="text-align: right; margin: 10px 0 0">
                  <el-button size="mini" type="text" @click="visible = false">取消</el-button>
                  <el-button type="primary" size="mini" @click="logout">确定</el-button>
                </div>
              </el-popover>
            </li>


          </div>


          <div class="tel hidden-sm hidden-xs">
            <a href="http://localhost:8080/#/" target="_blank">
            欢迎来到<img src="./assets/LabelClublogo.jpg">Label Club 音乐厂牌投稿管理平台</a>
          </div>

        </div>
      </div>
      <div class="wrap">
        <div class="Logo" style="padding: 12px 0px;">
          <a href="/">
            <img src="./assets/textlogo.jpg" style="height: 35px;">
          </a>
        </div>


        <div class="nav hidden-sm header-menu">
          <ul class="menu">
            <li><a href="/" class="menu-item hover" style="height: 45px;">Home</a></li>

		<li class="menu-item"><a style="height: 45px; ">All Labels</a>
              <ul class="sub-menu"><li class="menu-item"><router-link :to="`/labelList/`" >All Labels</router-link></li>
                <li class="menu-item"><router-link :to="`/Liuyan/`" >留言板</router-link></li>
              </ul>
    </li>
          
          </ul>
        </div>
		
      </div>
    </div>

    <!-- 登录模块 -->
    <MyLogin></MyLogin>
    <!-- 注册模块 -->
    <MyRegister :register="register" @fromChild="isRegister"></MyRegister>

    <!-- 主要区域容器 -->
    <el-main>
      <keep-alive>
        <router-view></router-view>
      </keep-alive>
    </el-main>

    <div class="footer">
      <div class="wrap">
        <div class="footer1">
          <span>链接 ：</span>
          <ul>
            <li><a href="http://localhost:9999/" target="_blank">厂牌/管理员/音乐人信息修改管理入口</a></li>

          </ul>
        </div>
        <div class="footer2">
          <div class="ft2">
            <ul>

              <li>FOREST DRE4M//2024.3.12//LABELCLUB version:0.0.1</li>
            </ul>
            <div>

              <span>地址：西北民族大学</span>
            </div>
          </div>
          <div class="ft3">
            <div class="ewm2">
              <img src="./assets/wechat.png">
            </div>
            <div class="lx2">
              <span>厂牌账号入驻</span>
              <b>13429599842</b>
              <h6>（欢迎您随时来电）</h6>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import {mapActions} from "vuex";
import {mapGetters} from "vuex";

export default {
  beforeUpdate() {
    this.activeIndex = this.$route.path;
  },
  data() {
    return {
      carouselItems: [], // 存储轮播图数据
      activeIndex: "", // 头部导航栏选中的标签
      search: "", // 搜索条件
      register: false, // 是否显示注册组件
      visible: false, // 是否退出登录
      username: '',
      cx: '',
    };
  },
  created() {
    // 获取浏览器localStorage，判断用户是否已经登录
    if (localStorage.getItem("user")) {
      // 如果已经登录，设置vuex登录状态
      this.setUser(JSON.parse(localStorage.getItem("user")));
      this.username = localStorage.getItem("username");
      this.cx = localStorage.getItem("cx");
    }
    this.fetchCarouselData();
    console.log(this.$store.getters.getUser)
  },
  computed: {
    ...mapGetters(["getUser", "getNum"])
  },
  watch: {},
  methods: {
    // fetchCarouselData() {
    //   this.$axios
    //       .get("/api/front/sp", {})
    //       .then(res => {
    //         let data = res.data.data;
    //         let filteredData = [];
    //         data.forEach(item => {
    //           filteredData.push(item);
    //         });
    //         this.carouselItems = filteredData;
    //       })
    //       .catch(err => {
    //         return Promise.reject(err);
    //       });
    // },
    ...mapActions(["setUser", "setShowLogin", "setShoppingCart"]),
    login() {
      // 点击登录按钮, 通过更改vuex的showLogin值显示登录组件
      this.setShowLogin(true);
    },

    // 退出登录
    logout() {
      this.visible = false;
      // 清空本地登录信息
      localStorage.setItem("user", "");
      // 清空vuex登录信息
      this.setUser("");
      this.notifySucceed("成功退出登录");
    },
    // 接收注册子组件传过来的数据
    isRegister(val) {
      this.register = val;
    },
  }
};
</script>

<style>
@import "assets/css/index2.css";
@import "assets/css/responsive.css";
@import "assets/css.css";
@import "assets/swiper.min.css";
@import "assets/bootstrap.min.css";
@import "assets/font-awesome.min.css";
@import "assets/animate.min.css";
@import "assets/share_style1_32.css";


/*@import "assets/css/style.css";*/
/* 全局CSS */
* {
  padding: 0;
  margin: 0;
  /*border: 0;*/
  list-style: none;
  font-size: 14px;
}


.newsline TD {
  LINE-HEIGHT: 25px;
  BORDER-BOTTOM: #c9c9c9 1px dashed;
  text-align: left;
}

.newsline TD A:link {
  COLOR: #000
}

.newsline TD A:visited {
  COLOR: #000
}

.newsline TD A:hover {
  COLOR: #000
}

.newsline TD A:active {
  COLOR: #000
}

a,
a:hover {
  text-decoration: none;
}

/* 全局CSS END */



.topbar .nav ul {
  float: right;
}

.topbar .nav li {
  float: left;
  height: 40px;
  color: #b0b0b0;
  font-size: 14px;
  text-align: center;
  line-height: 40px;
  margin-left: 20px;
}

.topbar .nav li a {
  color: #b0b0b0;
}

.topbar .nav a:hover {
  color: #fff;
}


.topbar .nav .shopCart:hover a {
  color: #ff6700;
}


.topbar .nav .shopCart-full a {
  color: white;
}

/* 顶部导航栏CSS END */



/* 顶栏容器CSS END */
.header {
  /*padding: 1em 0;*/
}

.w3layouts_logo a {
  display: block;
  text-decoration: none;
}

h1, h2, h3, h4, h5, h6, a {
  font-family: 'Roboto Condensed', sans-serif;
  margin: 0;
}

.w3layouts_logo a h1 {
  padding-left: 20px;
  padding-top: 20px;
  font-size: 2.8em;
  color: #212121;
  text-transform: uppercase;

  padding-right: 1.67em;
  font-weight: 900;
  padding-bottom: 0.3em;
}

.w3layouts_logo a h1 span {

  color: #FF8D1B;
  font-size: .3em;
  display: block;
  font-weight: 300;
  letter-spacing: 5px;
  text-align: right;
  line-height: 0;
}

.w3_search input[type="text"] {
  outline: none;
  border: none;
  background: #EFEFEF;
  padding: 11px;
  text-align: center;
  font-size: 14px;
  color: #999;
  width: 71%;
  float: left;
  border-top-left-radius: 25px;
  border-bottom-left-radius: 25px;
}

.w3_search input[type="submit"] {
  outline: none;
  border: none;
  background: #212121;
  padding: 10px 0;
  font-size: 14px;
  color: #fff;
  width: 22%;
  border-top-right-radius: 25px;
  border-bottom-right-radius: 25px;
}

.w3l_sign_in_register ul li a {
  color: #fff;
  display: inline-block;
  text-transform: uppercase;
  text-decoration: none;
  background: #FF8D1B;
  text-align: center;
  padding: 6px 30px;
  font-weight: bold;
}


.navbar-nav > li {
  float: left;
  border-right: 1px dotted #fff;
  width: 9%;
  text-align: center;
}

.navbar-default .navbar-nav > li > a {
  color: #fff;
  text-transform: uppercase;
}

.navbar-default .navbar-nav > li > a {
  color: #777;
}



.navbar-nav > li > a {
  padding-top: 10px;
  padding-bottom: 10px;
  line-height: 20px;
}

.nav > li {
  position: relative;
  display: block;
}

p, ul li, ol li {
  margin: 0;
  font-size: 14px;
}

article, aside, details, figcaption, figure, footer, header, hgroup, main, menu, nav, section, summary {
  display: block;
}


.w3l_sign_in_register ul li a {
  color: #fff;
  display: inline-block;
  text-transform: uppercase;
  text-decoration: none;
  background: #FF8D1B;
  text-align: center;
  padding: 6px 30px;
  font-weight: bold;
}



</style>
