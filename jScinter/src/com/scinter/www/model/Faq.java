package com.scinter.www.model;

import java.io.Serializable;
import java.util.Date;

public class Faq implements Serializable {
    private Integer faqId;

    private String faqImage;

    private String faqDesc;

    private String faqAnswer;

    private String faqType;

    private String branchCompany;

    private Integer faqStatus;

    private Date createTime;

    private String creater;

    private Date updateTime;

    private String updater;

    private static final long serialVersionUID = 1L;

    public Integer getFaqId() {
        return faqId;
    }

    public void setFaqId(Integer faqId) {
        this.faqId = faqId;
    }

    public String getFaqImage() {
        return faqImage;
    }

    public void setFaqImage(String faqImage) {
        this.faqImage = faqImage == null ? null : faqImage.trim();
    }

    public String getFaqDesc() {
        return faqDesc;
    }

    public void setFaqDesc(String faqDesc) {
        this.faqDesc = faqDesc == null ? null : faqDesc.trim();
    }

    public String getFaqAnswer() {
        return faqAnswer;
    }

    public void setFaqAnswer(String faqAnswer) {
        this.faqAnswer = faqAnswer == null ? null : faqAnswer.trim();
    }

    public String getFaqType() {
        return faqType;
    }

    public void setFaqType(String faqType) {
        this.faqType = faqType == null ? null : faqType.trim();
    }

    public String getBranchCompany() {
        return branchCompany;
    }

    public void setBranchCompany(String branchCompany) {
        this.branchCompany = branchCompany == null ? null : branchCompany.trim();
    }

    public Integer getFaqStatus() {
        return faqStatus;
    }

    public void setFaqStatus(Integer faqStatus) {
        this.faqStatus = faqStatus;
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