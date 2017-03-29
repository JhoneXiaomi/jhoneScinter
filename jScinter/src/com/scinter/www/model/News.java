package com.scinter.www.model;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
    private Integer newsId;

    private String title;

    private String type;

    private String author;

    private String source;

    private Integer readNum;

    private String thumbImg;

    private String keywords;

    private String contents;

    private String seoTitle;

    private String seoKeyword;

    private String seoDesc;

    private Integer status;

    private String branchCompany;

    private String creater;

    private Date createTime;

    private String updater;

    private Date updateTime;

    private String isHotNews;

	private String scinterNewsSeoTitleStr;
	
	private String scinterNewsSeoKeywordStr;
	
	private String scinterNewsSeoDescStr;
	
    private static final long serialVersionUID = 1L;

    
    public String getScinterNewsSeoTitleStr() {
		return scinterNewsSeoTitleStr;
	}

	public void setScinterNewsSeoTitleStr(String scinterNewsSeoTitleStr) {
		this.scinterNewsSeoTitleStr = scinterNewsSeoTitleStr;
	}

	public String getScinterNewsSeoKeywordStr() {
		return scinterNewsSeoKeywordStr;
	}

	public void setScinterNewsSeoKeywordStr(String scinterNewsSeoKeywordStr) {
		this.scinterNewsSeoKeywordStr = scinterNewsSeoKeywordStr;
	}

	public String getScinterNewsSeoDescStr() {
		return scinterNewsSeoDescStr;
	}

	public void setScinterNewsSeoDescStr(String scinterNewsSeoDescStr) {
		this.scinterNewsSeoDescStr = scinterNewsSeoDescStr;
	}

	public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public String getThumbImg() {
        return thumbImg;
    }

    public void setThumbImg(String thumbImg) {
        this.thumbImg = thumbImg == null ? null : thumbImg.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
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

    public String getIsHotNews() {
        return isHotNews;
    }

    public void setIsHotNews(String isHotNews) {
        this.isHotNews = isHotNews == null ? null : isHotNews.trim();
    }
}