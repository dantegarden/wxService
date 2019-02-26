package com.bjdvt.wx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleOrderReplayLineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SaleOrderReplayLineExample() {
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
     * @date 2018-07-11
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

        public Criteria andReplayIsNull() {
            addCriterion("replay is null");
            return (Criteria) this;
        }

        public Criteria andReplayIsNotNull() {
            addCriterion("replay is not null");
            return (Criteria) this;
        }

        public Criteria andReplayEqualTo(String value) {
            addCriterion("replay =", value, "replay");
            return (Criteria) this;
        }

        public Criteria andReplayNotEqualTo(String value) {
            addCriterion("replay <>", value, "replay");
            return (Criteria) this;
        }

        public Criteria andReplayGreaterThan(String value) {
            addCriterion("replay >", value, "replay");
            return (Criteria) this;
        }

        public Criteria andReplayGreaterThanOrEqualTo(String value) {
            addCriterion("replay >=", value, "replay");
            return (Criteria) this;
        }

        public Criteria andReplayLessThan(String value) {
            addCriterion("replay <", value, "replay");
            return (Criteria) this;
        }

        public Criteria andReplayLessThanOrEqualTo(String value) {
            addCriterion("replay <=", value, "replay");
            return (Criteria) this;
        }

        public Criteria andReplayLike(String value) {
            addCriterion("replay like", value, "replay");
            return (Criteria) this;
        }

        public Criteria andReplayNotLike(String value) {
            addCriterion("replay not like", value, "replay");
            return (Criteria) this;
        }

        public Criteria andReplayIn(List<String> values) {
            addCriterion("replay in", values, "replay");
            return (Criteria) this;
        }

        public Criteria andReplayNotIn(List<String> values) {
            addCriterion("replay not in", values, "replay");
            return (Criteria) this;
        }

        public Criteria andReplayBetween(String value1, String value2) {
            addCriterion("replay between", value1, value2, "replay");
            return (Criteria) this;
        }

        public Criteria andReplayNotBetween(String value1, String value2) {
            addCriterion("replay not between", value1, value2, "replay");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLineIdIsNull() {
            addCriterion("sale_order_line_id is null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLineIdIsNotNull() {
            addCriterion("sale_order_line_id is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLineIdEqualTo(Integer value) {
            addCriterion("sale_order_line_id =", value, "saleOrderLineId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLineIdNotEqualTo(Integer value) {
            addCriterion("sale_order_line_id <>", value, "saleOrderLineId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLineIdGreaterThan(Integer value) {
            addCriterion("sale_order_line_id >", value, "saleOrderLineId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLineIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_order_line_id >=", value, "saleOrderLineId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLineIdLessThan(Integer value) {
            addCriterion("sale_order_line_id <", value, "saleOrderLineId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLineIdLessThanOrEqualTo(Integer value) {
            addCriterion("sale_order_line_id <=", value, "saleOrderLineId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLineIdIn(List<Integer> values) {
            addCriterion("sale_order_line_id in", values, "saleOrderLineId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLineIdNotIn(List<Integer> values) {
            addCriterion("sale_order_line_id not in", values, "saleOrderLineId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLineIdBetween(Integer value1, Integer value2) {
            addCriterion("sale_order_line_id between", value1, value2, "saleOrderLineId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderLineIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_order_line_id not between", value1, value2, "saleOrderLineId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyIdIsNull() {
            addCriterion("sale_order_reply_id is null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyIdIsNotNull() {
            addCriterion("sale_order_reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyIdEqualTo(Integer value) {
            addCriterion("sale_order_reply_id =", value, "saleOrderReplyId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyIdNotEqualTo(Integer value) {
            addCriterion("sale_order_reply_id <>", value, "saleOrderReplyId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyIdGreaterThan(Integer value) {
            addCriterion("sale_order_reply_id >", value, "saleOrderReplyId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_order_reply_id >=", value, "saleOrderReplyId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyIdLessThan(Integer value) {
            addCriterion("sale_order_reply_id <", value, "saleOrderReplyId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("sale_order_reply_id <=", value, "saleOrderReplyId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyIdIn(List<Integer> values) {
            addCriterion("sale_order_reply_id in", values, "saleOrderReplyId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyIdNotIn(List<Integer> values) {
            addCriterion("sale_order_reply_id not in", values, "saleOrderReplyId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyIdBetween(Integer value1, Integer value2) {
            addCriterion("sale_order_reply_id between", value1, value2, "saleOrderReplyId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_order_reply_id not between", value1, value2, "saleOrderReplyId");
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
     * @date 2018-07-11
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