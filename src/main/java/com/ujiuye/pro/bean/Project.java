package com.ujiuye.pro.bean;

import com.ujiuye.cus.bean.Customer;
import com.ujiuye.sys.bean.Employee;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
    private Integer pid;

    private String pname;

    private Integer comname;

    private Customer customer;

    private String comper;

    private Integer empFk1;

    private Integer empcount;

    private Date starttime;

    private Date buildtime;

    private Integer cost;

    private String level;

    private Date endtime;

    private String remark;

    private Integer empFk;

    private Employee employee;

    private String companyname;
    private String companyperson;
    private String ename;

    public String getCompanyname() {
        return companyname;
    }

    public String getCompanyperson() {
        return companyperson;
    }

    public String getEname() {
        return ename;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setCompanyperson(String companyperson) {
        this.companyperson = companyperson;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Employee getEmployee() {
        return employee;
    }

    private static final long serialVersionUID = 1L;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Integer getComname() {
        return comname;
    }

    public void setComname(Integer comname) {
        this.comname = comname;
    }

    public String getComper() {
        return comper;
    }

    public void setComper(String comper) {
        this.comper = comper == null ? null : comper.trim();
    }

    public Integer getEmpFk1() {
        return empFk1;
    }

    public void setEmpFk1(Integer empFk1) {
        this.empFk1 = empFk1;
    }

    public Integer getEmpcount() {
        return empcount;
    }

    public void setEmpcount(Integer empcount) {
        this.empcount = empcount;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
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
        Project other = (Project) that;
        return (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getPname() == null ? other.getPname() == null : this.getPname().equals(other.getPname()))
            && (this.getComname() == null ? other.getComname() == null : this.getComname().equals(other.getComname()))
            && (this.getComper() == null ? other.getComper() == null : this.getComper().equals(other.getComper()))
            && (this.getEmpFk1() == null ? other.getEmpFk1() == null : this.getEmpFk1().equals(other.getEmpFk1()))
            && (this.getEmpcount() == null ? other.getEmpcount() == null : this.getEmpcount().equals(other.getEmpcount()))
            && (this.getStarttime() == null ? other.getStarttime() == null : this.getStarttime().equals(other.getStarttime()))
            && (this.getBuildtime() == null ? other.getBuildtime() == null : this.getBuildtime().equals(other.getBuildtime()))
            && (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCustomer() == null ? other.getCustomer() == null : this.getCustomer().equals(other.getCustomer()))
            && (this.getEmpFk() == null ? other.getEmpFk() == null : this.getEmpFk().equals(other.getEmpFk()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getPname() == null) ? 0 : getPname().hashCode());
        result = prime * result + ((getComname() == null) ? 0 : getComname().hashCode());
        result = prime * result + ((getComper() == null) ? 0 : getComper().hashCode());
        result = prime * result + ((getEmpFk1() == null) ? 0 : getEmpFk1().hashCode());
        result = prime * result + ((getEmpcount() == null) ? 0 : getEmpcount().hashCode());
        result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
        result = prime * result + ((getBuildtime() == null) ? 0 : getBuildtime().hashCode());
        result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getEmpFk() == null) ? 0 : getEmpFk().hashCode());
        result = prime * result + ((getCustomer() == null) ? 0 : getCustomer().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", pname=").append(pname);
        sb.append(", comname=").append(comname);
        sb.append(", comper=").append(comper);
        sb.append(", empFk1=").append(empFk1);
        sb.append(", empcount=").append(empcount);
        sb.append(", starttime=").append(starttime);
        sb.append(", buildtime=").append(buildtime);
        sb.append(", cost=").append(cost);
        sb.append(", level=").append(level);
        sb.append(", endtime=").append(endtime);
        sb.append(", remark=").append(remark);
        sb.append(", empFk=").append(empFk);
        sb.append(", customer=").append(customer);
        sb.append(", employee=").append(employee);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}