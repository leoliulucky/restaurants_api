package com.benxiaopao.provider.dao.map;

import com.benxiaopao.provider.dao.model.Restaurant;
import com.benxiaopao.provider.dao.model.RestaurantExample;
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

public interface RestaurantMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    @SelectProvider(type=RestaurantSqlProvider.class, method="countByExample")
    long countByExample(RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    @DeleteProvider(type=RestaurantSqlProvider.class, method="deleteByExample")
    int deleteByExample(RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    @Delete({
        "delete from restaurant_info",
        "where restaurantId = #{restaurantId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer restaurantId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    @Insert({
        "insert into restaurant_info (restaurantId, restaurantName, ",
        "icon, address, tel, ",
        "tags, createTime, ",
        "updateTime)",
        "values (#{restaurantId,jdbcType=INTEGER}, #{restaurantName,jdbcType=VARCHAR}, ",
        "#{icon,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, ",
        "#{tags,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Restaurant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    @InsertProvider(type=RestaurantSqlProvider.class, method="insertSelective")
    int insertSelective(Restaurant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    @SelectProvider(type=RestaurantSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="restaurantId", property="restaurantId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="restaurantName", property="restaurantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="tags", property="tags", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Restaurant> selectByExample(RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    @Select({
        "select",
        "restaurantId, restaurantName, icon, address, tel, tags, createTime, updateTime",
        "from restaurant_info",
        "where restaurantId = #{restaurantId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="restaurantId", property="restaurantId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="restaurantName", property="restaurantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="tags", property="tags", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Restaurant selectByPrimaryKey(Integer restaurantId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    @UpdateProvider(type=RestaurantSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Restaurant record, @Param("example") RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    @UpdateProvider(type=RestaurantSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Restaurant record, @Param("example") RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    @UpdateProvider(type=RestaurantSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Restaurant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    @Update({
        "update restaurant_info",
        "set restaurantName = #{restaurantName,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "tags = #{tags,jdbcType=VARCHAR},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP}",
        "where restaurantId = #{restaurantId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Restaurant record);
}