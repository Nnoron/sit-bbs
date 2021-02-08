package com.local.i_sit_bbs.controller;

import com.local.i_sit_bbs.common.Result;
import com.local.i_sit_bbs.pojo.UserInfo;
import com.local.i_sit_bbs.pojo.UserPassInfo;
import com.local.i_sit_bbs.services.UserService;
import com.local.i_sit_bbs.vo.RequestPassInfoVo;
import com.local.i_sit_bbs.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@EnableAutoConfiguration
@Api(value = "loginResisterController")
@RestController
@CrossOrigin
public class LoginRegisterController {

    @Autowired
    UserService UserService;

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    //登录
    @ApiOperation(value = "获得登录信息",notes = "通过userName获得userPassInfo")
    @GetMapping("/getUserPassInfo")
    public Result getUserPassInfo(RequestPassInfoVo requestPassInfoVo,HttpSession session){
        try{
            UserPassInfo userPassInfo = UserService.getUserPassInfo(requestPassInfoVo);
            if(userPassInfo!=null){
                session.setAttribute("name",requestPassInfoVo.getUserName());
                logger.info("登录，用户名为："+session.getAttribute("name"));
                return Result.success(userPassInfo);
            }
            return Result.failed("该账号未注册，登录失败");
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("数据返回失败");
        }
    }

    @ApiOperation(value = "管理员登录验证")
    @GetMapping("/getAdminPassInfo")
    public Result getAdminPassInfo(String userName,String passWord,HttpSession session){
        if(userName.equals("admin")&&passWord.equals("11223")){
            session.setAttribute("name","admin");
            return Result.success("管理员登录成功");
        }
        return Result.failed("登录失败");
    }

    //注册
    @ApiOperation(value = "新增用户",notes = "新增userPassInfo")
    @PostMapping("/insertUserInfo")
    public Result addUser(UserInfoVo userInfoVo, MultipartFile file) throws IOException {
        return Result.result(UserService.insertUserInfo(userInfoVo,file)>0);
    }
}
