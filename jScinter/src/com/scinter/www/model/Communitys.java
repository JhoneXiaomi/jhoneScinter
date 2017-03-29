package com.scinter.www.model;

import java.io.Serializable;
import java.util.Date;

public class Communitys implements Serializable {
    private Integer communityId;

    private String communityName;

    private String communityImage;

    private String communityDescription;

    private String status;

    private String branchCompany;

    private Date createTime;

    private Date updateTime;

    private String creater;

    private String updater;

    private Integer communityCases;

    private Integer signNumber;

    private String activityUrl;

    private String isHot;

    private static final long serialVersionUID = 1L;

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName == null ? null : communityName.trim();
    }

    public String getCommunityImage() {
        return communityImage;
    }

    public void setCommunityImage(String communityImage) {
        this.communityImage = communityImage == null ? null : communityImage.trim();
    }

    public String getCommunityDescription() {
        return communityDescription;
    }

    public void setCommunityDescription(String communityDescription) {
        this.communityDescription = communityDescription == null ? null : communityDescription.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBranchCompany() {
        return branchCompany;
    }

    public void setBranchCompany(String branchCompany) {
        this.branchCompany = branchCompany == null ? null : branchCompany.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public Integer getCommunityCases() {
        return communityCases;
    }

    public void setCommunityCases(Integer communityCases) {
        this.communityCases = communityCases;
    }

    public Integer getSignNumber() {
        return signNumber;
    }

    public void setSignNumber(Integer signNumber) {
        this.signNumber = signNumber;
    }

    public String getActivityUrl() {
        return activityUrl;
    }

    public void setActivityUrl(String activityUrl) {
        this.activityUrl = activityUrl == null ? null : activityUrl.trim();
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot == null ? null : isHot.trim();
    }
}