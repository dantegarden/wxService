package com.bjdvt.wx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseOrderReplayLineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PurchaseOrderReplayLineExample() {
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Short value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Short value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Short value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Short value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Short value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Short value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Short> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Short> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Short value1, Short value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Short value1, Short value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Short value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Short value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Short value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Short value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Short value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Short value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Short> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Short> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Short value1, Short value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Short value1, Short value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderLineIdIsNull() {
            addCriterion("purchase_order_line_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderLineIdIsNotNull() {
            addCriterion("purchase_order_line_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderLineIdEqualTo(Integer value) {
            addCriterion("purchase_order_line_id =", value, "purchaseOrderLineId");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderLineIdNotEqualTo(Integer value) {
            addCriterion("purchase_order_line_id <>", value, "purchaseOrderLineId");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderLineIdGreaterThan(Integer value) {
            addCriterion("purchase_order_line_id >", value, "purchaseOrderLineId");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderLineIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_order_line_id >=", value, "purchaseOrderLineId");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderLineIdLessThan(Integer value) {
            addCriterion("purchase_order_line_id <", value, "purchaseOrderLineId");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderLineIdLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_order_line_id <=", value, "purchaseOrderLineId");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderLineIdIn(List<Integer> values) {
            addCriterion("purchase_order_line_id in", values, "purchaseOrderLineId");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderLineIdNotIn(List<Integer> values) {
            addCriterion("purchase_order_line_id not in", values, "purchaseOrderLineId");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderLineIdBetween(Integer value1, Integer value2) {
            addCriterion("purchase_order_line_id between", value1, value2, "purchaseOrderLineId");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderLineIdNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_order_line_id not between", value1, value2, "purchaseOrderLineId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyCopy1IdIsNull() {
            addCriterion("sale_order_reply_copy1_id is null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyCopy1IdIsNotNull() {
            addCriterion("sale_order_reply_copy1_id is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyCopy1IdEqualTo(Integer value) {
            addCriterion("sale_order_reply_copy1_id =", value, "saleOrderReplyCopy1Id");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyCopy1IdNotEqualTo(Integer value) {
            addCriterion("sale_order_reply_copy1_id <>", value, "saleOrderReplyCopy1Id");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyCopy1IdGreaterThan(Integer value) {
            addCriterion("sale_order_reply_copy1_id >", value, "saleOrderReplyCopy1Id");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyCopy1IdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_order_reply_copy1_id >=", value, "saleOrderReplyCopy1Id");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyCopy1IdLessThan(Integer value) {
            addCriterion("sale_order_reply_copy1_id <", value, "saleOrderReplyCopy1Id");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyCopy1IdLessThanOrEqualTo(Integer value) {
            addCriterion("sale_order_reply_copy1_id <=", value, "saleOrderReplyCopy1Id");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyCopy1IdIn(List<Integer> values) {
            addCriterion("sale_order_reply_copy1_id in", values, "saleOrderReplyCopy1Id");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyCopy1IdNotIn(List<Integer> values) {
            addCriterion("sale_order_reply_copy1_id not in", values, "saleOrderReplyCopy1Id");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyCopy1IdBetween(Integer value1, Integer value2) {
            addCriterion("sale_order_reply_copy1_id between", value1, value2, "saleOrderReplyCopy1Id");
            return (Criteria) this;
        }

        public Criteria andSaleOrderReplyCopy1IdNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_order_reply_copy1_id not between", value1, value2, "saleOrderReplyCopy1Id");
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