<template>
  <div>
    <div class="loginTip">
      <span class="showTitle">在上应大校园论坛</span>
      <span class="showText">你可以见到有趣又博识的同学，你可以找到志同道合的朋友，可以问你所想，答你所知</span>
      <div class="logButtons">
        <el-button class="registerBtn" round>免费注册</el-button>
        <el-button class="logBtn" round>立即登录</el-button>
      </div>
    </div>

    <span class="advHandle" @click="advShowHandle">{{advHandleText}}</span>

    <div class="advShow" v-if="topAdvShow">
      <el-carousel :interval="4000" type="card" height="200px">
        <el-carousel-item v-for="item in 6" :key="item">
          <h3 class="medium">{{ item }}</h3>
        </el-carousel-item>
      </el-carousel>
    </div>

    <el-row class="contentShow" :gutter="30">
      <el-col :span="3"><div class="blankDiv"></div></el-col>
      <el-col :span="3">
        <div class="divide">
          <!--类别-->
          <div class="selector" :class='{selectActive:isActive===i.url}' v-for="i of selectors" :key="i.title" @click="selected(i)">
            {{i.title}}
          </div>
          <el-divider content-position="left" style="background: inherit">已关注标签</el-divider>
          <!--已关注标签-->
          <div class="selector" :class='{selectActive:isActive===i.url}' v-for="i of lables" :key="i.title" @click="selected(i)">
            {{i.title}}
          </div>
        </div>
      </el-col>

      <!--列表-->
      <el-col :span="11">
        <div class="divide" >

          <!--置顶显示-->
          <div class="topShow">
            <el-carousel trigger="click" height="250px">
              <el-carousel-item v-for="item in 4" :key="item">
                <h3 class="small">{{ item }}</h3>
              </el-carousel-item>
            </el-carousel>
          </div>

          <el-divider content-position="center" style="background: inherit">{{listName}}</el-divider>

          <div class="articleShow">
            <ul class="articleList">
              <li class="articleItem" v-for="item in articleList" :key="item.url">
                <div class="itemMain">
                  <div class="itemMeta">
                    <nuxt-link :to=item.authorUrl>
                      <Avatar class="itemAvatar" :src=item.avatar size="33"/>
                    </nuxt-link>
                    <nuxt-link :to="item.url">
                      <span class="itemTitle">{{item.title}}</span>
                    </nuxt-link>
                  </div>
                  <div class="itemContent">
                    {{item.content}}
                  </div>
                </div>
                <div class="itemExtra">
                  <nuxt-link :to=item.url>
                    <img class="itemImg" src="https://dev-file.iviewui.com/5wxHCQMUyrauMCGSVEYVxHR5JmvS7DpH/large" alt="">
                  </nuxt-link>
                </div>
                <div class="itemhHandle">
                  <ul class="ivu-list-item-action">
                    <li>
                      <Icon class="theHandle" type="ios-star-outline" size="17" @click="item.stared=true" v-if="!item.stared" />
                      <Icon class="theHandle" type="ios-star" size="17" color="orange" @click="item.stared=false" v-if="item.stared" />
                      <span @click="item.stared=true"> 123</span>
                    </li>
                    <li>
                      <Icon class="theHandle" type="ios-thumbs-up-outline" size="17" @click="item.approval=true" v-if="!item.approval" />
                      <Icon class="theHandle" type="ios-thumbs-up" size="17" color="orange" @click="item.approval=false" v-if="item.approval" />
                      <span @click="item.approval=true"> 234</span>
                    </li>
                    <li>
                      <Icon class="theHandle" type="ios-chatbubbles-outline" size="17" /> 345
                    </li>
                  </ul>
                </div>
              </li>
            </ul>
          </div>

          <div class="getMore">
            <span class="getMoreItem" @click="getMore">加载更多……</span>
          </div>
        </div>
      </el-col>
      <el-col :span="4">
        <div class="divide" style="padding-bottom: 30px">
          <div class="curHot">
            <div style="color: #7f828b;font-size:17px;font-family: 微软雅黑;font-weight:bold;line-height: 52px">
              当前热议：
              <a href="" style="color: cornflowerblue;float: right;margin-right:10px;line-height: 52px;font-size: 13px;">更多></a>
            </div>
            <a :href="i.id" v-for="i of hotItems" :key="i.id" :title="i.describe">{{i.describe.substring(0,11)+'...'}}<br></a>
          </div>
          <div class="actives" style="margin-top: 10px">
            <div style="color: #7f828b;font-size:17px;font-family: 微软雅黑;font-weight:bold;line-height: 52px">
              活动推荐：
              <a href="" style="color: cornflowerblue;float: right;margin-right:10px;line-height: 52px;font-size: 13px;">更多></a>
            </div>
            <div class="activeItem" style="border-bottom: lightgray 1px dashed;padding: 5px 5px;display: flex;flex-wrap: wrap">
              <!--时间展示-->
              <div class="activeDate" style="position:relative;;width: 34px;height: 34px;border-radius:17px;background:#d0e8f2">
                <div style="width:100%;height:47%;border-top-right-radius: 17px;
    border-top-left-radius: 17px;border-bottom: #f7f8fb 1px solid;position: absolute;top: 0;background: #79a3b1">
                  <span style="color: #f7f8fb;font-size: 8px;position: absolute;top: -1px;left: 7px;">Jan</span>
                </div>
                <span style="color: #47494e;font-size: 16px;position: absolute;bottom: -4px;left: 7px;">12</span>
              </div>
              <div class="activeTitle" style="width: 80%;margin-left: 7px">
                <nuxt-link to="/">分子材料解析大讲堂|大学生活动中心</nuxt-link>
              </div>
              <div class="activeClass" style="position: relative">
                <span style="font-size: 10px;color: #7f828b">讲座 · 2021-01-12 | 周二</span>
                <span style="font-size: 10px;color: orange;margin-left: 30px">进行中</span>
              </div>
            </div>
          </div>
          <!--悬浮广告-->
          <div class="floatAdv" style="width: 223px" v-if="floatAdvShow" @mouseover="closeHandleShow=true" @mouseleave="closeHandleShow=false">
            <a href="/">
              <img src="" alt="" style="width: 100%;height:170px;background: #47494e">
            </a>
            <div class="closeAdv" v-if="closeHandleShow" @click="floatAdvShow=false">×</div>
          </div>
        </div>
      </el-col>
      <el-col :span="3"><div class="blankDiv"></div></el-col>
    </el-row>
  </div>
