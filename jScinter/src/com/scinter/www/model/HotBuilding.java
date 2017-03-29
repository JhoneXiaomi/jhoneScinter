package com.scinter.www.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HotBuilding implements Serializable {
    private Integer bulidingId;

    private String bulidingName;

    private String bulidingArea;

    private String bulidingThumbImg;

    private String branchCompany;

    private Integer status;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String creater;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String updater;

    private static final long serialVersionUID = 1L;

    public Integer getBulidingId() {
        return bulidingId;
    }

    public void setBulidingId(Integer bulidingId) {
        this.bulidingId = bulidingId;
    }

    public String getBulidingName() {
        return bulidingName;
    }

    public void setBulidingName(String bulidingName) {
        this.bulidingName = bulidingName == null ? null : bulidingName.trim();
    }

    public String getBulidingArea() {
        return bulidingArea;
    }

    public void setBulidingArea(String bulidingArea) {
        this.bulidingArea = bulidingArea == null ? null : bulidingArea.trim();
    }

    public String getBulidingThumbImg() {
        return bulidingThumbImg;
    }

    public void setBulidingThumbImg(String bulidingThumbImg) {
        this.bulidingThumbImg = bulidingThumbImg == null ? null : bulidingThumbImg.trim();
    }

    public String getBranchCompany() {
        return branchCompany;
    }

    public void setBranchCompany(String branchCompany) {
        this.branchCompany = branchCompany == null ? null : branchCompany.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }
}