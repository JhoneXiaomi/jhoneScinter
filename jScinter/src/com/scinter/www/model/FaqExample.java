package com.scinter.www.model;

import com.scinter.www.util.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FaqExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public FaqExample() {
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

        public Criteria andFaqIdIsNull() {
            addCriterion("faq_id is null");
            return (Criteria) this;
        }

        public Criteria andFaqIdIsNotNull() {
            addCriterion("faq_id is not null");
            return (Criteria) this;
        }

        public Criteria andFaqIdEqualTo(Integer value) {
            addCriterion("faq_id =", value, "faqId");
            return (Criteria) this;
        }

        public Criteria andFaqIdNotEqualTo(Integer value) {
            addCriterion("faq_id <>", value, "faqId");
            return (Criteria) this;
        }

        public Criteria andFaqIdGreaterThan(Integer value) {
            addCriterion("faq_id >", value, "faqId");
            return (Criteria) this;
        }

        public Criteria andFaqIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("faq_id >=", value, "faqId");
            return (Criteria) this;
        }

        public Criteria andFaqIdLessThan(Integer value) {
            addCriterion("faq_id <", value, "faqId");
            return (Criteria) this;
        }

        public Criteria andFaqIdLessThanOrEqualTo(Integer value) {
            addCriterion("faq_id <=", value, "faqId");
            return (Criteria) this;
        }

        public Criteria andFaqIdIn(List<Integer> values) {
            addCriterion("faq_id in", values, "faqId");
            return (Criteria) this;
        }

        public Criteria andFaqIdNotIn(List<Integer> values) {
            addCriterion("faq_id not in", values, "faqId");
            return (Criteria) this;
        }

        public Criteria andFaqIdBetween(Integer value1, Integer value2) {
            addCriterion("faq_id between", value1, value2, "faqId");
            return (Criteria) this;
        }

        public Criteria andFaqIdNotBetween(Integer value1, Integer value2) {
            addCriterion("faq_id not between", value1, value2, "faqId");
            return (Criteria) this;
        }

        public Criteria andFaqImageIsNull() {
            addCriterion("faq_image is null");
            return (Criteria) this;
        }

        public Criteria andFaqImageIsNotNull() {
            addCriterion("faq_image is not null");
            return (Criteria) this;
        }

        public Criteria andFaqImageEqualTo(String value) {
            addCriterion("faq_image =", value, "faqImage");
            return (Criteria) this;
        }

        public Criteria andFaqImageNotEqualTo(String value) {
            addCriterion("faq_image <>", value, "faqImage");
            return (Criteria) this;
        }

        public Criteria andFaqImageGreaterThan(String value) {
            addCriterion("faq_image >", value, "faqImage");
            return (Criteria) this;
        }

        public Criteria andFaqImageGreaterThanOrEqualTo(String value) {
            addCriterion("faq_image >=", value, "faqImage");
            return (Criteria) this;
        }

        public Criteria andFaqImageLessThan(String value) {
            addCriterion("faq_image <", value, "faqImage");
            return (Criteria) this;
        }

        public Criteria andFaqImageLessThanOrEqualTo(String value) {
            addCriterion("faq_image <=", value, "faqImage");
            return (Criteria) this;
        }

        public Criteria andFaqImageLike(String value) {
            addCriterion("faq_image like", value, "faqImage");
            return (Criteria) this;
        }

        public Criteria andFaqImageNotLike(String value) {
            addCriterion("faq_image not like", value, "faqImage");
            return (Criteria) this;
        }

        public Criteria andFaqImageIn(List<String> values) {
            addCriterion("faq_image in", values, "faqImage");
            return (Criteria) this;
        }

        public Criteria andFaqImageNotIn(List<String> values) {
            addCriterion("faq_image not in", values, "faqImage");
            return (Criteria) this;
        }

        public Criteria andFaqImageBetween(String value1, String value2) {
            addCriterion("faq_image between", value1, value2, "faqImage");
            return (Criteria) this;
        }

        public Criteria andFaqImageNotBetween(String value1, String value2) {
            addCriterion("faq_image not between", value1, value2, "faqImage");
            return (Criteria) this;
        }

        public Criteria andFaqDescIsNull() {
            addCriterion("faq_desc is null");
            return (Criteria) this;
        }

        public Criteria andFaqDescIsNotNull() {
            addCriterion("faq_desc is not null");
            return (Criteria) this;
        }

        public Criteria andFaqDescEqualTo(String value) {
            addCriterion("faq_desc =", value, "faqDesc");
            return (Criteria) this;
        }

        public Criteria andFaqDescNotEqualTo(String value) {
            addCriterion("faq_desc <>", value, "faqDesc");
            return (Criteria) this;
        }

        public Criteria andFaqDescGreaterThan(String value) {
            addCriterion("faq_desc >", value, "faqDesc");
            return (Criteria) this;
        }

        public Criteria andFaqDescGreaterThanOrEqualTo(String value) {
            addCriterion("faq_desc >=", value, "faqDesc");
            return (Criteria) this;
        }

        public Criteria andFaqDescLessThan(String value) {
            addCriterion("faq_desc <", value, "faqDesc");
            return (Criteria) this;
        }

        public Criteria andFaqDescLessThanOrEqualTo(String value) {
            addCriterion("faq_desc <=", value, "faqDesc");
            return (Criteria) this;
        }

        public Criteria andFaqDescLike(String value) {
            addCriterion("faq_desc like", value, "faqDesc");
            return (Criteria) this;
        }

        public Criteria andFaqDescNotLike(String value) {
            addCriterion("faq_desc not like", value, "faqDesc");
            return (Criteria) this;
        }

        public Criteria andFaqDescIn(List<String> values) {
            addCriterion("faq_desc in", values, "faqDesc");
            return (Criteria) this;
        }

        public Criteria andFaqDescNotIn(List<String> values) {
            addCriterion("faq_desc not in", values, "faqDesc");
            return (Criteria) this;
        }

        public Criteria andFaqDescBetween(String value1, String value2) {
            addCriterion("faq_desc between", value1, value2, "faqDesc");
            return (Criteria) this;
        }

        public Criteria andFaqDescNotBetween(String value1, String value2) {
            addCriterion("faq_desc not between", value1, value2, "faqDesc");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerIsNull() {
            addCriterion("faq_answer is null");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerIsNotNull() {
            addCriterion("faq_answer is not null");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerEqualTo(String value) {
            addCriterion("faq_answer =", value, "faqAnswer");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerNotEqualTo(String value) {
            addCriterion("faq_answer <>", value, "faqAnswer");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerGreaterThan(String value) {
            addCriterion("faq_answer >", value, "faqAnswer");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("faq_answer >=", value, "faqAnswer");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerLessThan(String value) {
            addCriterion("faq_answer <", value, "faqAnswer");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerLessThanOrEqualTo(String value) {
            addCriterion("faq_answer <=", value, "faqAnswer");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerLike(String value) {
            addCriterion("faq_answer like", value, "faqAnswer");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerNotLike(String value) {
            addCriterion("faq_answer not like", value, "faqAnswer");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerIn(List<String> values) {
            addCriterion("faq_answer in", values, "faqAnswer");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerNotIn(List<String> values) {
            addCriterion("faq_answer not in", values, "faqAnswer");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerBetween(String value1, String value2) {
            addCriterion("faq_answer between", value1, value2, "faqAnswer");
            return (Criteria) this;
        }

        public Criteria andFaqAnswerNotBetween(String value1, String value2) {
            addCriterion("faq_answer not between", value1, value2, "faqAnswer");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIsNull() {
            addCriterion("faq_type is null");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIsNotNull() {
            addCriterion("faq_type is not null");
            return (Criteria) this;
        }

        public Criteria andFaqTypeEqualTo(String value) {
            addCriterion("faq_type =", value, "faqType");
            return (Criteria) this;
        }

        public Criteria andFaqTypeNotEqualTo(String value) {
            addCriterion("faq_type <>", value, "faqType");
            return (Criteria) this;
        }

        public Criteria andFaqTypeGreaterThan(String value) {
            addCriterion("faq_type >", value, "faqType");
            return (Criteria) this;
        }

        public Criteria andFaqTypeGreaterThanOrEqualTo(String value) {
            addCriterion("faq_type >=", value, "faqType");
            return (Criteria) this;
        }

        public Criteria andFaqTypeLessThan(String value) {
            addCriterion("faq_type <", value, "faqType");
            return (Criteria) this;
        }

        public Criteria andFaqTypeLessThanOrEqualTo(String value) {
            addCriterion("faq_type <=", value, "faqType");
            return (Criteria) this;
        }

        public Criteria andFaqTypeLike(String value) {
            addCriterion("faq_type like", value, "faqType");
            return (Criteria) this;
        }

        public Criteria andFaqTypeNotLike(String value) {
            addCriterion("faq_type not like", value, "faqType");
            return (Criteria) this;
        }

        public Criteria andFaqTypeIn(List<String> values) {
            addCriterion("faq_type in", values, "faqType");
            return (Criteria) this;
        }

        public Criteria andFaqTypeNotIn(List<String> values) {
            addCriterion("faq_type not in", values, "faqType");
            return (Criteria) this;
        }

        public Criteria andFaqTypeBetween(String value1, String value2) {
            addCriterion("faq_type between", value1, value2, "faqType");
            return (Criteria) this;
        }

        public Criteria andFaqTypeNotBetween(String value1, String value2) {
            addCriterion("faq_type not between", value1, value2, "faqType");
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

        public Criteria andFaqStatusIsNull() {
            addCriterion("faq_status is null");
            return (Criteria) this;
        }

        public Criteria andFaqStatusIsNotNull() {
            addCriterion("faq_status is not null");
            return (Criteria) this;
        }

        public Criteria andFaqStatusEqualTo(Integer value) {
            addCriterion("faq_status =", value, "faqStatus");
            return (Criteria) this;
        }

        public Criteria andFaqStatusNotEqualTo(Integer value) {
            addCriterion("faq_status <>", value, "faqStatus");
            return (Criteria) this;
        }

        public Criteria andFaqStatusGreaterThan(Integer value) {
            addCriterion("faq_status >", value, "faqStatus");
            return (Criteria) this;
        }

        public Criteria andFaqStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("faq_status >=", value, "faqStatus");
            return (Criteria) this;
        }

        public Criteria andFaqStatusLessThan(Integer value) {
            addCriterion("faq_status <", value, "faqStatus");
            return (Criteria) this;
        }

        public Criteria andFaqStatusLessThanOrEqualTo(Integer value) {
            addCriterion("faq_status <=", value, "faqStatus");
            return (Criteria) this;
        }

        public Criteria andFaqStatusIn(List<Integer> values) {
            addCriterion("faq_status in", values, "faqStatus");
            return (Criteria) this;
        }

        public Criteria andFaqStatusNotIn(List<Integer> values) {
            addCriterion("faq_status not in", values, "faqStatus");
            return (Criteria) this;
        }

        public Criteria andFaqStatusBetween(Integer value1, Integer value2) {
            addCriterion("faq_status between", value1, value2, "faqStatus");
            return (Criteria) this;
        }

        public Criteria andFaqStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("faq_status not between", value1, value2, "faqStatus");
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

        public Criteria andFaqImageLikeInsensitive(String value) {
            addCriterion("upper(faq_image) like", value.toUpperCase(), "faqImage");
            return this;
        }

        public Criteria andFaqDescLikeInsensitive(String value) {
            addCriterion("upper(faq_desc) like", value.toUpperCase(), "faqDesc");
            return this;
        }

        public Criteria andFaqAnswerLikeInsensitive(String value) {
            addCriterion("upper(faq_answer) like", value.toUpperCase(), "faqAnswer");
            return this;
        }

        public Criteria andFaqTypeLikeInsensitive(String value) {
            addCriterion("upper(faq_type) like", value.toUpperCase(), "faqType");
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