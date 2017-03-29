package com.scinter.www.model;

import com.scinter.www.util.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotBuildingSiteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public HotBuildingSiteExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNull() {
            addCriterion("site_name is null");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNotNull() {
            addCriterion("site_name is not null");
            return (Criteria) this;
        }

        public Criteria andSiteNameEqualTo(String value) {
            addCriterion("site_name =", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotEqualTo(String value) {
            addCriterion("site_name <>", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThan(String value) {
            addCriterion("site_name >", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThanOrEqualTo(String value) {
            addCriterion("site_name >=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThan(String value) {
            addCriterion("site_name <", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThanOrEqualTo(String value) {
            addCriterion("site_name <=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLike(String value) {
            addCriterion("site_name like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotLike(String value) {
            addCriterion("site_name not like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameIn(List<String> values) {
            addCriterion("site_name in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotIn(List<String> values) {
            addCriterion("site_name not in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameBetween(String value1, String value2) {
            addCriterion("site_name between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotBetween(String value1, String value2) {
            addCriterion("site_name not between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteStatusIsNull() {
            addCriterion("site_status is null");
            return (Criteria) this;
        }

        public Criteria andSiteStatusIsNotNull() {
            addCriterion("site_status is not null");
            return (Criteria) this;
        }

        public Criteria andSiteStatusEqualTo(String value) {
            addCriterion("site_status =", value, "siteStatus");
            return (Criteria) this;
        }

        public Criteria andSiteStatusNotEqualTo(String value) {
            addCriterion("site_status <>", value, "siteStatus");
            return (Criteria) this;
        }

        public Criteria andSiteStatusGreaterThan(String value) {
            addCriterion("site_status >", value, "siteStatus");
            return (Criteria) this;
        }

        public Criteria andSiteStatusGreaterThanOrEqualTo(String value) {
            addCriterion("site_status >=", value, "siteStatus");
            return (Criteria) this;
        }

        public Criteria andSiteStatusLessThan(String value) {
            addCriterion("site_status <", value, "siteStatus");
            return (Criteria) this;
        }

        public Criteria andSiteStatusLessThanOrEqualTo(String value) {
            addCriterion("site_status <=", value, "siteStatus");
            return (Criteria) this;
        }

        public Criteria andSiteStatusLike(String value) {
            addCriterion("site_status like", value, "siteStatus");
            return (Criteria) this;
        }

        public Criteria andSiteStatusNotLike(String value) {
            addCriterion("site_status not like", value, "siteStatus");
            return (Criteria) this;
        }

        public Criteria andSiteStatusIn(List<String> values) {
            addCriterion("site_status in", values, "siteStatus");
            return (Criteria) this;
        }

        public Criteria andSiteStatusNotIn(List<String> values) {
            addCriterion("site_status not in", values, "siteStatus");
            return (Criteria) this;
        }

        public Criteria andSiteStatusBetween(String value1, String value2) {
            addCriterion("site_status between", value1, value2, "siteStatus");
            return (Criteria) this;
        }

        public Criteria andSiteStatusNotBetween(String value1, String value2) {
            addCriterion("site_status not between", value1, value2, "siteStatus");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgIsNull() {
            addCriterion("site_thumb_img is null");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgIsNotNull() {
            addCriterion("site_thumb_img is not null");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgEqualTo(String value) {
            addCriterion("site_thumb_img =", value, "siteThumbImg");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgNotEqualTo(String value) {
            addCriterion("site_thumb_img <>", value, "siteThumbImg");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgGreaterThan(String value) {
            addCriterion("site_thumb_img >", value, "siteThumbImg");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgGreaterThanOrEqualTo(String value) {
            addCriterion("site_thumb_img >=", value, "siteThumbImg");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgLessThan(String value) {
            addCriterion("site_thumb_img <", value, "siteThumbImg");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgLessThanOrEqualTo(String value) {
            addCriterion("site_thumb_img <=", value, "siteThumbImg");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgLike(String value) {
            addCriterion("site_thumb_img like", value, "siteThumbImg");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgNotLike(String value) {
            addCriterion("site_thumb_img not like", value, "siteThumbImg");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgIn(List<String> values) {
            addCriterion("site_thumb_img in", values, "siteThumbImg");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgNotIn(List<String> values) {
            addCriterion("site_thumb_img not in", values, "siteThumbImg");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgBetween(String value1, String value2) {
            addCriterion("site_thumb_img between", value1, value2, "siteThumbImg");
            return (Criteria) this;
        }

        public Criteria andSiteThumbImgNotBetween(String value1, String value2) {
            addCriterion("site_thumb_img not between", value1, value2, "siteThumbImg");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNull() {
            addCriterion("house_type is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNotNull() {
            addCriterion("house_type is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeEqualTo(String value) {
            addCriterion("house_type =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(String value) {
            addCriterion("house_type <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(String value) {
            addCriterion("house_type >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("house_type >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(String value) {
            addCriterion("house_type <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(String value) {
            addCriterion("house_type <=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLike(String value) {
            addCriterion("house_type like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotLike(String value) {
            addCriterion("house_type not like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<String> values) {
            addCriterion("house_type in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<String> values) {
            addCriterion("house_type not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(String value1, String value2) {
            addCriterion("house_type between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(String value1, String value2) {
            addCriterion("house_type not between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andCostsIsNull() {
            addCriterion("costs is null");
            return (Criteria) this;
        }

        public Criteria andCostsIsNotNull() {
            addCriterion("costs is not null");
            return (Criteria) this;
        }

        public Criteria andCostsEqualTo(String value) {
            addCriterion("costs =", value, "costs");
            return (Criteria) this;
        }

        public Criteria andCostsNotEqualTo(String value) {
            addCriterion("costs <>", value, "costs");
            return (Criteria) this;
        }

        public Criteria andCostsGreaterThan(String value) {
            addCriterion("costs >", value, "costs");
            return (Criteria) this;
        }

        public Criteria andCostsGreaterThanOrEqualTo(String value) {
            addCriterion("costs >=", value, "costs");
            return (Criteria) this;
        }

        public Criteria andCostsLessThan(String value) {
            addCriterion("costs <", value, "costs");
            return (Criteria) this;
        }

        public Criteria andCostsLessThanOrEqualTo(String value) {
            addCriterion("costs <=", value, "costs");
            return (Criteria) this;
        }

        public Criteria andCostsLike(String value) {
            addCriterion("costs like", value, "costs");
            return (Criteria) this;
        }

        public Criteria andCostsNotLike(String value) {
            addCriterion("costs not like", value, "costs");
            return (Criteria) this;
        }

        public Criteria andCostsIn(List<String> values) {
            addCriterion("costs in", values, "costs");
            return (Criteria) this;
        }

        public Criteria andCostsNotIn(List<String> values) {
            addCriterion("costs not in", values, "costs");
            return (Criteria) this;
        }

        public Criteria andCostsBetween(String value1, String value2) {
            addCriterion("costs between", value1, value2, "costs");
            return (Criteria) this;
        }

        public Criteria andCostsNotBetween(String value1, String value2) {
            addCriterion("costs not between", value1, value2, "costs");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageIsNull() {
            addCriterion("house_acreage is null");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageIsNotNull() {
            addCriterion("house_acreage is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageEqualTo(String value) {
            addCriterion("house_acreage =", value, "houseAcreage");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageNotEqualTo(String value) {
            addCriterion("house_acreage <>", value, "houseAcreage");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageGreaterThan(String value) {
            addCriterion("house_acreage >", value, "houseAcreage");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageGreaterThanOrEqualTo(String value) {
            addCriterion("house_acreage >=", value, "houseAcreage");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageLessThan(String value) {
            addCriterion("house_acreage <", value, "houseAcreage");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageLessThanOrEqualTo(String value) {
            addCriterion("house_acreage <=", value, "houseAcreage");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageLike(String value) {
            addCriterion("house_acreage like", value, "houseAcreage");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageNotLike(String value) {
            addCriterion("house_acreage not like", value, "houseAcreage");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageIn(List<String> values) {
            addCriterion("house_acreage in", values, "houseAcreage");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageNotIn(List<String> values) {
            addCriterion("house_acreage not in", values, "houseAcreage");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageBetween(String value1, String value2) {
            addCriterion("house_acreage between", value1, value2, "houseAcreage");
            return (Criteria) this;
        }

        public Criteria andHouseAcreageNotBetween(String value1, String value2) {
            addCriterion("house_acreage not between", value1, value2, "houseAcreage");
            return (Criteria) this;
        }

        public Criteria andHouseStyleIsNull() {
            addCriterion("house_style is null");
            return (Criteria) this;
        }

        public Criteria andHouseStyleIsNotNull() {
            addCriterion("house_style is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStyleEqualTo(String value) {
            addCriterion("house_style =", value, "houseStyle");
            return (Criteria) this;
        }

        public Criteria andHouseStyleNotEqualTo(String value) {
            addCriterion("house_style <>", value, "houseStyle");
            return (Criteria) this;
        }

        public Criteria andHouseStyleGreaterThan(String value) {
            addCriterion("house_style >", value, "houseStyle");
            return (Criteria) this;
        }

        public Criteria andHouseStyleGreaterThanOrEqualTo(String value) {
            addCriterion("house_style >=", value, "houseStyle");
            return (Criteria) this;
        }

        public Criteria andHouseStyleLessThan(String value) {
            addCriterion("house_style <", value, "houseStyle");
            return (Criteria) this;
        }

        public Criteria andHouseStyleLessThanOrEqualTo(String value) {
            addCriterion("house_style <=", value, "houseStyle");
            return (Criteria) this;
        }

        public Criteria andHouseStyleLike(String value) {
            addCriterion("house_style like", value, "houseStyle");
            return (Criteria) this;
        }

        public Criteria andHouseStyleNotLike(String value) {
            addCriterion("house_style not like", value, "houseStyle");
            return (Criteria) this;
        }

        public Criteria andHouseStyleIn(List<String> values) {
            addCriterion("house_style in", values, "houseStyle");
            return (Criteria) this;
        }

        public Criteria andHouseStyleNotIn(List<String> values) {
            addCriterion("house_style not in", values, "houseStyle");
            return (Criteria) this;
        }

        public Criteria andHouseStyleBetween(String value1, String value2) {
            addCriterion("house_style between", value1, value2, "houseStyle");
            return (Criteria) this;
        }

        public Criteria andHouseStyleNotBetween(String value1, String value2) {
            addCriterion("house_style not between", value1, value2, "houseStyle");
            return (Criteria) this;
        }

        public Criteria andManagerIsNull() {
            addCriterion("manager is null");
            return (Criteria) this;
        }

        public Criteria andManagerIsNotNull() {
            addCriterion("manager is not null");
            return (Criteria) this;
        }

        public Criteria andManagerEqualTo(String value) {
            addCriterion("manager =", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotEqualTo(String value) {
            addCriterion("manager <>", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThan(String value) {
            addCriterion("manager >", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThanOrEqualTo(String value) {
            addCriterion("manager >=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThan(String value) {
            addCriterion("manager <", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThanOrEqualTo(String value) {
            addCriterion("manager <=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLike(String value) {
            addCriterion("manager like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotLike(String value) {
            addCriterion("manager not like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerIn(List<String> values) {
            addCriterion("manager in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotIn(List<String> values) {
            addCriterion("manager not in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerBetween(String value1, String value2) {
            addCriterion("manager between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotBetween(String value1, String value2) {
            addCriterion("manager not between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andDesignerIdIsNull() {
            addCriterion("designer_id is null");
            return (Criteria) this;
        }

        public Criteria andDesignerIdIsNotNull() {
            addCriterion("designer_id is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerIdEqualTo(Integer value) {
            addCriterion("designer_id =", value, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdNotEqualTo(Integer value) {
            addCriterion("designer_id <>", value, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdGreaterThan(Integer value) {
            addCriterion("designer_id >", value, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("designer_id >=", value, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdLessThan(Integer value) {
            addCriterion("designer_id <", value, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdLessThanOrEqualTo(Integer value) {
            addCriterion("designer_id <=", value, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdIn(List<Integer> values) {
            addCriterion("designer_id in", values, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdNotIn(List<Integer> values) {
            addCriterion("designer_id not in", values, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdBetween(Integer value1, Integer value2) {
            addCriterion("designer_id between", value1, value2, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("designer_id not between", value1, value2, "designerId");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNull() {
            addCriterion("read_num is null");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNotNull() {
            addCriterion("read_num is not null");
            return (Criteria) this;
        }

        public Criteria andReadNumEqualTo(Integer value) {
            addCriterion("read_num =", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotEqualTo(Integer value) {
            addCriterion("read_num <>", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThan(Integer value) {
            addCriterion("read_num >", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_num >=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThan(Integer value) {
            addCriterion("read_num <", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThanOrEqualTo(Integer value) {
            addCriterion("read_num <=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumIn(List<Integer> values) {
            addCriterion("read_num in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotIn(List<Integer> values) {
            addCriterion("read_num not in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumBetween(Integer value1, Integer value2) {
            addCriterion("read_num between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotBetween(Integer value1, Integer value2) {
            addCriterion("read_num not between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyIsNull() {
            addCriterion("branch_company is null");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyIsNotNull() {
            addCriterion("branch_company is not null");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyEqualTo(String value) {
            addCriterion("branch_company =", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyNotEqualTo(String value) {
            addCriterion("branch_company <>", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyGreaterThan(String value) {
            addCriterion("branch_company >", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("branch_company >=", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyLessThan(String value) {
            addCriterion("branch_company <", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyLessThanOrEqualTo(String value) {
            addCriterion("branch_company <=", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyLike(String value) {
            addCriterion("branch_company like", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyNotLike(String value) {
            addCriterion("branch_company not like", value, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyIn(List<String> values) {
            addCriterion("branch_company in", values, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyNotIn(List<String> values) {
            addCriterion("branch_company not in", values, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyBetween(String value1, String value2) {
            addCriterion("branch_company between", value1, value2, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andBranchCompanyNotBetween(String value1, String value2) {
            addCriterion("branch_company not between", value1, value2, "branchCompany");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNull() {
            addCriterion("updater is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNotNull() {
            addCriterion("updater is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterEqualTo(String value) {
            addCriterion("updater =", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotEqualTo(String value) {
            addCriterion("updater <>", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThan(String value) {
            addCriterion("updater >", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThanOrEqualTo(String value) {
            addCriterion("updater >=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThan(String value) {
            addCriterion("updater <", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThanOrEqualTo(String value) {
            addCriterion("updater <=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLike(String value) {
            addCriterion("updater like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotLike(String value) {
            addCriterion("updater not like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterIn(List<String> values) {
            addCriterion("updater in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotIn(List<String> values) {
            addCriterion("updater not in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterBetween(String value1, String value2) {
            addCriterion("updater between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotBetween(String value1, String value2) {
            addCriterion("updater not between", value1, value2, "updater");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andSiteNameLikeInsensitive(String value) {
            addCriterion("upper(site_name) like", value.toUpperCase(), "siteName");
            return this;
        }

        public Criteria andSiteStatusLikeInsensitive(String value) {
            addCriterion("upper(site_status) like", value.toUpperCase(), "siteStatus");
            return this;
        }

        public Criteria andSiteThumbImgLikeInsensitive(String value) {
            addCriterion("upper(site_thumb_img) like", value.toUpperCase(), "siteThumbImg");
            return this;
        }

        public Criteria andHouseTypeLikeInsensitive(String value) {
            addCriterion("upper(house_type) like", value.toUpperCase(), "houseType");
            return this;
        }

        public Criteria andCostsLikeInsensitive(String value) {
            addCriterion("upper(costs) like", value.toUpperCase(), "costs");
            return this;
        }

        public Criteria andHouseAcreageLikeInsensitive(String value) {
            addCriterion("upper(house_acreage) like", value.toUpperCase(), "houseAcreage");
            return this;
        }

        public Criteria andHouseStyleLikeInsensitive(String value) {
            addCriterion("upper(house_style) like", value.toUpperCase(), "houseStyle");
            return this;
        }

        public Criteria andManagerLikeInsensitive(String value) {
            addCriterion("upper(manager) like", value.toUpperCase(), "manager");
            return this;
        }

        public Criteria andBranchCompanyLikeInsensitive(String value) {
            addCriterion("upper(branch_company) like", value.toUpperCase(), "branchCompany");
            return this;
        }

        public Criteria andCreaterLikeInsensitive(String value) {
            addCriterion("upper(creater) like", value.toUpperCase(), "creater");
            return this;
        }

        public Criteria andUpdaterLikeInsensitive(String value) {
            addCriterion("upper(updater) like", value.toUpperCase(), "updater");
            return this;
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}