
<template>
  <div class="order">
    <div class="order-header">
      <div class="order-header-content">
        <p>
          <i class="el-icon-s-order" style="font-size: 30px;color: #ff6700;"></i>
          厂牌
        </p>
      </div>
    </div>

    <div class="order-content">
      <div class="content">
        <el-form :inline="true" :model="formInline" class="user-search">
          <el-form-item label=""><el-input size="small" style="width: 100px;" v-model="formInline.labelname" placeholder="输入厂牌名称"></el-input></el-form-item>
			<el-form-item label=""><el-input size="small" style="width: 100px;" v-model="formInline.genre" placeholder="输入流派"></el-input></el-form-item>
			
          <el-form-item>
            <el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
          </el-form-item>
        </el-form>
		
		
        <ul>

          <li class="header">
            <div class='pro-img'> 用户名</div>
            <div class='pro-img'> 密码</div>
            <div class='pro-img'> lid</div>
            <div class='pro-img'> 厂牌名称</div>
            <div class='pro-img'> 邮箱</div>
          </li>

          <li class="product-list" v-for="item in label" :key="item.id">
            <router-link :to="`/labeldetail/`+item.id" >
				<div class='pro-img'>{{item.username}}</div>
    <div class='pro-img'>{{item.password}}</div>
    <div class='pro-img'>{{item.lid}}</div>
    <div class='pro-img'>{{item.labelname}}</div>
    <div class='pro-img'>{{item.email}}</div>
    
    

             
            </router-link>
          </li>
        </ul>
        <div class="order-bar">
        </div>
      </div>
      <div style="margin-top:-40px;"></div>
    </div>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        label: "", // 数据列表
        userInfo:{},
        total: 0, // 厂牌总量
        currentPage:0,
        currentNum: 10, // 每页显示的厂牌数量
        current: 1, //当前页码
        activeName: "-1", // 分类列表当前选中的id
        formInline: {
          page: 1,
          limit: 10,
        },
      };
    },
    created() {
      this.getlabel();
    },
    activated() {
      this.activeName = "-1"; // 初始化分类列表当前选中的id为-1
      this.total = 0; // 初始化厂牌总量为0
      this.current = 1; //初始化当前页码为1
    },

    methods: {
      // 页码变化调用currentChange方法
      currentChange(current) {
        this.current = current;
        if (this.productName !== "") {
          this.getProductBySearch();
        } else {
          this.getData();
        }
        this.backtop();
      },
      search() {
        this.getlabel(this.formInline)
      },
      // 向后端请求分类列表数据
      getlabel(parameter) {
        this.$axios
               .post("/api/front/label", {...parameter})
                .then(res => {
                  debugger
                  this.label = res.data.data.list;
                  this.currentPage = this.formInline.current
                  this.pageSize = this.formInline.currentNum
                  this.total = res.data.data.total
                })
                .catch(err => {
                  return Promise.reject(err);
                });
      },



    }
  };
</script>
<style scoped>
  * {
    background: #fff;
    color: #444;
    font-family: "Open Sans", sans-serif;
  }
  .order {
    background-color: #f5f5f5;
    padding-bottom: 20px;
  }
  /* 我的厂牌头部CSS */
  .order .order-header {
    height: 64px;
    border-bottom: 2px solid #ff6700;
    background-color: #fff;
    margin-bottom: 20px;
  }
  .order .order-header .order-header-content {
    width: 1225px;
    margin: 0 auto;
  }
  .order .order-header p {
    font-size: 28px;
    line-height: 58px;
    float: left;
    font-weight: normal;
    color: #424242;
  }
  /* 我的厂牌头部CSS END */
  .order .content {
    width: 1225px;
    background-color: #fff;
    margin: 0 auto 50px;
  }

  .order .content ul {
    background-color: #fff;
    color: #424242;
    line-height: 85px;
  }
  /* 我的厂牌表头CSS */

  .order .content ul .header {
    height: 85px;
    padding-right: 26px;
    color: #424242;
  }
  /* 我的订单表头CSS END */

  /* 订单列表CSS */
  .order .content ul .product-list {
    height: 85px;
    padding: 15px 26px 15px 0;
    border-top: 1px solid #e0e0e0;
  }
  .order .content ul .pro-img {
    float: left;
    height: 45px;
    width: 120px;
    padding-left: 80px;
  }
  .order .content ul .pro-img img {
    height: 80px;
    width: 80px;
  }

  .order .content ul .pro-name a {
    color: #424242;
  }
  .order .content ul .pro-name a:hover {
    color: #ff6700;
  }

  .order .order-bar {
    width: 1185px;
    padding: 0 20px;
    border-top: 1px solid #ff6700;
    height: 50px;
    line-height: 50px;
    background-color: #fff;
  }

  /* 订单列表CSS END */

  /* 订单为空的时候显示的内容CSS */
  .order .order-empty .empty h2 {
    margin: 70px 0 15px;
    font-size: 36px;
  }
  .order .order-empty .empty p {
    margin: 0 0 20px;
    font-size: 20px;
  }
  /* 厂牌为空的时候显示的内容CSS END */
</style>
