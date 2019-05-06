package com.benxiaopao.provider.dao.map;

import com.benxiaopao.provider.dao.model.User;
import com.benxiaopao.provider.dao.model.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Sat Apr 20 10:26:44 CST 2019
     */
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Sat Apr 20 10:26:44 CST 2019
     */
    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Sat Apr 20 10:26:44 CST 2019
     */
    @Delete({
        "delete from user_info",
        "where userId = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Sat Apr 20 10:26:44 CST 2019
     */
    @Insert({
        "insert into user_info (userId, email, ",
        "nickName, realName, ",
        "displayName, password, ",
        "mobile, city, registerTime, ",
        "activeTime, status, ",
        "forbidStatus, securityLevel, ",
        "weiboUId, weiboAccessToken, ",
        "qqUId, qqAccessToken, ",
        "registerChannelId)",
        "values (#{userId,jdbcType=INTEGER}, #{email,jdbcType=VARCHAR}, ",
        "#{nickName,jdbcType=VARCHAR}, #{realName,jdbcType=VARCHAR}, ",
        "#{displayName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, #{registerTime,jdbcType=TIMESTAMP}, ",
        "#{activeTime,jdbcType=TIMESTAMP}, #{status,jdbcType=SMALLINT}, ",
        "#{forbidStatus,jdbcType=SMALLINT}, #{securityLevel,jdbcType=SMALLINT}, ",
        "#{weiboUId,jdbcType=VARCHAR}, #{weiboAccessToken,jdbcType=VARCHAR}, ",
        "#{qqUId,jdbcType=VARCHAR}, #{qqAccessToken,jdbcType=VARCHAR}, ",
        "#{registerChannelId,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="userId", before=false, resultType=Integer.class)
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Sat Apr 20 10:26:44 CST 2019
     */
    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="userId", before=false, resultType=Integer.class)
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Sat Apr 20 10:26:44 CST 2019
     */
    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickName", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="realName", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayName", property="displayName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="registerTime", property="registerTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="activeTime", property="activeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.SMALLINT),
        @Result(column="forbidStatus", property="forbidStatus", jdbcType=JdbcType.SMALLINT),
        @Result(column="securityLevel", property="securityLevel", jdbcType=JdbcType.SMALLINT),
        @Result(column="weiboUId", property="weiboUId", jdbcType=JdbcType.VARCHAR),
        @Result(column="weiboAccessToken", property="weiboAccessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="qqUId", property="qqUId", jdbcType=JdbcType.VARCHAR),
        @Result(column="qqAccessToken", property="qqAccessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="registerChannelId", property="registerChannelId", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Sat Apr 20 10:26:44 CST 2019
     */
    @Select({
        "select",
        "userId, email, nickName, realName, displayName, password, mobile, city, registerTime, ",
        "activeTime, status, forbidStatus, securityLevel, weiboUId, weiboAccessToken, ",
        "qqUId, qqAccessToken, registerChannelId",
        "from user_info",
        "where userId = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickName", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="realName", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayName", property="displayName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="registerTime", property="registerTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="activeTime", property="activeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.SMALLINT),
        @Result(column="forbidStatus", property="forbidStatus", jdbcType=JdbcType.SMALLINT),
        @Result(column="securityLevel", property="securityLevel", jdbcType=JdbcType.SMALLINT),
        @Result(column="weiboUId", property="weiboUId", jdbcType=JdbcType.VARCHAR),
        @Result(column="weiboAccessToken", property="weiboAccessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="qqUId", property="qqUId", jdbcType=JdbcType.VARCHAR),
        @Result(column="qqAccessToken", property="qqAccessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="registerChannelId", property="registerChannelId", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Sat Apr 20 10:26:44 CST 2019
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Sat Apr 20 10:26:44 CST 2019
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Sat Apr 20 10:26:44 CST 2019
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Sat Apr 20 10:26:44 CST 2019
     */
    @Update({
        "update user_info",
        "set email = #{email,jdbcType=VARCHAR},",
          "nickName = #{nickName,jdbcType=VARCHAR},",
          "realName = #{realName,jdbcType=VARCHAR},",
          "displayName = #{displayName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "registerTime = #{registerTime,jdbcType=TIMESTAMP},",
          "activeTime = #{activeTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=SMALLINT},",
          "forbidStatus = #{forbidStatus,jdbcType=SMALLINT},",
          "securityLevel = #{securityLevel,jdbcType=SMALLINT},",
          "weiboUId = #{weiboUId,jdbcType=VARCHAR},",
          "weiboAccessToken = #{weiboAccessToken,jdbcType=VARCHAR},",
          "qqUId = #{qqUId,jdbcType=VARCHAR},",
          "qqAccessToken = #{qqAccessToken,jdbcType=VARCHAR},",
          "registerChannelId = #{registerChannelId,jdbcType=VARCHAR}",
        "where userId = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);

    /**
     * 根据email获取用户对象
     * @param email
     * @return
     * @author liupoyang
     */
    @Select("select * from user_info where email= #{email}")
    User getUserByEmail(String email);

    /**
     * 根据mobile获取用户对象
     * @param mobile
     * @return
     * @author liupoyang
     */
    @Select("SELECT * FROM user_info WHERE mobile = #{mobile}")
    User getUserByMobile(String mobile);

    /**
     * 根据用户昵称获取用户对象
     * @param nickName
     * @return
     * @author liupoyang
     */
    @Select("select * from user_info where nickName= #{nickName}")
    User getUserByNickName(String nickName);

    /**
     * 判断用户昵称是否已经注册
     * @param nickName
     * @return
     * @author liupoyang
     */
    @Select("select count(1) from user_info where nickName = #{nickName}")
    int isNickNameExist(String nickName);

    /**
     * 判断邮箱是否注册
     * @param email
     * @return
     * @author liupoyang
     */
    @Select("select count(1) from user_info where email= #{email}")
    public int isEmailExist(String email);

    /**
     * 判断手机号是否注册
     * @param mobile
     * @return
     * @author liupoyang
     */
    @Select("select count(*) from user_info where mobile = #{mobile}")
    int isMobileExist(String mobile);

    /**
     * 根据email获取用户对象，并加锁
     * @param email
     * @return
     * @author liupoyang
     */
    @Select("select * from user_info where email= #{email} for update")
    User getUserByEmailForUpdate(String email);

    /**
     * 根据用户邮箱重置登录密码
     * @param email
     * @param password
     * @author liupoyang
     */
    @Update("update user_info set password = #{password} where email=#{email} ")
    void resetUserPassword(@Param("email")String email, @Param("password")String password);

    /**
     * 根据mobile获取用户对象，并加锁
     * @param mobile
     * @return
     * @author liupoyang
     */
    @Select("SELECT * FROM user_info WHERE mobile = #{mobile} for update")
    User getUserByMobileForUpdate(String mobile);

    /**
     * 根据用户手机重置登录密码
     * @param mobile
     * @param password
     * @author liupoyang
     */
    @Update("update user_info set password = #{password} where mobile=#{mobile} ")
    void resetUserPasswordByMobile(@Param("mobile")String mobile, @Param("password")String password);
}