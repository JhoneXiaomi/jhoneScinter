package com.scinter.www.model;

import com.scinter.www.util.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CasesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public CasesExample() {
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

        public Criteria andCaseIdIsNull() {
            addCriterion("case_id is null");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNotNull() {
            addCriterion("case_id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseIdEqualTo(Integer value) {
            addCriterion("case_id =", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotEqualTo(Integer value) {
            addCriterion("case_id <>", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThan(Integer value) {
            addCriterion("case_id >", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_id >=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThan(Integer value) {
            addCriterion("case_id <", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("case_id <=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdIn(List<Integer> values) {
            addCriterion("case_id in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotIn(List<Integer> values) {
            addCriterion("case_id not in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdBetween(Integer value1, Integer value2) {
            addCriterion("case_id between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("case_id not between", value1, value2, "caseId");
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

        public Criteria andCaseTitleIsNull() {
            addCriterion("case_title is null");
            return (Criteria) this;
        }

        public Criteria andCaseTitleIsNotNull() {
            addCriterion("case_title is not null");
            return (Criteria) this;
        }

        public Criteria andCaseTitleEqualTo(String value) {
            addCriterion("case_title =", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleNotEqualTo(String value) {
            addCriterion("case_title <>", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleGreaterThan(String value) {
            addCriterion("case_title >", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleGreaterThanOrEqualTo(String value) {
            addCriterion("case_title >=", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleLessThan(String value) {
            addCriterion("case_title <", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleLessThanOrEqualTo(String value) {
            addCriterion("case_title <=", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleLike(String value) {
            addCriterion("case_title like", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleNotLike(String value) {
            addCriterion("case_title not like", value, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleIn(List<String> values) {
            addCriterion("case_title in", values, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleNotIn(List<String> values) {
            addCriterion("case_title not in", values, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleBetween(String value1, String value2) {
            addCriterion("case_title between", value1, value2, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseTitleNotBetween(String value1, String value2) {
            addCriterion("case_title not between", value1, value2, "caseTitle");
            return (Criteria) this;
        }

        public Criteria andCaseDescIsNull() {
            addCriterion("case_desc is null");
            return (Criteria) this;
        }

        public Criteria andCaseDescIsNotNull() {
            addCriterion("case_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCaseDescEqualTo(String value) {
            addCriterion("case_desc =", value, "caseDesc");
            return (Criteria) this;
        }

        public Criteria andCaseDescNotEqualTo(String value) {
            addCriterion("case_desc <>", value, "caseDesc");
            return (Criteria) this;
        }

        public Criteria andCaseDescGreaterThan(String value) {
            addCriterion("case_desc >", value, "caseDesc");
            return (Criteria) this;
        }

        public Criteria andCaseDescGreaterThanOrEqualTo(String value) {
            addCriterion("case_desc >=", value, "caseDesc");
            return (Criteria) this;
        }

        public Criteria andCaseDescLessThan(String value) {
            addCriterion("case_desc <", value, "caseDesc");
            return (Criteria) this;
        }

        public Criteria andCaseDescLessThanOrEqualTo(String value) {
            addCriterion("case_desc <=", value, "caseDesc");
            return (Criteria) this;
        }

        public Criteria andCaseDescLike(String value) {
            addCriterion("case_desc like", value, "caseDesc");
            return (Criteria) this;
        }

        public Criteria andCaseDescNotLike(String value) {
            addCriterion("case_desc not like", value, "caseDesc");
            return (Criteria) this;
        }

        public Criteria andCaseDescIn(List<String> values) {
            addCriterion("case_desc in", values, "caseDesc");
            return (Criteria) this;
        }

        public Criteria andCaseDescNotIn(List<String> values) {
            addCriterion("case_desc not in", values, "caseDesc");
            return (Criteria) this;
        }

        public Criteria andCaseDescBetween(String value1, String value2) {
            addCriterion("case_desc between", value1, value2, "caseDesc");
            return (Criteria) this;
        }

        public Criteria andCaseDescNotBetween(String value1, String value2) {
            addCriterion("case_desc not between", value1, value2, "caseDesc");
            return (Criteria) this;
        }

        public Criteria andCaseStyleIsNull() {
            addCriterion("case_style is null");
            return (Criteria) this;
        }

        public Criteria andCaseStyleIsNotNull() {
            addCriterion("case_style is not null");
            return (Criteria) this;
        }

        public Criteria andCaseStyleEqualTo(String value) {
            addCriterion("case_style =", value, "caseStyle");
            return (Criteria) this;
        }

        public Criteria andCaseStyleNotEqualTo(String value) {
            addCriterion("case_style <>", value, "caseStyle");
            return (Criteria) this;
        }

        public Criteria andCaseStyleGreaterThan(String value) {
            addCriterion("case_style >", value, "caseStyle");
            return (Criteria) this;
        }

        public Criteria andCaseStyleGreaterThanOrEqualTo(String value) {
            addCriterion("case_style >=", value, "caseStyle");
            return (Criteria) this;
        }

        public Criteria andCaseStyleLessThan(String value) {
            addCriterion("case_style <", value, "caseStyle");
            return (Criteria) this;
        }

        public Criteria andCaseStyleLessThanOrEqualTo(String value) {
            addCriterion("case_style <=", value, "caseStyle");
            return (Criteria) this;
        }

        public Criteria andCaseStyleLike(String value) {
            addCriterion("case_style like", value, "caseStyle");
            return (Criteria) this;
        }

        public Criteria andCaseStyleNotLike(String value) {
            addCriterion("case_style not like", value, "caseStyle");
            return (Criteria) this;
        }

        public Criteria andCaseStyleIn(List<String> values) {
            addCriterion("case_style in", values, "caseStyle");
            return (Criteria) this;
        }

        public Criteria andCaseStyleNotIn(List<String> values) {
            addCriterion("case_style not in", values, "caseStyle");
            return (Criteria) this;
        }

        public Criteria andCaseStyleBetween(String value1, String value2) {
            addCriterion("case_style between", value1, value2, "caseStyle");
            return (Criteria) this;
        }

        public Criteria andCaseStyleNotBetween(String value1, String value2) {
            addCriterion("case_style not between", value1, value2, "caseStyle");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyIsNull() {
            addCriterion("case_money is null");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyIsNotNull() {
            addCriterion("case_money is not null");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyEqualTo(String value) {
            addCriterion("case_money =", value, "caseMoney");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyNotEqualTo(String value) {
            addCriterion("case_money <>", value, "caseMoney");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyGreaterThan(String value) {
            addCriterion("case_money >", value, "caseMoney");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("case_money >=", value, "caseMoney");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyLessThan(String value) {
            addCriterion("case_money <", value, "caseMoney");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyLessThanOrEqualTo(String value) {
            addCriterion("case_money <=", value, "caseMoney");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyLike(String value) {
            addCriterion("case_money like", value, "caseMoney");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyNotLike(String value) {
            addCriterion("case_money not like", value, "caseMoney");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyIn(List<String> values) {
            addCriterion("case_money in", values, "caseMoney");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyNotIn(List<String> values) {
            addCriterion("case_money not in", values, "caseMoney");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyBetween(String value1, String value2) {
            addCriterion("case_money between", value1, value2, "caseMoney");
            return (Criteria) this;
        }

        public Criteria andCaseMoneyNotBetween(String value1, String value2) {
            addCriterion("case_money not between", value1, value2, "caseMoney");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityIsNull() {
            addCriterion("case_community is null");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityIsNotNull() {
            addCriterion("case_community is not null");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityEqualTo(String value) {
            addCriterion("case_community =", value, "caseCommunity");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityNotEqualTo(String value) {
            addCriterion("case_community <>", value, "caseCommunity");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityGreaterThan(String value) {
            addCriterion("case_community >", value, "caseCommunity");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityGreaterThanOrEqualTo(String value) {
            addCriterion("case_community >=", value, "caseCommunity");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityLessThan(String value) {
            addCriterion("case_community <", value, "caseCommunity");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityLessThanOrEqualTo(String value) {
            addCriterion("case_community <=", value, "caseCommunity");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityLike(String value) {
            addCriterion("case_community like", value, "caseCommunity");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityNotLike(String value) {
            addCriterion("case_community not like", value, "caseCommunity");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityIn(List<String> values) {
            addCriterion("case_community in", values, "caseCommunity");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityNotIn(List<String> values) {
            addCriterion("case_community not in", values, "caseCommunity");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityBetween(String value1, String value2) {
            addCriterion("case_community between", value1, value2, "caseCommunity");
            return (Criteria) this;
        }

        public Criteria andCaseCommunityNotBetween(String value1, String value2) {
            addCriterion("case_community not between", value1, value2, "caseCommunity");
            return (Criteria) this;
        }

        public Criteria andCaseAcreageIsNull() {
            addCriterion("case_acreage is null");
            return (Criteria) this;
        }

        public Criteria andCaseAcreageIsNotNull() {
            addCriterion("case_acreage is not null");
            return (Criteria) this;
        }

        public Criteria andCaseAcreageEqualTo(Double value) {
            addCriterion("case_acreage =", value, "caseAcreage");
            return (Criteria) this;
        }

        public Criteria andCaseAcreageNotEqualTo(Double value) {
            addCriterion("case_acreage <>", value, "caseAcreage");
            return (Criteria) this;
        }

        public Criteria andCaseAcreageGreaterThan(Double value) {
            addCriterion("case_acreage >", value, "caseAcreage");
            return (Criteria) this;
        }

        public Criteria andCaseAcreageGreaterThanOrEqualTo(Double value) {
            addCriterion("case_acreage >=", value, "caseAcreage");
            return (Criteria) this;
        }

        public Criteria andCaseAcreageLessThan(Double value) {
            addCriterion("case_acreage <", value, "caseAcreage");
            return (Criteria) this;
        }

        public Criteria andCaseAcreageLessThanOrEqualTo(Double value) {
            addCriterion("case_acreage <=", value, "caseAcreage");
            return (Criteria) this;
        }

        public Criteria andCaseAcreageIn(List<Double> values) {
            addCriterion("case_acreage in", values, "caseAcreage");
            return (Criteria) this;
        }

        public Criteria andCaseAcreageNotIn(List<Double> values) {
            addCriterion("case_acreage not in", values, "caseAcreage");
            return (Criteria) this;
        }

        public Criteria andCaseAcreageBetween(Double value1, Double value2) {
            addCriterion("case_acreage between", value1, value2, "caseAcreage");
            return (Criteria) this;
        }

        public Criteria andCaseAcreageNotBetween(Double value1, Double value2) {
            addCriterion("case_acreage not between", value1, value2, "caseAcreage");
            return (Criteria) this;
        }

        public Criteria andCaseAreaIsNull() {
            addCriterion("case_area is null");
            return (Criteria) this;
        }

        public Criteria andCaseAreaIsNotNull() {
            addCriterion("case_area is not null");
            return (Criteria) this;
        }

        public Criteria andCaseAreaEqualTo(String value) {
            addCriterion("case_area =", value, "caseArea");
            return (Criteria) this;
        }

        public Criteria andCaseAreaNotEqualTo(String value) {
            addCriterion("case_area <>", value, "caseArea");
            return (Criteria) this;
        }

        public Criteria andCaseAreaGreaterThan(String value) {
            addCriterion("case_area >", value, "caseArea");
            return (Criteria) this;
        }

        public Criteria andCaseAreaGreaterThanOrEqualTo(String value) {
            addCriterion("case_area >=", value, "caseArea");
            return (Criteria) this;
        }

        public Criteria andCaseAreaLessThan(String value) {
            addCriterion("case_area <", value, "caseArea");
            return (Criteria) this;
        }

        public Criteria andCaseAreaLessThanOrEqualTo(String value) {
            addCriterion("case_area <=", value, "caseArea");
            return (Criteria) this;
        }

        public Criteria andCaseAreaLike(String value) {
            addCriterion("case_area like", value, "caseArea");
            return (Criteria) this;
        }

        public Criteria andCaseAreaNotLike(String value) {
            addCriterion("case_area not like", value, "caseArea");
            return (Criteria) this;
        }

        public Criteria andCaseAreaIn(List<String> values) {
            addCriterion("case_area in", values, "caseArea");
            return (Criteria) this;
        }

        public Criteria andCaseAreaNotIn(List<String> values) {
            addCriterion("case_area not in", values, "caseArea");
            return (Criteria) this;
        }

        public Criteria andCaseAreaBetween(String value1, String value2) {
            addCriterion("case_area between", value1, value2, "caseArea");
            return (Criteria) this;
        }

        public Criteria andCaseAreaNotBetween(String value1, String value2) {
            addCriterion("case_area not between", value1, value2, "caseArea");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeIsNull() {
            addCriterion("case_house_type is null");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeIsNotNull() {
            addCriterion("case_house_type is not null");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeEqualTo(String value) {
            addCriterion("case_house_type =", value, "caseHouseType");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeNotEqualTo(String value) {
            addCriterion("case_house_type <>", value, "caseHouseType");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeGreaterThan(String value) {
            addCriterion("case_house_type >", value, "caseHouseType");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("case_house_type >=", value, "caseHouseType");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeLessThan(String value) {
            addCriterion("case_house_type <", value, "caseHouseType");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeLessThanOrEqualTo(String value) {
            addCriterion("case_house_type <=", value, "caseHouseType");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeLike(String value) {
            addCriterion("case_house_type like", value, "caseHouseType");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeNotLike(String value) {
            addCriterion("case_house_type not like", value, "caseHouseType");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeIn(List<String> values) {
            addCriterion("case_house_type in", values, "caseHouseType");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeNotIn(List<String> values) {
            addCriterion("case_house_type not in", values, "caseHouseType");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeBetween(String value1, String value2) {
            addCriterion("case_house_type between", value1, value2, "caseHouseType");
            return (Criteria) this;
        }

        public Criteria andCaseHouseTypeNotBetween(String value1, String value2) {
            addCriterion("case_house_type not between", value1, value2, "caseHouseType");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerIsNull() {
            addCriterion("case_designer is null");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerIsNotNull() {
            addCriterion("case_designer is not null");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerEqualTo(String value) {
            addCriterion("case_designer =", value, "caseDesigner");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerNotEqualTo(String value) {
            addCriterion("case_designer <>", value, "caseDesigner");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerGreaterThan(String value) {
            addCriterion("case_designer >", value, "caseDesigner");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerGreaterThanOrEqualTo(String value) {
            addCriterion("case_designer >=", value, "caseDesigner");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerLessThan(String value) {
            addCriterion("case_designer <", value, "caseDesigner");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerLessThanOrEqualTo(String value) {
            addCriterion("case_designer <=", value, "caseDesigner");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerLike(String value) {
            addCriterion("case_designer like", value, "caseDesigner");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerNotLike(String value) {
            addCriterion("case_designer not like", value, "caseDesigner");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerIn(List<String> values) {
            addCriterion("case_designer in", values, "caseDesigner");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerNotIn(List<String> values) {
            addCriterion("case_designer not in", values, "caseDesigner");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerBetween(String value1, String value2) {
            addCriterion("case_designer between", value1, value2, "caseDesigner");
            return (Criteria) this;
        }

        public Criteria andCaseDesignerNotBetween(String value1, String value2) {
            addCriterion("case_designer not between", value1, value2, "caseDesigner");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgIsNull() {
            addCriterion("case_thumb_img is null");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgIsNotNull() {
            addCriterion("case_thumb_img is not null");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgEqualTo(String value) {
            addCriterion("case_thumb_img =", value, "caseThumbImg");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgNotEqualTo(String value) {
            addCriterion("case_thumb_img <>", value, "caseThumbImg");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgGreaterThan(String value) {
            addCriterion("case_thumb_img >", value, "caseThumbImg");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgGreaterThanOrEqualTo(String value) {
            addCriterion("case_thumb_img >=", value, "caseThumbImg");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgLessThan(String value) {
            addCriterion("case_thumb_img <", value, "caseThumbImg");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgLessThanOrEqualTo(String value) {
            addCriterion("case_thumb_img <=", value, "caseThumbImg");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgLike(String value) {
            addCriterion("case_thumb_img like", value, "caseThumbImg");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgNotLike(String value) {
            addCriterion("case_thumb_img not like", value, "caseThumbImg");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgIn(List<String> values) {
            addCriterion("case_thumb_img in", values, "caseThumbImg");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgNotIn(List<String> values) {
            addCriterion("case_thumb_img not in", values, "caseThumbImg");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgBetween(String value1, String value2) {
            addCriterion("case_thumb_img between", value1, value2, "caseThumbImg");
            return (Criteria) this;
        }

        public Criteria andCaseThumbImgNotBetween(String value1, String value2) {
            addCriterion("case_thumb_img not between", value1, value2, "caseThumbImg");
            return (Criteria) this;
        }

        public Criteria andCaseReadNumIsNull() {
            addCriterion("case_read_num is null");
            return (Criteria) this;
        }

        public Criteria andCaseReadNumIsNotNull() {
            addCriterion("case_read_num is not null");
            return (Criteria) this;
        }

        public Criteria andCaseReadNumEqualTo(Integer value) {
            addCriterion("case_read_num =", value, "caseReadNum");
            return (Criteria) this;
        }

        public Criteria andCaseReadNumNotEqualTo(Integer value) {
            addCriterion("case_read_num <>", value, "caseReadNum");
            return (Criteria) this;
        }

        public Criteria andCaseReadNumGreaterThan(Integer value) {
            addCriterion("case_read_num >", value, "caseReadNum");
            return (Criteria) this;
        }

        public Criteria andCaseReadNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_read_num >=", value, "caseReadNum");
            return (Criteria) this;
        }

        public Criteria andCaseReadNumLessThan(Integer value) {
            addCriterion("case_read_num <", value, "caseReadNum");
            return (Criteria) this;
        }

        public Criteria andCaseReadNumLessThanOrEqualTo(Integer value) {
            addCriterion("case_read_num <=", value, "caseReadNum");
            return (Criteria) this;
        }

        public Criteria andCaseReadNumIn(List<Integer> values) {
            addCriterion("case_read_num in", values, "caseReadNum");
            return (Criteria) this;
        }

        public Criteria andCaseReadNumNotIn(List<Integer> values) {
            addCriterion("case_read_num not in", values, "caseReadNum");
            return (Criteria) this;
        }

        public Criteria andCaseReadNumBetween(Integer value1, Integer value2) {
            addCriterion("case_read_num between", value1, value2, "caseReadNum");
            return (Criteria) this;
        }

        public Criteria andCaseReadNumNotBetween(Integer value1, Integer value2) {
            addCriterion("case_read_num not between", value1, value2, "caseReadNum");
            return (Criteria) this;
        }

        public Criteria andSeoTitleIsNull() {
            addCriterion("seo_title is null");
            return (Criteria) this;
        }

        public Criteria andSeoTitleIsNotNull() {
            addCriterion("seo_title is not null");
            return (Criteria) this;
        }

        public Criteria andSeoTitleEqualTo(String value) {
            addCriterion("seo_title =", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotEqualTo(String value) {
            addCriterion("seo_title <>", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleGreaterThan(String value) {
            addCriterion("seo_title >", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("seo_title >=", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleLessThan(String value) {
            addCriterion("seo_title <", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleLessThanOrEqualTo(String value) {
            addCriterion("seo_title <=", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleLike(String value) {
            addCriterion("seo_title like", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotLike(String value) {
            addCriterion("seo_title not like", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleIn(List<String> values) {
            addCriterion("seo_title in", values, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotIn(List<String> values) {
            addCriterion("seo_title not in", values, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleBetween(String value1, String value2) {
            addCriterion("seo_title between", value1, value2, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotBetween(String value1, String value2) {
            addCriterion("seo_title not between", value1, value2, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordIsNull() {
            addCriterion("seo_keyword is null");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordIsNotNull() {
            addCriterion("seo_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordEqualTo(String value) {
            addCriterion("seo_keyword =", value, "seoKeyword");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordNotEqualTo(String value) {
            addCriterion("seo_keyword <>", value, "seoKeyword");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordGreaterThan(String value) {
            addCriterion("seo_keyword >", value, "seoKeyword");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("seo_keyword >=", value, "seoKeyword");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordLessThan(String value) {
            addCriterion("seo_keyword <", value, "seoKeyword");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordLessThanOrEqualTo(String value) {
            addCriterion("seo_keyword <=", value, "seoKeyword");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordLike(String value) {
            addCriterion("seo_keyword like", value, "seoKeyword");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordNotLike(String value) {
            addCriterion("seo_keyword not like", value, "seoKeyword");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordIn(List<String> values) {
            addCriterion("seo_keyword in", values, "seoKeyword");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordNotIn(List<String> values) {
            addCriterion("seo_keyword not in", values, "seoKeyword");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordBetween(String value1, String value2) {
            addCriterion("seo_keyword between", value1, value2, "seoKeyword");
            return (Criteria) this;
        }

        public Criteria andSeoKeywordNotBetween(String value1, String value2) {
            addCriterion("seo_keyword not between", value1, value2, "seoKeyword");
            return (Criteria) this;
        }

        public Criteria andSeoDescIsNull() {
            addCriterion("seo_desc is null");
            return (Criteria) this;
        }

        public Criteria andSeoDescIsNotNull() {
            addCriterion("seo_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSeoDescEqualTo(String value) {
            addCriterion("seo_desc =", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescNotEqualTo(String value) {
            addCriterion("seo_desc <>", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescGreaterThan(String value) {
            addCriterion("seo_desc >", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescGreaterThanOrEqualTo(String value) {
            addCriterion("seo_desc >=", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescLessThan(String value) {
            addCriterion("seo_desc <", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescLessThanOrEqualTo(String value) {
            addCriterion("seo_desc <=", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescLike(String value) {
            addCriterion("seo_desc like", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescNotLike(String value) {
            addCriterion("seo_desc not like", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescIn(List<String> values) {
            addCriterion("seo_desc in", values, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescNotIn(List<String> values) {
            addCriterion("seo_desc not in", values, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescBetween(String value1, String value2) {
            addCriterion("seo_desc between", value1, value2, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescNotBetween(String value1, String value2) {
            addCriterion("seo_desc not between", value1, value2, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseIsNull() {
            addCriterion("is_hot_case is null");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseIsNotNull() {
            addCriterion("is_hot_case is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseEqualTo(String value) {
            addCriterion("is_hot_case =", value, "isHotCase");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseNotEqualTo(String value) {
            addCriterion("is_hot_case <>", value, "isHotCase");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseGreaterThan(String value) {
            addCriterion("is_hot_case >", value, "isHotCase");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseGreaterThanOrEqualTo(String value) {
            addCriterion("is_hot_case >=", value, "isHotCase");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseLessThan(String value) {
            addCriterion("is_hot_case <", value, "isHotCase");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseLessThanOrEqualTo(String value) {
            addCriterion("is_hot_case <=", value, "isHotCase");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseLike(String value) {
            addCriterion("is_hot_case like", value, "isHotCase");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseNotLike(String value) {
            addCriterion("is_hot_case not like", value, "isHotCase");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseIn(List<String> values) {
            addCriterion("is_hot_case in", values, "isHotCase");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseNotIn(List<String> values) {
            addCriterion("is_hot_case not in", values, "isHotCase");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseBetween(String value1, String value2) {
            addCriterion("is_hot_case between", value1, value2, "isHotCase");
            return (Criteria) this;
        }

        public Criteria andIsHotCaseNotBetween(String value1, String value2) {
            addCriterion("is_hot_case not between", value1, value2, "isHotCase");
            return (Criteria) this;
        }

        public Criteria andCaseStatusIsNull() {
            addCriterion("case_status is null");
            return (Criteria) this;
        }

        public Criteria andCaseStatusIsNotNull() {
            addCriterion("case_status is not null");
            return (Criteria) this;
        }

        public Criteria andCaseStatusEqualTo(Integer value) {
            addCriterion("case_status =", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotEqualTo(Integer value) {
            addCriterion("case_status <>", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusGreaterThan(Integer value) {
            addCriterion("case_status >", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_status >=", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusLessThan(Integer value) {
            addCriterion("case_status <", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("case_status <=", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusIn(List<Integer> values) {
            addCriterion("case_status in", values, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotIn(List<Integer> values) {
            addCriterion("case_status not in", values, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusBetween(Integer value1, Integer value2) {
            addCriterion("case_status between", value1, value2, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("case_status not between", value1, value2, "caseStatus");
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

        public Criteria andCommunityIdIsNull() {
            addCriterion("community_id is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNotNull() {
            addCriterion("community_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdEqualTo(Integer value) {
            addCriterion("community_id =", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotEqualTo(Integer value) {
            addCriterion("community_id <>", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThan(Integer value) {
            addCriterion("community_id >", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("community_id >=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThan(Integer value) {
            addCriterion("community_id <", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThanOrEqualTo(Integer value) {
            addCriterion("community_id <=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIn(List<Integer> values) {
            addCriterion("community_id in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotIn(List<Integer> values) {
            addCriterion("community_id not in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdBetween(Integer value1, Integer value2) {
            addCriterion("community_id between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("community_id not between", value1, value2, "communityId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andCaseTitleLikeInsensitive(String value) {
            addCriterion("upper(case_title) like", value.toUpperCase(), "caseTitle");
            return this;
        }

        public Criteria andCaseDescLikeInsensitive(String value) {
            addCriterion("upper(case_desc) like", value.toUpperCase(), "caseDesc");
            return this;
        }

        public Criteria andCaseStyleLikeInsensitive(String value) {
            addCriterion("upper(case_style) like", value.toUpperCase(), "caseStyle");
            return this;
        }

        public Criteria andCaseMoneyLikeInsensitive(String value) {
            addCriterion("upper(case_money) like", value.toUpperCase(), "caseMoney");
            return this;
        }

        public Criteria andCaseCommunityLikeInsensitive(String value) {
            addCriterion("upper(case_community) like", value.toUpperCase(), "caseCommunity");
            return this;
        }

        public Criteria andCaseAreaLikeInsensitive(String value) {
            addCriterion("upper(case_area) like", value.toUpperCase(), "caseArea");
            return this;
        }

        public Criteria andCaseHouseTypeLikeInsensitive(String value) {
            addCriterion("upper(case_house_type) like", value.toUpperCase(), "caseHouseType");
            return this;
        }

        public Criteria andCaseDesignerLikeInsensitive(String value) {
            addCriterion("upper(case_designer) like", value.toUpperCase(), "caseDesigner");
            return this;
        }

        public Criteria andCaseThumbImgLikeInsensitive(String value) {
            addCriterion("upper(case_thumb_img) like", value.toUpperCase(), "caseThumbImg");
            return this;
        }

        public Criteria andSeoTitleLikeInsensitive(String value) {
            addCriterion("upper(seo_title) like", value.toUpperCase(), "seoTitle");
            return this;
        }

        public Criteria andSeoKeywordLikeInsensitive(String value) {
            addCriterion("upper(seo_keyword) like", value.toUpperCase(), "seoKeyword");
            return this;
        }

        public Criteria andSeoDescLikeInsensitive(String value) {
            addCriterion("upper(seo_desc) like", value.toUpperCase(), "seoDesc");
            return this;
        }

        public Criteria andIsHotCaseLikeInsensitive(String value) {
            addCriterion("upper(is_hot_case) like", value.toUpperCase(), "isHotCase");
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