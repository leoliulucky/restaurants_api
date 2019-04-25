package com.benxiaopao.provider.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MobileAuthenExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
     */
    public MobileAuthenExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
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
     * This method corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
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

        public Criteria andMobileAuthenIdIsNull() {
            addCriterion("mobileAuthenId is null");
            return (Criteria) this;
        }

        public Criteria andMobileAuthenIdIsNotNull() {
            addCriterion("mobileAuthenId is not null");
            return (Criteria) this;
        }

        public Criteria andMobileAuthenIdEqualTo(Long value) {
            addCriterion("mobileAuthenId =", value, "mobileAuthenId");
            return (Criteria) this;
        }

        public Criteria andMobileAuthenIdNotEqualTo(Long value) {
            addCriterion("mobileAuthenId <>", value, "mobileAuthenId");
            return (Criteria) this;
        }

        public Criteria andMobileAuthenIdGreaterThan(Long value) {
            addCriterion("mobileAuthenId >", value, "mobileAuthenId");
            return (Criteria) this;
        }

        public Criteria andMobileAuthenIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mobileAuthenId >=", value, "mobileAuthenId");
            return (Criteria) this;
        }

        public Criteria andMobileAuthenIdLessThan(Long value) {
            addCriterion("mobileAuthenId <", value, "mobileAuthenId");
            return (Criteria) this;
        }

        public Criteria andMobileAuthenIdLessThanOrEqualTo(Long value) {
            addCriterion("mobileAuthenId <=", value, "mobileAuthenId");
            return (Criteria) this;
        }

        public Criteria andMobileAuthenIdIn(List<Long> values) {
            addCriterion("mobileAuthenId in", values, "mobileAuthenId");
            return (Criteria) this;
        }

        public Criteria andMobileAuthenIdNotIn(List<Long> values) {
            addCriterion("mobileAuthenId not in", values, "mobileAuthenId");
            return (Criteria) this;
        }

        public Criteria andMobileAuthenIdBetween(Long value1, Long value2) {
            addCriterion("mobileAuthenId between", value1, value2, "mobileAuthenId");
            return (Criteria) this;
        }

        public Criteria andMobileAuthenIdNotBetween(Long value1, Long value2) {
            addCriterion("mobileAuthenId not between", value1, value2, "mobileAuthenId");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("sendTime is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("sendTime is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("sendTime =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("sendTime <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("sendTime >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendTime >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("sendTime <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("sendTime <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("sendTime in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("sendTime not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("sendTime between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("sendTime not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andValidCodeIsNull() {
            addCriterion("validCode is null");
            return (Criteria) this;
        }

        public Criteria andValidCodeIsNotNull() {
            addCriterion("validCode is not null");
            return (Criteria) this;
        }

        public Criteria andValidCodeEqualTo(String value) {
            addCriterion("validCode =", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotEqualTo(String value) {
            addCriterion("validCode <>", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeGreaterThan(String value) {
            addCriterion("validCode >", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeGreaterThanOrEqualTo(String value) {
            addCriterion("validCode >=", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeLessThan(String value) {
            addCriterion("validCode <", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeLessThanOrEqualTo(String value) {
            addCriterion("validCode <=", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeLike(String value) {
            addCriterion("validCode like", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotLike(String value) {
            addCriterion("validCode not like", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeIn(List<String> values) {
            addCriterion("validCode in", values, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotIn(List<String> values) {
            addCriterion("validCode not in", values, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeBetween(String value1, String value2) {
            addCriterion("validCode between", value1, value2, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotBetween(String value1, String value2) {
            addCriterion("validCode not between", value1, value2, "validCode");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mobile_authen
     *
     * @mbg.generated do_not_delete_during_merge Sat Apr 20 10:27:14 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mobile_authen
     *
     * @mbg.generated Sat Apr 20 10:27:14 CST 2019
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