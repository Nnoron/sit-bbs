package com.local.i_sit_bbs.services;

import com.local.i_sit_bbs.pojo.CORecord;
import com.local.i_sit_bbs.pojo.CommentInfo;
import com.local.i_sit_bbs.vo.CommentInfoVo;

import java.util.List;

public interface CommentService {

    int addComment(CommentInfo commentInfo);

    List<CommentInfoVo> getComment(Integer articleId);

    CommentInfo getCommentById(Integer commentId);

    int deleteComment(CommentInfo commentInfo);

    int addSupport(Integer commentId);

    int addOppose(Integer commentId);

    int addCORecord(CORecord coRecord);

    int ifExisted(CORecord coRecord);
}
