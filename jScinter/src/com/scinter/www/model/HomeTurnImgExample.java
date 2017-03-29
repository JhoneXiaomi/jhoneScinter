package com.scinter.www.model;

import com.scinter.www.util.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeTurnImgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public HomeTurnImgExample() {
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

        public Criteria andHomeimgIdIsNull() {
            addCriterion("homeImg_id is null");
            return (Criteria) this;
        }

        public Criteria andHomeimgIdIsNotNull() {
            addCriterion("homeImg_id is not null");
            return (Criteria) this;
        }

        public Criteria andHomeimgIdEqualTo(Integer value) {
            addCriterion("homeImg_id =", value, "homeimgId");
            return (Criteria) this;
        }

        public Criteria andHomeimgIdNotEqualTo(Integer value) {
            addCriterion("homeImg_id <>", value, "homeimgId");
            return (Criteria) this;
        }

        public Criteria andHomeimgIdGreaterThan(Integer value) {
            addCriterion("homeImg_id >", value, "homeimgId");
            return (Criteria) this;
        }

        public Criteria andHomeimgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("homeImg_id >=", value, "homeimgId");
            return (Criteria) this;
        }

        public Criteria andHomeimgIdLessThan(Integer value) {
            addCriterion("homeImg_id <", value, "homeimgId");
            return (Criteria) this;
        }

        public Criteria andHomeimgIdLessThanOrEqualTo(Integer value) {
            addCriterion("homeImg_id <=", value, "homeimgId");
            return (Criteria) this;
        }

        public Criteria andHomeimgIdIn(List<Integer> values) {
            addCriterion("homeImg_id in", values, "homeimgId");
            return (Criteria) this;
        }

        public Criteria andHomeimgIdNotIn(List<Integer> values) {
            addCriterion("homeImg_id not in", values, "homeimgId");
            return (Criteria) this;
        }

        public Criteria andHomeimgIdBetween(Integer value1, Integer value2) {
            addCriterion("homeImg_id between", value1, value2, "homeimgId");
            return (Criteria) this;
        }

        public Criteria andHomeimgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("homeImg_id not between", value1, value2, "homeimgId");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlIsNull() {
            addCriterion("homeImg_url is null");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlIsNotNull() {
            addCriterion("homeImg_url is not null");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlEqualTo(String value) {
            addCriterion("homeImg_url =", value, "homeimgUrl");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlNotEqualTo(String value) {
            addCriterion("homeImg_url <>", value, "homeimgUrl");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlGreaterThan(String value) {
            addCriterion("homeImg_url >", value, "homeimgUrl");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("homeImg_url >=", value, "homeimgUrl");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlLessThan(String value) {
            addCriterion("homeImg_url <", value, "homeimgUrl");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlLessThanOrEqualTo(String value) {
            addCriterion("homeImg_url <=", value, "homeimgUrl");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlLike(String value) {
            addCriterion("homeImg_url like", value, "homeimgUrl");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlNotLike(String value) {
            addCriterion("homeImg_url not like", value, "homeimgUrl");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlIn(List<String> values) {
            addCriterion("homeImg_url in", values, "homeimgUrl");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlNotIn(List<String> values) {
            addCriterion("homeImg_url not in", values, "homeimgUrl");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlBetween(String value1, String value2) {
            addCriterion("homeImg_url between", value1, value2, "homeimgUrl");
            return (Criteria) this;
        }

        public Criteria andHomeimgUrlNotBetween(String value1, String value2) {
            addCriterion("homeImg_url not between", value1, value2, "homeimgUrl");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameIsNull() {
            addCriterion("homeImg_name is null");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameIsNotNull() {
            addCriterion("homeImg_name is not null");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameEqualTo(String value) {
            addCriterion("homeImg_name =", value, "homeimgName");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameNotEqualTo(String value) {
            addCriterion("homeImg_name <>", value, "homeimgName");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameGreaterThan(String value) {
            addCriterion("homeImg_name >", value, "homeimgName");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameGreaterThanOrEqualTo(String value) {
            addCriterion("homeImg_name >=", value, "homeimgName");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameLessThan(String value) {
            addCriterion("homeImg_name <", value, "homeimgName");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameLessThanOrEqualTo(String value) {
            addCriterion("homeImg_name <=", value, "homeimgName");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameLike(String value) {
            addCriterion("homeImg_name like", value, "homeimgName");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameNotLike(String value) {
            addCriterion("homeImg_name not like", value, "homeimgName");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameIn(List<String> values) {
            addCriterion("homeImg_name in", values, "homeimgName");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameNotIn(List<String> values) {
            addCriterion("homeImg_name not in", values, "homeimgName");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameBetween(String value1, String value2) {
            addCriterion("homeImg_name between", value1, value2, "homeimgName");
            return (Criteria) this;
        }

        public Criteria andHomeimgNameNotBetween(String value1, String value2) {
            addCriterion("homeImg_name not between", value1, value2, "homeimgName");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcIsNull() {
            addCriterion("homeImg_src is null");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcIsNotNull() {
            addCriterion("homeImg_src is not null");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcEqualTo(String value) {
            addCriterion("homeImg_src =", value, "homeimgSrc");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcNotEqualTo(String value) {
            addCriterion("homeImg_src <>", value, "homeimgSrc");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcGreaterThan(String value) {
            addCriterion("homeImg_src >", value, "homeimgSrc");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcGreaterThanOrEqualTo(String value) {
            addCriterion("homeImg_src >=", value, "homeimgSrc");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcLessThan(String value) {
            addCriterion("homeImg_src <", value, "homeimgSrc");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcLessThanOrEqualTo(String value) {
            addCriterion("homeImg_src <=", value, "homeimgSrc");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcLike(String value) {
            addCriterion("homeImg_src like", value, "homeimgSrc");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcNotLike(String value) {
            addCriterion("homeImg_src not like", value, "homeimgSrc");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcIn(List<String> values) {
            addCriterion("homeImg_src in", values, "homeimgSrc");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcNotIn(List<String> values) {
            addCriterion("homeImg_src not in", values, "homeimgSrc");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcBetween(String value1, String value2) {
            addCriterion("homeImg_src between", value1, value2, "homeimgSrc");
            return (Criteria) this;
        }

        public Criteria andHomeimgSrcNotBetween(String value1, String value2) {
            addCriterion("homeImg_src not between", value1, value2, "homeimgSrc");
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

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltIsNull() {
            addCriterion("homeImg_alt is null");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltIsNotNull() {
            addCriterion("homeImg_alt is not null");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltEqualTo(String value) {
            addCriterion("homeImg_alt =", value, "homeimgAlt");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltNotEqualTo(String value) {
            addCriterion("homeImg_alt <>", value, "homeimgAlt");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltGreaterThan(String value) {
            addCriterion("homeImg_alt >", value, "homeimgAlt");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltGreaterThanOrEqualTo(String value) {
            addCriterion("homeImg_alt >=", value, "homeimgAlt");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltLessThan(String value) {
            addCriterion("homeImg_alt <", value, "homeimgAlt");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltLessThanOrEqualTo(String value) {
            addCriterion("homeImg_alt <=", value, "homeimgAlt");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltLike(String value) {
            addCriterion("homeImg_alt like", value, "homeimgAlt");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltNotLike(String value) {
            addCriterion("homeImg_alt not like", value, "homeimgAlt");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltIn(List<String> values) {
            addCriterion("homeImg_alt in", values, "homeimgAlt");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltNotIn(List<String> values) {
            addCriterion("homeImg_alt not in", values, "homeimgAlt");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltBetween(String value1, String value2) {
            addCriterion("homeImg_alt between", value1, value2, "homeimgAlt");
            return (Criteria) this;
        }

        public Criteria andHomeimgAltNotBetween(String value1, String value2) {
            addCriterion("homeImg_alt not between", value1, value2, "homeimgAlt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andHomeimgUrlLikeInsensitive(String value) {
            addCriterion("upper(homeImg_url) like", value.toUpperCase(), "homeimgUrl");
            return this;
        }

        public Criteria andHomeimgNameLikeInsensitive(String value) {
            addCriterion("upper(homeImg_name) like", value.toUpperCase(), "homeimgName");
            return this;
        }

        public Criteria andHomeimgSrcLikeInsensitive(String value) {
            addCriterion("upper(homeImg_src) like", value.toUpperCase(), "homeimgSrc");
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

        public Criteria andHomeimgAltLikeInsensitive(String value) {
            addCriterion("upper(homeImg_alt) like", value.toUpperCase(), "homeimgAlt");
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