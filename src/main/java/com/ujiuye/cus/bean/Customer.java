package com.ujiuye.cus.bean;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private Integer id;

    private String comname;

    private String companyperson;

    private String comaddress;

    private String comphone;

    private String camera;

    private String present;

    private String remark;

    private Date addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname == null ? null : comname.trim();
    }

    public String getCompanyperson() {
        return companyperson;
    }

    public void setCompanyperson(String companyperson) {
        this.companyperson = companyperson == null ? null : companyperson.trim();
    }

    public String getComaddress() {
        return comaddress;
    }

    public void setComaddress(String comaddress) {
        this.comaddress = comaddress == null ? null : comaddress.trim();
    }

    public String getComphone() {
        return comphone;
    }

    public void setComphone(String comphone) {
        this.comphone = comphone == null ? null : comphone.trim();
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera == null ? null : camera.trim();
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present == null ? null : present.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
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
        Customer other = (Customer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getComname() == null ? other.getComname() == null : this.getComname().equals(other.getComname()))
            && (this.getCompanyperson() == null ? other.getCompanyperson() == null : this.getCompanyperson().equals(other.getCompanyperson()))
            && (this.getComaddress() == null ? other.getComaddress() == null : this.getComaddress().equals(other.getComaddress()))
            && (this.getComphone() == null ? other.getComphone() == null : this.getComphone().equals(other.getComphone()))
            && (this.getCamera() == null ? other.getCamera() == null : this.getCamera().equals(other.getCamera()))
            && (this.getPresent() == null ? other.getPresent() == null : this.getPresent().equals(other.getPresent()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getComname() == null) ? 0 : getComname().hashCode());
        result = prime * result + ((getCompanyperson() == null) ? 0 : getCompanyperson().hashCode());
        result = prime * result + ((getComaddress() == null) ? 0 : getComaddress().hashCode());
        result = prime * result + ((getComphone() == null) ? 0 : getComphone().hashCode());
        result = prime * result + ((getCamera() == null) ? 0 : getCamera().hashCode());
        result = prime * result + ((getPresent() == null) ? 0 : getPresent().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", comname=").append(comname);
        sb.append(", companyperson=").append(companyperson);
        sb.append(", comaddress=").append(comaddress);
        sb.append(", comphone=").append(comphone);
        sb.append(", camera=").append(camera);
        sb.append(", present=").append(present);
        sb.append(", remark=").append(remark);
        sb.append(", addtime=").append(addtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}