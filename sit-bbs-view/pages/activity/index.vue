<template>
    <div class="activityBody">
      <div class="px-container">
        <ul class="px-waterfall" v-for="(el,i) in newWaterfallData" :key="i">
          <li v-for="(item,index) in el" :key="index">
            <Card class="activitiesCard" style="width:320px;margin:0;padding-bottom: 5px">
              <div class="titleDiv" slot="title">
                <nuxt-link :to=item.url>
                  <img class="headIcon" :src="item.headIcon" alt="头像">
                </nuxt-link>
                <nuxt-link class="userName" :to=item.url>{{item.userName}}</nuxt-link>
                <Icon class="activityLike" @click="item.like=true" v-if="!item.like" type="ios-heart-outline" size="30"/>
                <Icon class="activityLike" @click="item.like=false" v-if="item.like" color="#ff4646" type="ios-heart" size="30" />
              </div>
              <div style="display: flex;flex-wrap: wrap">
                <div>
                  <el-image
                    style="width: 80px;height:80px;margin: 7px;"
                    v-if="item.img.length>0"
                    v-for="imgUrl of item.img"
                    :key="imgUrl"
                    :src="imgUrl"
                    :preview-src-list="item.img">
                  </el-image>
                </div>
                <div style="padding: 5px 8px;">
                  <div style="line-height: 30px">
                    {{item.text}}
                  </div>
                  <div style="position: absolute;right: 10px;padding: 5px">
                    <span style="color: darkgray;font-size: 13px">Time · {{item.publishTime}}</span>
                  </div>
                </div>
              </div>
            </Card>
          </li>
        </ul>
      </div>
    </div>
</template>

<script>
    export default {
        name: "index",
      data(){
          return{
            activityList:[
              {
                id:'123',
                img:[
                  '/images/blankHeadIcon.jpg',
                  '/images/pic1.jpeg',
                  '/images/pic2.jpeg',
                  '/images/pic3.jpeg',
                  '/images/pic4.jpeg',
                ],
                text:'今天天气真好呀！',
                userName:'这个是用户名嘻嘻',
                url:'/123',
                headIcon:'/images/blankHeadIcon.jpg',
                publishTime:'2021-02-05 10:32:14',
                like:true
              },
              {
                id:'123',
                img:[
                  '/images/blankHeadIcon.jpg',
                  '/images/pic1.jpeg',
                  '/images/pic2.jpeg',
                  '/images/pic3.jpeg',
                  '/images/pic4.jpeg',
                ],
                text:'今天天气真好呀！',
                userName:'这个是用户名嘻嘻',
                url:'/123',
                headIcon:'/images/blankHeadIcon.jpg',
                publishTime:'2021-02-05 10:32:14',
                like:true
              },
              {
                id:'123',
                img:[
                  '/images/blankHeadIcon.jpg',
                  '/images/pic1.jpeg',
                  '/images/pic2.jpeg',
                  '/images/pic3.jpeg',
                  '/images/pic4.jpeg',
                  '/images/pic1.jpeg',
                  '/images/pic2.jpeg',
                  '/images/pic3.jpeg',
                  '/images/pic4.jpeg',
                ],
                text:'今天天气真好呀！',
                userName:'这个是用户名嘻嘻',
                url:'/123',
                headIcon:'/images/blankHeadIcon.jpg',
                publishTime:'2021-02-05 10:32:14',
                like:false
              },
              {
                id:'123',
                img:[
                  '/images/blankHeadIcon.jpg',
                  '/images/pic1.jpeg',
                  '/images/pic2.jpeg',
                  '/images/pic3.jpeg',
                  '/images/pic4.jpeg',
                  '/images/pic1.jpeg',
                  '/images/pic2.jpeg',
                  '/images/pic3.jpeg',
                  '/images/pic4.jpeg',
                ],
                text:'今天天气真好呀！',
                userName:'这个是用户名嘻嘻',
                url:'/123',
                headIcon:'/images/blankHeadIcon.jpg',
                publishTime:'2021-02-05 10:32:14',
                like:false
              },
              {
                id:'123',
                text:'今天天气真好呀！人家的心情都好起来了呢，嘻嘻~',
                userName:'这个是用户名嘻嘻',
                url:'/123',
                headIcon:'/images/blankHeadIcon.jpg',
                publishTime:'2021-02-05 10:32:14',
                like:false
              },
            ],
            newWaterfallData: '',
          }
      },
      created(){

          for(let i=0;i<10;i++){
            this.activityList.push({
              id:'123',
              img:[
                '/images/blankHeadIcon.jpg',
                '/images/pic1.jpeg',
                '/images/pic2.jpeg',
                '/images/pic3.jpeg',
                '/images/pic4.jpeg',
                '/images/pic1.jpeg',
                '/images/pic2.jpeg',
                '/images/pic3.jpeg',
                '/images/pic4.jpeg',
              ],
              text:'今天天气真好呀！',
              userName:'这个是用户名嘻嘻',
              url:'/123',
              headIcon:'/images/blankHeadIcon.jpg',
              publishTime:'2021-02-05 10:32:14',
              like:false
            });
          }

        let [ ...waterfallData ]  = this.activityList;
        let [ ...newWaterfallData ]= [[],[],[],[]];
        waterfallData.forEach((el,i) => {
          switch( i%4 ) {
            case 0 : newWaterfallData[0].push(el);
              break;
            case 1: newWaterfallData[1].push(el);
              break;
            case 2: newWaterfallData[2].push(el);
              break;
            case 3: newWaterfallData[3].push(el);
              break
          }
        });
        this.newWaterfallData = newWaterfallData;
        console.log(this.newWaterfallData);
      },
      mounted(){
        this.width=(document.body.clientWidth || document.documentElement.clientWidth)-20;
      },
      methods:{
      }
    }
</script>

<style lang="less">

  .activityBody{
    background: #94b5c0;

    padding: 30px;
    /*width: 100%;*/
    .activitiesCard{
      .titleDiv{
        display: flex;
        .headIcon{
          width: 40px;
          height: 40px;
          border-radius: 20px
        }
        .headIcon:hover{
          filter:brightness(0.9);
        }
        .userName{
          display: inline-block;
          width: 40%;
          height: 45px;
          line-height: 45px;
          color: #47494e;
          margin-left: 10px;
        }
        .userName:hover{
          color: orange;
        }
      }
      .ivu-card-head{ //card中title栏
        padding: 8px 10px;
        .activityLike{
          position: absolute;
          top:15px;
          right: 15px;
          cursor: pointer;
        }
      }
      img:hover{
        filter:brightness(1.1);
      }
    }

    .px-container {
      display: flex;
      justify-content: space-around;
      width: 100%;
      margin-top: 20px;
      margin-left: 20px;

    }
    .px-waterfall {
      position: relative;
      display: block;
      width: calc(300px);
      list-style: none;
      &:nth-child(2n) {
        margin: 0 60px;
      }
      li{
        width: 320px;
        background: lightgray;
        border-radius: 8px;
        margin-bottom: 20px;
      }
    }
  }
</style>
