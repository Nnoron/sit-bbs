<template>
  <div class="newArticleBody">
    <div style="width: 100%;height: 200px"></div>
    <div class="editor">
      <el-tiptap
        v-model="content"
        :extensions="extensions"
        placeholder="该你发挥了 …"
        height="100%"
      />
    </div>

  </div>

</template>

<script>
  import {
    // necessary extensions
    Doc,
    Text,
    Paragraph,
    Heading,
    Bold,
    Underline,
    Italic,
    Strike,
    FontType,
    FontSize,
    TextColor,
    TextHighlight,
    LineHeight,
    Link,
    Image,
    Blockquote,
    CodeBlock,
    TextAlign,
    ListItem,
    BulletList,
    OrderedList,
    // Table,
    // TableHeader,
    // TableCell,
    // TableRow,
    HorizontalRule,
    History,
  } from 'element-tiptap';

  export default {
    name:'newArticle',
    data () {
      // editor extensions
      // they will be added to menubar and bubble menu by the order you declare.
      return {
        extensions: [
          new Doc(),
          new Text(),
          new Paragraph(),
          new Heading({ level: 5 }),
          new Bold({ bubble: true }), // render command-button in bubble menu.
          new Underline({ bubble: true, menubar: true }), // render command-button in bubble menu but not in menubar.
          new Italic(),
          new Strike(),
          new FontType(),
          new FontSize(),
          new TextColor(),
          new TextHighlight(),
          new LineHeight(),
          new Link(),
          new Image(),
          new Blockquote(),
          new CodeBlock(),
          new TextAlign(),
          new ListItem(),
          new BulletList(),
          new OrderedList(),
          // new Table(),
          // new TableHeader(),
          // new TableCell(),
          // new TableRow(),
          new HorizontalRule(),
          new History(),
        ],
        // editor's content
        content: ''
      };
    },
    watch:{
      content:function (newVal,oldVal) {
        console.log(newVal);
      }
    }
  }
</script>

<style scoped lang="less">

  .newArticleBody{
    background: #f7f8fb;
    height:1000px;
    .editor{
      width: 70%;
      height: 75%;
      margin: auto;
      padding: 50px 0;
    }
  }
</style>
