package com.scinter.www.model;

import java.io.Serializable;
import java.util.Date;

public class HomeTurnImg implements Serializable {
    private Integer homeimgId;

    private String homeimgUrl;

    private String homeimgName;

    private String homeimgSrc;

    private String branchCompany;

    private String creater;

    private Date createTime;

    private String updater;

    private Date updateTime;

    private Integer state;

    private String homeimgAlt;

    private static final long serialVersionUID = 1L;

    public Integer getHomeimgId() {
        return homeimgId;
    }

    public void setHomeimgId(Integer homeimgId) {
        this.homeimgId = homeimgId;
    }

    public String getHomeimgUrl() {
        return homeimgUrl;
    }

    public void setHomeimgUrl(String homeimgUrl) {
        this.homeimgUrl = homeimgUrl == null ? null : homeimgUrl.trim();
    }

    public String getHomeimgName() {
        return homeimgName;
    }

    public void setHomeimgName(String homeimgName) {
        this.homeimgName = homeimgName == null ? null : homeimgName.trim();
    }

    public String getHomeimgSrc() {
        return homeimgSrc;
    }

    public void setHomeimgSrc(String homeimgSrc) {
        this.homeimgSrc = homeimgSrc == null ? null : homeimgSrc.trim();
    }

    public String getBranchCompany() {
        return branchCompany;
    }

    public void setBranchCompany(String branchCompany) {
        this.branchCompany = branchCompany == null ? null : branchCompany.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getHomeimgAlt() {
        return homeimgAlt;
    }

    public void setHomeimgAlt(String homeimgAlt) {
        this.homeimgAlt = homeimgAlt == null ? null : homeimgAlt.trim();
    }
}