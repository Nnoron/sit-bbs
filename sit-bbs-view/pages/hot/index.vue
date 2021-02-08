<template>
  <div class="hotBody">
    <div class="hotAdv">
      <span class="hotAdvMessage">新春快乐！</span>
      <img class="hotAdvImg" :src="hotAdvImg" alt="">
    </div>

    <div class="hotRanks">
      <div class="searchRank">
        <div style="width: 100%;height: 200px;margin-bottom: 10px">
          <img src="/" alt="" style="width: 100%;height: 100%;background: #7f828b">
        </div>
        <label>>>搜索热度排行榜</label><span style="font-size: 13px;color: orange">（每三分钟更新一次）</span>
        <div class="rankItems">
          <ul>
            <li v-for="i of searchList" :key="i.url">
              <nuxt-link :to="i.url" :title="i.text">
                {{i.text.length>13?i.text.substring(0,13)+'...':i.text}}
              </nuxt-link>
              <div class="degreeExtra">
                <span class="extraText">{{i.degree}}人次</span>
                <Icon type="md-arrow-up" color="red" />
              </div>
            </li>
          </ul>
        </div>
      </div>
      <div class="articleRank">
        <label>>>文章热度排行榜</label><span style="font-size: 13px;color: orange">（每十分钟更新一次）</span>
        <div class="rankItems">
          <ul>
            <li v-for="i of articleList" :key="i.url">
              <div style="display: flex;flex-direction: column;">
                <nuxt-link :to="i.url" :title="i.text">
                  {{i.text.length>13?i.text.substring(0,13)+'...':i.text}}
                </nuxt-link>
                <span class="extraText" v-if="i.author">{{i.author}}</span>
              </div>
              <nuxt-link class="extraImg" v-if="i.img" :to=i.url>
                <img :src=i.img alt="">
              </nuxt-link>
              <div class="degreeExtra" v-if="!i.author">
                <span class="extraText">{{i.degree}}人次</span>
                <Icon type="md-arrow-up" color="red" />
              </div>
            </li>
          </ul>
        </div>
      </div>
      <div class="labelRank">
        <div style="width: 100%;height: 200px;margin-bottom: 10px">
          <img src="/" alt="" style="width: 100%;height: 100%;background: #7f828b">
        </div>
        <label>>>标签热度排行榜</label><span style="font-size: 13px;color: orange">（每小时更新一次）</span>
        <div class="rankItems">
          <ul>
            <li v-for="i of labelList" :key="i.url">
              <nuxt-link :to="i.url" :title="i.text">
                {{i.text}}
              </nuxt-link>
              <div class="degreeExtra">
                <span class="extraText">{{i.degree}}人次</span>
                <Icon type="md-arrow-up" color="red" />
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
      name: "index",
      data(){
          return{
            hotAdvImg:'/images/hotAdv.png',
            searchList:[
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
            ],
            articleList:[
              {text:'刘昊然到场迎新仪式',url:'/123',author:'我是作者嘻嘻',img:'123'},
              {text:'黄晓明去食堂吃了肥肠面并说很好吃',url:'/234',author:'我是作者嘻嘻',img:'123'},
              {text:'刘昊然到场迎新仪式',url:'/123',author:'我是作者嘻嘻',img:'123'},
              {text:'黄晓明去食堂吃了肥肠面并说很好吃',url:'/234',degree:'2321'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'1421'},
              {text:'黄晓明去食堂吃了肥肠面并说很好吃',url:'/234',degree:'1234'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
            ],
            labelList:[
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
              {text:'刘昊然到场迎新仪式',url:'/123',degree:'13245'},
              {text:'黄晓明去食堂吃了肥肠面',url:'/234',degree:'13245'},
            ],
          }
      },
      created(){
      },
      methods:{
      }
    }
</script>

<style scoped lang="less">

  .hotBody{
    background: #f7f8fb;
    padding-bottom: 30px;
  }

  .hotAdv{
    width: 100%;
    height: 150px;
    position: relative;
    margin: 0;
    padding: 0;
    .hotAdvImg{
      width: 100%;
      position: absolute;
      left: 0;
      top: 0;
      height: 100%;
    }
    .hotAdvMessage{
      z-index: 1;
      position: relative;
      top: 40px;
      left: 500px;
      letter-spacing: 8px;
      font-size: 50px;
      font-weight: bold;
      font-family: 微软雅黑;
      color: #f7f8fb;
    }
  }
  .hotRanks{
    width: 90%;
    margin: 50px auto;
    display: flex;
    justify-content: space-around;
    label{
      font-weight: bold;
      letter-spacing: 2px;
    }
    .rankItems{
      padding: 10px 10px;
      width: 100%;
      /*height: 92%;*/
      margin-top: 15px;
      /*border: darkgray 1px solid;*/
      background: white;
      box-shadow: 0 0 25px rgba(0,0,0,0.1);
      border-radius: 3px;
      a{
        color: #47494e;
        font-family: 微软雅黑;
        margin-left: 8px;
      }
      a:hover{
        color: orange;
      }
      ul{
        width: 100%;
        counter-reset: section;
        list-style: none;
      }
      li{
        display: flex;
        height: 30px;
        line-height: 30px;
      }
      li:before{
        counter-increment: section;
        content: counter(section);
        display: inline-block;
        height: 20px;
        line-height: 20px;
        margin-top: 5px;
        /*font-size: 16px;*/
        font-weight: bold;
        color: #f7f8fb;
        background: #b8c2cc;
        padding: 0 12px;
        border-radius: 3px;
      }
      .degreeExtra{
        width: 95px;
        margin: 0 5px 0 0;
        text-align: left;
      }
      .extraText{
        margin-left: 10px;
        color: orange;
        font-size: 13px;
        line-height: 20px;
      }
      .extraImg{
        margin-left: 15px;
        width: 80px;
        height: 60px;
        img{
          width: 100%;
          height: 100%;
        }
        img:hover{
          filter:brightness(0.8);
        }
      }
    }
    .searchRank{
      width: 26%;
      /*margin-top: 200px;*/
      li:nth-child(1):before{
        background: #ee9595;
      }
      li:nth-child(2):before{
        background: #ee9595;
      }
      li:nth-child(3):before{
        background: #ee9595;
      }
    }
    .articleRank{
      width: 26%;
      li:nth-child(1){
        height: 70px;
      }
      li:nth-child(2){
        height: 70px;
      }
      li:nth-child(3){
        height: 70px;
      }
      li:nth-child(1):before{
        background: #ef4f4f;
      }
      li:nth-child(2):before{
        background: #ef4f4f;
      }
      li:nth-child(3):before{
        background: #ef4f4f;
      }
    }
    .labelRank{
      width: 26%;
      /*margin-top: 200px;*/
      li:nth-child(1):before{
        background: #74c7b8;
      }
      li:nth-child(2):before{
        background: #74c7b8;
      }
      li:nth-child(3):before{
        background: #74c7b8;
      }
    }
  }
</style>
