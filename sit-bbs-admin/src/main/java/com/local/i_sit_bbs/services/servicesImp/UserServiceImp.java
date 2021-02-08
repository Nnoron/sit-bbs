package com.local.i_sit_bbs.services.servicesImp;

import com.local.i_sit_bbs.common.FilesPublicUtils;
import com.local.i_sit_bbs.common.IdGenerater;
import com.local.i_sit_bbs.dao.IntegralMapper;
import com.local.i_sit_bbs.dao.UserInfoMapper;
import com.local.i_sit_bbs.dao.UserPassInfoMapper;
import com.local.i_sit_bbs.pojo.Integral;
import com.local.i_sit_bbs.pojo.UserInfo;
import com.local.i_sit_bbs.pojo.UserPassInfo;
import com.local.i_sit_bbs.services.UserService;
import com.local.i_sit_bbs.vo.IntegralVo;
import com.local.i_sit_bbs.vo.RequestPassInfoVo;
import com.local.i_sit_bbs.vo.UserInfoVo;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImp implements UserService {

    @Value("${isit.cachePath}")
    private String cachePath;

    private static Log log=LogFactory.getLog(UserServiceImp.class);

    private String classUrl=this.getClass().getResource("/").getPath().substring(1);


    @Autowired
    UserPassInfoMapper userPassInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    IntegralMapper integralMapper;

    @Override
    public UserPassInfo getUserPassInfo(RequestPassInfoVo requestPassInfoVo) {
        return userPassInfoMapper.getUserPassInfo(requestPassInfoVo);
    }

    @Override
    public List<UserInfo> getUserInfo(UserInfo userInfo) {
        return userInfoMapper.getUserInfo(userInfo);
    }

    @Override
    public UserInfo getUserInfoById(Integer id) {
        return userInfoMapper.getUserInfoById(id);
    }

    @Override
    public List<UserInfo> getUserInfoByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public void getUserHeadIcon(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {

        FilesPublicUtils.getPhoto(classUrl+cachePath+"/headIcon/",fileName,request,response);
//        File file = new File(classUrl + cachePath+"headIcon/"+fileName);
//        InputStream is = new FileInputStream(file);
//        byte[] bytes = new byte[is.available()];
//        is.read(bytes);
//        is.close();
//
//        OutputStream os = response.getOutputStream();
//
//        response.setContentType("image/*");
//        os.write(bytes);
//        os.close();
    }

    @Override
    public Integral getIntegral(Integer id) {
        return integralMapper.getIntegral(id);
    }

    private void clearFiles(){
        File file=new File(classUrl+cachePath);
        File[] files=file.listFiles();
        assert files != null;
        if(file.exists()&& files.length>1){
            for(File filename : files){
                if(!filename.isDirectory()){
                    filename.delete();
                    log.info("删除文件-"+filename.getAbsolutePath());
                }
            }
        }
    }
    @Override
    public int insertUserInfo(UserInfoVo userInfoVo, MultipartFile file) throws IOException {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName(userInfoVo.getUserName());
        userInfo.setNickName(userInfoVo.getNickName());
        userInfo.setCollege(userInfoVo.getCollege());
        userInfo.setGender(userInfoVo.getGender());
        userInfo.setMajor(userInfoVo.getMajor());
        //压缩头像并存入地址
        String destPath =classUrl + cachePath+"headIcon/";
        if(!new File(destPath).exists()){
            new File(destPath).mkdirs();
        }
        String imageName=IdGenerater.getUUID();
        String imageDestPath=destPath + imageName;
        Thumbnails.of(FilesPublicUtils.uploadFile(file,classUrl+cachePath,imageName))  //原图上传到头像文件夹外
                .scale(1f)
                .outputQuality(0.2f)
                .toFile(imageDestPath);
        userInfo.setHeadPath(imageName);
        userInfoMapper.insertSelective(userInfo);
        int userId=userInfo.getUserId();
        UserPassInfo userPassInfo=new UserPassInfo();
        userPassInfo.setUserId(userId);
        userPassInfo.setUserName(userInfoVo.getUserName());
        userPassInfo.setPassWord(userInfoVo.getPassWord());
        userPassInfo.setValid(1);
        userPassInfoMapper.insertSelective(userPassInfo);
        clearFiles();
        return 1;
    }

    @Override
    public int editUserInfo(UserInfo userInfo) {
        return userInfoMapper.editUserInfo(userInfo);
    }

    @Override
    public int editUserPassInfo(UserPassInfo userPassInfo) {
        return userPassInfoMapper.editUserPassInfo(userPassInfo);
    }

    @Override
    public boolean editHeadIcon(MultipartFile file, Integer id) throws IOException {
        UserInfo userInfo=getUserInfoById(id);
        try{
            String destPath =classUrl + cachePath+"headIcon/";
            if(!new File(destPath).exists()){
                new File(destPath).mkdirs();
            }
            if(userInfo.getHeadPath().equals("")||userInfo.getHeadPath()==null){
                //压缩头像并存入地址
                String imageName=IdGenerater.getUUID();
                String imageDestPath=destPath + imageName;
                Thumbnails.of(FilesPublicUtils.uploadFile(file,classUrl+cachePath,imageName))  //原图上传到头像文件夹外
                        .scale(1f)
                        .outputQuality(0.2f)
                        .toFile(imageDestPath);
                userInfo.setHeadPath(imageName);
                userInfoMapper.editUserInfo(userInfo);
            }
            else{
                String imageDestPath=destPath + userInfo.getHeadPath();
                Thumbnails.of(FilesPublicUtils.uploadFile(file,classUrl+cachePath,userInfo.getHeadPath())) //原图上传到头像文件夹外
                        .scale(1f)
                        .outputQuality(0.2f)
                        .toFile(imageDestPath);
            }
            log.info("修改头像成功");
            clearFiles();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int editIntegral(IntegralVo integralVo) {
        return integralMapper.editIntegral(integralVo);
    }

    @Override
    public int addArv(Integer userId) {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(userId);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        userInfo.setArvTime(sdf.format(date));
        return userInfoMapper.addArv(userInfo);
    }


}
