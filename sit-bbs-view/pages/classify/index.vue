<template>
  <div class="classifyBody">
    <!--锚点显示栏-->
    <div class="anchorBar">
      <Anchor show-ink :offset-top="80" :scroll-offset="70">
        <AnchorLink style="margin-top: 20px" v-for="(item,index) of classes" :key="index" :href="'#'+item.simpleName" :title="item.title" />
      </Anchor>
    </div>
    <!--锚点显示栏-->

    <div class="classify">
      <div class="classifyContent" v-for="(classify,index) of classes" :key="index">
        <div class="classTitle" :id="classify.simpleName">
          <Icon type="md-menu" size="27"/>
          {{classify.title}}
          <!--<a :id="classify.simpleName" href="/"></a>-->
        </div>
        <div class="classItem">
          <nuxt-link :to="{path:'/classify/articleList',query:{classId:item.classId,title:item.link}}" v-for="(item,i) of classify.links" :key="i">
            <div class="classLink">
              <div class="linkText">
                【{{item.link}}】
              </div>
              <div class="linkDescribe">
                {{item.describe}}
              </div>
            </div>
          </nuxt-link>

        </div>
      </div>
    </div>


  </div>
</template>

<script>
  export default {
    middleware:'metaTitle',
    meta:{title:'分类浏览'},
    data(){
      return{
        classes:[
          {
            simpleName:'xyxw',
            title:'校园新闻',
            links:[
              {link:'官方新闻',describe:'想掌握校园官方一手消息吗，那就来吧',classId:'1-1'},
              {link:'民间传说',describe:'想掌握民间小道消息吗，嘘，快来吧',classId:'1-2'},
              {link:'官方新闻',describe:'想掌握校园官方一手消息吗，那就来吧',classId:'1-3'},
              {link:'民间传说',describe:'想掌握民间小道消息吗，嘘，快来吧',classId:'1-4'},
              {link:'官方新闻',describe:'想掌握校园官方一手消息吗，那就来吧',classId:'1-5'},
              {link:'民间传说',describe:'想掌握民间小道消息吗，嘘，快来吧',classId:'1-6'},
            ]
          },
          {
            simpleName:'wtqz',
            title:'问题求助',
            links:[
              {link:'官方新闻',describe:'想掌握校园官方一手消息吗，那就来吧',url:'/1234'},
              {link:'民间传说',describe:'想掌握民间小道消息吗，嘘，快来吧',url:'/1234'}
            ]
          },
          {
            simpleName:'xsjl',
            title:'学术交流',
            links:[
              {link:'官方新闻',describe:'想掌握校园官方一手消息吗，那就来吧',url:'/1234'},
              {link:'民间传说',describe:'想掌握民间小道消息吗，嘘，快来吧',url:'/1234'}
            ]
          }
        ]
      }
    },
    watch:{
    },
    mounted(){
      console.log(this.$route);
    }
  }
</script>

<style lang="less">

  .classifyBody{
    width: 100%;
    padding-top: 20px;
    padding-bottom: 40px;

    .anchorBar{
      z-index: 999;
      position: fixed;
      padding: 20px;
      top: 120px;
      left: 70px;
      width: 200px;
      border-right: #7f828b 10px solid;
      /*height: 300px;*/
      background: #f7f8fb;
      font-size: 16px;
      font-weight: bold;
    }

    .classify{
      width: 70%;
      height: 100%;
      border-left: #7f828b 10px solid;
      padding-bottom: 150px;
      background: #f7f8fb;
      margin-left: 300px;
      display: flex;
      flex-direction: column;
      /*板块*/
      .classifyContent{
        margin-top: 60px;
        margin-left: 20px;
        padding-right: 30px;
        .classTitle{
          font-size: 24px;
          font-weight: bold;
          border-bottom: lightgray 2px solid;
        }
        /*链接父容器-调整链接排列*/
        .classItem{
          margin-top: 30px;
          display: flex;
          justify-content: left;
          flex-wrap: wrap;
          .classLink{
            margin-left:20px;
            margin-top: 20px;
            width: 300px;
            height: 90px;
            border-radius: 5px;
            padding: 8px;
            background: #fff;
            border: lightgray 1px solid;
            cursor: pointer;
            .linkText{
              font-size: 22px;
              color: cornflowerblue;
              font-weight: bold;
            }
            .linkDescribe{
              padding: 5px;
              font-size: 13px;
              color: #7f828b;
            }
          }
          .classLink:hover{
            filter:brightness(0.97);
          }
        }
      }
    }
  }
</style>
