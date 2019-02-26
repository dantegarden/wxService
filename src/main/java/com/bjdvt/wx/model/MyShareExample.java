package com.bjdvt.wx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyShareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MyShareExample() {
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
     * @date 2018-08-23
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

        public Criteria andLastShareIdIsNull() {
            addCriterion("last_share_id is null");
            return (Criteria) this;
        }

        public Criteria andLastShareIdIsNotNull() {
            addCriterion("last_share_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastShareIdEqualTo(String value) {
            addCriterion("last_share_id =", value, "lastShareId");
            return (Criteria) this;
        }

        public Criteria andLastShareIdNotEqualTo(String value) {
            addCriterion("last_share_id <>", value, "lastShareId");
            return (Criteria) this;
        }

        public Criteria andLastShareIdGreaterThan(String value) {
            addCriterion("last_share_id >", value, "lastShareId");
            return (Criteria) this;
        }

        public Criteria andLastShareIdGreaterThanOrEqualTo(String value) {
            addCriterion("last_share_id >=", value, "lastShareId");
            return (Criteria) this;
        }

        public Criteria andLastShareIdLessThan(String value) {
            addCriterion("last_share_id <", value, "lastShareId");
            return (Criteria) this;
        }

        public Criteria andLastShareIdLessThanOrEqualTo(String value) {
            addCriterion("last_share_id <=", value, "lastShareId");
            return (Criteria) this;
        }

        public Criteria andLastShareIdLike(String value) {
            addCriterion("last_share_id like", value, "lastShareId");
            return (Criteria) this;
        }

        public Criteria andLastShareIdNotLike(String value) {
            addCriterion("last_share_id not like", value, "lastShareId");
            return (Criteria) this;
        }

        public Criteria andLastShareIdIn(List<String> values) {
            addCriterion("last_share_id in", values, "lastShareId");
            return (Criteria) this;
        }

        public Criteria andLastShareIdNotIn(List<String> values) {
            addCriterion("last_share_id not in", values, "lastShareId");
            return (Criteria) this;
        }

        public Criteria andLastShareIdBetween(String value1, String value2) {
            addCriterion("last_share_id between", value1, value2, "lastShareId");
            return (Criteria) this;
        }

        public Criteria andLastShareIdNotBetween(String value1, String value2) {
            addCriterion("last_share_id not between", value1, value2, "lastShareId");
            return (Criteria) this;
        }

        public Criteria andLastFormUserIdIsNull() {
            addCriterion("last_form_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLastFormUserIdIsNotNull() {
            addCriterion("last_form_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastFormUserIdEqualTo(Integer value) {
            addCriterion("last_form_user_id =", value, "lastFormUserId");
            return (Criteria) this;
        }

        public Criteria andLastFormUserIdNotEqualTo(Integer value) {
            addCriterion("last_form_user_id <>", value, "lastFormUserId");
            return (Criteria) this;
        }

        public Criteria andLastFormUserIdGreaterThan(Integer value) {
            addCriterion("last_form_user_id >", value, "lastFormUserId");
            return (Criteria) this;
        }

        public Criteria andLastFormUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_form_user_id >=", value, "lastFormUserId");
            return (Criteria) this;
        }

        public Criteria andLastFormUserIdLessThan(Integer value) {
            addCriterion("last_form_user_id <", value, "lastFormUserId");
            return (Criteria) this;
        }

        public Criteria andLastFormUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("last_form_user_id <=", value, "lastFormUserId");
            return (Criteria) this;
        }

        public Criteria andLastFormUserIdIn(List<Integer> values) {
            addCriterion("last_form_user_id in", values, "lastFormUserId");
            return (Criteria) this;
        }

        public Criteria andLastFormUserIdNotIn(List<Integer> values) {
            addCriterion("last_form_user_id not in", values, "lastFormUserId");
            return (Criteria) this;
        }

        public Criteria andLastFormUserIdBetween(Integer value1, Integer value2) {
            addCriterion("last_form_user_id between", value1, value2, "lastFormUserId");
            return (Criteria) this;
        }

        public Criteria andLastFormUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("last_form_user_id not between", value1, value2, "lastFormUserId");
            return (Criteria) this;
        }

        public Criteria andShareIdIsNull() {
            addCriterion("share_id is null");
            return (Criteria) this;
        }

        public Criteria andShareIdIsNotNull() {
            addCriterion("share_id is not null");
            return (Criteria) this;
        }

        public Criteria andShareIdEqualTo(String value) {
            addCriterion("share_id =", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotEqualTo(String value) {
            addCriterion("share_id <>", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThan(String value) {
            addCriterion("share_id >", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThanOrEqualTo(String value) {
            addCriterion("share_id >=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThan(String value) {
            addCriterion("share_id <", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThanOrEqualTo(String value) {
            addCriterion("share_id <=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLike(String value) {
            addCriterion("share_id like", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotLike(String value) {
            addCriterion("share_id not like", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdIn(List<String> values) {
            addCriterion("share_id in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotIn(List<String> values) {
            addCriterion("share_id not in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdBetween(String value1, String value2) {
            addCriterion("share_id between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotBetween(String value1, String value2) {
            addCriterion("share_id not between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(Integer value) {
            addCriterion("owner_id =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(Integer value) {
            addCriterion("owner_id <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(Integer value) {
            addCriterion("owner_id >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_id >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(Integer value) {
            addCriterion("owner_id <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(Integer value) {
            addCriterion("owner_id <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<Integer> values) {
            addCriterion("owner_id in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<Integer> values) {
            addCriterion("owner_id not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(Integer value1, Integer value2) {
            addCriterion("owner_id between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_id not between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerCompanyIdIsNull() {
            addCriterion("owner_company_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerCompanyIdIsNotNull() {
            addCriterion("owner_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerCompanyIdEqualTo(Integer value) {
            addCriterion("owner_company_id =", value, "ownerCompanyId");
            return (Criteria) this;
        }

        public Criteria andOwnerCompanyIdNotEqualTo(Integer value) {
            addCriterion("owner_company_id <>", value, "ownerCompanyId");
            return (Criteria) this;
        }

        public Criteria andOwnerCompanyIdGreaterThan(Integer value) {
            addCriterion("owner_company_id >", value, "ownerCompanyId");
            return (Criteria) this;
        }

        public Criteria andOwnerCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_company_id >=", value, "ownerCompanyId");
            return (Criteria) this;
        }

        public Criteria andOwnerCompanyIdLessThan(Integer value) {
            addCriterion("owner_company_id <", value, "ownerCompanyId");
            return (Criteria) this;
        }

        public Criteria andOwnerCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("owner_company_id <=", value, "ownerCompanyId");
            return (Criteria) this;
        }

        public Criteria andOwnerCompanyIdIn(List<Integer> values) {
            addCriterion("owner_company_id in", values, "ownerCompanyId");
            return (Criteria) this;
        }

        public Criteria andOwnerCompanyIdNotIn(List<Integer> values) {
            addCriterion("owner_company_id not in", values, "ownerCompanyId");
            return (Criteria) this;
        }

        public Criteria andOwnerCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("owner_company_id between", value1, value2, "ownerCompanyId");
            return (Criteria) this;
        }

        public Criteria andOwnerCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_company_id not between", value1, value2, "ownerCompanyId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIsNull() {
            addCriterion("from_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIsNotNull() {
            addCriterion("from_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserIdEqualTo(Integer value) {
            addCriterion("from_user_id =", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotEqualTo(Integer value) {
            addCriterion("from_user_id <>", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdGreaterThan(Integer value) {
            addCriterion("from_user_id >", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_user_id >=", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLessThan(Integer value) {
            addCriterion("from_user_id <", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("from_user_id <=", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIn(List<Integer> values) {
            addCriterion("from_user_id in", values, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotIn(List<Integer> values) {
            addCriterion("from_user_id not in", values, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdBetween(Integer value1, Integer value2) {
            addCriterion("from_user_id between", value1, value2, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("from_user_id not between", value1, value2, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
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
     * @date 2018-08-23
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