package com.benxiaopao.provider.dao.map;

import com.benxiaopao.provider.dao.model.Restaurant;
import com.benxiaopao.provider.dao.model.RestaurantExample.Criteria;
import com.benxiaopao.provider.dao.model.RestaurantExample.Criterion;
import com.benxiaopao.provider.dao.model.RestaurantExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RestaurantSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    public String countByExample(RestaurantExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("restaurant_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    public String deleteByExample(RestaurantExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("restaurant_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    public String insertSelective(Restaurant record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("restaurant_info");
        
        if (record.getRestaurantId() != null) {
            sql.VALUES("restaurantId", "#{restaurantId,jdbcType=INTEGER}");
        }
        
        if (record.getRestaurantName() != null) {
            sql.VALUES("restaurantName", "#{restaurantName,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.VALUES("tel", "#{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getTags() != null) {
            sql.VALUES("tags", "#{tags,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("updateTime", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    public String selectByExample(RestaurantExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("restaurantId");
        } else {
            sql.SELECT("restaurantId");
        }
        sql.SELECT("restaurantName");
        sql.SELECT("icon");
        sql.SELECT("address");
        sql.SELECT("tel");
        sql.SELECT("tags");
        sql.SELECT("createTime");
        sql.SELECT("updateTime");
        sql.FROM("restaurant_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Restaurant record = (Restaurant) parameter.get("record");
        RestaurantExample example = (RestaurantExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("restaurant_info");
        
        if (record.getRestaurantId() != null) {
            sql.SET("restaurantId = #{record.restaurantId,jdbcType=INTEGER}");
        }
        
        if (record.getRestaurantName() != null) {
            sql.SET("restaurantName = #{record.restaurantName,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        }
        
        if (record.getTags() != null) {
            sql.SET("tags = #{record.tags,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("restaurant_info");
        
        sql.SET("restaurantId = #{record.restaurantId,jdbcType=INTEGER}");
        sql.SET("restaurantName = #{record.restaurantName,jdbcType=VARCHAR}");
        sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        sql.SET("tags = #{record.tags,jdbcType=VARCHAR}");
        sql.SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        RestaurantExample example = (RestaurantExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    public String updateByPrimaryKeySelective(Restaurant record) {
        SQL sql = new SQL();
        sql.UPDATE("restaurant_info");
        
        if (record.getRestaurantName() != null) {
            sql.SET("restaurantName = #{restaurantName,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getTags() != null) {
            sql.SET("tags = #{tags,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("updateTime = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("restaurantId = #{restaurantId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant_info
     *
     * @mbg.generated Tue Apr 23 00:48:57 CST 2019
     */
    protected void applyWhere(SQL sql, RestaurantExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}