package com.mysupermarket.pojo;

import java.util.ArrayList;
import java.util.List;

public class GoodExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public GoodExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
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

        public Criteria andGIdIsNull() {
            addCriterion("g_id is null");
            return (Criteria) this;
        }

        public Criteria andGIdIsNotNull() {
            addCriterion("g_id is not null");
            return (Criteria) this;
        }

        public Criteria andGIdEqualTo(Integer value) {
            addCriterion("g_id =", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotEqualTo(Integer value) {
            addCriterion("g_id <>", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdGreaterThan(Integer value) {
            addCriterion("g_id >", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("g_id >=", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdLessThan(Integer value) {
            addCriterion("g_id <", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdLessThanOrEqualTo(Integer value) {
            addCriterion("g_id <=", value, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdIn(List<Integer> values) {
            addCriterion("g_id in", values, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotIn(List<Integer> values) {
            addCriterion("g_id not in", values, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdBetween(Integer value1, Integer value2) {
            addCriterion("g_id between", value1, value2, "gId");
            return (Criteria) this;
        }

        public Criteria andGIdNotBetween(Integer value1, Integer value2) {
            addCriterion("g_id not between", value1, value2, "gId");
            return (Criteria) this;
        }

        public Criteria andGNameIsNull() {
            addCriterion("g_name is null");
            return (Criteria) this;
        }

        public Criteria andGNameIsNotNull() {
            addCriterion("g_name is not null");
            return (Criteria) this;
        }

        public Criteria andGNameEqualTo(String value) {
            addCriterion("g_name =", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotEqualTo(String value) {
            addCriterion("g_name <>", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThan(String value) {
            addCriterion("g_name >", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThanOrEqualTo(String value) {
            addCriterion("g_name >=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThan(String value) {
            addCriterion("g_name <", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThanOrEqualTo(String value) {
            addCriterion("g_name <=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLike(String value) {
            addCriterion("g_name like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotLike(String value) {
            addCriterion("g_name not like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameIn(List<String> values) {
            addCriterion("g_name in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotIn(List<String> values) {
            addCriterion("g_name not in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameBetween(String value1, String value2) {
            addCriterion("g_name between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotBetween(String value1, String value2) {
            addCriterion("g_name not between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGUrlIsNull() {
            addCriterion("g_url is null");
            return (Criteria) this;
        }

        public Criteria andGUrlIsNotNull() {
            addCriterion("g_url is not null");
            return (Criteria) this;
        }

        public Criteria andGUrlEqualTo(String value) {
            addCriterion("g_url =", value, "gUrl");
            return (Criteria) this;
        }

        public Criteria andGUrlNotEqualTo(String value) {
            addCriterion("g_url <>", value, "gUrl");
            return (Criteria) this;
        }

        public Criteria andGUrlGreaterThan(String value) {
            addCriterion("g_url >", value, "gUrl");
            return (Criteria) this;
        }

        public Criteria andGUrlGreaterThanOrEqualTo(String value) {
            addCriterion("g_url >=", value, "gUrl");
            return (Criteria) this;
        }

        public Criteria andGUrlLessThan(String value) {
            addCriterion("g_url <", value, "gUrl");
            return (Criteria) this;
        }

        public Criteria andGUrlLessThanOrEqualTo(String value) {
            addCriterion("g_url <=", value, "gUrl");
            return (Criteria) this;
        }

        public Criteria andGUrlLike(String value) {
            addCriterion("g_url like", value, "gUrl");
            return (Criteria) this;
        }

        public Criteria andGUrlNotLike(String value) {
            addCriterion("g_url not like", value, "gUrl");
            return (Criteria) this;
        }

        public Criteria andGUrlIn(List<String> values) {
            addCriterion("g_url in", values, "gUrl");
            return (Criteria) this;
        }

        public Criteria andGUrlNotIn(List<String> values) {
            addCriterion("g_url not in", values, "gUrl");
            return (Criteria) this;
        }

        public Criteria andGUrlBetween(String value1, String value2) {
            addCriterion("g_url between", value1, value2, "gUrl");
            return (Criteria) this;
        }

        public Criteria andGUrlNotBetween(String value1, String value2) {
            addCriterion("g_url not between", value1, value2, "gUrl");
            return (Criteria) this;
        }

        public Criteria andGPriceIsNull() {
            addCriterion("g_price is null");
            return (Criteria) this;
        }

        public Criteria andGPriceIsNotNull() {
            addCriterion("g_price is not null");
            return (Criteria) this;
        }

        public Criteria andGPriceEqualTo(Double value) {
            addCriterion("g_price =", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceNotEqualTo(Double value) {
            addCriterion("g_price <>", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceGreaterThan(Double value) {
            addCriterion("g_price >", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("g_price >=", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceLessThan(Double value) {
            addCriterion("g_price <", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceLessThanOrEqualTo(Double value) {
            addCriterion("g_price <=", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceIn(List<Double> values) {
            addCriterion("g_price in", values, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceNotIn(List<Double> values) {
            addCriterion("g_price not in", values, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceBetween(Double value1, Double value2) {
            addCriterion("g_price between", value1, value2, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceNotBetween(Double value1, Double value2) {
            addCriterion("g_price not between", value1, value2, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGSalesIsNull() {
            addCriterion("g_sales is null");
            return (Criteria) this;
        }

        public Criteria andGSalesIsNotNull() {
            addCriterion("g_sales is not null");
            return (Criteria) this;
        }

        public Criteria andGSalesEqualTo(Integer value) {
            addCriterion("g_sales =", value, "gSales");
            return (Criteria) this;
        }

        public Criteria andGSalesNotEqualTo(Integer value) {
            addCriterion("g_sales <>", value, "gSales");
            return (Criteria) this;
        }

        public Criteria andGSalesGreaterThan(Integer value) {
            addCriterion("g_sales >", value, "gSales");
            return (Criteria) this;
        }

        public Criteria andGSalesGreaterThanOrEqualTo(Integer value) {
            addCriterion("g_sales >=", value, "gSales");
            return (Criteria) this;
        }

        public Criteria andGSalesLessThan(Integer value) {
            addCriterion("g_sales <", value, "gSales");
            return (Criteria) this;
        }

        public Criteria andGSalesLessThanOrEqualTo(Integer value) {
            addCriterion("g_sales <=", value, "gSales");
            return (Criteria) this;
        }

        public Criteria andGSalesIn(List<Integer> values) {
            addCriterion("g_sales in", values, "gSales");
            return (Criteria) this;
        }

        public Criteria andGSalesNotIn(List<Integer> values) {
            addCriterion("g_sales not in", values, "gSales");
            return (Criteria) this;
        }

        public Criteria andGSalesBetween(Integer value1, Integer value2) {
            addCriterion("g_sales between", value1, value2, "gSales");
            return (Criteria) this;
        }

        public Criteria andGSalesNotBetween(Integer value1, Integer value2) {
            addCriterion("g_sales not between", value1, value2, "gSales");
            return (Criteria) this;
        }

        public Criteria andGRemainIsNull() {
            addCriterion("g_remain is null");
            return (Criteria) this;
        }

        public Criteria andGRemainIsNotNull() {
            addCriterion("g_remain is not null");
            return (Criteria) this;
        }

        public Criteria andGRemainEqualTo(Integer value) {
            addCriterion("g_remain =", value, "gRemain");
            return (Criteria) this;
        }

        public Criteria andGRemainNotEqualTo(Integer value) {
            addCriterion("g_remain <>", value, "gRemain");
            return (Criteria) this;
        }

        public Criteria andGRemainGreaterThan(Integer value) {
            addCriterion("g_remain >", value, "gRemain");
            return (Criteria) this;
        }

        public Criteria andGRemainGreaterThanOrEqualTo(Integer value) {
            addCriterion("g_remain >=", value, "gRemain");
            return (Criteria) this;
        }

        public Criteria andGRemainLessThan(Integer value) {
            addCriterion("g_remain <", value, "gRemain");
            return (Criteria) this;
        }

        public Criteria andGRemainLessThanOrEqualTo(Integer value) {
            addCriterion("g_remain <=", value, "gRemain");
            return (Criteria) this;
        }

        public Criteria andGRemainIn(List<Integer> values) {
            addCriterion("g_remain in", values, "gRemain");
            return (Criteria) this;
        }

        public Criteria andGRemainNotIn(List<Integer> values) {
            addCriterion("g_remain not in", values, "gRemain");
            return (Criteria) this;
        }

        public Criteria andGRemainBetween(Integer value1, Integer value2) {
            addCriterion("g_remain between", value1, value2, "gRemain");
            return (Criteria) this;
        }

        public Criteria andGRemainNotBetween(Integer value1, Integer value2) {
            addCriterion("g_remain not between", value1, value2, "gRemain");
            return (Criteria) this;
        }

        public Criteria andGKindIsNull() {
            addCriterion("g_kind is null");
            return (Criteria) this;
        }

        public Criteria andGKindIsNotNull() {
            addCriterion("g_kind is not null");
            return (Criteria) this;
        }

        public Criteria andGKindEqualTo(Integer value) {
            addCriterion("g_kind =", value, "gKind");
            return (Criteria) this;
        }

        public Criteria andGKindNotEqualTo(Integer value) {
            addCriterion("g_kind <>", value, "gKind");
            return (Criteria) this;
        }

        public Criteria andGKindGreaterThan(Integer value) {
            addCriterion("g_kind >", value, "gKind");
            return (Criteria) this;
        }

        public Criteria andGKindGreaterThanOrEqualTo(Integer value) {
            addCriterion("g_kind >=", value, "gKind");
            return (Criteria) this;
        }

        public Criteria andGKindLessThan(Integer value) {
            addCriterion("g_kind <", value, "gKind");
            return (Criteria) this;
        }

        public Criteria andGKindLessThanOrEqualTo(Integer value) {
            addCriterion("g_kind <=", value, "gKind");
            return (Criteria) this;
        }

        public Criteria andGKindIn(List<Integer> values) {
            addCriterion("g_kind in", values, "gKind");
            return (Criteria) this;
        }

        public Criteria andGKindNotIn(List<Integer> values) {
            addCriterion("g_kind not in", values, "gKind");
            return (Criteria) this;
        }

        public Criteria andGKindBetween(Integer value1, Integer value2) {
            addCriterion("g_kind between", value1, value2, "gKind");
            return (Criteria) this;
        }

        public Criteria andGKindNotBetween(Integer value1, Integer value2) {
            addCriterion("g_kind not between", value1, value2, "gKind");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table good
     *
     * @mbggenerated do_not_delete_during_merge Sun Aug 06 09:44:18 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table good
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
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