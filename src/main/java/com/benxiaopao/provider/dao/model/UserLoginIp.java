package com.benxiaopao.provider.dao.model;

import java.util.Date;

public class UserLoginIp {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_login_ip.ipId
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    private Integer ipId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_login_ip.userId
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_login_ip.loginIP
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    private Long loginIP;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_login_ip.browserType
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    private Short browserType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_login_ip.osType
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    private Short osType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_login_ip.loginAddress
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    private String loginAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_login_ip.loginTime
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    private Date loginTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_login_ip.ipId
     *
     * @return the value of user_login_ip.ipId
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public Integer getIpId() {
        return ipId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_login_ip.ipId
     *
     * @param ipId the value for user_login_ip.ipId
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public void setIpId(Integer ipId) {
        this.ipId = ipId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_login_ip.userId
     *
     * @return the value of user_login_ip.userId
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_login_ip.userId
     *
     * @param userId the value for user_login_ip.userId
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_login_ip.loginIP
     *
     * @return the value of user_login_ip.loginIP
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public Long getLoginIP() {
        return loginIP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_login_ip.loginIP
     *
     * @param loginIP the value for user_login_ip.loginIP
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public void setLoginIP(Long loginIP) {
        this.loginIP = loginIP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_login_ip.browserType
     *
     * @return the value of user_login_ip.browserType
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public Short getBrowserType() {
        return browserType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_login_ip.browserType
     *
     * @param browserType the value for user_login_ip.browserType
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public void setBrowserType(Short browserType) {
        this.browserType = browserType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_login_ip.osType
     *
     * @return the value of user_login_ip.osType
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public Short getOsType() {
        return osType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_login_ip.osType
     *
     * @param osType the value for user_login_ip.osType
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public void setOsType(Short osType) {
        this.osType = osType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_login_ip.loginAddress
     *
     * @return the value of user_login_ip.loginAddress
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public String getLoginAddress() {
        return loginAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_login_ip.loginAddress
     *
     * @param loginAddress the value for user_login_ip.loginAddress
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress == null ? null : loginAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_login_ip.loginTime
     *
     * @return the value of user_login_ip.loginTime
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_login_ip.loginTime
     *
     * @param loginTime the value for user_login_ip.loginTime
     *
     * @mbg.generated Sun May 05 00:45:31 CST 2019
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}