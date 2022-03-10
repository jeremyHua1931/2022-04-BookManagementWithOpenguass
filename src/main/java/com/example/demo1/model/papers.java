package com.example.demo1.model;

public class papers {
    private String paper_id;
    private String paper_title;
    private String author;
    private String date;
    private String jc_name;//journalOrConferenceName
    private String issue_number;
    private String volume_number;
    private String page_number;
    private String DOI;   // doi的全称是“digital object identifier”，数字对象唯一标识，被喻为“互联网上的条形码”、“科技论文的身份证”，通过它可以方便、可靠地链接到论文全文

    public String getPaper_id() {
        return paper_id;
    }

    public String getPaper_title() {
        return paper_title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getJc_name() {
        return jc_name;
    }

    public String getIssue_number() {
        return issue_number;
    }

    public String getVolume_number() {
        return volume_number;
    }

    public String getPage_number() {
        return page_number;
    }

    public String getDOI() {
        return DOI;
    }

    public void setPaper_id(String paper_id) {
        this.paper_id = paper_id;
    }

    public void setPaper_title(String paper_title) {
        this.paper_title = paper_title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setJc_name(String jc_name) {
        this.jc_name = jc_name;
    }

    public void setIssue_number(String issue_number) {
        this.issue_number = issue_number;
    }

    public void setVolume_number(String volume_number) {
        this.volume_number = volume_number;
    }

    public void setPage_number(String page_number) {
        this.page_number = page_number;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }
}
