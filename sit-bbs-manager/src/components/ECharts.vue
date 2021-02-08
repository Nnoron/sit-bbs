<template>
  <div style="width: 90%;height: 90%;margin: 20px">
    <v-chart :options="options"></v-chart>
  </div>
</template>

<script>
  import ECharts from 'vue-echarts'
  import 'echarts/lib/component/tooltip'
  import 'echarts/lib/component/title'
  import 'echarts/lib/component/legend'
  import 'echarts/lib/chart/pie'
  import 'echarts/lib/chart/line'
    export default {
        name: "PieCharts",
      components: {
        'v-chart': ECharts
      },
      props:['options'],
      data(){
          return {}
      }
    }
</script>

<style scoped>
  .echarts {
    width: 100%;
    height: 100%;
  }
</style>
