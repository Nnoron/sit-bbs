package com.local.i_sit_bbs.controller;

import com.local.i_sit_bbs.common.Result;
import com.local.i_sit_bbs.dao.CORecordMapper;
import com.local.i_sit_bbs.pojo.CORecord;
import com.local.i_sit_bbs.pojo.CommentInfo;
import com.local.i_sit_bbs.pojo.UserInfo;
import com.local.i_sit_bbs.services.CommentService;
import com.local.i_sit_bbs.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@EnableAutoConfiguration
@Api(value = "CommentController")
@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    CommentService commentService;
    @Resource
    private UserService userService;

    private Logger logger=LoggerFactory.getLogger(this.getClass());


    @ApiOperation(value = "查询评论",notes = "通过articleId查询评论")
    @GetMapping("/getComment")
    public Result getComment(Integer articleId){
        try{
            return Result.success(commentService.getComment(articleId));
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("获取评论失败");
        }
    }

    @ApiOperation(value = "添加评论",notes = "包装commentInfo实体新增comment_info表数据")
    @PostMapping("/addComment")
    public Result addComment(@RequestBody CommentInfo commentInfo, HttpSession session, HttpServletRequest request){
        if(session.getAttribute("name")==null ||
                userService.getUserInfo(new UserInfo((String)session.getAttribute("name")))==null){
            logger.info("登录信息有误，无权进行此项操作："+request.getRequestURL());
            return Result.failed("登录信息有误，无权进行此项操作");
        }
        return Result.result(commentService.addComment(commentInfo)>0);
    }

    @ApiOperation(value = "删除评论",notes = "包装commentInfo实体，同过多条件锁定该条评论并删除")
    @GetMapping("/deleteComment")
    public Result deleteComment(CommentInfo commentInfo){
        return Result.result(commentService.deleteComment(commentInfo)>0);
    }

    @GetMapping("/addSupport")
    public Result addSupport(Integer commentId,HttpSession session,HttpServletRequest request){
        if(session.getAttribute("name")==null ||
                userService.getUserInfo(new UserInfo((String)session.getAttribute("name")))==null){
            logger.info("登录信息有误，无权进行此项操作："+request.getRequestURL());
            return Result.failed("登录信息有误，无权进行此项操作");
        }
        return Result.success(commentService.addSupport(commentId));
    }

    @GetMapping("/addOppose")
    public Result addOppose(Integer commentId,HttpSession session,HttpServletRequest request){
        if(session.getAttribute("name")==null ||
                userService.getUserInfo(new UserInfo((String)session.getAttribute("name")))==null){
            logger.info("登录信息有误，无权进行此项操作："+request.getRequestURL());
            return Result.failed("登录信息有误，无权进行此项操作");
        }
        return Result.success(commentService.addOppose(commentId));
    }

    @PostMapping("/addCORecord")
    public Result addCORecord(CORecord coRecord){
        return Result.success(commentService.addCORecord(coRecord));
    }

    @PostMapping("/ifExisted")
    public Result ifExisted(CORecord coRecord){
        return Result.success(commentService.ifExisted(coRecord));
    }

}
