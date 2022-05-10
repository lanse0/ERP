package com.qf.market.utils;

/**
 * Copyright (C),2015-2022,北京千锋教育
 * FileName: PageUtils
 * Author: skyhappy
 * Date:2022/4/26 16:00
 */
public class PageUtils {
    private int pageNum=1;
    private int pageSize=10;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
