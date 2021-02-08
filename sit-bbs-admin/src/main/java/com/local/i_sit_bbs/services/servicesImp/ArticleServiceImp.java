package com.local.i_sit_bbs.services.servicesImp;

import com.google.common.collect.Sets;
import com.local.i_sit_bbs.common.FilesPublicUtils;
import com.local.i_sit_bbs.common.IdGenerater;
import com.local.i_sit_bbs.dao.ArticleInfoMapper;
import com.local.i_sit_bbs.dao.TopMapper;
import com.local.i_sit_bbs.dao.UserInfoMapper;
import com.local.i_sit_bbs.pojo.ArticleInfo;
import com.local.i_sit_bbs.pojo.ArticlePhoto;
import com.local.i_sit_bbs.pojo.Top;
import com.local.i_sit_bbs.pojo.UserInfo;
import com.local.i_sit_bbs.services.ArticleService;
import com.local.i_sit_bbs.services.UserService;
import com.local.i_sit_bbs.vo.ArticleInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ArticleServiceImp implements ArticleService {

    @Autowired
    ArticleInfoMapper articleInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    TopMapper topMapper;

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Override
    public int addArticle(ArticleInfo articleInfo) {
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        articleInfo.setPublishTime(dateFormat.format(date));
        articleInfo.setCommentNum(0);
        return articleInfoMapper.insertSelective(articleInfo);
    }

    @Value("${isit.cachePath}")
    private String cachePath;

    private String classUrl=this.getClass().getResource("/").getPath().substring(1);

    @Override
    public String addPhoto(MultipartFile file, int articleId) {
        try{
            String suffix=Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
            String fileName=IdGenerater.getUUID()+suffix;
            FilesPublicUtils.uploadFile(file,classUrl+cachePath+"articlePhotos/",fileName);
            articleInfoMapper.insertPhoto(new ArticlePhoto(fileName,articleId));
            return fileName;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("帖子(id："+articleId+")内部图片上传失败");
            return null;
        }
    }

    @Override
    public int deletePhoto(String fileName) {
        File file=new File(classUrl+cachePath+"articlePhotos/"+fileName);
        if(file.exists()){
            file.delete();
            if(articleInfoMapper.deletePhoto(fileName)>0){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public void getPhoto(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {

        FilesPublicUtils.getPhoto(classUrl+cachePath+"/articlePhotos/",fileName,request,response);

    }


    @Override
    public int deleteArticle(Integer articleId) {
        return articleInfoMapper.deleteArticle(articleId);
    }

    @Override
    public int updateArticle(ArticleInfo articleInfo) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        articleInfo.setCommentTime(sdf.format(date));
        return articleInfoMapper.editArticle(articleInfo);
    }

    @Override
    public List<ArticleInfoVo> getArticles(ArticleInfo articleInfo) {

        List<ArticleInfo> articleInfos=articleInfoMapper.getArticles(articleInfo);

        List<Integer> ids = new ArrayList<>() ;
        //获取userId
        //并去重
        for(ArticleInfo articleInfo2:articleInfos){
            if(!ids.contains(articleInfo2.getAuthorId())){
                ids.add(articleInfo2.getAuthorId());
            }
        }

        HashMap<Integer,String> userNicksMap=new HashMap<>();
        HashMap<Integer,String> userHeadPath=new HashMap<>();
        if(ids.size()>0){
            List<UserInfo> userInfos=userInfoMapper.getUserInfoByIds(ids);
            userInfos.forEach(userInfo->{
                userNicksMap.put(userInfo.getUserId(),userInfo.getNickName());
                userHeadPath.put(userInfo.getUserId(),userInfo.getHeadPath());
            });
        }

        List<ArticleInfoVo> articleInfoVos=new ArrayList<>();

        if(userHeadPath.size()>0 && userNicksMap.size()>0){
            //代码重复使用，包装为方法
            setArticleInfoVo(articleInfos, userNicksMap, userHeadPath, articleInfoVos);
        }else{
            for (ArticleInfo articleInfo1 : articleInfos) {
                ArticleInfoVo articleInfoVo=new ArticleInfoVo();
                articleInfoVo.setArticleId(articleInfo1.getArticleId());
                articleInfoVo.setArticleState(articleInfo1.getArticleState());
                articleInfoVo.setArticleClass(articleInfo1.getArticleClass());
                articleInfoVo.setArticleTitle(articleInfo1.getArticleTitle());
                articleInfoVo.setPublishTime(articleInfo1.getPublishTime());
                articleInfoVos.add(articleInfoVo);
            }
        }
        return articleInfoVos;
    }

    @Override
    public ArticleInfoVo getArticleById(Integer id) {
        ArticleInfo articleInfo=articleInfoMapper.getArticleById(id);
        String labelString=articleInfo.getLabels();
        String[] labels=labelString.split(",");

        ArticleInfoVo articleInfoVo=new ArticleInfoVo();
        articleInfoVo.setArticleTitle(articleInfo.getArticleTitle());
        articleInfoVo.setLabels(labels);
        articleInfoVo.setArticleClass(articleInfo.getArticleClass());
        articleInfoVo.setArticleText(articleInfo.getArticleText());
        return articleInfoVo;
    }

    @Override
    public List<ArticleInfoVo> getHotThisWeek() {
        Calendar calendar=Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        List<ArticleInfo> articleInfoList=articleInfoMapper.getHotThisWeek(sdf.format(calendar.getTime()));

        if(articleInfoList.size()>0){
            //获取userId并去重,获取user昵称和头像地址
            List<Integer> userIds=new ArrayList<>();
            for(ArticleInfo articleInfo2:articleInfoList){
                if(!userIds.contains(articleInfo2.getAuthorId())){
                    userIds.add(articleInfo2.getAuthorId());
                }
            }
            HashMap<Integer,String> userNicksMap=new HashMap<>();
            HashMap<Integer,String> userHeadPath=new HashMap<>();
            List<UserInfo> userInfos=userInfoMapper.getUserInfoByIds(userIds);
            userInfos.forEach(userInfo->{
                userNicksMap.put(userInfo.getUserId(),userInfo.getNickName());
                userHeadPath.put(userInfo.getUserId(),userInfo.getHeadPath());
            });

            List<ArticleInfoVo> articleInfoVoList=new ArrayList<>();

            //重复代码包装为方法
            setArticleInfoVo(articleInfoList, userNicksMap, userHeadPath, articleInfoVoList);

            return articleInfoVoList;
        }else{
            return null;
        }

    }

    /*
    代码重复使用，包装为方法
     */
    private void setArticleInfoVo(List<ArticleInfo> articleInfoList, HashMap<Integer, String> userNicksMap, HashMap<Integer, String> userHeadPath, List<ArticleInfoVo> articleInfoVoList) {
        for(ArticleInfo articleInfo:articleInfoList){
            ArticleInfoVo articleInfoVo=new ArticleInfoVo();
            articleInfoVo.setArticleId(articleInfo.getArticleId());
            articleInfoVo.setArticleTitle(articleInfo.getArticleTitle());
            articleInfoVo.setPublishTime(articleInfo.getPublishTime());

            articleInfoVo.setAuthorId(articleInfo.getAuthorId());
            articleInfoVo.setAuthorName(userNicksMap.get(articleInfo.getAuthorId()));
            articleInfoVo.setImgUrl(userHeadPath.get(articleInfo.getAuthorId()));

            articleInfoVo.setReplierId(articleInfo.getReplierId());
            articleInfoVo.setReplierNickname(articleInfo.getReplierNickname());
            articleInfoVo.setCommentTime(articleInfo.getCommentTime());
            String labelString=articleInfo.getLabels();
            String[] labels=labelString.split(",");
            articleInfoVo.setLabels(labels);
            articleInfoVo.setArticleClass(articleInfo.getArticleClass());
            articleInfoVo.setArticleState(articleInfo.getArticleState());
            articleInfoVo.setCommentNum(articleInfo.getCommentNum());

            articleInfoVoList.add(articleInfoVo);
        }
    }

    @Override
    public List<ArticleInfoVo> getTopThisWeek(int type) {

        List<Integer> articleIds=new ArrayList<>();
        List<Top> tops;
        //得到本周一的日期
        Calendar calendar=Calendar.getInstance(Locale.CHINA);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        SimpleDateFormat sldf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sldf.format(calendar.getTime());
        tops=topMapper.getTopsByParams(new Top(null,date,type));

        for(Top top:tops){
            articleIds.add(top.getArticleId());
        }

        List<ArticleInfoVo> articleInfoVoList=new ArrayList<>();
        if(articleIds.size()>0){
            List<ArticleInfo> articleInfoList=articleInfoMapper.getArticlesByIds(articleIds);
            //获取userId
            //并去重
            List<Integer> ids=new ArrayList<>();
            for(ArticleInfo articleInfo2:articleInfoList){
                if(!ids.contains(articleInfo2.getAuthorId())){
                    ids.add(articleInfo2.getAuthorId());
                }
            }

            HashMap<Integer,String> userNicksMap=new HashMap<>();
            HashMap<Integer,String> userHeadPath=new HashMap<>();
            List<UserInfo> userInfos=userInfoMapper.getUserInfoByIds(ids);
            userInfos.forEach(userInfo->{
                userNicksMap.put(userInfo.getUserId(),userInfo.getNickName());
                userHeadPath.put(userInfo.getUserId(),userInfo.getHeadPath());
            });

            for(ArticleInfo articleInfo:articleInfoList){
                ArticleInfoVo articleInfoVo=new ArticleInfoVo();

                articleInfoVo.setArticleId(articleInfo.getArticleId());
                articleInfoVo.setArticleTitle(articleInfo.getArticleTitle());

                articleInfoVo.setAuthorName(userNicksMap.get(articleInfo.getAuthorId()));
                articleInfoVo.setAuthorId(articleInfo.getAuthorId());
                articleInfoVo.setImgUrl(userHeadPath.get(articleInfo.getAuthorId()));

                articleInfoVoList.add(articleInfoVo);
            }
        }


        return articleInfoVoList;
    }

    @Override
    public List<ArticleInfoVo> getTopsByDate(String date) {

        List<Top> tops=topMapper.getTopsByParams(new Top(null,date,null));
        List<Integer> articleIds=new ArrayList<>();
        for(Top top:tops){
            articleIds.add(top.getArticleId());
        }

        List<ArticleInfoVo> articleInfoVoList=new ArrayList<>();
        if(articleIds.size()>0){
            List<ArticleInfo> articleInfoList=articleInfoMapper.getArticlesByIds(articleIds);

            for(ArticleInfo articleInfo:articleInfoList){
                ArticleInfoVo articleInfoVo=new ArticleInfoVo();

                articleInfoVo.setArticleId(articleInfo.getArticleId());
                articleInfoVo.setArticleTitle(articleInfo.getArticleTitle());
                for (Top top : tops) {
                    if(top.getArticleId().equals(articleInfo.getArticleId())){
                        articleInfoVo.setSetTime(top.getTime());
                        break;
                    }
                }
                articleInfoVoList.add(articleInfoVo);
            }
        }
        return articleInfoVoList;
    }

    @Override
    public int getTopsNumThisWeek() {
        Calendar calendar=Calendar.getInstance(Locale.CHINA);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        SimpleDateFormat sldf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sldf.format(calendar.getTime());

        return topMapper.getTopsNumThisWeek(date);
    }

    @Override
    public Top getTopById(Integer articleId) {
        return topMapper.getTopById(articleId);
    }

    @Override
    public int setTop(Integer articleId) {
        Top top=new Top();
        top.setArticleId(articleId);
        //得到本周一的日期
        Calendar calendar=Calendar.getInstance(Locale.CHINA);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        SimpleDateFormat sldf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sldf.format(calendar.getTime());
        top.setTime(date);
        return topMapper.insert(top);
    }

    @Override
    public int deleteTop(Integer articleId) {
        return topMapper.deleteTop(articleId);
    }


}
