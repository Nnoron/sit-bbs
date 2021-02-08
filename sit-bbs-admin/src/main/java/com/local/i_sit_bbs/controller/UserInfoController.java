package com.local.i_sit_bbs.controller;

import com.local.i_sit_bbs.common.Result;
import com.local.i_sit_bbs.pojo.UserInfo;
import com.local.i_sit_bbs.pojo.UserPassInfo;
import com.local.i_sit_bbs.services.UserService;
import com.local.i_sit_bbs.vo.IntegralVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@EnableAutoConfiguration
@Api(value = "userInfoController")
@RestController
@CrossOrigin
public class UserInfoController {

    @Autowired
    UserService userService;

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    //查询指定id用户基本信息
    @ApiOperation(value = "通过id查询用户信息",notes = "查询用户信息")
    @GetMapping("/getUserInfoById")
    public Result getUserInfoById(Integer id){
        try{
            return Result.success(userService.getUserInfoById(id));
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("获取个人信息失败");
        }
    }

    //多条件查询用户信息
    @ApiOperation(value = "多条件查询用户信息",notes = "查询用户信息")
    @GetMapping("/getUserInfo")
    public Result getUserInfo(UserInfo userInfo){
        try{
            return Result.success(userService.getUserInfo(userInfo));
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("获取个人信息失败");
        }
    }

    //用户名是否存在
    @GetMapping("/userNameIfExist")
    public Result getUserName(UserInfo userInfo){
        if(userService.getUserInfo(userInfo).size()>0){
            return Result.success(0);
        }else{
            return Result.success(1);
        }
    }

    //返回用户头像
    @ApiOperation(value = "返回用户头像", notes="返回图片流")
    @GetMapping("/getUserHeadIcon/{fileName}")
    public void getUserHeadIcon(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.getUserHeadIcon(fileName,request,response);
    }

    //更新用户基本信息
    @ApiOperation(value = "更新用户基本信息",notes = "更新userInfo")
    @PostMapping("/editUserInfo")
    public Result editUserInfo(UserInfo userInfo){
        return Result.result(userService.editUserInfo(userInfo)>0);
    }

    //修改用户密码
    @ApiOperation(value = "修改用户密码",notes = "更新userPassInfo")
    @PostMapping("/editUserPassInfo")
    public Result editUserPassInfo(UserPassInfo userPassInfo){
        return Result.result(userService.editUserPassInfo(userPassInfo)>0);
    }

    //更换头像
    @ApiOperation(value = "更换头像",notes="更新userInfo表中的headPath,并返回新地址")
    @PostMapping("/editHeadIcon")
    public Result editHeadIcon(@RequestParam(value="file") MultipartFile file, Integer id) throws IOException {
        if(userService.editHeadIcon(file,id)){
            return Result.success(userService.getUserInfoById(id).getHeadPath());
        }
        else{
            return Result.failed("图片上传错误");
        }
    }

    //修改积分
    @ApiOperation(value = "修改积分",notes = "包装Integral修改integral对应数据")
    @PostMapping("/editIntegral")
    public Result editIntegral(@RequestBody IntegralVo integralVo){
        return Result.result(userService.editIntegral(integralVo)>0);
    }

    //查询积分
    @GetMapping("/getIntegral")
    public Result getIntegral(Integer userId){
        return Result.success(userService.getIntegral(userId));
    }

    //签到
    @GetMapping("/addArv")
    public Result addArv(Integer userId, HttpSession session,HttpServletRequest request){
        if(session.getAttribute("name")==null ||
                userService.getUserInfo(new UserInfo((String)session.getAttribute("name")))==null){
            logger.info("登录信息有误，无权进行此项操作："+request.getRequestURL());
            return Result.failed("登录信息有误，无权进行此项操作");
        }
        return Result.success(userService.addArv(userId));
    }

}
