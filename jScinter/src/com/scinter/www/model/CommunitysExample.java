package com.scinter.www.model;

import com.scinter.www.util.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunitysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public CommunitysExample() {
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

        public Criteria andCommunityNameIsNull() {
            addCriterion("community_name is null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNotNull() {
            addCriterion("community_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameEqualTo(String value) {
            addCriterion("community_name =", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotEqualTo(String value) {
            addCriterion("community_name <>", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThan(String value) {
            addCriterion("community_name >", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThanOrEqualTo(String value) {
            addCriterion("community_name >=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThan(String value) {
            addCriterion("community_name <", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThanOrEqualTo(String value) {
            addCriterion("community_name <=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLike(String value) {
            addCriterion("community_name like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotLike(String value) {
            addCriterion("community_name not like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIn(List<String> values) {
            addCriterion("community_name in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotIn(List<String> values) {
            addCriterion("community_name not in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameBetween(String value1, String value2) {
            addCriterion("community_name between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotBetween(String value1, String value2) {
            addCriterion("community_name not between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityImageIsNull() {
            addCriterion("community_image is null");
            return (Criteria) this;
        }

        public Criteria andCommunityImageIsNotNull() {
            addCriterion("community_image is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityImageEqualTo(String value) {
            addCriterion("community_image =", value, "communityImage");
            return (Criteria) this;
        }

        public Criteria andCommunityImageNotEqualTo(String value) {
            addCriterion("community_image <>", value, "communityImage");
            return (Criteria) this;
        }

        public Criteria andCommunityImageGreaterThan(String value) {
            addCriterion("community_image >", value, "communityImage");
            return (Criteria) this;
        }

        public Criteria andCommunityImageGreaterThanOrEqualTo(String value) {
            addCriterion("community_image >=", value, "communityImage");
            return (Criteria) this;
        }

        public Criteria andCommunityImageLessThan(String value) {
            addCriterion("community_image <", value, "communityImage");
            return (Criteria) this;
        }

        public Criteria andCommunityImageLessThanOrEqualTo(String value) {
            addCriterion("community_image <=", value, "communityImage");
            return (Criteria) this;
        }

        public Criteria andCommunityImageLike(String value) {
            addCriterion("community_image like", value, "communityImage");
            return (Criteria) this;
        }

        public Criteria andCommunityImageNotLike(String value) {
            addCriterion("community_image not like", value, "communityImage");
            return (Criteria) this;
        }

        public Criteria andCommunityImageIn(List<String> values) {
            addCriterion("community_image in", values, "communityImage");
            return (Criteria) this;
        }

        public Criteria andCommunityImageNotIn(List<String> values) {
            addCriterion("community_image not in", values, "communityImage");
            return (Criteria) this;
        }

        public Criteria andCommunityImageBetween(String value1, String value2) {
            addCriterion("community_image between", value1, value2, "communityImage");
            return (Criteria) this;
        }

        public Criteria andCommunityImageNotBetween(String value1, String value2) {
            addCriterion("community_image not between", value1, value2, "communityImage");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionIsNull() {
            addCriterion("community_description is null");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionIsNotNull() {
            addCriterion("community_description is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionEqualTo(String value) {
            addCriterion("community_description =", value, "communityDescription");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionNotEqualTo(String value) {
            addCriterion("community_description <>", value, "communityDescription");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionGreaterThan(String value) {
            addCriterion("community_description >", value, "communityDescription");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("community_description >=", value, "communityDescription");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionLessThan(String value) {
            addCriterion("community_description <", value, "communityDescription");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionLessThanOrEqualTo(String value) {
            addCriterion("community_description <=", value, "communityDescription");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionLike(String value) {
            addCriterion("community_description like", value, "communityDescription");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionNotLike(String value) {
            addCriterion("community_description not like", value, "communityDescription");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionIn(List<String> values) {
            addCriterion("community_description in", values, "communityDescription");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionNotIn(List<String> values) {
            addCriterion("community_description not in", values, "communityDescription");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionBetween(String value1, String value2) {
            addCriterion("community_description between", value1, value2, "communityDescription");
            return (Criteria) this;
        }

        public Criteria andCommunityDescriptionNotBetween(String value1, String value2) {
            addCriterion("community_description not between", value1, value2, "communityDescription");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andCommunityCasesIsNull() {
            addCriterion("community_cases is null");
            return (Criteria) this;
        }

        public Criteria andCommunityCasesIsNotNull() {
            addCriterion("community_cases is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityCasesEqualTo(Integer value) {
            addCriterion("community_cases =", value, "communityCases");
            return (Criteria) this;
        }

        public Criteria andCommunityCasesNotEqualTo(Integer value) {
            addCriterion("community_cases <>", value, "communityCases");
            return (Criteria) this;
        }

        public Criteria andCommunityCasesGreaterThan(Integer value) {
            addCriterion("community_cases >", value, "communityCases");
            return (Criteria) this;
        }

        public Criteria andCommunityCasesGreaterThanOrEqualTo(Integer value) {
            addCriterion("community_cases >=", value, "communityCases");
            return (Criteria) this;
        }

        public Criteria andCommunityCasesLessThan(Integer value) {
            addCriterion("community_cases <", value, "communityCases");
            return (Criteria) this;
        }

        public Criteria andCommunityCasesLessThanOrEqualTo(Integer value) {
            addCriterion("community_cases <=", value, "communityCases");
            return (Criteria) this;
        }

        public Criteria andCommunityCasesIn(List<Integer> values) {
            addCriterion("community_cases in", values, "communityCases");
            return (Criteria) this;
        }

        public Criteria andCommunityCasesNotIn(List<Integer> values) {
            addCriterion("community_cases not in", values, "communityCases");
            return (Criteria) this;
        }

        public Criteria andCommunityCasesBetween(Integer value1, Integer value2) {
            addCriterion("community_cases between", value1, value2, "communityCases");
            return (Criteria) this;
        }

        public Criteria andCommunityCasesNotBetween(Integer value1, Integer value2) {
            addCriterion("community_cases not between", value1, value2, "communityCases");
            return (Criteria) this;
        }

        public Criteria andSignNumberIsNull() {
            addCriterion("sign_number is null");
            return (Criteria) this;
        }

        public Criteria andSignNumberIsNotNull() {
            addCriterion("sign_number is not null");
            return (Criteria) this;
        }

        public Criteria andSignNumberEqualTo(Integer value) {
            addCriterion("sign_number =", value, "signNumber");
            return (Criteria) this;
        }

        public Criteria andSignNumberNotEqualTo(Integer value) {
            addCriterion("sign_number <>", value, "signNumber");
            return (Criteria) this;
        }

        public Criteria andSignNumberGreaterThan(Integer value) {
            addCriterion("sign_number >", value, "signNumber");
            return (Criteria) this;
        }

        public Criteria andSignNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_number >=", value, "signNumber");
            return (Criteria) this;
        }

        public Criteria andSignNumberLessThan(Integer value) {
            addCriterion("sign_number <", value, "signNumber");
            return (Criteria) this;
        }

        public Criteria andSignNumberLessThanOrEqualTo(Integer value) {
            addCriterion("sign_number <=", value, "signNumber");
            return (Criteria) this;
        }

        public Criteria andSignNumberIn(List<Integer> values) {
            addCriterion("sign_number in", values, "signNumber");
            return (Criteria) this;
        }

        public Criteria andSignNumberNotIn(List<Integer> values) {
            addCriterion("sign_number not in", values, "signNumber");
            return (Criteria) this;
        }

        public Criteria andSignNumberBetween(Integer value1, Integer value2) {
            addCriterion("sign_number between", value1, value2, "signNumber");
            return (Criteria) this;
        }

        public Criteria andSignNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_number not between", value1, value2, "signNumber");
            return (Criteria) this;
        }

        public Criteria andActivityUrlIsNull() {
            addCriterion("activity_url is null");
            return (Criteria) this;
        }

        public Criteria andActivityUrlIsNotNull() {
            addCriterion("activity_url is not null");
            return (Criteria) this;
        }

        public Criteria andActivityUrlEqualTo(String value) {
            addCriterion("activity_url =", value, "activityUrl");
            return (Criteria) this;
        }

        public Criteria andActivityUrlNotEqualTo(String value) {
            addCriterion("activity_url <>", value, "activityUrl");
            return (Criteria) this;
        }

        public Criteria andActivityUrlGreaterThan(String value) {
            addCriterion("activity_url >", value, "activityUrl");
            return (Criteria) this;
        }

        public Criteria andActivityUrlGreaterThanOrEqualTo(String value) {
            addCriterion("activity_url >=", value, "activityUrl");
            return (Criteria) this;
        }

        public Criteria andActivityUrlLessThan(String value) {
            addCriterion("activity_url <", value, "activityUrl");
            return (Criteria) this;
        }

        public Criteria andActivityUrlLessThanOrEqualTo(String value) {
            addCriterion("activity_url <=", value, "activityUrl");
            return (Criteria) this;
        }

        public Criteria andActivityUrlLike(String value) {
            addCriterion("activity_url like", value, "activityUrl");
            return (Criteria) this;
        }

        public Criteria andActivityUrlNotLike(String value) {
            addCriterion("activity_url not like", value, "activityUrl");
            return (Criteria) this;
        }

        public Criteria andActivityUrlIn(List<String> values) {
            addCriterion("activity_url in", values, "activityUrl");
            return (Criteria) this;
        }

        public Criteria andActivityUrlNotIn(List<String> values) {
            addCriterion("activity_url not in", values, "activityUrl");
            return (Criteria) this;
        }

        public Criteria andActivityUrlBetween(String value1, String value2) {
            addCriterion("activity_url between", value1, value2, "activityUrl");
            return (Criteria) this;
        }

        public Criteria andActivityUrlNotBetween(String value1, String value2) {
            addCriterion("activity_url not between", value1, value2, "activityUrl");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNull() {
            addCriterion("is_hot is null");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNotNull() {
            addCriterion("is_hot is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotEqualTo(String value) {
            addCriterion("is_hot =", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotEqualTo(String value) {
            addCriterion("is_hot <>", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThan(String value) {
            addCriterion("is_hot >", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThanOrEqualTo(String value) {
            addCriterion("is_hot >=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThan(String value) {
            addCriterion("is_hot <", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThanOrEqualTo(String value) {
            addCriterion("is_hot <=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLike(String value) {
            addCriterion("is_hot like", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotLike(String value) {
            addCriterion("is_hot not like", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotIn(List<String> values) {
            addCriterion("is_hot in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotIn(List<String> values) {
            addCriterion("is_hot not in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotBetween(String value1, String value2) {
            addCriterion("is_hot between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotBetween(String value1, String value2) {
            addCriterion("is_hot not between", value1, value2, "isHot");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andCommunityNameLikeInsensitive(String value) {
            addCriterion("upper(community_name) like", value.toUpperCase(), "communityName");
            return this;
        }

        public Criteria andCommunityImageLikeInsensitive(String value) {
            addCriterion("upper(community_image) like", value.toUpperCase(), "communityImage");
            return this;
        }

        public Criteria andCommunityDescriptionLikeInsensitive(String value) {
            addCriterion("upper(community_description) like", value.toUpperCase(), "communityDescription");
            return this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(status) like", value.toUpperCase(), "status");
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

        public Criteria andActivityUrlLikeInsensitive(String value) {
            addCriterion("upper(activity_url) like", value.toUpperCase(), "activityUrl");
            return this;
        }

        public Criteria andIsHotLikeInsensitive(String value) {
            addCriterion("upper(is_hot) like", value.toUpperCase(), "isHot");
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