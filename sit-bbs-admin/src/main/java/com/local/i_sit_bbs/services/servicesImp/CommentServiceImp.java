package com.local.i_sit_bbs.services.servicesImp;

import com.local.i_sit_bbs.dao.CORecordMapper;
import com.local.i_sit_bbs.dao.CommentInfoMapper;
import com.local.i_sit_bbs.dao.UserInfoMapper;
import com.local.i_sit_bbs.pojo.CORecord;
import com.local.i_sit_bbs.pojo.CommentInfo;
import com.local.i_sit_bbs.pojo.UserInfo;
import com.local.i_sit_bbs.services.CommentService;
import com.local.i_sit_bbs.vo.CommentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    CommentInfoMapper commentInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    CORecordMapper coRecordMapper;

    @Override
    public int addComment(CommentInfo commentInfo) {
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        commentInfo.setCommentTime(dateFormat.format(date));
        return commentInfoMapper.insertSelective(commentInfo);
    }

    @Override
    public List<CommentInfoVo> getComment(Integer articleId) {
        List<CommentInfo> commentInfoList=commentInfoMapper.getComment(articleId);
        List<CommentInfoVo> commentInfoVoList=new ArrayList<>();

        for(CommentInfo commentInfo:commentInfoList){

            if(commentInfo.getIfSource()!=null && commentInfo.getIfSource()==1){  //如果为根评论

                CommentInfoVo commentInfoVo = new CommentInfoVo();
                List<CommentInfoVo> childerVo=new ArrayList<>();

                commentInfoVo.setCommentId(commentInfo.getCommentId());
                commentInfoVo.setCommentPictures(commentInfo.getCommentPictures());
                commentInfoVo.setCommentText(commentInfo.getCommentText());
                commentInfoVo.setCommentTime(commentInfo.getCommentTime());
                commentInfoVo.setIsToken(commentInfo.getIsToken());
                commentInfoVo.setSupport(commentInfo.getSupport());
                commentInfoVo.setOppose(commentInfo.getOppose());

                UserInfo userInfo=userInfoMapper.getUserByName(commentInfo.getReviewerUsername());
                commentInfoVo.setUserId(userInfo.getUserId());
                commentInfoVo.setNickName(userInfo.getNickName());
                commentInfoVo.setHeadIcon(userInfo.getHeadPath());

                for(CommentInfo commentInfo1:commentInfoList) {  //将子评论封装进list
                    CommentInfoVo commentInfoVo1=new CommentInfoVo();
                    if(commentInfo1.getSourceId()!=null && commentInfo1.getSourceId().equals(commentInfo.getCommentId())){
                        commentInfoVo1.setCommentId(commentInfo1.getCommentId());
                        commentInfoVo1.setCommentText(commentInfo1.getCommentText());
                        commentInfoVo1.setCommentTime(commentInfo1.getCommentTime());

                        UserInfo userInfo1=userInfoMapper.getUserByName(commentInfo1.getReviewerUsername());
                        commentInfoVo1.setNickName(userInfo1.getNickName());
                        commentInfoVo1.setUserId(userInfo1.getUserId());
                        commentInfoVo1.setHeadIcon(userInfo1.getHeadPath());

                        UserInfo userInfo2=userInfoMapper.getUserByName(commentInfoMapper.getCommentById(commentInfo1.getParentId()).getReviewerUsername());
                        commentInfoVo1.setParentNickName(userInfo2.getNickName());
                        commentInfoVo1.setParentId(userInfo2.getUserId());
                        commentInfoVo1.setIfShow(false);

                        childerVo.add(commentInfoVo1);  //将子评论封装进list
                    }
                }
                commentInfoVo.setChildrenVos(childerVo);
                commentInfoVoList.add(commentInfoVo);
            }

        }
        return commentInfoVoList;
    }

    @Override
    public CommentInfo getCommentById(Integer commentId) {
        return commentInfoMapper.getCommentById(commentId);
    }

    @Override
    public int deleteComment(CommentInfo commentInfo) {
        return commentInfoMapper.deleteComment(commentInfo);
    }

    @Override
    public int addSupport(Integer commentId) {
        CommentInfo commentInfo=commentInfoMapper.getCommentById(commentId);
        commentInfo.setSupport(commentInfo.getSupport()+1);

        return commentInfoMapper.updateComment(commentInfo);
    }

    @Override
    public int addOppose(Integer commentId) {
        CommentInfo commentInfo=commentInfoMapper.getCommentById(commentId);
        commentInfo.setOppose(commentInfo.getOppose()+1);
        return commentInfoMapper.updateComment(commentInfo);
    }

    @Override
    public int addCORecord(CORecord coRecord) {
        return coRecordMapper.insert(coRecord);
    }

    @Override
    public int ifExisted(CORecord coRecord) {
        return coRecordMapper.ifExisted(coRecord);
    }


}
