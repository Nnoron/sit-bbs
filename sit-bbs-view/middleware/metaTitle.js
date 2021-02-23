export default ({store, route, redirect}) => {
  route.matched.forEach((item, index) => {
    if(route.meta[index].title!==''){
      item.meta.title = route.meta[index].title;
    }
  })
}
