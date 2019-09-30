package com.fayelau.tummy.base.core.utils;

import java.util.Collection;
import java.util.LinkedList;

import com.fayelau.tummy.base.core.exception.TummyException;

public class ResponseRange<T> implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    protected Integer code; // 返回码
    protected Boolean success; // 是否出现异常
    protected String message; // 异常信息
    protected Integer size; // 数据集合长度
    protected Collection<T> data; // 数据集合

    protected Boolean page; // 是否分页
    protected Long total; // 表长度
    protected Integer pageNumber; // 页码
    protected Integer pageSize;// 每页显示多少

    public ResponseRange() {
        this.code = 200;
        this.size = 0;
        this.success = true;
        this.data = new LinkedList<>();
        this.page = false;
    }

    public void openPage(int pageNumber, int pageSize) {
        this.page = true;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = 0L;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
        this.setSize(data.size());
    }

    public void setOneData(T data) {
        this.data.add(data);
        this.size = this.size + 1;
    }

    public void setException(TummyException e) {
        this.success = false;
        this.message = e.getMessage();
        this.code = e.getCode();
    }
    
    public void setException(Exception e) {
        this.success = false;
        this.message = e.getMessage();
        this.code = 500;
    }

    public Boolean isPage() {
        return page;
    }

    public void setPage(Boolean page) {
        this.page = page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
