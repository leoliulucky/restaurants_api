package com.benxiaopao.provider.dao.map;

import com.benxiaopao.provider.dao.model.ProductCategory;
import com.benxiaopao.provider.dao.model.ProductCategoryExample.Criteria;
import com.benxiaopao.provider.dao.model.ProductCategoryExample.Criterion;
import com.benxiaopao.provider.dao.model.ProductCategoryExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ProductCategorySqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbg.generated Sat Apr 20 10:24:44 CST 2019
     */
    public String countByExample(ProductCategoryExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("product_category");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbg.generated Sat Apr 20 10:24:44 CST 2019
     */
    public String deleteByExample(ProductCategoryExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("product_category");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbg.generated Sat Apr 20 10:24:44 CST 2019
     */
    public String insertSelective(ProductCategory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product_category");
        
        if (record.getCategoryId() != null) {
            sql.VALUES("categoryId", "#{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCategoryName() != null) {
            sql.VALUES("categoryName", "#{categoryName,jdbcType=VARCHAR}");
        }
        
        if (record.getCategoryType() != null) {
            sql.VALUES("categoryType", "#{categoryType,jdbcType=INTEGER}");
        }
        
        if (record.getRestaurantId() != null) {
            sql.VALUES("restaurantId", "#{restaurantId,jdbcType=INTEGER}");
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
     * This method corresponds to the database table product_category
     *
     * @mbg.generated Sat Apr 20 10:24:44 CST 2019
     */
    public String selectByExample(ProductCategoryExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("categoryId");
        } else {
            sql.SELECT("categoryId");
        }
        sql.SELECT("categoryName");
        sql.SELECT("categoryType");
        sql.SELECT("restaurantId");
        sql.SELECT("createTime");
        sql.SELECT("updateTime");
        sql.FROM("product_category");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbg.generated Sat Apr 20 10:24:44 CST 2019
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        ProductCategory record = (ProductCategory) parameter.get("record");
        ProductCategoryExample example = (ProductCategoryExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("product_category");
        
        if (record.getCategoryId() != null) {
            sql.SET("categoryId = #{record.categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCategoryName() != null) {
            sql.SET("categoryName = #{record.categoryName,jdbcType=VARCHAR}");
        }
        
        if (record.getCategoryType() != null) {
            sql.SET("categoryType = #{record.categoryType,jdbcType=INTEGER}");
        }
        
        if (record.getRestaurantId() != null) {
            sql.SET("restaurantId = #{record.restaurantId,jdbcType=INTEGER}");
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
     * This method corresponds to the database table product_category
     *
     * @mbg.generated Sat Apr 20 10:24:44 CST 2019
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("product_category");
        
        sql.SET("categoryId = #{record.categoryId,jdbcType=INTEGER}");
        sql.SET("categoryName = #{record.categoryName,jdbcType=VARCHAR}");
        sql.SET("categoryType = #{record.categoryType,jdbcType=INTEGER}");
        sql.SET("restaurantId = #{record.restaurantId,jdbcType=INTEGER}");
        sql.SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        ProductCategoryExample example = (ProductCategoryExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbg.generated Sat Apr 20 10:24:44 CST 2019
     */
    public String updateByPrimaryKeySelective(ProductCategory record) {
        SQL sql = new SQL();
        sql.UPDATE("product_category");
        
        if (record.getCategoryName() != null) {
            sql.SET("categoryName = #{categoryName,jdbcType=VARCHAR}");
        }
        
        if (record.getCategoryType() != null) {
            sql.SET("categoryType = #{categoryType,jdbcType=INTEGER}");
        }
        
        if (record.getRestaurantId() != null) {
            sql.SET("restaurantId = #{restaurantId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("updateTime = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("categoryId = #{categoryId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_category
     *
     * @mbg.generated Sat Apr 20 10:24:44 CST 2019
     */
    protected void applyWhere(SQL sql, ProductCategoryExample example, boolean includeExamplePhrase) {
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