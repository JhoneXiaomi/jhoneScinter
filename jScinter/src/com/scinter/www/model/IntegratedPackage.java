package com.scinter.www.model;

import java.io.Serializable;
import java.util.Date;

public class IntegratedPackage implements Serializable {
    private Integer integratedPackageId;

    private String integratedPackageName;

    private String integratedPackageDescribe;

    private String integratedPackageImage;

    private String creater;

    private Date createTime;

    private String updater;

    private Date updateTime;

    private String branchCompany;

    private Boolean integratedPackageStatus;

    private static final long serialVersionUID = 1L;

    public Integer getIntegratedPackageId() {
        return integratedPackageId;
    }

    public void setIntegratedPackageId(Integer integratedPackageId) {
        this.integratedPackageId = integratedPackageId;
    }

    public String getIntegratedPackageName() {
        return integratedPackageName;
    }

    public void setIntegratedPackageName(String integratedPackageName) {
        this.integratedPackageName = integratedPackageName == null ? null : integratedPackageName.trim();
    }

    public String getIntegratedPackageDescribe() {
        return integratedPackageDescribe;
    }

    public void setIntegratedPackageDescribe(String integratedPackageDescribe) {
        this.integratedPackageDescribe = integratedPackageDescribe == null ? null : integratedPackageDescribe.trim();
    }

    public String getIntegratedPackageImage() {
        return integratedPackageImage;
    }

    public void setIntegratedPackageImage(String integratedPackageImage) {
        this.integratedPackageImage = integratedPackageImage == null ? null : integratedPackageImage.trim();
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

    public String getBranchCompany() {
        return branchCompany;
    }

    public void setBranchCompany(String branchCompany) {
        this.branchCompany = branchCompany == null ? null : branchCompany.trim();
    }

    public Boolean getIntegratedPackageStatus() {
        return integratedPackageStatus;
    }

    public void setIntegratedPackageStatus(Boolean integratedPackageStatus) {
        this.integratedPackageStatus = integratedPackageStatus;
    }
}