package com.scinter.www.model;

import com.scinter.www.util.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DesignerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public DesignerExample() {
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

        public Criteria andDesignerNameIsNull() {
            addCriterion("designer_name is null");
            return (Criteria) this;
        }

        public Criteria andDesignerNameIsNotNull() {
            addCriterion("designer_name is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerNameEqualTo(String value) {
            addCriterion("designer_name =", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameNotEqualTo(String value) {
            addCriterion("designer_name <>", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameGreaterThan(String value) {
            addCriterion("designer_name >", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameGreaterThanOrEqualTo(String value) {
            addCriterion("designer_name >=", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameLessThan(String value) {
            addCriterion("designer_name <", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameLessThanOrEqualTo(String value) {
            addCriterion("designer_name <=", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameLike(String value) {
            addCriterion("designer_name like", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameNotLike(String value) {
            addCriterion("designer_name not like", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameIn(List<String> values) {
            addCriterion("designer_name in", values, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameNotIn(List<String> values) {
            addCriterion("designer_name not in", values, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameBetween(String value1, String value2) {
            addCriterion("designer_name between", value1, value2, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameNotBetween(String value1, String value2) {
            addCriterion("designer_name not between", value1, value2, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleIsNull() {
            addCriterion("designer_title is null");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleIsNotNull() {
            addCriterion("designer_title is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleEqualTo(String value) {
            addCriterion("designer_title =", value, "designerTitle");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleNotEqualTo(String value) {
            addCriterion("designer_title <>", value, "designerTitle");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleGreaterThan(String value) {
            addCriterion("designer_title >", value, "designerTitle");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleGreaterThanOrEqualTo(String value) {
            addCriterion("designer_title >=", value, "designerTitle");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleLessThan(String value) {
            addCriterion("designer_title <", value, "designerTitle");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleLessThanOrEqualTo(String value) {
            addCriterion("designer_title <=", value, "designerTitle");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleLike(String value) {
            addCriterion("designer_title like", value, "designerTitle");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleNotLike(String value) {
            addCriterion("designer_title not like", value, "designerTitle");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleIn(List<String> values) {
            addCriterion("designer_title in", values, "designerTitle");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleNotIn(List<String> values) {
            addCriterion("designer_title not in", values, "designerTitle");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleBetween(String value1, String value2) {
            addCriterion("designer_title between", value1, value2, "designerTitle");
            return (Criteria) this;
        }

        public Criteria andDesignerTitleNotBetween(String value1, String value2) {
            addCriterion("designer_title not between", value1, value2, "designerTitle");
            return (Criteria) this;
        }

        public Criteria andDesignerSexIsNull() {
            addCriterion("designer_sex is null");
            return (Criteria) this;
        }

        public Criteria andDesignerSexIsNotNull() {
            addCriterion("designer_sex is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerSexEqualTo(String value) {
            addCriterion("designer_sex =", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexNotEqualTo(String value) {
            addCriterion("designer_sex <>", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexGreaterThan(String value) {
            addCriterion("designer_sex >", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexGreaterThanOrEqualTo(String value) {
            addCriterion("designer_sex >=", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexLessThan(String value) {
            addCriterion("designer_sex <", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexLessThanOrEqualTo(String value) {
            addCriterion("designer_sex <=", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexLike(String value) {
            addCriterion("designer_sex like", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexNotLike(String value) {
            addCriterion("designer_sex not like", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexIn(List<String> values) {
            addCriterion("designer_sex in", values, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexNotIn(List<String> values) {
            addCriterion("designer_sex not in", values, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexBetween(String value1, String value2) {
            addCriterion("designer_sex between", value1, value2, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexNotBetween(String value1, String value2) {
            addCriterion("designer_sex not between", value1, value2, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolIsNull() {
            addCriterion("designer_school is null");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolIsNotNull() {
            addCriterion("designer_school is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolEqualTo(String value) {
            addCriterion("designer_school =", value, "designerSchool");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolNotEqualTo(String value) {
            addCriterion("designer_school <>", value, "designerSchool");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolGreaterThan(String value) {
            addCriterion("designer_school >", value, "designerSchool");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("designer_school >=", value, "designerSchool");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolLessThan(String value) {
            addCriterion("designer_school <", value, "designerSchool");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolLessThanOrEqualTo(String value) {
            addCriterion("designer_school <=", value, "designerSchool");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolLike(String value) {
            addCriterion("designer_school like", value, "designerSchool");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolNotLike(String value) {
            addCriterion("designer_school not like", value, "designerSchool");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolIn(List<String> values) {
            addCriterion("designer_school in", values, "designerSchool");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolNotIn(List<String> values) {
            addCriterion("designer_school not in", values, "designerSchool");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolBetween(String value1, String value2) {
            addCriterion("designer_school between", value1, value2, "designerSchool");
            return (Criteria) this;
        }

        public Criteria andDesignerSchoolNotBetween(String value1, String value2) {
            addCriterion("designer_school not between", value1, value2, "designerSchool");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceIsNull() {
            addCriterion("designer_birth_place is null");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceIsNotNull() {
            addCriterion("designer_birth_place is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceEqualTo(String value) {
            addCriterion("designer_birth_place =", value, "designerBirthPlace");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceNotEqualTo(String value) {
            addCriterion("designer_birth_place <>", value, "designerBirthPlace");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceGreaterThan(String value) {
            addCriterion("designer_birth_place >", value, "designerBirthPlace");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("designer_birth_place >=", value, "designerBirthPlace");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceLessThan(String value) {
            addCriterion("designer_birth_place <", value, "designerBirthPlace");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceLessThanOrEqualTo(String value) {
            addCriterion("designer_birth_place <=", value, "designerBirthPlace");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceLike(String value) {
            addCriterion("designer_birth_place like", value, "designerBirthPlace");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceNotLike(String value) {
            addCriterion("designer_birth_place not like", value, "designerBirthPlace");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceIn(List<String> values) {
            addCriterion("designer_birth_place in", values, "designerBirthPlace");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceNotIn(List<String> values) {
            addCriterion("designer_birth_place not in", values, "designerBirthPlace");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceBetween(String value1, String value2) {
            addCriterion("designer_birth_place between", value1, value2, "designerBirthPlace");
            return (Criteria) this;
        }

        public Criteria andDesignerBirthPlaceNotBetween(String value1, String value2) {
            addCriterion("designer_birth_place not between", value1, value2, "designerBirthPlace");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgIsNull() {
            addCriterion("designer_photo_img is null");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgIsNotNull() {
            addCriterion("designer_photo_img is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgEqualTo(String value) {
            addCriterion("designer_photo_img =", value, "designerPhotoImg");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgNotEqualTo(String value) {
            addCriterion("designer_photo_img <>", value, "designerPhotoImg");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgGreaterThan(String value) {
            addCriterion("designer_photo_img >", value, "designerPhotoImg");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgGreaterThanOrEqualTo(String value) {
            addCriterion("designer_photo_img >=", value, "designerPhotoImg");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgLessThan(String value) {
            addCriterion("designer_photo_img <", value, "designerPhotoImg");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgLessThanOrEqualTo(String value) {
            addCriterion("designer_photo_img <=", value, "designerPhotoImg");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgLike(String value) {
            addCriterion("designer_photo_img like", value, "designerPhotoImg");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgNotLike(String value) {
            addCriterion("designer_photo_img not like", value, "designerPhotoImg");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgIn(List<String> values) {
            addCriterion("designer_photo_img in", values, "designerPhotoImg");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgNotIn(List<String> values) {
            addCriterion("designer_photo_img not in", values, "designerPhotoImg");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgBetween(String value1, String value2) {
            addCriterion("designer_photo_img between", value1, value2, "designerPhotoImg");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoImgNotBetween(String value1, String value2) {
            addCriterion("designer_photo_img not between", value1, value2, "designerPhotoImg");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgIsNull() {
            addCriterion("designer_certificate_img is null");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgIsNotNull() {
            addCriterion("designer_certificate_img is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgEqualTo(String value) {
            addCriterion("designer_certificate_img =", value, "designerCertificateImg");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgNotEqualTo(String value) {
            addCriterion("designer_certificate_img <>", value, "designerCertificateImg");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgGreaterThan(String value) {
            addCriterion("designer_certificate_img >", value, "designerCertificateImg");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgGreaterThanOrEqualTo(String value) {
            addCriterion("designer_certificate_img >=", value, "designerCertificateImg");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgLessThan(String value) {
            addCriterion("designer_certificate_img <", value, "designerCertificateImg");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgLessThanOrEqualTo(String value) {
            addCriterion("designer_certificate_img <=", value, "designerCertificateImg");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgLike(String value) {
            addCriterion("designer_certificate_img like", value, "designerCertificateImg");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgNotLike(String value) {
            addCriterion("designer_certificate_img not like", value, "designerCertificateImg");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgIn(List<String> values) {
            addCriterion("designer_certificate_img in", values, "designerCertificateImg");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgNotIn(List<String> values) {
            addCriterion("designer_certificate_img not in", values, "designerCertificateImg");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgBetween(String value1, String value2) {
            addCriterion("designer_certificate_img between", value1, value2, "designerCertificateImg");
            return (Criteria) this;
        }

        public Criteria andDesignerCertificateImgNotBetween(String value1, String value2) {
            addCriterion("designer_certificate_img not between", value1, value2, "designerCertificateImg");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileIsNull() {
            addCriterion("designer_profile is null");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileIsNotNull() {
            addCriterion("designer_profile is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileEqualTo(String value) {
            addCriterion("designer_profile =", value, "designerProfile");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileNotEqualTo(String value) {
            addCriterion("designer_profile <>", value, "designerProfile");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileGreaterThan(String value) {
            addCriterion("designer_profile >", value, "designerProfile");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileGreaterThanOrEqualTo(String value) {
            addCriterion("designer_profile >=", value, "designerProfile");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileLessThan(String value) {
            addCriterion("designer_profile <", value, "designerProfile");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileLessThanOrEqualTo(String value) {
            addCriterion("designer_profile <=", value, "designerProfile");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileLike(String value) {
            addCriterion("designer_profile like", value, "designerProfile");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileNotLike(String value) {
            addCriterion("designer_profile not like", value, "designerProfile");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileIn(List<String> values) {
            addCriterion("designer_profile in", values, "designerProfile");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileNotIn(List<String> values) {
            addCriterion("designer_profile not in", values, "designerProfile");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileBetween(String value1, String value2) {
            addCriterion("designer_profile between", value1, value2, "designerProfile");
            return (Criteria) this;
        }

        public Criteria andDesignerProfileNotBetween(String value1, String value2) {
            addCriterion("designer_profile not between", value1, value2, "designerProfile");
            return (Criteria) this;
        }

        public Criteria andDesignerPriceIsNull() {
            addCriterion("designer_price is null");
            return (Criteria) this;
        }

        public Criteria andDesignerPriceIsNotNull() {
            addCriterion("designer_price is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerPriceEqualTo(Integer value) {
            addCriterion("designer_price =", value, "designerPrice");
            return (Criteria) this;
        }

        public Criteria andDesignerPriceNotEqualTo(Integer value) {
            addCriterion("designer_price <>", value, "designerPrice");
            return (Criteria) this;
        }

        public Criteria andDesignerPriceGreaterThan(Integer value) {
            addCriterion("designer_price >", value, "designerPrice");
            return (Criteria) this;
        }

        public Criteria andDesignerPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("designer_price >=", value, "designerPrice");
            return (Criteria) this;
        }

        public Criteria andDesignerPriceLessThan(Integer value) {
            addCriterion("designer_price <", value, "designerPrice");
            return (Criteria) this;
        }

        public Criteria andDesignerPriceLessThanOrEqualTo(Integer value) {
            addCriterion("designer_price <=", value, "designerPrice");
            return (Criteria) this;
        }

        public Criteria andDesignerPriceIn(List<Integer> values) {
            addCriterion("designer_price in", values, "designerPrice");
            return (Criteria) this;
        }

        public Criteria andDesignerPriceNotIn(List<Integer> values) {
            addCriterion("designer_price not in", values, "designerPrice");
            return (Criteria) this;
        }

        public Criteria andDesignerPriceBetween(Integer value1, Integer value2) {
            addCriterion("designer_price between", value1, value2, "designerPrice");
            return (Criteria) this;
        }

        public Criteria andDesignerPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("designer_price not between", value1, value2, "designerPrice");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptIsNull() {
            addCriterion("designer_dept is null");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptIsNotNull() {
            addCriterion("designer_dept is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptEqualTo(String value) {
            addCriterion("designer_dept =", value, "designerDept");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptNotEqualTo(String value) {
            addCriterion("designer_dept <>", value, "designerDept");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptGreaterThan(String value) {
            addCriterion("designer_dept >", value, "designerDept");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptGreaterThanOrEqualTo(String value) {
            addCriterion("designer_dept >=", value, "designerDept");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptLessThan(String value) {
            addCriterion("designer_dept <", value, "designerDept");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptLessThanOrEqualTo(String value) {
            addCriterion("designer_dept <=", value, "designerDept");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptLike(String value) {
            addCriterion("designer_dept like", value, "designerDept");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptNotLike(String value) {
            addCriterion("designer_dept not like", value, "designerDept");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptIn(List<String> values) {
            addCriterion("designer_dept in", values, "designerDept");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptNotIn(List<String> values) {
            addCriterion("designer_dept not in", values, "designerDept");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptBetween(String value1, String value2) {
            addCriterion("designer_dept between", value1, value2, "designerDept");
            return (Criteria) this;
        }

        public Criteria andDesignerDeptNotBetween(String value1, String value2) {
            addCriterion("designer_dept not between", value1, value2, "designerDept");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeIsNull() {
            addCriterion("designer_work_time is null");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeIsNotNull() {
            addCriterion("designer_work_time is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeEqualTo(String value) {
            addCriterion("designer_work_time =", value, "designerWorkTime");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeNotEqualTo(String value) {
            addCriterion("designer_work_time <>", value, "designerWorkTime");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeGreaterThan(String value) {
            addCriterion("designer_work_time >", value, "designerWorkTime");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeGreaterThanOrEqualTo(String value) {
            addCriterion("designer_work_time >=", value, "designerWorkTime");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeLessThan(String value) {
            addCriterion("designer_work_time <", value, "designerWorkTime");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeLessThanOrEqualTo(String value) {
            addCriterion("designer_work_time <=", value, "designerWorkTime");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeLike(String value) {
            addCriterion("designer_work_time like", value, "designerWorkTime");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeNotLike(String value) {
            addCriterion("designer_work_time not like", value, "designerWorkTime");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeIn(List<String> values) {
            addCriterion("designer_work_time in", values, "designerWorkTime");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeNotIn(List<String> values) {
            addCriterion("designer_work_time not in", values, "designerWorkTime");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeBetween(String value1, String value2) {
            addCriterion("designer_work_time between", value1, value2, "designerWorkTime");
            return (Criteria) this;
        }

        public Criteria andDesignerWorkTimeNotBetween(String value1, String value2) {
            addCriterion("designer_work_time not between", value1, value2, "designerWorkTime");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleIsNull() {
            addCriterion("designer_style is null");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleIsNotNull() {
            addCriterion("designer_style is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleEqualTo(String value) {
            addCriterion("designer_style =", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleNotEqualTo(String value) {
            addCriterion("designer_style <>", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleGreaterThan(String value) {
            addCriterion("designer_style >", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleGreaterThanOrEqualTo(String value) {
            addCriterion("designer_style >=", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleLessThan(String value) {
            addCriterion("designer_style <", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleLessThanOrEqualTo(String value) {
            addCriterion("designer_style <=", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleLike(String value) {
            addCriterion("designer_style like", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleNotLike(String value) {
            addCriterion("designer_style not like", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleIn(List<String> values) {
            addCriterion("designer_style in", values, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleNotIn(List<String> values) {
            addCriterion("designer_style not in", values, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleBetween(String value1, String value2) {
            addCriterion("designer_style between", value1, value2, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleNotBetween(String value1, String value2) {
            addCriterion("designer_style not between", value1, value2, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaIsNull() {
            addCriterion("designer_idea is null");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaIsNotNull() {
            addCriterion("designer_idea is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaEqualTo(String value) {
            addCriterion("designer_idea =", value, "designerIdea");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaNotEqualTo(String value) {
            addCriterion("designer_idea <>", value, "designerIdea");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaGreaterThan(String value) {
            addCriterion("designer_idea >", value, "designerIdea");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaGreaterThanOrEqualTo(String value) {
            addCriterion("designer_idea >=", value, "designerIdea");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaLessThan(String value) {
            addCriterion("designer_idea <", value, "designerIdea");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaLessThanOrEqualTo(String value) {
            addCriterion("designer_idea <=", value, "designerIdea");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaLike(String value) {
            addCriterion("designer_idea like", value, "designerIdea");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaNotLike(String value) {
            addCriterion("designer_idea not like", value, "designerIdea");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaIn(List<String> values) {
            addCriterion("designer_idea in", values, "designerIdea");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaNotIn(List<String> values) {
            addCriterion("designer_idea not in", values, "designerIdea");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaBetween(String value1, String value2) {
            addCriterion("designer_idea between", value1, value2, "designerIdea");
            return (Criteria) this;
        }

        public Criteria andDesignerIdeaNotBetween(String value1, String value2) {
            addCriterion("designer_idea not between", value1, value2, "designerIdea");
            return (Criteria) this;
        }

        public Criteria andDesignerPopularityIsNull() {
            addCriterion("designer_popularity is null");
            return (Criteria) this;
        }

        public Criteria andDesignerPopularityIsNotNull() {
            addCriterion("designer_popularity is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerPopularityEqualTo(Integer value) {
            addCriterion("designer_popularity =", value, "designerPopularity");
            return (Criteria) this;
        }

        public Criteria andDesignerPopularityNotEqualTo(Integer value) {
            addCriterion("designer_popularity <>", value, "designerPopularity");
            return (Criteria) this;
        }

        public Criteria andDesignerPopularityGreaterThan(Integer value) {
            addCriterion("designer_popularity >", value, "designerPopularity");
            return (Criteria) this;
        }

        public Criteria andDesignerPopularityGreaterThanOrEqualTo(Integer value) {
            addCriterion("designer_popularity >=", value, "designerPopularity");
            return (Criteria) this;
        }

        public Criteria andDesignerPopularityLessThan(Integer value) {
            addCriterion("designer_popularity <", value, "designerPopularity");
            return (Criteria) this;
        }

        public Criteria andDesignerPopularityLessThanOrEqualTo(Integer value) {
            addCriterion("designer_popularity <=", value, "designerPopularity");
            return (Criteria) this;
        }

        public Criteria andDesignerPopularityIn(List<Integer> values) {
            addCriterion("designer_popularity in", values, "designerPopularity");
            return (Criteria) this;
        }

        public Criteria andDesignerPopularityNotIn(List<Integer> values) {
            addCriterion("designer_popularity not in", values, "designerPopularity");
            return (Criteria) this;
        }

        public Criteria andDesignerPopularityBetween(Integer value1, Integer value2) {
            addCriterion("designer_popularity between", value1, value2, "designerPopularity");
            return (Criteria) this;
        }

        public Criteria andDesignerPopularityNotBetween(Integer value1, Integer value2) {
            addCriterion("designer_popularity not between", value1, value2, "designerPopularity");
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

        public Criteria andDesignerNameLikeInsensitive(String value) {
            addCriterion("upper(designer_name) like", value.toUpperCase(), "designerName");
            return this;
        }

        public Criteria andDesignerTitleLikeInsensitive(String value) {
            addCriterion("upper(designer_title) like", value.toUpperCase(), "designerTitle");
            return this;
        }

        public Criteria andDesignerSexLikeInsensitive(String value) {
            addCriterion("upper(designer_sex) like", value.toUpperCase(), "designerSex");
            return this;
        }

        public Criteria andDesignerSchoolLikeInsensitive(String value) {
            addCriterion("upper(designer_school) like", value.toUpperCase(), "designerSchool");
            return this;
        }

        public Criteria andDesignerBirthPlaceLikeInsensitive(String value) {
            addCriterion("upper(designer_birth_place) like", value.toUpperCase(), "designerBirthPlace");
            return this;
        }

        public Criteria andDesignerPhotoImgLikeInsensitive(String value) {
            addCriterion("upper(designer_photo_img) like", value.toUpperCase(), "designerPhotoImg");
            return this;
        }

        public Criteria andDesignerCertificateImgLikeInsensitive(String value) {
            addCriterion("upper(designer_certificate_img) like", value.toUpperCase(), "designerCertificateImg");
            return this;
        }

        public Criteria andDesignerProfileLikeInsensitive(String value) {
            addCriterion("upper(designer_profile) like", value.toUpperCase(), "designerProfile");
            return this;
        }

        public Criteria andDesignerDeptLikeInsensitive(String value) {
            addCriterion("upper(designer_dept) like", value.toUpperCase(), "designerDept");
            return this;
        }

        public Criteria andDesignerWorkTimeLikeInsensitive(String value) {
            addCriterion("upper(designer_work_time) like", value.toUpperCase(), "designerWorkTime");
            return this;
        }

        public Criteria andDesignerStyleLikeInsensitive(String value) {
            addCriterion("upper(designer_style) like", value.toUpperCase(), "designerStyle");
            return this;
        }

        public Criteria andDesignerIdeaLikeInsensitive(String value) {
            addCriterion("upper(designer_idea) like", value.toUpperCase(), "designerIdea");
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