package com.benxiaopao.provider.dao.model;

import java.util.Date;

public class UserLoginFailure {
    /**
     * 最大尝试次数（需锁定）
     */
    public static final int MAX_ATTEMPTS_LOCKED = 10;
    /**
     * 最大尝试次数（需输入验证码）
     */
    public static final int MAX_ATTEMPTS_VALIDATE = 3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_login_failure.userId
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_login_failure.attemptTimes
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    private Integer attemptTimes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_login_failure.lastAttemped
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    private Date lastAttemped;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_login_failure.lastLocked
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    private Date lastLocked;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_login_failure.lastLoginIP
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    private Long lastLoginIP;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_login_failure.userId
     *
     * @return the value of user_login_failure.userId
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_login_failure.userId
     *
     * @param userId the value for user_login_failure.userId
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_login_failure.attemptTimes
     *
     * @return the value of user_login_failure.attemptTimes
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public Integer getAttemptTimes() {
        return attemptTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_login_failure.attemptTimes
     *
     * @param attemptTimes the value for user_login_failure.attemptTimes
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public void setAttemptTimes(Integer attemptTimes) {
        this.attemptTimes = attemptTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_login_failure.lastAttemped
     *
     * @return the value of user_login_failure.lastAttemped
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public Date getLastAttemped() {
        return lastAttemped;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_login_failure.lastAttemped
     *
     * @param lastAttemped the value for user_login_failure.lastAttemped
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public void setLastAttemped(Date lastAttemped) {
        this.lastAttemped = lastAttemped;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_login_failure.lastLocked
     *
     * @return the value of user_login_failure.lastLocked
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public Date getLastLocked() {
        return lastLocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_login_failure.lastLocked
     *
     * @param lastLocked the value for user_login_failure.lastLocked
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public void setLastLocked(Date lastLocked) {
        this.lastLocked = lastLocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_login_failure.lastLoginIP
     *
     * @return the value of user_login_failure.lastLoginIP
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public Long getLastLoginIP() {
        return lastLoginIP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_login_failure.lastLoginIP
     *
     * @param lastLoginIP the value for user_login_failure.lastLoginIP
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public void setLastLoginIP(Long lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }
}