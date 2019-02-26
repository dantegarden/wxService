package com.bjdvt.wx.model;

import java.util.ArrayList;
import java.util.List;

public class AllofficialsExample  {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AllofficialsExample() {
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

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2018-08-08
     */
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

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andOfficialNameIsNull() {
            addCriterion("official_name is null");
            return (Criteria) this;
        }

        public Criteria andOfficialNameIsNotNull() {
            addCriterion("official_name is not null");
            return (Criteria) this;
        }

        public Criteria andOfficialNameEqualTo(String value) {
            addCriterion("official_name =", value, "officialName");
            return (Criteria) this;
        }

        public Criteria andOfficialNameNotEqualTo(String value) {
            addCriterion("official_name <>", value, "officialName");
            return (Criteria) this;
        }

        public Criteria andOfficialNameGreaterThan(String value) {
            addCriterion("official_name >", value, "officialName");
            return (Criteria) this;
        }

        public Criteria andOfficialNameGreaterThanOrEqualTo(String value) {
            addCriterion("official_name >=", value, "officialName");
            return (Criteria) this;
        }

        public Criteria andOfficialNameLessThan(String value) {
            addCriterion("official_name <", value, "officialName");
            return (Criteria) this;
        }

        public Criteria andOfficialNameLessThanOrEqualTo(String value) {
            addCriterion("official_name <=", value, "officialName");
            return (Criteria) this;
        }

        public Criteria andOfficialNameLike(String value) {
            addCriterion("official_name like", value, "officialName");
            return (Criteria) this;
        }

        public Criteria andOfficialNameNotLike(String value) {
            addCriterion("official_name not like", value, "officialName");
            return (Criteria) this;
        }

        public Criteria andOfficialNameIn(List<String> values) {
            addCriterion("official_name in", values, "officialName");
            return (Criteria) this;
        }

        public Criteria andOfficialNameNotIn(List<String> values) {
            addCriterion("official_name not in", values, "officialName");
            return (Criteria) this;
        }

        public Criteria andOfficialNameBetween(String value1, String value2) {
            addCriterion("official_name between", value1, value2, "officialName");
            return (Criteria) this;
        }

        public Criteria andOfficialNameNotBetween(String value1, String value2) {
            addCriterion("official_name not between", value1, value2, "officialName");
            return (Criteria) this;
        }

        public Criteria andPosterIsNull() {
            addCriterion("poster is null");
            return (Criteria) this;
        }

        public Criteria andPosterIsNotNull() {
            addCriterion("poster is not null");
            return (Criteria) this;
        }

        public Criteria andPosterEqualTo(Integer value) {
            addCriterion("poster =", value, "poster");
            return (Criteria) this;
        }

        public Criteria andPosterNotEqualTo(Integer value) {
            addCriterion("poster <>", value, "poster");
            return (Criteria) this;
        }

        public Criteria andPosterGreaterThan(Integer value) {
            addCriterion("poster >", value, "poster");
            return (Criteria) this;
        }

        public Criteria andPosterGreaterThanOrEqualTo(Integer value) {
            addCriterion("poster >=", value, "poster");
            return (Criteria) this;
        }

        public Criteria andPosterLessThan(Integer value) {
            addCriterion("poster <", value, "poster");
            return (Criteria) this;
        }

        public Criteria andPosterLessThanOrEqualTo(Integer value) {
            addCriterion("poster <=", value, "poster");
            return (Criteria) this;
        }

        public Criteria andPosterIn(List<Integer> values) {
            addCriterion("poster in", values, "poster");
            return (Criteria) this;
        }

        public Criteria andPosterNotIn(List<Integer> values) {
            addCriterion("poster not in", values, "poster");
            return (Criteria) this;
        }

        public Criteria andPosterBetween(Integer value1, Integer value2) {
            addCriterion("poster between", value1, value2, "poster");
            return (Criteria) this;
        }

        public Criteria andPosterNotBetween(Integer value1, Integer value2) {
            addCriterion("poster not between", value1, value2, "poster");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeIsNull() {
            addCriterion("official_describe is null");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeIsNotNull() {
            addCriterion("official_describe is not null");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeEqualTo(String value) {
            addCriterion("official_describe =", value, "officialDescribe");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeNotEqualTo(String value) {
            addCriterion("official_describe <>", value, "officialDescribe");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeGreaterThan(String value) {
            addCriterion("official_describe >", value, "officialDescribe");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("official_describe >=", value, "officialDescribe");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeLessThan(String value) {
            addCriterion("official_describe <", value, "officialDescribe");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeLessThanOrEqualTo(String value) {
            addCriterion("official_describe <=", value, "officialDescribe");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeLike(String value) {
            addCriterion("official_describe like", value, "officialDescribe");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeNotLike(String value) {
            addCriterion("official_describe not like", value, "officialDescribe");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeIn(List<String> values) {
            addCriterion("official_describe in", values, "officialDescribe");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeNotIn(List<String> values) {
            addCriterion("official_describe not in", values, "officialDescribe");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeBetween(String value1, String value2) {
            addCriterion("official_describe between", value1, value2, "officialDescribe");
            return (Criteria) this;
        }

        public Criteria andOfficialDescribeNotBetween(String value1, String value2) {
            addCriterion("official_describe not between", value1, value2, "officialDescribe");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2018-08-08
     */
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