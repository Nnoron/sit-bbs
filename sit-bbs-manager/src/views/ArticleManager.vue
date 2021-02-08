<template>
  <div>
    <Card style="text-align: left">
      <p slot="title" style="text-align: left">查询</p>
      标题：<Input class="searchInput" v-model="value1" placeholder="Enter something..." clearable />
      类型：<Input class="searchInput" v-model="value2" placeholder="Enter something..." clearable />
      作者：<Input class="searchInput" v-model="value3" placeholder="Enter something..." clearable />
      <br><br>
      发表时间：<DatePicker type="date" v-model="value4" placeholder="Select date" style="width: 175px; margin-right: 50px"></DatePicker>
      <Button class="theButton" type="primary" icon="ios-search">查询</Button>
      <Button class="theButton" icon="md-close">清空</Button>
    </Card>
    <Table></Table>
  </div>
</template>

<script>
  import Table from '@/components/Table'
    export default {
      name: "ArticleManager",
      components:{
        Table
      },
      data(){
        return{
          value1: '',
          value2: '',
          value3: '',
          value4: ''
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
</style>
