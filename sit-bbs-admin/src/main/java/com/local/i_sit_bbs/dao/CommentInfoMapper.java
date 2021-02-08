package com.local.i_sit_bbs.dao;

import com.local.i_sit_bbs.pojo.CommentInfo;
import org.springframework.stereotype.Repository;

import javax.xml.stream.events.Comment;
import java.util.List;

@Repository
public interface CommentInfoMapper {
    int insert(CommentInfo record);

    int insertSelective(CommentInfo record);

    List<CommentInfo> getComment(Integer articleId);

    int deleteComment(CommentInfo commentInfo);

    CommentInfo getCommentById(Integer commentId);

    int updateComment(CommentInfo commentInfo);
}