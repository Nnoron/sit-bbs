export default ({store, route, redirect}) => {
  route.matched.forEach((item, index) => {
    if(route.meta[index].title!=='' && route.meta[index].title!==undefined){
      item.meta.title = route.meta[index].title;
    }
  });
}
