<template>
  <div class="breadCrumb">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item to="/home">首页</el-breadcrumb-item>
      <el-breadcrumb-item v-if="item.meta.title!==undefined" v-for="(item,index) in routerData" :key="index" :to="item.path">{{item.meta.title}}</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
    export default {
        name: "BreadCrumb",
      data(){
        return{
          routerData:[],
        }
      },
      created(){
      },
      mounted(){
        // this.routerData=this.$route.matched;
      },
    }
</script>

<style scoped>
  .breadCrumb{
    margin: 0 170px 20px;
  }
</style>
