package com.scinter.www.model;

import java.io.Serializable;
import java.util.Date;

public class Designer implements Serializable {
    private Integer designerId;

    private String designerName;

    private String designerTitle;

    private String designerSex;

    private String designerSchool;

    private String designerBirthPlace;

    private String designerPhotoImg;

    private String designerCertificateImg;

    private String designerProfile;

    private Integer designerPrice;

    private String designerDept;

    private String designerWorkTime;

    private String designerStyle;

    private String designerIdea;

    private Integer designerPopularity;

    private Integer status;

    private String branchCompany;

    private Date createTime;

    private String creater;

    private Date updateTime;

    private String updater;

    private static final long serialVersionUID = 1L;

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

    public String getDesignerTitle() {
        return designerTitle;
    }

    public void setDesignerTitle(String designerTitle) {
        this.designerTitle = designerTitle == null ? null : designerTitle.trim();
    }

    public String getDesignerSex() {
        return designerSex;
    }

    public void setDesignerSex(String designerSex) {
        this.designerSex = designerSex == null ? null : designerSex.trim();
    }

    public String getDesignerSchool() {
        return designerSchool;
    }

    public void setDesignerSchool(String designerSchool) {
        this.designerSchool = designerSchool == null ? null : designerSchool.trim();
    }

    public String getDesignerBirthPlace() {
        return designerBirthPlace;
    }

    public void setDesignerBirthPlace(String designerBirthPlace) {
        this.designerBirthPlace = designerBirthPlace == null ? null : designerBirthPlace.trim();
    }

    public String getDesignerPhotoImg() {
        return designerPhotoImg;
    }

    public void setDesignerPhotoImg(String designerPhotoImg) {
        this.designerPhotoImg = designerPhotoImg == null ? null : designerPhotoImg.trim();
    }

    public String getDesignerCertificateImg() {
        return designerCertificateImg;
    }

    public void setDesignerCertificateImg(String designerCertificateImg) {
        this.designerCertificateImg = designerCertificateImg == null ? null : designerCertificateImg.trim();
    }

    public String getDesignerProfile() {
        return designerProfile;
    }

    public void setDesignerProfile(String designerProfile) {
        this.designerProfile = designerProfile == null ? null : designerProfile.trim();
    }

    public Integer getDesignerPrice() {
        return designerPrice;
    }

    public void setDesignerPrice(Integer designerPrice) {
        this.designerPrice = designerPrice;
    }

    public String getDesignerDept() {
        return designerDept;
    }

    public void setDesignerDept(String designerDept) {
        this.designerDept = designerDept == null ? null : designerDept.trim();
    }

    public String getDesignerWorkTime() {
        return designerWorkTime;
    }

    public void setDesignerWorkTime(String designerWorkTime) {
        this.designerWorkTime = designerWorkTime == null ? null : designerWorkTime.trim();
    }

    public String getDesignerStyle() {
        return designerStyle;
    }

    public void setDesignerStyle(String designerStyle) {
        this.designerStyle = designerStyle == null ? null : designerStyle.trim();
    }

    public String getDesignerIdea() {
        return designerIdea;
    }

    public void setDesignerIdea(String designerIdea) {
        this.designerIdea = designerIdea == null ? null : designerIdea.trim();
    }

    public Integer getDesignerPopularity() {
        return designerPopularity;
    }

    public void setDesignerPopularity(Integer designerPopularity) {
        this.designerPopularity = designerPopularity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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