</template>

<script>
  import BackTop from "../../components/BackTop";
  export default {
    components: {BackTop},
    data(){
      return{
        selectors:[
          {title:'为你推荐',url:'getRecommend'},
          {title:'最新内容',url:'getNew'}
        ],
        lables:[
          {title:'学术交流',url:'getComment'},
          {title:'问题求助',url:'getHelp'},
          {title:'更多标签……',url:'getMoreLables'}
        ],
        isActive:'getRecommend',
        topAdvShow:true,
        floatAdvShow:true,
        closeHandleShow:false,

        advHandleText:'-隐藏',
        listName:'为你推荐',
        articleList: [
          {
            authorUrl:'/1',
            url:'/123',
            title: 'This is title 1',
            avatar: 'https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar',
            content: 'This is the content, this is the content, this is the content, this is the content.',
            stared:true,
            approval:false,
          },
          {
            authorUrl:'/1',
            url:'/234',
            title: 'This is title 2',
            avatar: 'https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar',
            content: 'This is the content, this is the content, this is the content, this is the content.',
            stared:true,
            approval:true,
          },
          {
            authorUrl:'/1',
            url:'/345',
            title: 'This is title 3',
            avatar: 'https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar',
            content: 'This is the content, this is the content, this is the content, this is the content.',
            stared:false,
            approval:true,
          },
          {
            authorUrl:'/1',
            url:'/456',
            title: 'This is title 4',
            avatar: 'https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar',
            content: 'This is the content, this is the content, this is the content, this is the content.',
            stared:false,
            approval:true,
          },
          {
            authorUrl:'/1',
            url:'/567',
            title: 'This is title 5',
            avatar: 'https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar',
            content: 'This is the content, this is the content, this is the content, this is the content.',
            stared:false,
            approval:false,
          },
          {
            authorUrl:'/1',
            url:'/678',
            title: 'This is title 6',
            avatar: 'https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar',
            content: 'This is the content, this is the content, this is the content, this is the content.',
            stared:false,
            approval:false,
          },
        ],
        hotItems:[{id:123,describe:'31省区市新增确诊52例 本土36例'},
          {id:234,describe:'春运机票火车票退改签须知来了'},
          {id:345,describe:'入主白宫近10日 拜登做了10件大事'}],
        num:10,
        contentHeight:0,
      }
    },
    created(){
    },
    mounted(){
      window.addEventListener('scroll',this.setClientHeight);
    },
    watch:{
    },
    methods:{
      setClientHeight(){
        let scrollHeight = document.documentElement.scrollTop; //滚动的高度
        if(scrollHeight>=740){
          if(document.querySelector(".floatAdv")){
            document.getElementsByClassName("floatAdv")[0].className="floatAdvFixed";
          }
        }
        else{
          if(document.querySelector(".floatAdvFixed"))
          document.getElementsByClassName("floatAdvFixed")[0].className="floatAdv";
        }
      },
      selected(item){
        this.isActive=item.url;
        this.listName=item.title;
      },
      advShowHandle(){
        this.topAdvShow=(this.topAdvShow===false);
        this.advHandleText=this.advHandleText==='-隐藏'?'-显示':'-隐藏';
      },
      getMore () {
        for(let i=0;i<5;i++){
          this.num++;
          this.articleList.push({
            authorUrl:'/1',
            url:'/'+this.num,
            title: 'This is title '+(this.num),
            description: 'This is description, this is description, this is description.',
            avatar: 'https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar',
            content: 'This is the content, this is the content, this is the content, this is the content.',
            stared:false,
            approval:false,
          })
        }
        this.setClientHeight();
      },
    },

  }
