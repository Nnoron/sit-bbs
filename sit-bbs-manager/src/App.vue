<template>
  <div id="app">
    <NavigateBar></NavigateBar>
    <!--<router-view/>-->
  </div>
</template>

<script>
  import NavigateBar from '@/components/NavigateBar'
export default {
  name: 'App',
  components:{
    NavigateBar
  },
}
</script>

<style>
  body{
    margin: 0;
  }
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    background-color: #F7F7F7;color: #2c3e50;
    margin: 0;
    padding:0
  }
</style>
