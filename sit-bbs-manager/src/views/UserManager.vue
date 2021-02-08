<template>
  <div>
    <Card style="text-align: left">
      <p slot="title" style="text-align: left">查询</p>
      昵称：<Input class="searchInput" v-model="value1" placeholder="Enter something..." clearable />
      账号：<Input class="searchInput" v-model="value2" placeholder="Enter something..." clearable />
      学院：<Input class="searchInput" v-model="value3" placeholder="Enter something..." clearable />
      <br><br>
      专业：<Input class="searchInput" v-model="value3" placeholder="Enter something..." clearable />
      楼号：<Input class="searchInput" v-model="value3" placeholder="Enter something..." clearable />
      注册时间：<DatePicker type="date" v-model="value4" placeholder="Select date" style="width: 175px; margin-right: 50px"></DatePicker>
      <br><br>
      性别：<Select class="searchInput" v-model="gender" style="width:200px">
        <Option v-for="item in genders" :value="item.value" :key="item.value">{{ item.label }}</Option>
      </Select>
      <Button class="theButton" type="primary" icon="ios-search">查询</Button>
      <Button class="theButton" icon="md-close">清空</Button>
    </Card>
    <Card id="userTable">
      <Table :columns="columns" :data="tableData" ref="table">
        <template slot-scope="{row,index}" slot="action">
          <el-button type="text" @click="infoModal=true">详情</el-button>
          <el-button type="text">{{row.status===3?disableButtonText[1]:disableButtonText[0]}}</el-button>
        </template>
      </Table>
      <div style="margin-left: 50px;display: flex">
        <Button id="exportButton" type="primary" size="large" @click="exportData"><Icon type="ios-download-outline"></Icon>导出排序整理后的数据</Button>
        <Page :total="100" :current="1" style="margin-left: 100px;margin-top: 25px" @on-change="changePage"></Page>
      </div>
    </Card>
    <Modal
      v-model="infoModal"
      title="详情"
      @on-ok="ok"
      @on-cancel="cancel"
      style="text-align: left;"
      width="500">
      <img src="/static/images/avatar.jpg" alt="" style="width: 100px;height:100px;margin-left: 170px">
      <div style="margin-left: 150px;line-height: 30px">
        <Row>昵称：<span>大背头BB机</span></Row>
        <Row>账号：<span>123456</span></Row>
        <Row>性别：<span>123456</span></Row>
        <Row>学院：<span>123456</span></Row>
        <Row>专业：<span>123456</span></Row>
        <Row>电话：<span>123456</span></Row>
        <Row>密码：<span>123456789</span><el-button type="text" style="margin-left: 20px;padding-top:0" @click="pwdModal=true">修改密码</el-button></Row>
        <Row>权限：<span>普通用户</span><el-button type="text" style="margin-left: 20px;padding-top:0" @click="pwdModal=true">修改权限</el-button></Row>
      </div>
    </Modal>
    <Modal
      v-model="pwdModal"
      title="修改密码"
      @on-ok="ok"
      @on-cancel="cancel"
      class-name="pwdModal"
      width="300"
      :styles="{top: '35%'}">
      <Input v-model="pwdValue" placeholder="Enter something..." style="width: 260px" />
    </Modal>
  </div>
</template>

<script>
    export default {
        name: "UserManager",
      data(){
        return{
          value1: '',
          value2: '',
          value3: '',
          value4: '',
          pwdValue: '',
          disableButtonText: ['禁用','启用'],
          infoModal: false,
          pwdModal: false,
          genders: [
            {
              label: '男',
              value: 'male'
            },{
              label: '女',
              value: 'female'
            }
          ],
          columns: [
            {
              "title": "id",
              "key": "id",
              "width": 80
            },
            {
              "title": "昵称",
              "key": "nickName",
              "width": 150
            },
            {
              "title": "账号",
              "key": "userName",
              "width": 150
            },
            {
              "title": "学院",
              "key": "college",
              "width": 150
            },
            {
              "title": "楼号",
              "key": "buildingNO",
              "width": 100,
              "sortable": true,
              filters: [
                {
                  label: '高层',
                  value: 1
                },
                {
                  label: '低层',
                  value: 2
                }
              ],
              filterMultiple: false,
              filterMethod (value, row) {
                if (value === 1) {
                  return row.buildingNO > 7;
                } else if (value === 2) {
                  return row.buildingNO <= 7;
                }
              }
            },
            {
              "title": "状态",
              "key": "status",
              "width": 130,
              render: (h, params) => {
                const row = params.row;
                const color = row.status === 1 ? 'primary' : row.status === 2 ? 'success' : 'error';
                const text = row.status === 1 ? '可用' : row.status === 2 ? '登录中' : '禁用';

                return h('Tag', {
                  props: {
                    type: 'dot',
                    color: color
                  }
                }, text);
              }
            },
            {
              title: "可用操作",
              slot: "action",
              width: 150,
              align: "center"
            }
          ],
          tableData: [
            {
              id: 1,
              nickName: '追风烧面',
              userName: '997011759',
              status: 1,
              gender: '男',
              college: '经济管理',
              major: '信息管理',
              buildingNO: 5,
              tel: 15199998858,
              passWord: 12345678965
            },{
              id: 10,
              nickName: '天蚕少女',
              userName: '451289376',
              status: 2,
              gender: '女',
              college: '计算机',
              major: '计算机',
              buildingNO: 5,
              tel: 18156496653,
              passWord: 12345678965
            },{
              id: 101,
              nickName: '赤脚大仙',
              userName: '451289376',
              status: 3,
              gender: '女',
              college: '计算机',
              major: '计算机',
              buildingNO: 5,
              tel: 18156496653,
              passWord: 12345678965
            },{
              id: 1012,
              nickName: '无敌于天下的大神棍',
              userName: '451289376',
              status: 1,
              gender: '男',
              college: '计算机',
              major: '计算机',
              buildingNO: 5,
              tel: 18156496653,
              passWord: 12345678965
            },
          ]
        }
      },
      methods:{
        exportData(){
          this.$refs.table.exportCsv({
            filename: 'Sorting and filtering data',
            original: false
          });
        }
      }
    }
</script>

<style scoped>
  .searchInput{
    width: 200px;margin-right: 50px;
  }
  .theButton{
    margin-right: 50px;
  }
  #userTable{
    margin-top: 20px;
    margin-bottom: 50px;
  }
  #exportButton{
    margin-top: 20px;
  }
</style>
