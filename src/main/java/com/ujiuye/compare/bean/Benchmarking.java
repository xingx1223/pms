package com.ujiuye.compare.bean;

import java.util.Date;

public class Benchmarking {
    private Integer id;
    private String compnayName;
    private double salesAmount;
    private Integer year;
    private String business;
    private String priority;
    private String disadvantage;
    private String status;
    private Integer emp_count;
    private Date createTime;
    private String simpleDesc;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompnayName(String compnayName) {
        this.compnayName = compnayName;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDisadvantage(String disadvantage) {
        this.disadvantage = disadvantage;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEmp_count(Integer emp_count) {
        this.emp_count = emp_count;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setSimpleDesc(String simpleDesc) {
        this.simpleDesc = simpleDesc;
    }

    public Integer getId() {
        return id;
    }

    public String getCompnayName() {
        return compnayName;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public Integer getYear() {
        return year;
    }

    public String getBusiness() {
        return business;
    }

    public String getPriority() {
        return priority;
    }

    public String getDisadvantage() {
        return disadvantage;
    }

    public String getStatus() {
        return status;
    }

    public Integer getEmp_count() {
        return emp_count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getSimpleDesc() {
        return simpleDesc;
    }

    @Override
    public String toString() {
        return "Benchmarking{" +
                "id=" + id +
                ", compnayName='" + compnayName + '\'' +
                ", salesAmount=" + salesAmount +
                ", year=" + year +
                ", business='" + business + '\'' +
                ", priority='" + priority + '\'' +
                ", disadvantage='" + disadvantage + '\'' +
                ", status='" + status + '\'' +
                ", emp_count=" + emp_count +
                ", createTime=" + createTime +
                ", simpleDesc='" + simpleDesc + '\'' +
                '}';
    }
}
