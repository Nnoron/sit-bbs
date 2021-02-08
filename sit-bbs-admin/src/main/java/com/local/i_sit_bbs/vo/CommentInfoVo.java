package com.local.i_sit_bbs.vo;

import java.util.List;

public class CommentInfoVo {

    private Integer commentId;

    private String commentText;

    private String commentPictures;

    private String commentTime;

    private String isToken;

    private String nickName;

    private String headIcon;

    private Integer userId;

    private Integer support;

    private Integer oppose;

    private String parentNickName;

    private Integer parentId;

    private boolean ifShow;

    private List<CommentInfoVo> childrenVos;

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentPictures() {
        return commentPictures;
    }

    public void setCommentPictures(String commentPictures) {
        this.commentPictures = commentPictures;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getIsToken() {
        return isToken;
    }

    public void setIsToken(String isToken) {
        this.isToken = isToken;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public Integer getOppose() {
        return oppose;
    }

    public void setOppose(Integer oppose) {
        this.oppose = oppose;
    }

    public String getParentNickName() {
        return parentNickName;
    }

    public void setParentNickName(String parentNickName) {
        this.parentNickName = parentNickName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<CommentInfoVo> getChildrenVos() {
        return childrenVos;
    }

    public void setChildrenVos(List<CommentInfoVo> childrenVos) {
        this.childrenVos = childrenVos;
    }

    public boolean isIfShow() {
        return ifShow;
    }

    public void setIfShow(boolean ifShow) {
        this.ifShow = ifShow;
    }
}
