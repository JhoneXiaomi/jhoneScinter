package com.scinter.www.model;

import com.scinter.www.util.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RepairExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public RepairExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andRepairIdIsNull() {
            addCriterion("repair_id is null");
            return (Criteria) this;
        }

        public Criteria andRepairIdIsNotNull() {
            addCriterion("repair_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepairIdEqualTo(String value) {
            addCriterion("repair_id =", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotEqualTo(String value) {
            addCriterion("repair_id <>", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdGreaterThan(String value) {
            addCriterion("repair_id >", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdGreaterThanOrEqualTo(String value) {
            addCriterion("repair_id >=", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdLessThan(String value) {
            addCriterion("repair_id <", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdLessThanOrEqualTo(String value) {
            addCriterion("repair_id <=", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdLike(String value) {
            addCriterion("repair_id like", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotLike(String value) {
            addCriterion("repair_id not like", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdIn(List<String> values) {
            addCriterion("repair_id in", values, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotIn(List<String> values) {
            addCriterion("repair_id not in", values, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdBetween(String value1, String value2) {
            addCriterion("repair_id between", value1, value2, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotBetween(String value1, String value2) {
            addCriterion("repair_id not between", value1, value2, "repairId");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNull() {
            addCriterion("client_name is null");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNotNull() {
            addCriterion("client_name is not null");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("client_name =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotEqualTo(String value) {
            addCriterion("client_name <>", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThan(String value) {
            addCriterion("client_name >", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThanOrEqualTo(String value) {
            addCriterion("client_name >=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThan(String value) {
            addCriterion("client_name <", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThanOrEqualTo(String value) {
            addCriterion("client_name <=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLike(String value) {
            addCriterion("client_name like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotLike(String value) {
            addCriterion("client_name not like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameIn(List<String> values) {
            addCriterion("client_name in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotIn(List<String> values) {
            addCriterion("client_name not in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameBetween(String value1, String value2) {
            addCriterion("client_name between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotBetween(String value1, String value2) {
            addCriterion("client_name not between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andBuildNameIsNull() {
            addCriterion("build_name is null");
            return (Criteria) this;
        }

        public Criteria andBuildNameIsNotNull() {
            addCriterion("build_name is not null");
            return (Criteria) this;
        }

        public Criteria andBuildNameEqualTo(String value) {
            addCriterion("build_name =", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotEqualTo(String value) {
            addCriterion("build_name <>", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameGreaterThan(String value) {
            addCriterion("build_name >", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameGreaterThanOrEqualTo(String value) {
            addCriterion("build_name >=", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLessThan(String value) {
            addCriterion("build_name <", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLessThanOrEqualTo(String value) {
            addCriterion("build_name <=", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLike(String value) {
            addCriterion("build_name like", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotLike(String value) {
            addCriterion("build_name not like", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameIn(List<String> values) {
            addCriterion("build_name in", values, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotIn(List<String> values) {
            addCriterion("build_name not in", values, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameBetween(String value1, String value2) {
            addCriterion("build_name between", value1, value2, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotBetween(String value1, String value2) {
            addCriterion("build_name not between", value1, value2, "buildName");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andChargeManagerIsNull() {
            addCriterion("charge_manager is null");
            return (Criteria) this;
        }

        public Criteria andChargeManagerIsNotNull() {
            addCriterion("charge_manager is not null");
            return (Criteria) this;
        }

        public Criteria andChargeManagerEqualTo(String value) {
            addCriterion("charge_manager =", value, "chargeManager");
            return (Criteria) this;
        }

        public Criteria andChargeManagerNotEqualTo(String value) {
            addCriterion("charge_manager <>", value, "chargeManager");
            return (Criteria) this;
        }

        public Criteria andChargeManagerGreaterThan(String value) {
            addCriterion("charge_manager >", value, "chargeManager");
            return (Criteria) this;
        }

        public Criteria andChargeManagerGreaterThanOrEqualTo(String value) {
            addCriterion("charge_manager >=", value, "chargeManager");
            return (Criteria) this;
        }

        public Criteria andChargeManagerLessThan(String value) {
            addCriterion("charge_manager <", value, "chargeManager");
            return (Criteria) this;
        }

        public Criteria andChargeManagerLessThanOrEqualTo(String value) {
            addCriterion("charge_manager <=", value, "chargeManager");
            return (Criteria) this;
        }

        public Criteria andChargeManagerLike(String value) {
            addCriterion("charge_manager like", value, "chargeManager");
            return (Criteria) this;
        }

        public Criteria andChargeManagerNotLike(String value) {
            addCriterion("charge_manager not like", value, "chargeManager");
            return (Criteria) this;
        }

        public Criteria andChargeManagerIn(List<String> values) {
            addCriterion("charge_manager in", values, "chargeManager");
            return (Criteria) this;
        }

        public Criteria andChargeManagerNotIn(List<String> values) {
            addCriterion("charge_manager not in", values, "chargeManager");
            return (Criteria) this;
        }

        public Criteria andChargeManagerBetween(String value1, String value2) {
            addCriterion("charge_manager between", value1, value2, "chargeManager");
            return (Criteria) this;
        }

        public Criteria andChargeManagerNotBetween(String value1, String value2) {
            addCriterion("charge_manager not between", value1, value2, "chargeManager");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerIsNull() {
            addCriterion("charge_designer is null");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerIsNotNull() {
            addCriterion("charge_designer is not null");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerEqualTo(String value) {
            addCriterion("charge_designer =", value, "chargeDesigner");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerNotEqualTo(String value) {
            addCriterion("charge_designer <>", value, "chargeDesigner");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerGreaterThan(String value) {
            addCriterion("charge_designer >", value, "chargeDesigner");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerGreaterThanOrEqualTo(String value) {
            addCriterion("charge_designer >=", value, "chargeDesigner");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerLessThan(String value) {
            addCriterion("charge_designer <", value, "chargeDesigner");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerLessThanOrEqualTo(String value) {
            addCriterion("charge_designer <=", value, "chargeDesigner");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerLike(String value) {
            addCriterion("charge_designer like", value, "chargeDesigner");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerNotLike(String value) {
            addCriterion("charge_designer not like", value, "chargeDesigner");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerIn(List<String> values) {
            addCriterion("charge_designer in", values, "chargeDesigner");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerNotIn(List<String> values) {
            addCriterion("charge_designer not in", values, "chargeDesigner");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerBetween(String value1, String value2) {
            addCriterion("charge_designer between", value1, value2, "chargeDesigner");
            return (Criteria) this;
        }

        public Criteria andChargeDesignerNotBetween(String value1, String value2) {
            addCriterion("charge_designer not between", value1, value2, "chargeDesigner");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNull() {
            addCriterion("repair_time is null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNotNull() {
            addCriterion("repair_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeEqualTo(Date value) {
            addCriterion("repair_time =", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotEqualTo(Date value) {
            addCriterion("repair_time <>", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThan(Date value) {
            addCriterion("repair_time >", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("repair_time >=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThan(Date value) {
            addCriterion("repair_time <", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThanOrEqualTo(Date value) {
            addCriterion("repair_time <=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIn(List<Date> values) {
            addCriterion("repair_time in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotIn(List<Date> values) {
            addCriterion("repair_time not in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeBetween(Date value1, Date value2) {
            addCriterion("repair_time between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotBetween(Date value1, Date value2) {
            addCriterion("repair_time not between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTypeIsNull() {
            addCriterion("repair_type is null");
            return (Criteria) this;
        }

        public Criteria andRepairTypeIsNotNull() {
            addCriterion("repair_type is not null");
            return (Criteria) this;
        }

        public Criteria andRepairTypeEqualTo(String value) {
            addCriterion("repair_type =", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeNotEqualTo(String value) {
            addCriterion("repair_type <>", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeGreaterThan(String value) {
            addCriterion("repair_type >", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeGreaterThanOrEqualTo(String value) {
            addCriterion("repair_type >=", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeLessThan(String value) {
            addCriterion("repair_type <", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeLessThanOrEqualTo(String value) {
            addCriterion("repair_type <=", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeLike(String value) {
            addCriterion("repair_type like", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeNotLike(String value) {
            addCriterion("repair_type not like", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeIn(List<String> values) {
            addCriterion("repair_type in", values, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeNotIn(List<String> values) {
            addCriterion("repair_type not in", values, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeBetween(String value1, String value2) {
            addCriterion("repair_type between", value1, value2, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeNotBetween(String value1, String value2) {
            addCriterion("repair_type not between", value1, value2, "repairType");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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

        public Criteria andRepairStatusIsNull() {
            addCriterion("repair_status is null");
            return (Criteria) this;
        }

        public Criteria andRepairStatusIsNotNull() {
            addCriterion("repair_status is not null");
            return (Criteria) this;
        }

        public Criteria andRepairStatusEqualTo(Integer value) {
            addCriterion("repair_status =", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotEqualTo(Integer value) {
            addCriterion("repair_status <>", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusGreaterThan(Integer value) {
            addCriterion("repair_status >", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("repair_status >=", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusLessThan(Integer value) {
            addCriterion("repair_status <", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusLessThanOrEqualTo(Integer value) {
            addCriterion("repair_status <=", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusIn(List<Integer> values) {
            addCriterion("repair_status in", values, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotIn(List<Integer> values) {
            addCriterion("repair_status not in", values, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusBetween(Integer value1, Integer value2) {
            addCriterion("repair_status between", value1, value2, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("repair_status not between", value1, value2, "repairStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andRepairIdLikeInsensitive(String value) {
            addCriterion("upper(repair_id) like", value.toUpperCase(), "repairId");
            return this;
        }

        public Criteria andClientNameLikeInsensitive(String value) {
            addCriterion("upper(client_name) like", value.toUpperCase(), "clientName");
            return this;
        }

        public Criteria andSexLikeInsensitive(String value) {
            addCriterion("upper(sex) like", value.toUpperCase(), "sex");
            return this;
        }

        public Criteria andPhoneLikeInsensitive(String value) {
            addCriterion("upper(phone) like", value.toUpperCase(), "phone");
            return this;
        }

        public Criteria andBuildNameLikeInsensitive(String value) {
            addCriterion("upper(build_name) like", value.toUpperCase(), "buildName");
            return this;
        }

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(address) like", value.toUpperCase(), "address");
            return this;
        }

        public Criteria andChargeManagerLikeInsensitive(String value) {
            addCriterion("upper(charge_manager) like", value.toUpperCase(), "chargeManager");
            return this;
        }

        public Criteria andChargeDesignerLikeInsensitive(String value) {
            addCriterion("upper(charge_designer) like", value.toUpperCase(), "chargeDesigner");
            return this;
        }

        public Criteria andRepairTypeLikeInsensitive(String value) {
            addCriterion("upper(repair_type) like", value.toUpperCase(), "repairType");
            return this;
        }

        public Criteria andNoteLikeInsensitive(String value) {
            addCriterion("upper(note) like", value.toUpperCase(), "note");
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