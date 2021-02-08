/**
 * Copyright © 软中 2019 Info. Tech Ltd. All rights reserved
 */
package com.local.i_sit_bbs.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:  PageResultVo
 * @Description: TODO
 * @Author: DedoChen
 * @Date: 2019/4/8 14:42
 * @Version: 1.0.0
 */
public class Page<T> implements Serializable {
    // @Property: 页编号：第几页
    private int pageNum = 0;
    // @Property: 页大小：每页记录数
    private int pageSize = 10;
    // @Property: 限定数：每页的数量
    private int limit;
    // @Property: 总条数
    private int totalCount;
    // @Property: 总页数
    private int totalPages;
    // @Property: 返回值List
    private List<T> resultList = new ArrayList<>();

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }
}
