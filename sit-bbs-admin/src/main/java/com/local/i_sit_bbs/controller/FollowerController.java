package com.local.i_sit_bbs.controller;

import com.local.i_sit_bbs.common.Result;
import com.local.i_sit_bbs.pojo.Follower;
import com.local.i_sit_bbs.pojo.UserInfo;
import com.local.i_sit_bbs.services.FollowerService;
import com.local.i_sit_bbs.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@EnableAutoConfiguration
@Api(value = "FollowerController")
@RestController
@CrossOrigin
public class FollowerController {

    @Autowired
    FollowerService followerService;
    @Resource
    private UserService userService;

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "添加关注",notes = "包装follower实体，新增follower_list表数据")
    @PostMapping("/addConcern")
    public Result addConcern(Follower follower, HttpSession session, HttpServletRequest request){
        if(session.getAttribute("name")==null ||
                userService.getUserInfo(new UserInfo((String)session.getAttribute("name")))==null){
            logger.info("登录信息有误，无权进行此项操作："+request.getRequestURL());
            return Result.failed("登录信息有误，无权进行此项操作："+request.getRequestURL());
        }
        return Result.result(followerService.addConcern(follower)>0);
    }

    @ApiOperation(value = "删除一条关注数据")
    @GetMapping("/deleteConcern")
    public Result deleteConcern(Follower follower){
        return Result.result(followerService.deleteConcern(follower)>0);
    }

    @ApiOperation(value = "查询userId对应的所有粉丝")
    @GetMapping("/getAllFans")
    public Result getAllFans(Integer userId){
        try{
            return Result.success(followerService.getAllFans(userId));
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("获取粉丝列表失败");
        }
    }

    @ApiOperation(value = "查询userId关注的人")
    @GetMapping("/getAllConcern")
    public Result getAllConcern(Integer userId){
        try{
            return Result.success(followerService.getAllConcern(userId));
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("获取关注列表失败");
        }
    }

    @ApiOperation(value = "关注你的人数量")
    @GetMapping("/getFansNum")
    public Result getFansNum(Integer userId){
        try{
            return Result.success(followerService.getFansNum(userId));
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("获取粉丝数失败");
        }
    }

    @ApiOperation(value = "查询你关注的人的数量")
    @GetMapping("/getConcernNum")
    public Result getConcernNum(Integer followerId){
        try{
            return Result.success(followerService.getConcernNum(followerId));
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("获取关注数失败");
        }
    }

    @ApiOperation(value = "判断是否关注",notes = "1为已关注，0为未关注")
    @GetMapping("/ifConcern")
    public Result ifConcern(Follower follower){
        return Result.success(followerService.ifConcern(follower));
    }

}
