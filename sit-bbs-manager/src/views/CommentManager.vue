<template>
  <div>
    <Card style="text-align: left">
      <p slot="title" style="text-align: left">查询</p>
      帖子标题：<Input class="searchInput" v-model="value1" placeholder="Enter something..." clearable />
      发表人：<Input class="searchInput" v-model="value2" placeholder="Enter something..." clearable />
      发表时间：<DatePicker type="date" v-model="value3" placeholder="Select date" style="width: 175px; margin-right: 50px"></DatePicker>
      <br><br>
      <Button class="theButton" type="primary" icon="ios-search">查询</Button>
      <Button class="theButton" icon="md-close">清空</Button>
    </Card>
    <Table></Table>
  </div>
</template>

<script>
  import Table from '@/components/Table'
    export default {
        name: "CommentManager",
      components:{
        Table
      },
      data(){
        return{
          value1: '',
          value2: '',
          value3: ''
        }
      }
    }
</script>

<style scoped>
  .searchInput{
    width: 200px;margin-right: 40px;
  }
  .theButton{
    margin-right: 50px;
  }
</style>
