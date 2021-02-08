<template>
  <div id="statisticsView">
    <Row>
      <Col class="colDiv" span="6">
        <div style="height: 100%;width: 200px;margin: 20px auto">
          <p class="statisticsTitle" style="text-align: left">今日访问人数：</p>
          <div class="statisticsDiv">
            <span class="statisticsSpan">2000</span>
          </div>
          <p class="statisticsTitle" style="text-align: left">当前在线人数：</p>
          <div class="statisticsDiv">
            <span class="statisticsSpan">2000</span>
          </div>
          <p class="statisticsTitle" style="text-align: left">手机在线人数：</p>
          <div class="statisticsDiv">
            <span class="statisticsSpan">2000</span>
          </div>
          <p class="statisticsTitle" style="text-align: left">今日注册人数：</p>
          <div class="statisticsDiv">
            <span class="statisticsSpan">2000</span>
          </div>
          <p class="statisticsTitle" style="text-align: left">总注册人数：</p>
          <div class="statisticsDiv">
            <span class="statisticsSpan">2000</span>
          </div>
        </div>
      </Col>
      <Col span="2" style="height: 500px"></Col>
      <Col class="colDiv" span="16">
        <Row style="height: 300px;border-bottom: solid #F7F7F7 10px;">
          <EChart :options="option1"></EChart>
        </Row>
        <Row style="height: 300px">
          <EChart :options="option2"></EChart>
        </Row>
      </Col>
    </Row>
  </div>
</template>

<script>
  import EChart from '@/components/ECharts'
    export default {
        name: "Statistics",
      components:{
        EChart
      },
      data(){
          return{
            option1:{
              title : {
                text: '当前用户年级分布',//主标题
                x:'left',//x轴方向对齐方式
              },
              tooltip : {
                trigger: 'item',
                formatter: '{a} <br/>{b} : {c} ({d}%)'
              },
              legend: {
                orient: 'vertical',
                right: 'right',
                data: ['2016届','2017届','2018届','2019届','2020届']
              },
              series : [
                {
                  name: '年级人数',
                  type: 'pie',
                  radius : '55%',
                  center: ['50%', '60%'],
                  data:[
                    {value:335, name:'2016届'},
                    {value:310, name:'2017届'},
                    {value:234, name:'2018届'},
                    {value:135, name:'2019届'},
                    {value:1548, name:'2020届'}
                  ],
                  itemStyle: {
                    emphasis: {
                      shadowBlur: 10,
                      shadowOffsetX: 0,
                      shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                  }
                }
              ]
            },
            option2:{
              title: {
                text: '往年网站用户数统计',
              },
              // legend: {
              //   right:'right',
              //   data: ['招商银行', '浦发银行', '广发银行', '上海银行']
              // },
              xAxis: {
                type: 'category',   // 还有其他的type，可以去官网喵两眼哦
                data: ['2016', '2017', '2018', '2019', '2020', '2021', '2022'],   // x轴数据
                name: '日期',   // x轴名称
                // x轴名称样式
                nameTextStyle: {
                  fontWeight: 600,
                  fontSize: 13
                }
              },
              yAxis: {
                type: 'value',
                name: '注册用户数',   // y轴名称
                // y轴名称样式
                nameTextStyle: {
                  fontWeight: 600,
                  fontSize: 13
                }
              },
              tooltip: {
                trigger: 'axis'   // axis   item   none三个值
              },
              series: [
                {
                  name: '用户总数',
                  data: [820, 901, 923, 934, 1290, 1330, 1450],
                  type: 'line'
                },
                // {
                //   name: '浦发银行',
                //   data: [620, 711, 823, 934, 1445, 1456, 1178],
                //   type: 'line'
                // },
                // {
                //   name: '广发银行',
                //   data: [612, 920, 1140, 1160, 1190, 1234, 1321],
                //   type: 'line'
                // },
                // {
                //   name: '上海银行',
                //   data: [234, 320, 453, 567, 789, 999, 1200],
                //   type: 'line'
                // }
              ]
            }
          }
      }
    }
</script>

<style scoped>
  #statisticsView{
    margin-bottom: 50px;
  }
  .statisticsDiv{
    width: 200px;
    height: 80px;
    border: solid #CDC9C9 2px;
    margin: 5px auto;
    color: 	#CDC5BF;
  }
  .statisticsDiv:hover{
    border: #0099CC solid 3px;
    cursor:pointer;
  }
  .statisticsSpan{
    text-align: center;
    font-size: 4em;
    font-family: 黑体
  }
  .statisticsTitle{
    font-family: 微软雅黑;
    font-weight: bold;
  }
  .colDiv{
    height: 600px;background-color: white;border: lightgray solid 1px;border-radius: 5px;
  }
</style>
