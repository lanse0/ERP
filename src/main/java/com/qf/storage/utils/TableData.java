package com.qf.storage.utils;
/*
 * skyhappy  2022-4-29 22:30
*  封装一个 layUI页面表格使用的时候的公共类
*     这个类转json后和 layUI页面表格数据保持一致
* */
public class TableData {
    private  int code;
    private String msg;
    private long count;

    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
