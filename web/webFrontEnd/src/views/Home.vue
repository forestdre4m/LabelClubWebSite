<template>
  <div>

<div class="cpzx wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">
  <div class="wrap">

    <div class="top"></div>
    <div class="top" >* 登录并投稿后，系统会根据相关数据向您推荐类似厂牌。</div>
<div>
  <img src="../assets/imgs/homepic.png">
</div>

	<div class="title">
    <h2>厂牌推荐列表</h2>
	</div>
	<div class="productctn productshow">
    <div class="swiper-container product swiper-container-vertical swiper-container-wp8-vertical">
		<div class="swiper-wrapper" style="transition-duration: 1000ms; transform: translate 3d(-607px, 0px, 0px);">

      <div class="swiper-slide" style="float: left; width: 1200px; margin-top: 10px;" v-for="item in objssp" :key="item.id" >
			<router-link :to="`/labeldetail/`+item.id">
        <div class="cp" >
          <div class="cpimg">
            <a id="">
              <img :src="`/api/`+item.labelpic" width='150' height='150' alt="">
              <td width='50%' height=44>流派标签：{{ item.genre  }}</td><td width='39%' ></td>
            </a>
          </div>
          <td id="cptit" class="cptit" style="float:right">{{ item.labelname }}
          </td>
        </div>
			</router-link>
      </div>
		</div>
    </div>
	</div>
  </div>
</div>


	
  </div>
</template>
<script>
import {mapActions} from "vuex";

export default {
  data() {
    return {
      objssp: [],
      objstx: [],
      wbjxwtz1: [],
      labeldetail: "",
    };
  },
  watch: {
    // eslint-disable-next-line no-unused-vars
    '$route'(to, from) {
      this.$router.go(0)
    },
  },
  created() {
    let user = localStorage.getItem("user");
    if (user) {
      this.userInfo = JSON.parse(localStorage.getItem("user"));
    }
    this.loadTablesp(10);
	//loadtx2


  },
  methods: {
    ...mapActions(["setUser", "setShowLogin", "setShoppingCart"]),
    goUrl() {
      window.location.href = 'http://localhost:9999'
    },



    loadTablesp(ns) {
        this.$axios
                .post("/api/front/recommend", {})
                .then(res => {
                  let data = res.data.data.list;
                  let filteredData = [];
                  let i=0;
                  data.forEach(item => {
                    i++;
                    if(i<=ns)
                    {
                      filteredData.push(item);
                    }
                  });
                  this.objssp = filteredData;
                });
      },
    //loadtxhs


  }
};
</script>
<style scoped>
@import "../assets/css/index.scss";



.message-item {
  margin-bottom: 20px;
}

.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  display: flex;
  justify-content: center;
  margin-top: 13px;
  line-height: 12px;
}

.button {
  width: 100%;
  text-align: center;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.el-row {
  margin-bottom: 20px;

}

last-child {
  margin-bottom: 0;
}

.el-col {
  border-radius: 4px;
}

.bg-purple {
  background: #d3dce6;
}

.bg-purple-light {
  background: #e5e9f2;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}

.info-item {
  display: flex;
  font-size: 13px;
  color: #606266;
  height: 28px;
  line-height: 28px;
}

.info-item :hover {
  color: #303133;
  cursor: pointer;
}

.info-item-left {
  flex: 1;
  flex-shrink: 0;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}

.rizhuti_v2-widget-search-bg > .container {
  max-width: none !important;
  padding: 0 !important;
}

.container, .container-fluid, .container-lg, .container-md, .container-sm, .container-xl {
  width: 100%;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}

.module.search-bg {
  z-index: 2 !important;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  min-height: calc(100vh - 70vh);
  position: relative;
  text-align: center;
  background-repeat: no-repeat;
  background-position: 50%;
  background-size: cover;
}

.module.search-bg .search-bg-overlay {
  height: 100%;
  width: 100%;
  top: 0;
  left: 0;
  position: absolute;
  filter: brightness(100%) contrast(100%) saturate(100%) blur(0px) hue-rotate(0deg);
  background-color: #191e4b;
  opacity: 0.5;
  transition: background 0.3s, border-radius 0.3s, opacity 0.3s;
}

.module.search-bg .container {
  z-index: 1;
  margin: auto;
  padding-bottom: 140px;
  padding-top: 140px;
  max-width: 820px;
}

.module.search-bg .search-title {
  color: #fff;
  letter-spacing: 2px;
  font-size: 24px;
}

.module.search-bg .search-desc {
  color: #fff;
  margin-bottom: 25px;
}

.module.search-bg .search-form {
  max-width: 100%;
}

.search-form form {
  display: flex;
  -ms-flex-flow: row nowrap;
  flex-flow: row nowrap;
  -ms-flex-align: center;
  align-items: center;
  -ms-flex-pack: justify;
  justify-content: space-between;
  width: 100%;
  border-radius: 50px;
}

.search-form .search-fields {
  background-color: #ffffff;
  position: relative;
  display: inline-block;
  flex: 1;
  vertical-align: top;
  background: #fff;
  border-radius: 30px;
  opacity: 0.8;
  overflow: hidden;
}

.search-form .search-fields input {
  display: block;
  height: 50px;
  line-height: 20px;
  width: 100%;
  border: 2px solid #fff;
  position: relative;
  z-index: 100;
  margin: 0;
  font-size: 16px;
  outline: 0;
  -webkit-appearance: none;
}

.search-form .search-fields button {
  position: absolute;
  height: 54px;
  width: 50px;
  right: 0;
  top: 0;
  z-index: 1000;
  border: none !important;
  background: 0 0 !important;
  max-height: 50px;
}

.module.search-bg .popula-search-key {
  text-align: left;
  color: #fff;
  margin-top: 10px;
  opacity: 0.5;
}

.module.search-bg .popula-search-key > a {
  color: #fff;
}

.modular-title-1 .section-title {
  font-size: 24px;
  letter-spacing: .5px;
  margin-bottom: 30px;
  text-transform: uppercase;
}

.image {
  width: 100%;
  display: block;
  max-height: 120px;
  min-height: 120px;
}

.clearfix {
  width: 100%;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.clearfix {
  font-size: 10px;
  line-height: 1.9;
  display: inline-block;
}

.title {
  font-size: 5px;
  letter-spacing: -0.2px;
  margin-bottom: 0;
  overflow: hidden;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  white-space: normal;
  height: 36px;
  line-height: 18px;
}

.clear {
  clear: both;
}

.el-form-item {
  margin-bottom: 0px !important;
}

.section {
  width: 100%;

  overflow: hidden;
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
}

h3 {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.col-md-3 {
  width: 24%;
}

</style>
