<template>
  <div class="footer">
    <div class="footerLinks lightGray">
      <dl style="width: 80px">
        <dt class="footerTitle">产品</dt>
        <dd class="footerLink" v-for="i of productLink" :key="i.url">
          <nuxt-link :to=i.url>{{i.text}}</nuxt-link>
        </dd>
      </dl>

      <dl style="width: 80px">
        <dt class="footerTitle">资源</dt>
        <dd class="footerLink" v-for="i of resourceLink" :key="i.url">
          <nuxt-link :to=i.url>{{i.text}}</nuxt-link>
        </dd>
      </dl>

      <dl style="width: 80px">
        <dt class="footerTitle">合作</dt>
        <dd class="footerLink" v-for="i of partnerLink" :key="i.url">
          <nuxt-link :to=i.url>{{i.text}}</nuxt-link>
        </dd>
      </dl>

      <dl style="width: 80px">
        <dt class="footerTitle">产品</dt>
        <dd class="footerLink" v-for="i of noticeLink" :key="i.url">
          <nuxt-link :to=i.url>{{i.text}}</nuxt-link>
        </dd>
      </dl>

      <dl style="width: 80px">
        <dt class="footerTitle">条款</dt>
        <dd class="footerLink" v-for="i of clauseLink" :key="i.url">
          <nuxt-link :to=i.url>{{i.text}}</nuxt-link>
        </dd>
      </dl>
    </div>
    <div class="copyrightBackground lightGray">
      <div class="copyright">
        <p>
          Copyright © 2011-2021 SegmentFault. 当前呈现版本 19.02.27
        </p>
        <p>
          浙ICP备15005796号-2   浙公网安备33010602002000号 杭州堆栈科技有限公司版权所有
        </p>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "Footer",
      data(){
          return{
            productLink:[
              {text:'热门推荐',url:'/hot'},
              {text:'分类浏览',url:'/class'},
              {text:'动态查看',url:'/activeShow'},
              {text:'文件漫游',url:'/fileShow'},
            ],
            resourceLink:[
              {text:'每周精选',url:'/weekShow'},
              {text:'用户排行榜',url:'/userRank'},
              {text:'帮助中心',url:'/helpCenter'},
              {text:'社区服务中心',url:'/communityService'}
            ],
            partnerLink:[
              {text:'关于我们',url:'/aboutUs'},
              {text:'联系我们',url:'/contactUs'},
              {text:'合作伙伴',url:'/partners'}
            ],
            noticeLink:[
              {text:'微博',url:'/toWeibo'},
              {text:'公众号',url:'/toWeixin'}
            ],
            clauseLink:[
              {text:'服务条款',url:'/serviceClause'},
              {text:'隐私政策',url:'/privacyPolicies'}
            ]
          }
      }
    }
</script>

<style scoped lang="less">

  .footer{
    position: relative;
    margin-top: 60px;
  }

  .footerLinks{
    width: 100%;
    height: 200px;
    border-top: lightgray 1px solid;
    /*margin-top: 120px;*/
    padding: 30px 150px;
    display: flex;
    justify-content: space-around;
    .footerTitle{
      font-size: 17px;
      font-weight: bold;
      margin-bottom: 20px;
    }
    .footerLink{
      margin: 10px 0;
      font-size: 13px;
      a{
        color: #7f828b;
      }
      a:hover{
        text-decoration: underline;
      }
    }
  }
  .lightGray{
    background: #d3e0ea;
  }
  .copyrightBackground{
    padding: 20px;
    width: 100%;
    height: 170px;
    .copyright{
      width: 70%;
      height: 100px;
      background: #f7f8fb;
      margin: auto;
      padding-top: 10px;
      text-align: center;
      color: #7f828b;
    }
  }

</style>
