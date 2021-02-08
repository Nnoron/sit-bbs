package com.local.i_sit_bbs.services;

import com.local.i_sit_bbs.pojo.Integral;
import com.local.i_sit_bbs.pojo.UserInfo;
import com.local.i_sit_bbs.pojo.UserPassInfo;
import com.local.i_sit_bbs.vo.IntegralVo;
import com.local.i_sit_bbs.vo.RequestPassInfoVo;
import com.local.i_sit_bbs.vo.UserInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserService {
    //获得登录信息
    UserPassInfo getUserPassInfo(RequestPassInfoVo requestPassInfoVo);
    //多条件查询用户信息
    List<UserInfo> getUserInfo(UserInfo userInfo);
    //通过id用户基本信息
    UserInfo getUserInfoById(Integer id);
    //批量id查询
    List<UserInfo>  getUserInfoByIds(List<Integer> ids);
    //获得用户头像
    void getUserHeadIcon(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException;
    //获得积分信息
    Integral getIntegral(Integer id);
    //新增用户信息（含账密）
    int insertUserInfo(UserInfoVo userInfoVo, MultipartFile multipartFile) throws IOException;
    //修改用户基本信息
    int editUserInfo(UserInfo userInfo);
    //修改用户密码
    int editUserPassInfo(UserPassInfo userPassInfo);
    //修改用户头像
    boolean editHeadIcon(MultipartFile file, Integer id) throws IOException;
    //修改积分
    int editIntegral(IntegralVo integralVo);
    //签到记录
    int addArv(Integer userId);
}
