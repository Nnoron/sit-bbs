package com.local.i_sit_bbs.controller;

import com.local.i_sit_bbs.common.Result;
import com.local.i_sit_bbs.pojo.CollectionInfo;
import com.local.i_sit_bbs.pojo.UserInfo;
import com.local.i_sit_bbs.services.CollectionService;
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
@Api(value = "CollectionController")
@RestController
@CrossOrigin
public class CollectionController {

    @Autowired
    CollectionService collectionService;
    @Resource
    private UserService userService;

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "新增收藏")
    @PostMapping("/addCollection")
    public Result addCollection(@RequestBody CollectionInfo collectionInfo, HttpSession session, HttpServletRequest request){
        if(session.getAttribute("name")==null ||
                userService.getUserInfo(new UserInfo((String)session.getAttribute("name")))==null){
            logger.info("登录信息有误，无权进行此项操作："+request.getRequestURL());
            return Result.failed("登录信息有误，无权进行此项操作："+request.getRequestURL());
        }
        return Result.result(collectionService.addCollection(collectionInfo)>0);
    }

    @ApiOperation(value = "删除收藏")
    @GetMapping("/deleteCollection")
    public Result deleteCollection(CollectionInfo collectionInfo){
        return Result.result(collectionService.deleteCollecticon(collectionInfo)>0);
    }

    @ApiOperation(value = "查询收藏")
    @GetMapping("/getCollection")
    public Result getCollection(String userId){
        try{
            return Result.success(collectionService.getCollections(userId));
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("获取收藏失败");
        }
    }
}
