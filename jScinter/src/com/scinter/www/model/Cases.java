package com.scinter.www.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Cases implements Serializable {
    private Integer caseId;

    private Integer designerId;

    private String caseTitle;

    private String caseDesc;

    private String caseStyle;

    private String caseMoney;

    private String caseCommunity;

    private Double caseAcreage;

    private String caseArea;

    private String caseHouseType;

    private String caseDesigner;

    private String caseThumbImg;

    private Integer caseReadNum;

    private String seoTitle;

    private String seoKeyword;

    private String seoDesc;

    private String isHotCase;

    private Integer caseStatus;

    private String branchCompany;

    private String creater;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String updater;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private Integer communityId;
    
    private String scinterCasesSeoTitleStr;
    
    private String scinterCasesSeoKeywordStr;
    
    private String scinterCasesSeoDescStr;

    private static final long serialVersionUID = 1L;
    
    public String getScinterCasesSeoTitleStr() {
		return scinterCasesSeoTitleStr;
	}

	public void setScinterCasesSeoTitleStr(String scinterCasesSeoTitleStr) {
		this.scinterCasesSeoTitleStr = scinterCasesSeoTitleStr;
	}

	public String getScinterCasesSeoKeywordStr() {
		return scinterCasesSeoKeywordStr;
	}

	public void setScinterCasesSeoKeywordStr(String scinterCasesSeoKeywordStr) {
		this.scinterCasesSeoKeywordStr = scinterCasesSeoKeywordStr;
	}

	public String getScinterCasesSeoDescStr() {
		return scinterCasesSeoDescStr;
	}

	public void setScinterCasesSeoDescStr(String scinterCasesSeoDescStr) {
		this.scinterCasesSeoDescStr = scinterCasesSeoDescStr;
	}

	public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Integer designerId) {
        this.designerId = designerId;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle == null ? null : caseTitle.trim();
    }

    public String getCaseDesc() {
        return caseDesc;
    }

    public void setCaseDesc(String caseDesc) {
        this.caseDesc = caseDesc == null ? null : caseDesc.trim();
    }

    public String getCaseStyle() {
        return caseStyle;
    }

    public void setCaseStyle(String caseStyle) {
        this.caseStyle = caseStyle == null ? null : caseStyle.trim();
    }

    public String getCaseMoney() {
        return caseMoney;
    }

    public void setCaseMoney(String caseMoney) {
        this.caseMoney = caseMoney == null ? null : caseMoney.trim();
    }

    public String getCaseCommunity() {
        return caseCommunity;
    }

    public void setCaseCommunity(String caseCommunity) {
        this.caseCommunity = caseCommunity == null ? null : caseCommunity.trim();
    }

    public Double getCaseAcreage() {
        return caseAcreage;
    }

    public void setCaseAcreage(Double caseAcreage) {
        this.caseAcreage = caseAcreage;
    }

    public String getCaseArea() {
        return caseArea;
    }

    public void setCaseArea(String caseArea) {
        this.caseArea = caseArea == null ? null : caseArea.trim();
    }

    public String getCaseHouseType() {
        return caseHouseType;
    }

    public void setCaseHouseType(String caseHouseType) {
        this.caseHouseType = caseHouseType == null ? null : caseHouseType.trim();
    }

    public String getCaseDesigner() {
        return caseDesigner;
    }

    public void setCaseDesigner(String caseDesigner) {
        this.caseDesigner = caseDesigner == null ? null : caseDesigner.trim();
    }

    public String getCaseThumbImg() {
        return caseThumbImg;
    }

    public void setCaseThumbImg(String caseThumbImg) {
        this.caseThumbImg = caseThumbImg == null ? null : caseThumbImg.trim();
    }

    public Integer getCaseReadNum() {
        return caseReadNum;
    }

    public void setCaseReadNum(Integer caseReadNum) {
        this.caseReadNum = caseReadNum;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle == null ? null : seoTitle.trim();
    }

    public String getSeoKeyword() {
        return seoKeyword;
    }

    public void setSeoKeyword(String seoKeyword) {
        this.seoKeyword = seoKeyword == null ? null : seoKeyword.trim();
    }

    public String getSeoDesc() {
        return seoDesc;
    }

    public void setSeoDesc(String seoDesc) {
        this.seoDesc = seoDesc == null ? null : seoDesc.trim();
    }

    public String getIsHotCase() {
        return isHotCase;
    }

    public void setIsHotCase(String isHotCase) {
        this.isHotCase = isHotCase == null ? null : isHotCase.trim();
    }

    public Integer getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(Integer caseStatus) {
        this.caseStatus = caseStatus;
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

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }
}