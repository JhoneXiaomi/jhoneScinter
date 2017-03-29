package com.scinter.www.model;

import com.scinter.www.util.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotBuildingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public HotBuildingExample() {
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

        public Criteria andBulidingIdIsNull() {
            addCriterion("buliding_id is null");
            return (Criteria) this;
        }

        public Criteria andBulidingIdIsNotNull() {
            addCriterion("buliding_id is not null");
            return (Criteria) this;
        }

        public Criteria andBulidingIdEqualTo(Integer value) {
            addCriterion("buliding_id =", value, "bulidingId");
            return (Criteria) this;
        }

        public Criteria andBulidingIdNotEqualTo(Integer value) {
            addCriterion("buliding_id <>", value, "bulidingId");
            return (Criteria) this;
        }

        public Criteria andBulidingIdGreaterThan(Integer value) {
            addCriterion("buliding_id >", value, "bulidingId");
            return (Criteria) this;
        }

        public Criteria andBulidingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("buliding_id >=", value, "bulidingId");
            return (Criteria) this;
        }

        public Criteria andBulidingIdLessThan(Integer value) {
            addCriterion("buliding_id <", value, "bulidingId");
            return (Criteria) this;
        }

        public Criteria andBulidingIdLessThanOrEqualTo(Integer value) {
            addCriterion("buliding_id <=", value, "bulidingId");
            return (Criteria) this;
        }

        public Criteria andBulidingIdIn(List<Integer> values) {
            addCriterion("buliding_id in", values, "bulidingId");
            return (Criteria) this;
        }

        public Criteria andBulidingIdNotIn(List<Integer> values) {
            addCriterion("buliding_id not in", values, "bulidingId");
            return (Criteria) this;
        }

        public Criteria andBulidingIdBetween(Integer value1, Integer value2) {
            addCriterion("buliding_id between", value1, value2, "bulidingId");
            return (Criteria) this;
        }

        public Criteria andBulidingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("buliding_id not between", value1, value2, "bulidingId");
            return (Criteria) this;
        }

        public Criteria andBulidingNameIsNull() {
            addCriterion("buliding_name is null");
            return (Criteria) this;
        }

        public Criteria andBulidingNameIsNotNull() {
            addCriterion("buliding_name is not null");
            return (Criteria) this;
        }

        public Criteria andBulidingNameEqualTo(String value) {
            addCriterion("buliding_name =", value, "bulidingName");
            return (Criteria) this;
        }

        public Criteria andBulidingNameNotEqualTo(String value) {
            addCriterion("buliding_name <>", value, "bulidingName");
            return (Criteria) this;
        }

        public Criteria andBulidingNameGreaterThan(String value) {
            addCriterion("buliding_name >", value, "bulidingName");
            return (Criteria) this;
        }

        public Criteria andBulidingNameGreaterThanOrEqualTo(String value) {
            addCriterion("buliding_name >=", value, "bulidingName");
            return (Criteria) this;
        }

        public Criteria andBulidingNameLessThan(String value) {
            addCriterion("buliding_name <", value, "bulidingName");
            return (Criteria) this;
        }

        public Criteria andBulidingNameLessThanOrEqualTo(String value) {
            addCriterion("buliding_name <=", value, "bulidingName");
            return (Criteria) this;
        }

        public Criteria andBulidingNameLike(String value) {
            addCriterion("buliding_name like", value, "bulidingName");
            return (Criteria) this;
        }

        public Criteria andBulidingNameNotLike(String value) {
            addCriterion("buliding_name not like", value, "bulidingName");
            return (Criteria) this;
        }

        public Criteria andBulidingNameIn(List<String> values) {
            addCriterion("buliding_name in", values, "bulidingName");
            return (Criteria) this;
        }

        public Criteria andBulidingNameNotIn(List<String> values) {
            addCriterion("buliding_name not in", values, "bulidingName");
            return (Criteria) this;
        }

        public Criteria andBulidingNameBetween(String value1, String value2) {
            addCriterion("buliding_name between", value1, value2, "bulidingName");
            return (Criteria) this;
        }

        public Criteria andBulidingNameNotBetween(String value1, String value2) {
            addCriterion("buliding_name not between", value1, value2, "bulidingName");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaIsNull() {
            addCriterion("buliding_area is null");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaIsNotNull() {
            addCriterion("buliding_area is not null");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaEqualTo(String value) {
            addCriterion("buliding_area =", value, "bulidingArea");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaNotEqualTo(String value) {
            addCriterion("buliding_area <>", value, "bulidingArea");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaGreaterThan(String value) {
            addCriterion("buliding_area >", value, "bulidingArea");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaGreaterThanOrEqualTo(String value) {
            addCriterion("buliding_area >=", value, "bulidingArea");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaLessThan(String value) {
            addCriterion("buliding_area <", value, "bulidingArea");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaLessThanOrEqualTo(String value) {
            addCriterion("buliding_area <=", value, "bulidingArea");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaLike(String value) {
            addCriterion("buliding_area like", value, "bulidingArea");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaNotLike(String value) {
            addCriterion("buliding_area not like", value, "bulidingArea");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaIn(List<String> values) {
            addCriterion("buliding_area in", values, "bulidingArea");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaNotIn(List<String> values) {
            addCriterion("buliding_area not in", values, "bulidingArea");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaBetween(String value1, String value2) {
            addCriterion("buliding_area between", value1, value2, "bulidingArea");
            return (Criteria) this;
        }

        public Criteria andBulidingAreaNotBetween(String value1, String value2) {
            addCriterion("buliding_area not between", value1, value2, "bulidingArea");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgIsNull() {
            addCriterion("buliding_thumb_img is null");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgIsNotNull() {
            addCriterion("buliding_thumb_img is not null");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgEqualTo(String value) {
            addCriterion("buliding_thumb_img =", value, "bulidingThumbImg");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgNotEqualTo(String value) {
            addCriterion("buliding_thumb_img <>", value, "bulidingThumbImg");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgGreaterThan(String value) {
            addCriterion("buliding_thumb_img >", value, "bulidingThumbImg");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgGreaterThanOrEqualTo(String value) {
            addCriterion("buliding_thumb_img >=", value, "bulidingThumbImg");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgLessThan(String value) {
            addCriterion("buliding_thumb_img <", value, "bulidingThumbImg");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgLessThanOrEqualTo(String value) {
            addCriterion("buliding_thumb_img <=", value, "bulidingThumbImg");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgLike(String value) {
            addCriterion("buliding_thumb_img like", value, "bulidingThumbImg");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgNotLike(String value) {
            addCriterion("buliding_thumb_img not like", value, "bulidingThumbImg");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgIn(List<String> values) {
            addCriterion("buliding_thumb_img in", values, "bulidingThumbImg");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgNotIn(List<String> values) {
            addCriterion("buliding_thumb_img not in", values, "bulidingThumbImg");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgBetween(String value1, String value2) {
            addCriterion("buliding_thumb_img between", value1, value2, "bulidingThumbImg");
            return (Criteria) this;
        }

        public Criteria andBulidingThumbImgNotBetween(String value1, String value2) {
            addCriterion("buliding_thumb_img not between", value1, value2, "bulidingThumbImg");
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

        public Criteria andBulidingNameLikeInsensitive(String value) {
            addCriterion("upper(buliding_name) like", value.toUpperCase(), "bulidingName");
            return this;
        }

        public Criteria andBulidingAreaLikeInsensitive(String value) {
            addCriterion("upper(buliding_area) like", value.toUpperCase(), "bulidingArea");
            return this;
        }

        public Criteria andBulidingThumbImgLikeInsensitive(String value) {
            addCriterion("upper(buliding_thumb_img) like", value.toUpperCase(), "bulidingThumbImg");
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