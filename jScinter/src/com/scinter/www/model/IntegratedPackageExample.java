package com.scinter.www.model;

import com.scinter.www.util.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IntegratedPackageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public IntegratedPackageExample() {
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

        public Criteria andIntegratedPackageIdIsNull() {
            addCriterion("Integrated_package_id is null");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageIdIsNotNull() {
            addCriterion("Integrated_package_id is not null");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageIdEqualTo(Integer value) {
            addCriterion("Integrated_package_id =", value, "integratedPackageId");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageIdNotEqualTo(Integer value) {
            addCriterion("Integrated_package_id <>", value, "integratedPackageId");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageIdGreaterThan(Integer value) {
            addCriterion("Integrated_package_id >", value, "integratedPackageId");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Integrated_package_id >=", value, "integratedPackageId");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageIdLessThan(Integer value) {
            addCriterion("Integrated_package_id <", value, "integratedPackageId");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageIdLessThanOrEqualTo(Integer value) {
            addCriterion("Integrated_package_id <=", value, "integratedPackageId");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageIdIn(List<Integer> values) {
            addCriterion("Integrated_package_id in", values, "integratedPackageId");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageIdNotIn(List<Integer> values) {
            addCriterion("Integrated_package_id not in", values, "integratedPackageId");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageIdBetween(Integer value1, Integer value2) {
            addCriterion("Integrated_package_id between", value1, value2, "integratedPackageId");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Integrated_package_id not between", value1, value2, "integratedPackageId");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameIsNull() {
            addCriterion("Integrated_package_name is null");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameIsNotNull() {
            addCriterion("Integrated_package_name is not null");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameEqualTo(String value) {
            addCriterion("Integrated_package_name =", value, "integratedPackageName");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameNotEqualTo(String value) {
            addCriterion("Integrated_package_name <>", value, "integratedPackageName");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameGreaterThan(String value) {
            addCriterion("Integrated_package_name >", value, "integratedPackageName");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameGreaterThanOrEqualTo(String value) {
            addCriterion("Integrated_package_name >=", value, "integratedPackageName");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameLessThan(String value) {
            addCriterion("Integrated_package_name <", value, "integratedPackageName");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameLessThanOrEqualTo(String value) {
            addCriterion("Integrated_package_name <=", value, "integratedPackageName");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameLike(String value) {
            addCriterion("Integrated_package_name like", value, "integratedPackageName");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameNotLike(String value) {
            addCriterion("Integrated_package_name not like", value, "integratedPackageName");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameIn(List<String> values) {
            addCriterion("Integrated_package_name in", values, "integratedPackageName");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameNotIn(List<String> values) {
            addCriterion("Integrated_package_name not in", values, "integratedPackageName");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameBetween(String value1, String value2) {
            addCriterion("Integrated_package_name between", value1, value2, "integratedPackageName");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageNameNotBetween(String value1, String value2) {
            addCriterion("Integrated_package_name not between", value1, value2, "integratedPackageName");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeIsNull() {
            addCriterion("Integrated_package_describe is null");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeIsNotNull() {
            addCriterion("Integrated_package_describe is not null");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeEqualTo(String value) {
            addCriterion("Integrated_package_describe =", value, "integratedPackageDescribe");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeNotEqualTo(String value) {
            addCriterion("Integrated_package_describe <>", value, "integratedPackageDescribe");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeGreaterThan(String value) {
            addCriterion("Integrated_package_describe >", value, "integratedPackageDescribe");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("Integrated_package_describe >=", value, "integratedPackageDescribe");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeLessThan(String value) {
            addCriterion("Integrated_package_describe <", value, "integratedPackageDescribe");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeLessThanOrEqualTo(String value) {
            addCriterion("Integrated_package_describe <=", value, "integratedPackageDescribe");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeLike(String value) {
            addCriterion("Integrated_package_describe like", value, "integratedPackageDescribe");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeNotLike(String value) {
            addCriterion("Integrated_package_describe not like", value, "integratedPackageDescribe");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeIn(List<String> values) {
            addCriterion("Integrated_package_describe in", values, "integratedPackageDescribe");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeNotIn(List<String> values) {
            addCriterion("Integrated_package_describe not in", values, "integratedPackageDescribe");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeBetween(String value1, String value2) {
            addCriterion("Integrated_package_describe between", value1, value2, "integratedPackageDescribe");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageDescribeNotBetween(String value1, String value2) {
            addCriterion("Integrated_package_describe not between", value1, value2, "integratedPackageDescribe");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageIsNull() {
            addCriterion("Integrated_package_image is null");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageIsNotNull() {
            addCriterion("Integrated_package_image is not null");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageEqualTo(String value) {
            addCriterion("Integrated_package_image =", value, "integratedPackageImage");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageNotEqualTo(String value) {
            addCriterion("Integrated_package_image <>", value, "integratedPackageImage");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageGreaterThan(String value) {
            addCriterion("Integrated_package_image >", value, "integratedPackageImage");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageGreaterThanOrEqualTo(String value) {
            addCriterion("Integrated_package_image >=", value, "integratedPackageImage");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageLessThan(String value) {
            addCriterion("Integrated_package_image <", value, "integratedPackageImage");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageLessThanOrEqualTo(String value) {
            addCriterion("Integrated_package_image <=", value, "integratedPackageImage");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageLike(String value) {
            addCriterion("Integrated_package_image like", value, "integratedPackageImage");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageNotLike(String value) {
            addCriterion("Integrated_package_image not like", value, "integratedPackageImage");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageIn(List<String> values) {
            addCriterion("Integrated_package_image in", values, "integratedPackageImage");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageNotIn(List<String> values) {
            addCriterion("Integrated_package_image not in", values, "integratedPackageImage");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageBetween(String value1, String value2) {
            addCriterion("Integrated_package_image between", value1, value2, "integratedPackageImage");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageImageNotBetween(String value1, String value2) {
            addCriterion("Integrated_package_image not between", value1, value2, "integratedPackageImage");
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

        public Criteria andIntegratedPackageStatusIsNull() {
            addCriterion("Integrated_package_status is null");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageStatusIsNotNull() {
            addCriterion("Integrated_package_status is not null");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageStatusEqualTo(Boolean value) {
            addCriterion("Integrated_package_status =", value, "integratedPackageStatus");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageStatusNotEqualTo(Boolean value) {
            addCriterion("Integrated_package_status <>", value, "integratedPackageStatus");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageStatusGreaterThan(Boolean value) {
            addCriterion("Integrated_package_status >", value, "integratedPackageStatus");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("Integrated_package_status >=", value, "integratedPackageStatus");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageStatusLessThan(Boolean value) {
            addCriterion("Integrated_package_status <", value, "integratedPackageStatus");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("Integrated_package_status <=", value, "integratedPackageStatus");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageStatusIn(List<Boolean> values) {
            addCriterion("Integrated_package_status in", values, "integratedPackageStatus");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageStatusNotIn(List<Boolean> values) {
            addCriterion("Integrated_package_status not in", values, "integratedPackageStatus");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("Integrated_package_status between", value1, value2, "integratedPackageStatus");
            return (Criteria) this;
        }

        public Criteria andIntegratedPackageStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("Integrated_package_status not between", value1, value2, "integratedPackageStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andIntegratedPackageNameLikeInsensitive(String value) {
            addCriterion("upper(Integrated_package_name) like", value.toUpperCase(), "integratedPackageName");
            return this;
        }

        public Criteria andIntegratedPackageDescribeLikeInsensitive(String value) {
            addCriterion("upper(Integrated_package_describe) like", value.toUpperCase(), "integratedPackageDescribe");
            return this;
        }

        public Criteria andIntegratedPackageImageLikeInsensitive(String value) {
            addCriterion("upper(Integrated_package_image) like", value.toUpperCase(), "integratedPackageImage");
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

        public Criteria andBranchCompanyLikeInsensitive(String value) {
            addCriterion("upper(branch_company) like", value.toUpperCase(), "branchCompany");
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