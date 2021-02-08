package com.local.i_sit_bbs.controller;

import com.github.pagehelper.PageHelper;
import com.local.i_sit_bbs.common.PageInfo;
import com.local.i_sit_bbs.common.Result;
import com.local.i_sit_bbs.pojo.ArticleInfo;
import com.local.i_sit_bbs.pojo.UserInfo;
import com.local.i_sit_bbs.services.ArticleService;
import com.local.i_sit_bbs.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@EnableAutoConfiguration
@Api(value = "ArticleController")
@RestController
@CrossOrigin
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Resource
    private UserService userService;

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "新增帖子",notes = "新增articleInfo")
    @PostMapping("/addArticle")
    public Result addArticle(@RequestBody ArticleInfo articleInfo,HttpSession session,HttpServletRequest request){
        if(session.getAttribute("name")==null ||
                userService.getUserInfo(new UserInfo((String)session.getAttribute("name")))==null){
            logger.info("登录信息有误，无权进行此项操作："+request.getRequestURL());
            return Result.failed("登录信息有误，无权进行此项操作");
        }
        return Result.result(articleService.addArticle(articleInfo)>0);
    }

    @ApiOperation(value = "添加图片")
    @PostMapping("/uploadPhoto")
    public Result uploadPhoto(MultipartFile file,int articleId){

        String fileName=articleService.addPhoto(file,articleId);
        if(fileName!=null){
            logger.info("图片"+fileName+"上传完成");
            return Result.success(fileName,"图片"+fileName+"上传完成");
        }
        logger.info("图片"+fileName+"上传失败");
        return Result.failed("图片"+fileName+"上传失败");
    }

    @ApiOperation(value = "返回图片")
    @GetMapping("/getPhoto/{fileName}")
    public void getPhoto(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        articleService.getPhoto(fileName,request,response);
    }

    @ApiOperation(value = "删除图片")
    @GetMapping("/deletePhoto/{fileName}")
    public Result deletePhoto(@PathVariable String fileName){
        if(articleService.deletePhoto(fileName)>0){
            logger.info("图片"+fileName+"已删除");
            return Result.success(null,"图片"+fileName+"已删除");
        }
        logger.info("图片"+fileName+"删除失败");
        return Result.failed("图片"+fileName+"删除失败");
    }

    @ApiOperation(value = "删除帖子",notes = "通过articleId删除articleInfo")
    @GetMapping("/deleteArticle")
    public Result deleteArticle(Integer articleId){
        return Result.result(articleService.deleteArticle(articleId)>0);
    }

    @ApiOperation(value = "更新帖子",notes = "更新帖子信息")
    @PostMapping("/editArticle")
    public Result editArticle(@RequestBody ArticleInfo articleInfo,HttpServletRequest request,HttpSession session){
        if(session.getAttribute("name")==null ||
                userService.getUserInfo(new UserInfo((String)session.getAttribute("name")))==null){
            logger.info("登录信息有误，无权进行此项操作："+request.getRequestURL());
            return Result.failed("登录信息有误，无权进行此项操作");
        }
        return Result.result(articleService.updateArticle(articleInfo)>0);
    }

    @ApiOperation(value = "多条件查询帖子",notes = "包装articleInfo实体查询返回List")
    @GetMapping("/getArticles")
    public Result getArticles(ArticleInfo articleInfo,@RequestParam(defaultValue = "0") int pageNum){
        try {
            if(pageNum!=0){
                PageHelper.startPage(pageNum,10);
            }
            PageInfo pageInfo=new PageInfo(articleService.getArticles(articleInfo));
            return Result.success(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("获取数据错误");
        }
    }

    //通过id查询帖子详情
    @ApiOperation(value = "通过id查询帖子详情",notes = "通过id查询帖子详情")
    @GetMapping("/getArticleById")
    public Result getArticleById(Integer id){
        try {
            return Result.success(articleService.getArticleById(id));
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("获取数据错误");
        }
    }

    //查询本周置顶帖
    @ApiOperation(value = "查询本周置顶帖",notes = "查询本周置顶帖")
    @GetMapping("/getTopsThisWeek")
    public Result getTopsThisWeek(int type){
        try {
            return Result.success(articleService.getTopThisWeek(type));
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("获取数据错误");
        }
    }

    @GetMapping("/getTopsByDate")
    public Result getTopsByDate(String date){
        return Result.success(articleService.getTopsByDate(date));
    }

    //查询本周热门贴
    @ApiOperation(value = "查询本周热门贴",notes = "查询本周热门贴")
    @GetMapping("/getHotsThisWeek")
    public Result getHotsThisWeek(){
        try {
            return Result.success(articleService.getHotThisWeek());
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("获取数据错误");
        }
    }

    @GetMapping("/setTop")
    public Result setTop(Integer articleId){
        return Result.success(articleService.setTop(articleId)>0);
    }

    @GetMapping("/getTopsNumThisWeek")
    public Result getTopsNumThisWeek(){
        return Result.success(articleService.getTopsNumThisWeek());
    }

    @GetMapping("/getTopById")
    public Result getTopById(Integer articleId){
        return Result.success(articleService.getTopById(articleId));
    }

    @GetMapping("/deleteTop")
    public Result deleteTop(Integer id){
        return Result.success(articleService.deleteTop(id)>0);
    }
}
