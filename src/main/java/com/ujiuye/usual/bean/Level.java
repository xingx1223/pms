package com.ujiuye.usual.bean;

import java.io.Serializable;

public class Level implements Serializable {
    private Integer jid;

    private String jname;

    private String jdis;

    private static final long serialVersionUID = 1L;

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname == null ? null : jname.trim();
    }

    public String getJdis() {
        return jdis;
    }

    public void setJdis(String jdis) {
        this.jdis = jdis == null ? null : jdis.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Level other = (Level) that;
        return (this.getJid() == null ? other.getJid() == null : this.getJid().equals(other.getJid()))
            && (this.getJname() == null ? other.getJname() == null : this.getJname().equals(other.getJname()))
            && (this.getJdis() == null ? other.getJdis() == null : this.getJdis().equals(other.getJdis()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getJid() == null) ? 0 : getJid().hashCode());
        result = prime * result + ((getJname() == null) ? 0 : getJname().hashCode());
        result = prime * result + ((getJdis() == null) ? 0 : getJdis().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", jid=").append(jid);
        sb.append(", jname=").append(jname);
        sb.append(", jdis=").append(jdis);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}