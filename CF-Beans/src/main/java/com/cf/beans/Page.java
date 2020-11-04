package com.cf.beans;

import java.util.List;

public class Page {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalCount;
    private Integer totalPages;
    private List data;

    public Page() {
    }

    public Page(Integer pageNum, Integer pageSize, Integer totalCount, Integer totalPages, List data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPages=" + totalPages +
                ", data=" + data +
                '}';
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if(pageNum<1){
           this.pageNum=1;
        }else
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(pageSize<1){
            this.pageSize=10;
        }else
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
//        this.totalPages=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
