<template>
  <Card :bordered="false" style="height: 500px;width: 100%;">
    <p slot="title" style="text-align: left">我的信息</p>
    <div>
      <div style="width: 200px;margin-left: 100px;margin-top: 50px">
        <el-image
          style="width: 180px; height: 180px; border-radius: 90px"
          :src="url"
          :fit="fit"></el-image>
        <el-button type="text" @click="selectIcon">修改头像</el-button>
      </div>
      <div id="myInfo">
        <span style="font-size: 20px;font-family: 仿宋">基本信息</span><br>
        <span class="label">昵称：</span><span>大背头BB机</span><br>
        <span class="label">账号：</span><span>123456</span><br>
        <span class="label">手机：</span><span>151****5978</span><br>
        <span class="label">权限：</span><span>管理员</span><br>
        <el-button type="text" @click="selectIcon">修改资料</el-button>
      </div>
    </div>

  </Card>
</template>

<script>
    export default {
        name: "MyInfo",
      data(){
          return{
            url: '/static/images/avatar.jpg'
          }
      }
    }
</script>

<style scoped>
  #myInfo{
    width: 300px;
    position: relative;top: -214px;left: 454px;
    font-family: 微软雅黑;line-height: 35px;text-align: left;
  }
  .label{
    font-family: 仿宋;
    font-size: 16px;
  }
</style>
