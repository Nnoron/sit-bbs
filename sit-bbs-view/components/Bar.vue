<template>
  <div>
    <div class="topBar">
      <!--logo-->
      <Logo />

      <!--item-->
      <div class="link" :class='{active:$route.name===i.name}' v-for="i of menuitems" :key="i.text">
        <nuxt-link class="linkText" :to='{name:i.name}'>
          <span>{{ i.text }}</span>
        </nuxt-link>
      </div>

      <!--search-->
      <div class="search">
        <el-button icon="el-icon-search" round @click="searchBarShow = true">搜索</el-button>
      </div>

      <!--person information-->
      <div  class="personInfo" @mouseover="loginMenuShow = true" @mouseout="loginMenuShow = false">
        <nuxt-link to="hot">
          <img class="headInfo" :src="headPath" alt="">
          <span class="userName">{{username}}</span>
        </nuxt-link>
      </div>
    </div>


    <!--登录前状态栏-->
    <div class="beforeLogin" v-show="loginMenuShow" @mouseover="loginMenuShow = true" @mouseleave="loginMenuShow = false">
      <div style="background-color: #bee5d3;display: flex">
        <img class="headIcon" :src="headPath" alt="">
        <div style="display: flex;flex-flow: column;margin: 35px 45px 0 0;line-height: 12px;" >
          <span style="font-weight: bold;font-size: 18px;">您还未登录</span><br>
          <span style="font-size: 13px;color:dimgrey">登录后可享更多功能哦</span>
        </div>
        <el-button class="logBtn"  round>登录</el-button>
      </div>
      <div style="display: flex;margin: 25px">
        <div class="menuItem" v-for="i of personItems" :key="i.text">
          <i :class="i.icon" style="font-size: 30px;display: inline-block;"></i><br>
          <span>{{i.text}}</span>
        </div>
      </div>
    </div>

    <!--搜索栏-->
    <div class="searchBar" v-show="searchBarShow" @mouseleave="searchBarShow = false">
      <p style="font-size: 20px;font-family: 微软雅黑;color: darkgray;text-align: center;line-height: 20px;margin-top: 10px">
        搜索  <i class="el-icon-search"></i>
      </p>
      <div style="margin-top: 15px;text-align: center">
        <el-input placeholder="请输入内容" v-model="input3" class="input-with-select" style="width: 80%">
          <el-select v-model="select" slot="prepend" placeholder="请选择" style="width: 100px;">
            <el-option label="餐厅名" value="1"></el-option>
            <el-option label="订单号" value="2"></el-option>
            <el-option label="用户电话" value="3"></el-option>
          </el-select>
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
        <div class="hotSearch">
          <p style="text-align: left;color: darkgray;padding: 0 0 0 60px;line-height: 35px">热搜话题：</p>
          <a :href="i.id" v-for="i of linkItems" :key="i.id">{{i.describe}}<br></a>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "Bar",
  data () {
    return {
      menuitems:[
        { text:'首页', name:'home'},
        { text:'热门排行', name:'hot'},
        { text:'动态分享', name:'activity'},
        { text:'分类浏览', name:'classify'},
        { text:'文件漫游', name:'file'},
      ],
      personItems:[
        {icon:'el-icon-star-off',text:'我的收藏'},
        {icon:'el-icon-user',text:'我的关注'},
        {icon:'el-icon-document',text:'发表文章'},
        {icon:'el-icon-message',text:'我的消息'}
      ],
      linkItems:[
        {id:123,describe:'刘昊然到场迎新仪式'},
        {id:234,describe:'黄晓明去食堂吃了肥肠饭'}
      ],
      username:'请登录',
      headPath:'/images/blankHeadIcon.jpg',
      loginMenuShow:false,
      searchBarShow:false,
      input3: '',
      select: '',
    }
  },
  created(){

  },
  watch:{
  },
  mounted(){
  },
  methods:{
  }
}
</script>

<style lang="less">
  .topBar{
    z-index: 999;
    width: 100%;
    height: 60px;
    background-color: rgba(255,255,255,0.9);
    box-shadow: 0 0 25px rgba(0,0,0,0.1);
    position: fixed;
    top: 0;
    opacity: 100%;
    display: flex;
  }
  .link{
    float: left;
    padding: 0 10px;
    margin: 0 10px;
    width: 100px;
    height: 100%;
    background-color: rgba(255,255,255,-0.1);
    text-align: center;
    line-height: 63px;
    a{
      color: #47494e;
    }
    .linkText{
      display: inline-block;
      height: 100%;
      width: 100%;
    }
  }
  .link:hover,.link:focus{
    cursor: pointer;
    border-bottom: #5669ba 5px solid;
    a{
      color: #5669ba;
    }
  }
  .active{
    border-bottom: #5669ba 5px solid;
    a{
      color: #5669ba;
    }
  }

  .search{
    margin:auto 35px;
    padding: 10px;

  }


  .personInfo{
    padding: 5px;
    margin: 0 auto 0 30px;
    height: 100%;
    background-color: rgba(255,255,255,-0.1);
    text-align: center;
    /*line-height: 55px;*/
    display: flex;
    width: 200px;
    color: #47494e;
    .headInfo{
      width: 53px;
      height: 53px;
      border: orange 3px solid;
      border-radius: 30px;
      padding: 2px;
    }
    .headInfo:hover{
      border: cornflowerblue 3px solid;
    }
    .userName{
      position: absolute;
      color: #7f828b;
      margin:17px 10px 0;
      font-weight: bold;
    }
    .userName:hover{
      color: orange;
    }
  }

  .beforeLogin{
    z-index: 2000;
    position: fixed;
    top: 60px;
    float: right;
    right: 5%;
    background-color: white;
    box-shadow: 0 0 25px rgba(0,0,0,0.1);
    width: 430px;
    height: 230px;
    animation: 0.4s beforeLoginAppear;
    .headIcon{
      margin: 20px;
      height: 60px;
      width: 60px;
      border-radius: 30px;
    }
    .menuItem{
      padding: 9px 0;
      width: 80px;
      height: 80px;
      border: darkgray 1px solid;
      border-radius: 3px;
      margin: 0 8px;
      text-align: center;
      line-height: 32px;
    }
    .menuItem:hover{
      background-color: #8b5e83;
      color: #f7f8fb;
      cursor: pointer;
    }
    .logBtn{
      margin-top: 30px;
      background-color: #5669ba;
      color: #f7f8fb;
      height: 38px
    }
    .logBtn:hover{
      background-color: #5eaaa8;
    }
  }

  .searchBar{
    z-index: 2000;
    width: 600px;
    height: 250px;
    box-shadow: 0 0 25px rgba(0,0,0,0.1);
    position: fixed;
    top: 60px;
    float: left;
    left: 40%;
    animation: 1s beforeLoginAppear;
    background-color: white;
    a{
      color: #47494e;
    }
    a:hover{
      color: orange;
    }
    .el-select .el-input {
      width: 100px;
    }
    .input-with-select .el-input-group__prepend {
      background-color: #fff;
    }
  }



  @keyframes beforeLoginAppear {
    0%{transform: translateY(-10px);opacity: 0;}
    100%{ transform: translateY(0px);opacity: 1;}
  }
</style>
