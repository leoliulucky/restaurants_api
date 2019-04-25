package com.benxiaopao.provider.dao.map;

import com.benxiaopao.provider.dao.model.UserRegisterTemp;
import com.benxiaopao.provider.dao.model.UserRegisterTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserRegisterTempMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_register_temp
     *
     * @mbg.generated Sat Apr 20 10:26:22 CST 2019
     */
    @SelectProvider(type=UserRegisterTempSqlProvider.class, method="countByExample")
    long countByExample(UserRegisterTempExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_register_temp
     *
     * @mbg.generated Sat Apr 20 10:26:22 CST 2019
     */
    @DeleteProvider(type=UserRegisterTempSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserRegisterTempExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_register_temp
     *
     * @mbg.generated Sat Apr 20 10:26:22 CST 2019
     */
    @Delete({
        "delete from user_register_temp",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_register_temp
     *
     * @mbg.generated Sat Apr 20 10:26:22 CST 2019
     */
    @Insert({
        "insert into user_register_temp (id, mobile, ",
        "email, nickName, ",
        "passwd, registerTime, ",
        "question, answer, ",
        "weiboUId, weiboAccessToken, ",
        "qqUId, qqAccessToken, ",
        "registerChannelId, tempInfo)",
        "values (#{id,jdbcType=INTEGER}, #{mobile,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
        "#{passwd,jdbcType=VARCHAR}, #{registerTime,jdbcType=TIMESTAMP}, ",
        "#{question,jdbcType=VARCHAR}, #{answer,jdbcType=VARCHAR}, ",
        "#{weiboUId,jdbcType=VARCHAR}, #{weiboAccessToken,jdbcType=VARCHAR}, ",
        "#{qqUId,jdbcType=VARCHAR}, #{qqAccessToken,jdbcType=VARCHAR}, ",
        "#{registerChannelId,jdbcType=VARCHAR}, #{tempInfo,jdbcType=VARCHAR})"
    })
    int insert(UserRegisterTemp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_register_temp
     *
     * @mbg.generated Sat Apr 20 10:26:22 CST 2019
     */
    @InsertProvider(type=UserRegisterTempSqlProvider.class, method="insertSelective")
    int insertSelective(UserRegisterTemp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_register_temp
     *
     * @mbg.generated Sat Apr 20 10:26:22 CST 2019
     */
    @SelectProvider(type=UserRegisterTempSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickName", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="passwd", property="passwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="registerTime", property="registerTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="question", property="question", jdbcType=JdbcType.VARCHAR),
        @Result(column="answer", property="answer", jdbcType=JdbcType.VARCHAR),
        @Result(column="weiboUId", property="weiboUId", jdbcType=JdbcType.VARCHAR),
        @Result(column="weiboAccessToken", property="weiboAccessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="qqUId", property="qqUId", jdbcType=JdbcType.VARCHAR),
        @Result(column="qqAccessToken", property="qqAccessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="registerChannelId", property="registerChannelId", jdbcType=JdbcType.VARCHAR),
        @Result(column="tempInfo", property="tempInfo", jdbcType=JdbcType.VARCHAR)
    })
    List<UserRegisterTemp> selectByExample(UserRegisterTempExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_register_temp
     *
     * @mbg.generated Sat Apr 20 10:26:22 CST 2019
     */
    @Select({
        "select",
        "id, mobile, email, nickName, passwd, registerTime, question, answer, weiboUId, ",
        "weiboAccessToken, qqUId, qqAccessToken, registerChannelId, tempInfo",
        "from user_register_temp",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickName", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="passwd", property="passwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="registerTime", property="registerTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="question", property="question", jdbcType=JdbcType.VARCHAR),
        @Result(column="answer", property="answer", jdbcType=JdbcType.VARCHAR),
        @Result(column="weiboUId", property="weiboUId", jdbcType=JdbcType.VARCHAR),
        @Result(column="weiboAccessToken", property="weiboAccessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="qqUId", property="qqUId", jdbcType=JdbcType.VARCHAR),
        @Result(column="qqAccessToken", property="qqAccessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="registerChannelId", property="registerChannelId", jdbcType=JdbcType.VARCHAR),
        @Result(column="tempInfo", property="tempInfo", jdbcType=JdbcType.VARCHAR)
    })
    UserRegisterTemp selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_register_temp
     *
     * @mbg.generated Sat Apr 20 10:26:22 CST 2019
     */
    @UpdateProvider(type=UserRegisterTempSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserRegisterTemp record, @Param("example") UserRegisterTempExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_register_temp
     *
     * @mbg.generated Sat Apr 20 10:26:22 CST 2019
     */
    @UpdateProvider(type=UserRegisterTempSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserRegisterTemp record, @Param("example") UserRegisterTempExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_register_temp
     *
     * @mbg.generated Sat Apr 20 10:26:22 CST 2019
     */
    @UpdateProvider(type=UserRegisterTempSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserRegisterTemp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_register_temp
     *
     * @mbg.generated Sat Apr 20 10:26:22 CST 2019
     */
    @Update({
        "update user_register_temp",
        "set mobile = #{mobile,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "nickName = #{nickName,jdbcType=VARCHAR},",
          "passwd = #{passwd,jdbcType=VARCHAR},",
          "registerTime = #{registerTime,jdbcType=TIMESTAMP},",
          "question = #{question,jdbcType=VARCHAR},",
          "answer = #{answer,jdbcType=VARCHAR},",
          "weiboUId = #{weiboUId,jdbcType=VARCHAR},",
          "weiboAccessToken = #{weiboAccessToken,jdbcType=VARCHAR},",
          "qqUId = #{qqUId,jdbcType=VARCHAR},",
          "qqAccessToken = #{qqAccessToken,jdbcType=VARCHAR},",
          "registerChannelId = #{registerChannelId,jdbcType=VARCHAR},",
          "tempInfo = #{tempInfo,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserRegisterTemp record);
}