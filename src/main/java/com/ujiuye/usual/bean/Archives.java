package com.ujiuye.usual.bean;

import com.ujiuye.sys.bean.Employee;

import java.io.Serializable;
import java.util.Date;

public class Archives implements Serializable {
    private String dnum;

    private String landline;

    private String school;

    private String zhuanye;

    private String sosperson;

    private Date biyedate;

    private String zzmm;

    private String minzu;

    private String xueli;

    private String email;

    private Integer empFk;

    private String remark;

    private Date hirdate;

    private Employee employee;

    private Level level;
    private Dept dept;

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Level getLevel() {
        return level;
    }

    public Dept getDept() {
        return dept;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    private static final long serialVersionUID = 1L;

    public String getDnum() {
        return dnum;
    }

    public void setDnum(String dnum) {
        this.dnum = dnum == null ? null : dnum.trim();
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline == null ? null : landline.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getZhuanye() {
        return zhuanye;
    }

    public void setZhuanye(String zhuanye) {
        this.zhuanye = zhuanye == null ? null : zhuanye.trim();
    }

    public String getSosperson() {
        return sosperson;
    }

    public void setSosperson(String sosperson) {
        this.sosperson = sosperson == null ? null : sosperson.trim();
    }

    public Date getBiyedate() {
        return biyedate;
    }

    public void setBiyedate(Date biyedate) {
        this.biyedate = biyedate;
    }

    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm == null ? null : zzmm.trim();
    }

    public String getMinzu() {
        return minzu;
    }

    public void setMinzu(String minzu) {
        this.minzu = minzu == null ? null : minzu.trim();
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli == null ? null : xueli.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getHirdate() {
        return hirdate;
    }

    public void setHirdate(Date hirdate) {
        this.hirdate = hirdate;
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
        Archives other = (Archives) that;
        return (this.getDnum() == null ? other.getDnum() == null : this.getDnum().equals(other.getDnum()))
            && (this.getLandline() == null ? other.getLandline() == null : this.getLandline().equals(other.getLandline()))
            && (this.getSchool() == null ? other.getSchool() == null : this.getSchool().equals(other.getSchool()))
            && (this.getZhuanye() == null ? other.getZhuanye() == null : this.getZhuanye().equals(other.getZhuanye()))
            && (this.getSosperson() == null ? other.getSosperson() == null : this.getSosperson().equals(other.getSosperson()))
            && (this.getBiyedate() == null ? other.getBiyedate() == null : this.getBiyedate().equals(other.getBiyedate()))
            && (this.getZzmm() == null ? other.getZzmm() == null : this.getZzmm().equals(other.getZzmm()))
            && (this.getMinzu() == null ? other.getMinzu() == null : this.getMinzu().equals(other.getMinzu()))
            && (this.getXueli() == null ? other.getXueli() == null : this.getXueli().equals(other.getXueli()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getEmpFk() == null ? other.getEmpFk() == null : this.getEmpFk().equals(other.getEmpFk()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getHirdate() == null ? other.getHirdate() == null : this.getHirdate().equals(other.getHirdate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDnum() == null) ? 0 : getDnum().hashCode());
        result = prime * result + ((getLandline() == null) ? 0 : getLandline().hashCode());
        result = prime * result + ((getSchool() == null) ? 0 : getSchool().hashCode());
        result = prime * result + ((getZhuanye() == null) ? 0 : getZhuanye().hashCode());
        result = prime * result + ((getSosperson() == null) ? 0 : getSosperson().hashCode());
        result = prime * result + ((getBiyedate() == null) ? 0 : getBiyedate().hashCode());
        result = prime * result + ((getZzmm() == null) ? 0 : getZzmm().hashCode());
        result = prime * result + ((getMinzu() == null) ? 0 : getMinzu().hashCode());
        result = prime * result + ((getXueli() == null) ? 0 : getXueli().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getEmpFk() == null) ? 0 : getEmpFk().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getHirdate() == null) ? 0 : getHirdate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dnum=").append(dnum);
        sb.append(", landline=").append(landline);
        sb.append(", school=").append(school);
        sb.append(", zhuanye=").append(zhuanye);
        sb.append(", sosperson=").append(sosperson);
        sb.append(", biyedate=").append(biyedate);
        sb.append(", zzmm=").append(zzmm);
        sb.append(", minzu=").append(minzu);
        sb.append(", xueli=").append(xueli);
        sb.append(", email=").append(email);
        sb.append(", empFk=").append(empFk);
        sb.append(", remark=").append(remark);
        sb.append(", hirdate=").append(hirdate);
        sb.append(", dept=").append(dept);
        sb.append(", level=").append(level);
        sb.append(", employee=").append(employee);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}