<template>
  <div class="newArticleBody">
    <div class="topRow">
      <p style="color: darkgray;text-align: center;line-height: 40px;letter-spacing: 1px">注：请遵守站规版规，严格按照要求发帖发言！</p>
      <div class="inputDiv">
        <div class="blockInfo">
          <span style="font-size: 23px;font-family: 微软雅黑">当前板块</span>
          <img style="margin-top:10px;background-color: cornflowerblue;width: 80px;height: 80px;display: block" src="" alt="占位图片">
        </div>

        <div class="articleInfo">
          <div class="inputRow">
            <span style="font-size: 17px">主题：</span>
            <el-input placeholder="请输入内容"
                      v-model="subject"
                      clearable
                      size="small"
                      style="width: 70%"></el-input>
          </div>
          <div class="inputRow">
            <span style="font-size: 17px">话题：</span>
            <Poptip trigger="click" placement="bottom"  title="当前热议话题" width="220">
              <el-input placeholder="请输入内容"
                        v-model="label"
                        size="small"
                        style="width: 100%"
                        ></el-input>
              <div slot="content">
                <ul>
                  <li>#刘昊然啊啊啊啊#</li>
                  <li>#王宝强啊啊啊啊#</li>
                  <li>#贾玲啊啊啊啊#</li>
                  <li>#沈腾啊啊啊啊#</li>
                </ul>
              </div>
            </Poptip>


          </div>
          <div class="inputRow">
            <span style="font-size: 17px">查看权限：</span>
            <el-select v-model="select" slot="prepend" placeholder="请选择" size="small" style="width: 30%">
              <el-option label="所有人" value="1"></el-option>
              <el-option label="关注我的人" value="2"></el-option>
              <el-option label="仅主页" value="3"></el-option>
            </el-select>
          </div>
        </div>
      </div>
      </div>



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
        subject:'',
        label:'',
        select:'',
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

<style lang="less">

  .newArticleBody{
    background: #f7f8fb;
    height:1000px;
    padding: 20px 0;
    .topRow{
      width: 60%;
      background-color: white;
      padding: 0 20px 0 20px;
      border: lightgray 1px solid;
      margin: 20px auto;
      .inputDiv{
        display: flex;
        justify-content: space-between;
        .blockInfo{
          width: 150px;
          height: fit-content;
          display: flex;
          flex-direction: column;
          align-items: center;
        }
        .articleInfo{
          width: 70%;
          display: flex;
          flex-direction: column;
          .inputRow{
            margin-bottom: 20px;
            display: flex;
            align-items: center;
            .ivu-poptip{
              width: 33%;
              .ivu-poptip-rel{
                width: 100%;
              }
            }
            ul{
              list-style: none;
              li{
                line-height: 23px;
                text-align: center;
              }
              li:hover{
                color: orange;
                cursor: pointer;
              }
            }
          }
        }
      }

    }

    .editor{
      width: 60%;
      height: 75%;
      margin: auto;
      border: lightgray 1px solid;
      border-radius: 9px;
    }
  }
</style>
