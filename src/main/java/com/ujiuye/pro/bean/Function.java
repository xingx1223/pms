package com.ujiuye.pro.bean;

import java.io.Serializable;

public class Function implements Serializable {
    private Integer id;

    private String proname;

    private String analysisname;

    private Integer modeleFk;

    private String functionname;

    private String level;

    private String simpledis;

    private String detaileddis;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname == null ? null : proname.trim();
    }

    public String getAnalysisname() {
        return analysisname;
    }

    public void setAnalysisname(String analysisname) {
        this.analysisname = analysisname == null ? null : analysisname.trim();
    }

    public Integer getModeleFk() {
        return modeleFk;
    }

    public void setModeleFk(Integer modeleFk) {
        this.modeleFk = modeleFk;
    }

    public String getFunctionname() {
        return functionname;
    }

    public void setFunctionname(String functionname) {
        this.functionname = functionname == null ? null : functionname.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getSimpledis() {
        return simpledis;
    }

    public void setSimpledis(String simpledis) {
        this.simpledis = simpledis == null ? null : simpledis.trim();
    }

    public String getDetaileddis() {
        return detaileddis;
    }

    public void setDetaileddis(String detaileddis) {
        this.detaileddis = detaileddis == null ? null : detaileddis.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        Function other = (Function) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProname() == null ? other.getProname() == null : this.getProname().equals(other.getProname()))
            && (this.getAnalysisname() == null ? other.getAnalysisname() == null : this.getAnalysisname().equals(other.getAnalysisname()))
            && (this.getModeleFk() == null ? other.getModeleFk() == null : this.getModeleFk().equals(other.getModeleFk()))
            && (this.getFunctionname() == null ? other.getFunctionname() == null : this.getFunctionname().equals(other.getFunctionname()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getSimpledis() == null ? other.getSimpledis() == null : this.getSimpledis().equals(other.getSimpledis()))
            && (this.getDetaileddis() == null ? other.getDetaileddis() == null : this.getDetaileddis().equals(other.getDetaileddis()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProname() == null) ? 0 : getProname().hashCode());
        result = prime * result + ((getAnalysisname() == null) ? 0 : getAnalysisname().hashCode());
        result = prime * result + ((getModeleFk() == null) ? 0 : getModeleFk().hashCode());
        result = prime * result + ((getFunctionname() == null) ? 0 : getFunctionname().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getSimpledis() == null) ? 0 : getSimpledis().hashCode());
        result = prime * result + ((getDetaileddis() == null) ? 0 : getDetaileddis().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", proname=").append(proname);
        sb.append(", analysisname=").append(analysisname);
        sb.append(", modeleFk=").append(modeleFk);
        sb.append(", functionname=").append(functionname);
        sb.append(", level=").append(level);
        sb.append(", simpledis=").append(simpledis);
        sb.append(", detaileddis=").append(detaileddis);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}