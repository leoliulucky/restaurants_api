package com.benxiaopao.provider.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserLoginIpExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public UserLoginIpExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
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
     * This method corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
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

        public Criteria andIpIdIsNull() {
            addCriterion("ipId is null");
            return (Criteria) this;
        }

        public Criteria andIpIdIsNotNull() {
            addCriterion("ipId is not null");
            return (Criteria) this;
        }

        public Criteria andIpIdEqualTo(Integer value) {
            addCriterion("ipId =", value, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdNotEqualTo(Integer value) {
            addCriterion("ipId <>", value, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdGreaterThan(Integer value) {
            addCriterion("ipId >", value, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ipId >=", value, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdLessThan(Integer value) {
            addCriterion("ipId <", value, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdLessThanOrEqualTo(Integer value) {
            addCriterion("ipId <=", value, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdIn(List<Integer> values) {
            addCriterion("ipId in", values, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdNotIn(List<Integer> values) {
            addCriterion("ipId not in", values, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdBetween(Integer value1, Integer value2) {
            addCriterion("ipId between", value1, value2, "ipId");
            return (Criteria) this;
        }

        public Criteria andIpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ipId not between", value1, value2, "ipId");
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

        public Criteria andLoginIPIsNull() {
            addCriterion("loginIP is null");
            return (Criteria) this;
        }

        public Criteria andLoginIPIsNotNull() {
            addCriterion("loginIP is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIPEqualTo(Long value) {
            addCriterion("loginIP =", value, "loginIP");
            return (Criteria) this;
        }

        public Criteria andLoginIPNotEqualTo(Long value) {
            addCriterion("loginIP <>", value, "loginIP");
            return (Criteria) this;
        }

        public Criteria andLoginIPGreaterThan(Long value) {
            addCriterion("loginIP >", value, "loginIP");
            return (Criteria) this;
        }

        public Criteria andLoginIPGreaterThanOrEqualTo(Long value) {
            addCriterion("loginIP >=", value, "loginIP");
            return (Criteria) this;
        }

        public Criteria andLoginIPLessThan(Long value) {
            addCriterion("loginIP <", value, "loginIP");
            return (Criteria) this;
        }

        public Criteria andLoginIPLessThanOrEqualTo(Long value) {
            addCriterion("loginIP <=", value, "loginIP");
            return (Criteria) this;
        }

        public Criteria andLoginIPIn(List<Long> values) {
            addCriterion("loginIP in", values, "loginIP");
            return (Criteria) this;
        }

        public Criteria andLoginIPNotIn(List<Long> values) {
            addCriterion("loginIP not in", values, "loginIP");
            return (Criteria) this;
        }

        public Criteria andLoginIPBetween(Long value1, Long value2) {
            addCriterion("loginIP between", value1, value2, "loginIP");
            return (Criteria) this;
        }

        public Criteria andLoginIPNotBetween(Long value1, Long value2) {
            addCriterion("loginIP not between", value1, value2, "loginIP");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeIsNull() {
            addCriterion("browserType is null");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeIsNotNull() {
            addCriterion("browserType is not null");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeEqualTo(Short value) {
            addCriterion("browserType =", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeNotEqualTo(Short value) {
            addCriterion("browserType <>", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeGreaterThan(Short value) {
            addCriterion("browserType >", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("browserType >=", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeLessThan(Short value) {
            addCriterion("browserType <", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeLessThanOrEqualTo(Short value) {
            addCriterion("browserType <=", value, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeIn(List<Short> values) {
            addCriterion("browserType in", values, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeNotIn(List<Short> values) {
            addCriterion("browserType not in", values, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeBetween(Short value1, Short value2) {
            addCriterion("browserType between", value1, value2, "browserType");
            return (Criteria) this;
        }

        public Criteria andBrowserTypeNotBetween(Short value1, Short value2) {
            addCriterion("browserType not between", value1, value2, "browserType");
            return (Criteria) this;
        }

        public Criteria andOsTypeIsNull() {
            addCriterion("osType is null");
            return (Criteria) this;
        }

        public Criteria andOsTypeIsNotNull() {
            addCriterion("osType is not null");
            return (Criteria) this;
        }

        public Criteria andOsTypeEqualTo(Short value) {
            addCriterion("osType =", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotEqualTo(Short value) {
            addCriterion("osType <>", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeGreaterThan(Short value) {
            addCriterion("osType >", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("osType >=", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeLessThan(Short value) {
            addCriterion("osType <", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeLessThanOrEqualTo(Short value) {
            addCriterion("osType <=", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeIn(List<Short> values) {
            addCriterion("osType in", values, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotIn(List<Short> values) {
            addCriterion("osType not in", values, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeBetween(Short value1, Short value2) {
            addCriterion("osType between", value1, value2, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotBetween(Short value1, Short value2) {
            addCriterion("osType not between", value1, value2, "osType");
            return (Criteria) this;
        }

        public Criteria andLoginAddressIsNull() {
            addCriterion("loginAddress is null");
            return (Criteria) this;
        }

        public Criteria andLoginAddressIsNotNull() {
            addCriterion("loginAddress is not null");
            return (Criteria) this;
        }

        public Criteria andLoginAddressEqualTo(String value) {
            addCriterion("loginAddress =", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressNotEqualTo(String value) {
            addCriterion("loginAddress <>", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressGreaterThan(String value) {
            addCriterion("loginAddress >", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressGreaterThanOrEqualTo(String value) {
            addCriterion("loginAddress >=", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressLessThan(String value) {
            addCriterion("loginAddress <", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressLessThanOrEqualTo(String value) {
            addCriterion("loginAddress <=", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressLike(String value) {
            addCriterion("loginAddress like", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressNotLike(String value) {
            addCriterion("loginAddress not like", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressIn(List<String> values) {
            addCriterion("loginAddress in", values, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressNotIn(List<String> values) {
            addCriterion("loginAddress not in", values, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressBetween(String value1, String value2) {
            addCriterion("loginAddress between", value1, value2, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressNotBetween(String value1, String value2) {
            addCriterion("loginAddress not between", value1, value2, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("loginTime is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("loginTime is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("loginTime =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("loginTime <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("loginTime >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("loginTime >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("loginTime <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("loginTime <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("loginTime in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("loginTime not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("loginTime between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("loginTime not between", value1, value2, "loginTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_login_ip
     *
     * @mbg.generated do_not_delete_during_merge Sun May 05 00:45:31 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_login_ip
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
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