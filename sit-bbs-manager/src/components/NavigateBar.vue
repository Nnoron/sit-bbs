<template>
  <div class="navigateBar">
    <!--顶部内容-->
    <el-row>
      <!--顶部导航栏-->
      <Affix>
        <Menu mode="horizontal" :theme="theme">
          <div id="logo">logo</div>
          <div :id="theme=='dark'||theme=='primary'?'darkTheme':'others'" style="float: right;margin-right: 100px;display: flex">
            可选主题：
            <RadioGroup v-model="theme">
              <Radio label="light"></Radio>
              <Radio label="dark"></Radio>
              <Radio label="primary"></Radio>
            </RadioGroup>
          </div>
          <div style="height:50px;float: right;margin-right: 50px;display: flex;margin-top: 5px">
            <img src="/static/images/avatar.jpg" alt="" style="width: 50px;height: 50px;border-radius: 25px;">
            <Submenu style="padding-left: 7px;">
              <template slot="title">
                大背头BB机
              </template>
              <MenuItem to="/MyInfo">我的信息</MenuItem>
              <MenuItem>退出登录</MenuItem>
            </Submenu>
          </div>
        </Menu>
      </Affix>

    </el-row>
    <!--顶部内容-->
    <!--下行内容-->
    <el-row>
      <!--左侧导航栏-->
      <el-col :span="4">
        <Affix offset-top="60">
          <Menu :theme="theme" :active-name="activeMenuName" style="margin-top: 1px; height: 660px">
            <MenuGroup title="内容管理">
              <MenuItem name="ArticleManager" to="/ArticleManager">
                <Icon type="md-document" />
                帖子管理
              </MenuItem>
              <MenuItem name="CommentManager"  to="/CommentManager">
                <Icon type="md-chatbubbles"/>
                评论管理
              </MenuItem>
              <MenuItem name="FileManager" to="/FileManager">
                <Icon type="md-folder" />
                文件管理
              </MenuItem>
              <MenuItem name="1">
                <Icon type="md-mail" />
                <Badge :count="3">举报管理</Badge>
              </MenuItem>
            </MenuGroup>
            <MenuGroup title="用户管理">
              <MenuItem name="UserManager" to="/UserManager">
                <Icon type="md-people" />
                用户管理
              </MenuItem>
              <MenuItem name="Statistics" to="/Statistics">
                <Icon type="ios-people" />
                用户统计
              </MenuItem>
            </MenuGroup>
            <MenuGroup title="系统管理">
              <MenuItem name="6">
                <Icon type="md-person" />
                角色管理
              </MenuItem>
              <MenuItem name="7">
                <Icon type="md-grid" />
                字典管理
              </MenuItem>
              <MenuItem name="8">
                <Icon type="md-menu" />
                版块管理
              </MenuItem>
              <MenuItem name="9">
                <Icon type="ios-paper" />
                日志管理
              </MenuItem>
            </MenuGroup>
          </Menu>
        </Affix>
      </el-col>
      <el-col :span="2" style="margin-top: 20px;height: 500px">
        <div style="width: 100px;margin-left: 20px;font-size: 15px">
          <Icon type="ios-arrow-forward" /><span>帖子管理</span>
        </div>
      </el-col>
      <!--路由内容-->
      <el-col :span="15" style="margin-top: 50px; height: 100%">
        <keep-alive>
          <router-view/>
        </keep-alive>
      </el-col>
    </el-row>
    <!--路由内容-->
    <!--下行内容-->
  </div>
</template>
<script>
  export default {
    name:'NavigateBar',
    data () {
      return {
        theme: 'primary',
        activeMenuName: this.$route.name.name
      }
    }
  }
</script>

<style scoped>
  #logo{
    width: 100px;height: 50px;
    background-color: cadetblue;color:white;
    float: left;margin-left: 80px;margin-top: 4px;text-align: center;
  }
  #darkTheme{
    color: aliceblue;
  }
  #darkTheme1{
    color: aliceblue;
  }
  .navigateBar{
    padding:0;
    margin: 0;
  }
  .el-dropdown-link{
    cursor: pointer;
  }

</style>
