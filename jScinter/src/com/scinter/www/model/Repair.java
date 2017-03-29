package com.scinter.www.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Repair implements Serializable {
    private Integer id;

    private String repairId;

    private String clientName;

    private String sex;

    private String phone;

    private String buildName;

    private String address;

    private String chargeManager;

    private String chargeDesigner;
    @DateTimeFormat(pattern="yyyy-MM-dd")//日期类型注解
    private Date startDate;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//日期类型注解
    private Date repairTime;

    private String repairType;

    private String note;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//日期类型注解
    private Date createTime;

    private Integer status;

    private String branchCompany;

    private Integer repairStatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepairId() {
        return repairId;
    }

    public void setRepairId(String repairId) {
        this.repairId = repairId == null ? null : repairId.trim();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName == null ? null : clientName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName == null ? null : buildName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getChargeManager() {
        return chargeManager;
    }

    public void setChargeManager(String chargeManager) {
        this.chargeManager = chargeManager == null ? null : chargeManager.trim();
    }

    public String getChargeDesigner() {
        return chargeDesigner;
    }

    public void setChargeDesigner(String chargeDesigner) {
        this.chargeDesigner = chargeDesigner == null ? null : chargeDesigner.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType == null ? null : repairType.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Integer getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(Integer repairStatus) {
        this.repairStatus = repairStatus;
    }
}