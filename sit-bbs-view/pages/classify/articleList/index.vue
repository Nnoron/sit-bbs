<template>
  <div class="articleListBody">
    <div class="breadCrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item to="/home">首页</el-breadcrumb-item>
        <el-breadcrumb-item to="/classify">分类浏览</el-breadcrumb-item>
        <el-breadcrumb-item>{{curBlockName}}</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <!--公告区-->
    <div class="noticeDiv">
      <!--板块信息-->
      <div class="topRow">
        <div class="blockInfo">
          <span id="blockName">{{curBlockName}}</span>
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
        <span>排序方式：</span>
        <span class="sortButton">热度</span>
        <span class="sortButton" @mouseleave="publishTimeShowFlag=false" @click="publishTimeShowFlag=true">发帖时间<Icon type="md-arrow-dropdown" /></span>
        <span class="sortButton" @mouseleave="replyTimeShowFlag=false" @click="replyTimeShowFlag=true">回复时间<Icon type="md-arrow-dropdown" /></span>
      </div>
    </div>
    <div class="articleListDiv">
      <div class="publishTimeShow" v-show="publishTimeShowFlag" @mouseover="publishTimeShowFlag=true" @mouseleave="publishTimeShowFlag=false">
        <List border size="small">
          <ListItem><a class="ptSelectItem" href="">最新</a></ListItem>
          <ListItem><a class="ptSelectItem" href="">最近三天</a></ListItem>
          <ListItem><a class="ptSelectItem" href="">最近一周</a></ListItem>
          <ListItem><a class="ptSelectItem" href="">最近一月</a></ListItem>
        </List>
      </div>
      <div  class="replyTimeShow" v-show="replyTimeShowFlag" @mouseover="replyTimeShowFlag=true" @mouseleave="replyTimeShowFlag=false">
        <List border size="small">
          <ListItem><a class="ptSelectItem" href="">最新</a></ListItem>
          <ListItem><a class="ptSelectItem" href="">最近三天</a></ListItem>
          <ListItem><a class="ptSelectItem" href="">最近一周</a></ListItem>
          <ListItem><a class="ptSelectItem" href="">最近一月</a></ListItem>
        </List>
      </div>
      <table rules=none>
        <tr style="color: darkgray;height: 30px;line-height: 30px">
          <th width="120px">类型</th>
          <th width="450px">主题</th>
          <th width="300px">发帖人 · 发帖时间</th>
          <th width="80px">热度</th>
          <th width="300px">最后回复 · 回复时间</th>
        </tr>
        <tr class="listRow" v-for="(item,index) in articlesInfo" :key="index">
          <td class="listContent" width="120px"><a :href="item.typeId">[{{item.type}}]</a></td>
          <td class="listContent" width="400px"><a :href="item.subjectId">{{item.subject}}</a></td>
          <td class="listContent" width="250px">
            <a :href="item.authorId">{{item.author}}</a> · <span class="listContent grayFont">{{item.publishTime}}</span>
          </td>
          <td class="listContent" width="80px">{{item.degree}}</td>
          <td class="listContent" width="250px">
            <a :href="item.replierId">{{item.lastReplier}}</a> · <span class="listContent grayFont">{{item.replyTime}}</span>
          </td>
        </tr>
      </table>
      <p @click="getMore" style="text-align: center;font-weight: bold;height:50px;line-height: 50px">加载更多……</p>
    </div>
  </div>
</template>

