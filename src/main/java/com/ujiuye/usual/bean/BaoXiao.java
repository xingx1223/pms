package com.ujiuye.usual.bean;

import java.io.Serializable;
import java.util.Date;

public class BaoXiao implements Serializable {
    private String bxid;

    private String paymode;

    private Double totalmoney;

    private Date bxtime;

    private String bxremark;

    private Integer bxstatus;

    private Integer empFk;

    private String result;

    private static final long serialVersionUID = 1L;

    public String getBxid() {
        return bxid;
    }

    public void setBxid(String bxid) {
        this.bxid = bxid == null ? null : bxid.trim();
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode == null ? null : paymode.trim();
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Date getBxtime() {
        return bxtime;
    }

    public void setBxtime(Date bxtime) {
        this.bxtime = bxtime;
    }

    public String getBxremark() {
        return bxremark;
    }

    public void setBxremark(String bxremark) {
        this.bxremark = bxremark == null ? null : bxremark.trim();
    }

    public Integer getBxstatus() {
        return bxstatus;
    }

    public void setBxstatus(Integer bxstatus) {
        this.bxstatus = bxstatus;
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
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
        BaoXiao other = (BaoXiao) that;
        return (this.getBxid() == null ? other.getBxid() == null : this.getBxid().equals(other.getBxid()))
            && (this.getPaymode() == null ? other.getPaymode() == null : this.getPaymode().equals(other.getPaymode()))
            && (this.getTotalmoney() == null ? other.getTotalmoney() == null : this.getTotalmoney().equals(other.getTotalmoney()))
            && (this.getBxtime() == null ? other.getBxtime() == null : this.getBxtime().equals(other.getBxtime()))
            && (this.getBxremark() == null ? other.getBxremark() == null : this.getBxremark().equals(other.getBxremark()))
            && (this.getBxstatus() == null ? other.getBxstatus() == null : this.getBxstatus().equals(other.getBxstatus()))
            && (this.getEmpFk() == null ? other.getEmpFk() == null : this.getEmpFk().equals(other.getEmpFk()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBxid() == null) ? 0 : getBxid().hashCode());
        result = prime * result + ((getPaymode() == null) ? 0 : getPaymode().hashCode());
        result = prime * result + ((getTotalmoney() == null) ? 0 : getTotalmoney().hashCode());
        result = prime * result + ((getBxtime() == null) ? 0 : getBxtime().hashCode());
        result = prime * result + ((getBxremark() == null) ? 0 : getBxremark().hashCode());
        result = prime * result + ((getBxstatus() == null) ? 0 : getBxstatus().hashCode());
        result = prime * result + ((getEmpFk() == null) ? 0 : getEmpFk().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bxid=").append(bxid);
        sb.append(", paymode=").append(paymode);
        sb.append(", totalmoney=").append(totalmoney);
        sb.append(", bxtime=").append(bxtime);
        sb.append(", bxremark=").append(bxremark);
        sb.append(", bxstatus=").append(bxstatus);
        sb.append(", empFk=").append(empFk);
        sb.append(", result=").append(result);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}