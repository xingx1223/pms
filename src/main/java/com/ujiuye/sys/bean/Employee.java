package com.ujiuye.sys.bean;

import com.ujiuye.usual.bean.Archives;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private Integer eid;

    private String ename;

    private String esex;

    private Integer eage;

    private String telephone;

    private Date hiredate;

    private String pnum;

    private String username;

    private String password;

    private String remark;

    private Integer pFk;

    private Integer dFk;

    private Integer lFk;

    private Archives archives;

    public void setArchives(Archives archives) {
        this.archives = archives;
    }

    public Archives getArchives() {
        return archives;
    }

    private static final long serialVersionUID = 1L;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex == null ? null : esex.trim();
    }

    public Integer getEage() {
        return eage;
    }

    public void setEage(Integer eage) {
        this.eage = eage;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum == null ? null : pnum.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getpFk() {
        return pFk;
    }

    public void setpFk(Integer pFk) {
        this.pFk = pFk;
    }

    public Integer getdFk() {
        return dFk;
    }

    public void setdFk(Integer dFk) {
        this.dFk = dFk;
    }

    public Integer getlFk() {
        return lFk;
    }

    public void setlFk(Integer lFk) {
        this.lFk = lFk;
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
        Employee other = (Employee) that;
        return (this.getEid() == null ? other.getEid() == null : this.getEid().equals(other.getEid()))
            && (this.getEname() == null ? other.getEname() == null : this.getEname().equals(other.getEname()))
            && (this.getEsex() == null ? other.getEsex() == null : this.getEsex().equals(other.getEsex()))
            && (this.getEage() == null ? other.getEage() == null : this.getEage().equals(other.getEage()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getHiredate() == null ? other.getHiredate() == null : this.getHiredate().equals(other.getHiredate()))
            && (this.getPnum() == null ? other.getPnum() == null : this.getPnum().equals(other.getPnum()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getpFk() == null ? other.getpFk() == null : this.getpFk().equals(other.getpFk()))
            && (this.getdFk() == null ? other.getdFk() == null : this.getdFk().equals(other.getdFk()))
            && (this.getlFk() == null ? other.getlFk() == null : this.getlFk().equals(other.getlFk()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEid() == null) ? 0 : getEid().hashCode());
        result = prime * result + ((getEname() == null) ? 0 : getEname().hashCode());
        result = prime * result + ((getEsex() == null) ? 0 : getEsex().hashCode());
        result = prime * result + ((getEage() == null) ? 0 : getEage().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getHiredate() == null) ? 0 : getHiredate().hashCode());
        result = prime * result + ((getPnum() == null) ? 0 : getPnum().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getpFk() == null) ? 0 : getpFk().hashCode());
        result = prime * result + ((getdFk() == null) ? 0 : getdFk().hashCode());
        result = prime * result + ((getlFk() == null) ? 0 : getlFk().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eid=").append(eid);
        sb.append(", ename=").append(ename);
        sb.append(", esex=").append(esex);
        sb.append(", eage=").append(eage);
        sb.append(", telephone=").append(telephone);
        sb.append(", hiredate=").append(hiredate);
        sb.append(", pnum=").append(pnum);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", remark=").append(remark);
        sb.append(", pFk=").append(pFk);
        sb.append(", dFk=").append(dFk);
        sb.append(", lFk=").append(lFk);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}