<script>
  export default {
    middleware: 'metaTitle',
    meta:{title:'分类列表'},
    data(){
      return{
        curBlockName:this.$route.query.title,
        newNum:23,
        allNum:32415,
        onlineNum:89,
        blockAdminHeadIcon:'/images/blankHeadIcon.jpg',
        labels:[
          {text:'学习请教'},
          {text:'寻人启事'},
          {text:'全部'}
        ],
        curLabel:'学习请教',
        publishTimeShowFlag:false,
        replyTimeShowFlag:false,
        articlesInfo:[
          {type:'校园新闻',
            typeId:1,
            subject:'刘昊然在迎新晚会献歌一曲',
            subjectId:11,
            author:'author',
            authorId:1,
            degree:88,
            publishTime:'2021-02-26 13:25:15',
            lastReplier:'我是班主任',
            replierId:13,
            replyTime:'2021-02-26 14:13:24'
          },
          {type:'校园新闻',
            typeId:1,
            subject:'刘昊然在迎新晚会献歌一曲',
            articleId:11,
            author:'author',
            authorId:1,
            degree:89,
            publishTime:'2021-02-26 13:25:15',
            lastReplier:'我是班主任',
            replierId:13,
            replyTime:'2021-02-26 14:13:24'
          },
          {type:'校园新闻',
            typeId:1,
            subject:'刘昊然在迎新晚会献歌一曲',
            articleId:11,
            author:'author',
            authorId:1,
            degree:90,
            publishTime:'2021-02-26 13:25:15',
            lastReplier:'我是班主任',
            replierId:13,
            replyTime:'2021-02-26 14:13:24'
          }
        ]
      }
    },
    created(){
    },
    mounted(){
      // console.log(this.$route.path);
      if(sessionStorage.getItem("CUR_BLOCK")!==undefined && sessionStorage.getItem("CUR_BLOCK")!==""){
        this.curBlockName=JSON.parse(sessionStorage.getItem("CUR_BLOCK"));
      }
      sessionStorage.setItem("CUR_BLOCK",JSON.stringify(this.$route.query.title));
    },
    methods:{
      getMore(){
        let array={
          type:'校园新闻',
          typeId:1,
          subject:'刘昊然在迎新晚会献歌一曲',
          articleId:11,
          author:'author',
          authorId:1,
          degree:90,
          publishTime:'2021-02-26 13:25:15',
          lastReplier:'我是班主任',
          replierId:13,
          replyTime:'2021-02-26 14:13:24'
        };
        for (let i=0;i<5;i++){
          this.articlesInfo.push(array);
        }
      }
    }

  }
</script>

<style lang="less">
  .articleListBody{
    /*height: 1000px;*/
    width: 100%;
    padding: 20px 0;
    background-color: #f7f8fb;
    .breadCrumb{
      margin: 0 170px 20px;
    }
    .noticeDiv{
      width: 78%;
      margin: auto;
      padding: 10px 20px;
      border-top: #d3e0ea 10px solid;
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
        margin-left: 15px;
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
      background-color: #d3e0ea;
      height: 40px;
      margin: auto;
      padding-left: 20px;
      padding-right: 30px;
      display: flex;
      justify-content: space-between;
      .sortButtonDiv{
        .sortButton{
          display: inline-block;
          position: relative;
          font-weight: bold;
          height:42px;
          line-height: 42px;
          margin-left: 15px;
        }
        .sortButton:hover{
          color: orange;
          cursor: pointer;
        }
      }
    }


    .articleListDiv{
      margin: auto;
      width: 78%;
      /*height: 500px;*/
      background-color: white;
      border: lightgray 1px solid;
      position: relative;
      .ptSelectItem{
        width: 100%;
        text-align: center;
        color: #47494e;
      }
      .ptSelectItem:hover{
        color: cornflowerblue;
      }
      .publishTimeShow{
        z-index: 2000;
        width: 100px;
        position: absolute;
        top: -3px;
        right: 110px;
        .ivu-list{
          background-color: white;
          border-radius: 0;
        }
      }
      .replyTimeShow{
        z-index: 2000;
        width: 100px;
        position: absolute;
        top: -3px;
        right: 10px;
        .ivu-list{
          background-color: white;
          border-radius: 0;
        }
      }
      .grayFont{
        color: darkgray;
        font-size: 13px;
      }
      .listRow{
        .listContent{
          text-align: center;
          height:50px;
          line-height: 50px;
          a{
            color: #47494e;
          }
          a:hover{
            color: orange;
          }
        }
      }
      .listRow:hover{
        background-color: #eeeeee;
      }
      table tr:nth-child(2n){
        background: #f7f9fb;
      }
      p{
        cursor: pointer;
      }
    }
  }
</style>
