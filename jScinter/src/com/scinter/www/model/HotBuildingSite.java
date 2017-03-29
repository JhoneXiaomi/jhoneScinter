package com.scinter.www.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HotBuildingSite implements Serializable {
    private Integer id;

    private String siteName;

    private String siteStatus;

    private String siteThumbImg;

    private String houseType;

    private String costs;

    private String houseAcreage;

    private String houseStyle;

    private String manager;

    private Integer designerId;
    
    private String designerName;
    
    private Integer readNum;

    private String branchCompany;

    private Integer status;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String creater;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String updater;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getSiteStatus() {
        return siteStatus;
    }

    public void setSiteStatus(String siteStatus) {
        this.siteStatus = siteStatus == null ? null : siteStatus.trim();
    }

    public String getSiteThumbImg() {
        return siteThumbImg;
    }

    public void setSiteThumbImg(String siteThumbImg) {
        this.siteThumbImg = siteThumbImg == null ? null : siteThumbImg.trim();
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    public String getCosts() {
        return costs;
    }

    public void setCosts(String costs) {
        this.costs = costs == null ? null : costs.trim();
    }

    public String getHouseAcreage() {
        return houseAcreage;
    }

    public void setHouseAcreage(String houseAcreage) {
        this.houseAcreage = houseAcreage == null ? null : houseAcreage.trim();
    }

    public String getHouseStyle() {
        return houseStyle;
    }

    public void setHouseStyle(String houseStyle) {
        this.houseStyle = houseStyle == null ? null : houseStyle.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public Integer getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Integer designerId) {
        this.designerId = designerId;
    }

    public String getDesignerName() {
		return designerName;
	}

	public void setDesignerName(String designerName) {
		this.designerName = designerName == null ? null : designerName.trim();
	}

	public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
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