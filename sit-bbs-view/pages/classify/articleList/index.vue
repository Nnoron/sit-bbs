<template>
  <div class="articleListBody">
    <BreadCrumb />
    <!--公告区-->
    <div class="noticeDiv">
      <!--板块信息-->
      <div class="topRow">
        <div class="blockInfo">
          <span id="blockName">官方新闻</span>
          <span style="margin-left: 30px">今日新增：</span><span id="newNum">{{newNum}}</span>
          <span style="margin-left: 30px">帖子总数：{{allNum}}</span>
          <span style="margin-left: 30px">当前在线：{{onlineNum}}</span>
        </div>
        <div class="newArticle">
          <nuxt-link id="newButton" to="/user/myHome/newArticle">发表新帖</nuxt-link>
        </div>
      </div>
      <!--公告内容-->
      <div class="blockNotice">
        <div class="noticeContent">
          <p style="font-size: 18px;font-weight: bold">板块公告：</p>
          <div id="noticeMessage">
            sadffffffffffffffffffffff <br>
            asdfffffffffffffffffff <br>
            asffffffffffffffffff <br>
            asfffffffffff <br>
            asffffffffffff <br>
            asdfffffffffffffffffff <br>
            asffffffffffffffffff <br>
          </div>
        </div>
        <div style="display: flex;justify-content: space-between">
          <div></div>
          <div class="blockAdmin">
            版主：
            <nuxt-link to="/home">
              <img id="blockAdminHeadIcon" :src="blockAdminHeadIcon" alt="">
            </nuxt-link>
          </div>
        </div>
      </div>
    </div>
    <!--公告区-->

    <!--标签区-->
    <div class="labelsRow">
      <div class="labelDiv" v-for="item of labels" :key="item.text">
        <span class="labelContent">{{item.text}}</span><span class="labelNum">12342</span>
      </div>
    </div>
    <!--标签区-->

    <!--筛选区-->
    <div class="sortDiv">
      <div>
        <span>当前标签：</span><span style="font-size: 20px;line-height: 40px;font-weight: bold">{{curLabel}}</span>
      </div>
      <div class="sortButtonDiv">
        <span class="sortButton">热度</span>
        <span class="sortButton">发帖时间</span>
        <span class="sortButton">回复时间</span>
      </div>
    </div>
    <div class="articleListDiv">

    </div>
  </div>
</template>

<script>
  export default {
    data(){
      return{
        newNum:23,
        allNum:32415,
        onlineNum:89,
        blockAdminHeadIcon:'/images/blankHeadIcon.jpg',
        labels:[
          {text:'学习请教'},
          {text:'寻人启事'},
          {text:'全部'}
        ],
        curLabel:'学习请教'
      }
    },
    watch:{
      $route(){
        console.log(this.$route);
      }
    },
    mounted(){
    }

  }
</script>

<style scoped lang="less">
  .articleListBody{
    /*height: 1000px;*/
    width: 100%;
    padding: 20px 0;
    background-color: #f7f8fb;
    .noticeDiv{
      width: 78%;
      margin: auto;
      padding: 10px 20px;
      border-top: orange 5px solid;
      border-left: lightgray 1px solid;
      border-right: lightgray 1px solid;
      border-bottom: lightgray 1px solid;
      background-color: white;
      .topRow{
        display: flex;
        justify-content: space-between;
        .blockInfo{
          width: fit-content;
          #blockName{
            font-size: 30px;
            font-weight: bold;
            font-family: 微软雅黑;
          }
          #newNum{
            font-weight: bold;
            color: orangered;
          }
        }
        .newArticle{
          margin-right: 100px;
          #newButton{
            font-size: 20px;
            line-height: 45px;
          }
        }
      }
      .blockNotice{
        position: relative;
        .noticeContent{
            margin-top: 20px;
          #noticeMessage{
            width: 85%;
            margin: auto;
            padding: 20px;
            /*border: #47494e 1px solid;*/
          }
        }
        .blockAdmin{
          margin-top: 20px;
          margin-right: 100px;
          display: flex;
          align-items: center;
          #blockAdminHeadIcon{
            width: 46px;
            height: 46px;
            border-radius: 23px;
          }
          #blockAdminHeadIcon:hover{
            filter:brightness(0.9);
          }
        }
      }
    }
    .labelsRow{
      display: flex;
      margin: auto;
      height: 50px;
      width: 78%;
      padding:5px;
      .labelDiv{
        border: darkgray 1px solid;
        height: 30px;
        margin-left: 20px;
        margin-top: 5px;
        padding: 5px;
        .labelNum{
          display: inline-block;
          margin-left: 5px;
          padding: 3px;
          height: 20px;
          line-height: 16px;
          background-color: darkgray;
          color: #f7f8fb;
          border-radius: 3px;
        }
      }
      .labelDiv:hover{
        cursor: pointer;
        border: #47494e 1px solid;
        color: orange;
      }

    }

    .sortDiv{
      width: 78%;
      background-color: #e7e6e1;
      height: 40px;
      margin: auto;
      padding-left: 20px;
      padding-right: 30px;
      display: flex;
      justify-content: space-between;
      .sortButtonDiv{
        font-weight: bold;
        line-height: 40px;
        .sortButton{
          margin-left: 15px;
        }
      }
    }

    .articleListDiv{
      margin: auto;
      width: 78%;
      height: 500px;
      background-color: white;
      border: lightgray 1px solid;
    }
  }
</style>
