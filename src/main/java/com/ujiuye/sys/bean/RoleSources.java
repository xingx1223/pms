package com.ujiuye.sys.bean;

public class RoleSources {
    private Integer rid;
    private Integer sid;

    public RoleSources(Integer rid, Integer sid) {
        this.rid = rid;
        this.sid = sid;
    }

    public RoleSources() {
    }

    public Integer getRid() {
        return rid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