</script>

<style lang="less">
  .loginTip{
    background-image: url("/images/topPic.jpg");
    background-size: cover;
    position: relative;
    width: 100%;
    height: 200px;
    display: flex;

    .showTitle{
      position: absolute;
      left: 200px;
      top: 50px;
      color: #f7f8fb;
      font-family: 幼圆;
      letter-spacing: 5px;
      font-size: 40px;
    }
    .showText{
      position: absolute;
      left: 100px;
      top: 110px;
      color: #f7f8fb;
    }
    .logButtons{
      height: auto;
      position: absolute;
      right: 200px;
      top: 80px;
      .logBtn{
        background-color: #5669ba;
        color: #f7f8fb;
        height: 38px
      }
      .logBtn:hover{
        background-color: #726a95;
      }
    }
  }

  .selector{
    text-align: center;
    line-height: 35px;
    width: 100%;
    height: 35px;
    border-radius: 5px;
    background: inherit;
    margin-bottom: 2px;
  }
  .selector:hover{
    cursor: pointer;
    filter: brightness(0.9);
  }
  .selectActive{
    background: #a3d2ca;
    color: #f7f8fb;
  }

  .advShow{
    width: 73%;
    margin:20px auto 0;
    position: relative;
  }
  .el-carousel__item h3 {
    text-align: center;
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
  .advHandle{
    z-index: 4;
    position: absolute;
    margin-top: 8px;
    right: 210px;
    color: #726a95;
    font-family: 微软雅黑;
    letter-spacing: 3px;
  }
  .advHandle:hover{
    cursor: pointer;
  }


  .contentShow{
    margin-top: 30px;
    width: 100%;
    position: relative;
    left: 15px;
    .divide{
      position: relative;
      width: 100%;
      background: white;
      //#f7f8fb
    }
    .blankDiv{
      height: 500px;
      background: inherit;
    }
  }

  .getMore{
    text-align: center;
    height: 40px;
    .getMoreItem{
      line-height: 40px;
      color: #726a95;
      font-weight: bold;
    }
    .getMoreItem:hover{
      cursor: pointer;
    }
  }

  .curHot{
     a{
      color: #47494e;
      display: inline-block;
      padding-left: 15px;
      line-height: 24px;
    }
    a:hover{
      color: orange;
    }
  }
  .floatAdv{
    position:relative;
    margin-top: 30px;
    .closeAdv{
      width:25px;
      position: absolute;
      top: 0;
      right: 0;
      background: #f7f8fb;
      text-align: center;
      font-size: 18px
    }
    .closeAdv:hover{
      filter: brightness(0.9);
      cursor: pointer;
    }
  }
  .floatAdvFixed{
    width: 100%;
    position: fixed;
    top: 80px;
    z-index: 999;
    .closeAdv{
      width:25px;
      position: absolute;
      top: 0;
      right: 0;
      background: #f7f8fb;
      text-align: center;
      font-size: 18px
    }
    .closeAdv:hover{
      filter: brightness(0.9);
      cursor: pointer;
    }
  }
  .articleShow{
    width: 100%;
    list-style: none;
    .articleList{
      list-style: none;
      font-size: 16px;
      line-height: 25px;
      a{
        color: #47494e;
      }
      a:hover{
        color: orange;
      }
      .articleItem{
        border-bottom: 1px solid #e8eaec;
        padding: 12px 10px;
        display: flex;
        flex-wrap: wrap;
        .itemMain{
          width: 70%;
          .itemMeta{
            .itemAvatar:hover{
              filter: brightness(0.9);
            }
            .itemTitle{
              margin-left: 10px;
            }
          }
          .itemContent{
            padding:10px 0 10px 20px;
          }
        }
        .itemExtra{
          width: 25%;
          margin:15px 0 0 10px;
          .itemImg{
            width: 100%;
          }
        }
        .itemhHandle{
          .ivu-list-item-action{
            margin-left: 0;
            li:first-child {
              padding-left: 0;
            }
            li {
              padding: 0 16px;
            }
          }
        }
      }
      .articleItem:last-child{
        border: none;
      }
    }

  }

</style>
