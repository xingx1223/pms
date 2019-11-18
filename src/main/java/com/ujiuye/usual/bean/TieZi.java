package com.ujiuye.usual.bean;

import java.util.Date;

public class TieZi {

    private Integer id;
    private String content;
    private String empFk;
    private String title;
    private Date addDate;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEmpFk(String empFk) {
        this.empFk = empFk;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getEmpFk() {
        return empFk;
    }

    public String getTitle() {
        return title;
    }

    public Date getAddDate() {
        return addDate;
    }
    @Override
    public String toString() {
        return "TieZi{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", empFk='" + empFk + '\'' +
                ", title='" + title + '\'' +
                ", addDate=" + addDate +
                '}';
    }
}
