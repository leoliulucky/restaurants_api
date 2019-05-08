package com.benxiaopao.provider.dao.map;

import com.benxiaopao.provider.dao.model.Order;
import com.benxiaopao.provider.dao.model.OrderExample.Criteria;
import com.benxiaopao.provider.dao.model.OrderExample.Criterion;
import com.benxiaopao.provider.dao.model.OrderExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OrderSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sat Apr 20 10:25:29 CST 2019
     */
    public String countByExample(OrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("order_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sat Apr 20 10:25:29 CST 2019
     */
    public String deleteByExample(OrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("order_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sat Apr 20 10:25:29 CST 2019
     */
    public String insertSelective(Order record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_info");
        
        if (record.getOrderId() != null) {
            sql.VALUES("orderId", "#{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getPayType() != null) {
            sql.VALUES("payType", "#{payType,jdbcType=INTEGER}");
        }
        
        if (record.getTotalAmout() != null) {
            sql.VALUES("totalAmout", "#{totalAmout,jdbcType=DECIMAL}");
        }
        
        if (record.getRealTotalAmout() != null) {
            sql.VALUES("realTotalAmout", "#{realTotalAmout,jdbcType=DECIMAL}");
        }
        
        if (record.getShipmentExpense() != null) {
            sql.VALUES("shipmentExpense", "#{shipmentExpense,jdbcType=DECIMAL}");
        }
        
        if (record.getOrderStatus() != null) {
            sql.VALUES("orderStatus", "#{orderStatus,jdbcType=SMALLINT}");
        }
        
        if (record.getOrderType() != null) {
            sql.VALUES("orderType", "#{orderType,jdbcType=TINYINT}");
        }
        
        if (record.getOrderFrom() != null) {
            sql.VALUES("orderFrom", "#{orderFrom,jdbcType=TINYINT}");
        }
        
        if (record.getpOrderId() != null) {
            sql.VALUES("pOrderId", "#{pOrderId,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerId() != null) {
            sql.VALUES("buyerId", "#{buyerId,jdbcType=INTEGER}");
        }
        
        if (record.getConsignee() != null) {
            sql.VALUES("consignee", "#{consignee,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.VALUES("province", "#{province,jdbcType=INTEGER}");
        }
        
        if (record.getCity() != null) {
            sql.VALUES("city", "#{city,jdbcType=INTEGER}");
        }
        
        if (record.getDistrict() != null) {
            sql.VALUES("district", "#{district,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.VALUES("tel", "#{tel,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sat Apr 20 10:25:29 CST 2019
     */
    public String selectByExample(OrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("orderId");
        } else {
            sql.SELECT("orderId");
        }
        sql.SELECT("payType");
        sql.SELECT("totalAmout");
        sql.SELECT("realTotalAmout");
        sql.SELECT("shipmentExpense");
        sql.SELECT("orderStatus");
        sql.SELECT("orderType");
        sql.SELECT("orderFrom");
        sql.SELECT("pOrderId");
        sql.SELECT("buyerId");
        sql.SELECT("consignee");
        sql.SELECT("province");
        sql.SELECT("city");
        sql.SELECT("district");
        sql.SELECT("address");
        sql.SELECT("tel");
        sql.SELECT("restaurantId");
        sql.SELECT("createTime");
        sql.SELECT("updateTime");
        sql.FROM("order_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sat Apr 20 10:25:29 CST 2019
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Order record = (Order) parameter.get("record");
        OrderExample example = (OrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("order_info");
        
        if (record.getOrderId() != null) {
            sql.SET("orderId = #{record.orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getPayType() != null) {
            sql.SET("payType = #{record.payType,jdbcType=INTEGER}");
        }
        
        if (record.getTotalAmout() != null) {
            sql.SET("totalAmout = #{record.totalAmout,jdbcType=DECIMAL}");
        }
        
        if (record.getRealTotalAmout() != null) {
            sql.SET("realTotalAmout = #{record.realTotalAmout,jdbcType=DECIMAL}");
        }
        
        if (record.getShipmentExpense() != null) {
            sql.SET("shipmentExpense = #{record.shipmentExpense,jdbcType=DECIMAL}");
        }
        
        if (record.getOrderStatus() != null) {
            sql.SET("orderStatus = #{record.orderStatus,jdbcType=SMALLINT}");
        }
        
        if (record.getOrderType() != null) {
            sql.SET("orderType = #{record.orderType,jdbcType=TINYINT}");
        }
        
        if (record.getOrderFrom() != null) {
            sql.SET("orderFrom = #{record.orderFrom,jdbcType=TINYINT}");
        }
        
        if (record.getpOrderId() != null) {
            sql.SET("pOrderId = #{record.pOrderId,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerId() != null) {
            sql.SET("buyerId = #{record.buyerId,jdbcType=INTEGER}");
        }
        
        if (record.getConsignee() != null) {
            sql.SET("consignee = #{record.consignee,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.SET("province = #{record.province,jdbcType=INTEGER}");
        }
        
        if (record.getCity() != null) {
            sql.SET("city = #{record.city,jdbcType=INTEGER}");
        }
        
        if (record.getDistrict() != null) {
            sql.SET("district = #{record.district,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sat Apr 20 10:25:29 CST 2019
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("order_info");
        
        sql.SET("orderId = #{record.orderId,jdbcType=VARCHAR}");
        sql.SET("payType = #{record.payType,jdbcType=INTEGER}");
        sql.SET("totalAmout = #{record.totalAmout,jdbcType=DECIMAL}");
        sql.SET("realTotalAmout = #{record.realTotalAmout,jdbcType=DECIMAL}");
        sql.SET("shipmentExpense = #{record.shipmentExpense,jdbcType=DECIMAL}");
        sql.SET("orderStatus = #{record.orderStatus,jdbcType=SMALLINT}");
        sql.SET("orderType = #{record.orderType,jdbcType=TINYINT}");
        sql.SET("orderFrom = #{record.orderFrom,jdbcType=TINYINT}");
        sql.SET("pOrderId = #{record.pOrderId,jdbcType=VARCHAR}");
        sql.SET("buyerId = #{record.buyerId,jdbcType=INTEGER}");
        sql.SET("consignee = #{record.consignee,jdbcType=VARCHAR}");
        sql.SET("province = #{record.province,jdbcType=INTEGER}");
        sql.SET("city = #{record.city,jdbcType=INTEGER}");
        sql.SET("district = #{record.district,jdbcType=INTEGER}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        sql.SET("restaurantId = #{record.restaurantId,jdbcType=INTEGER}");
        sql.SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("updateTime = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        OrderExample example = (OrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sat Apr 20 10:25:29 CST 2019
     */
    public String updateByPrimaryKeySelective(Order record) {
        SQL sql = new SQL();
        sql.UPDATE("order_info");
        
        if (record.getPayType() != null) {
            sql.SET("payType = #{payType,jdbcType=INTEGER}");
        }
        
        if (record.getTotalAmout() != null) {
            sql.SET("totalAmout = #{totalAmout,jdbcType=DECIMAL}");
        }
        
        if (record.getRealTotalAmout() != null) {
            sql.SET("realTotalAmout = #{realTotalAmout,jdbcType=DECIMAL}");
        }
        
        if (record.getShipmentExpense() != null) {
            sql.SET("shipmentExpense = #{shipmentExpense,jdbcType=DECIMAL}");
        }
        
        if (record.getOrderStatus() != null) {
            sql.SET("orderStatus = #{orderStatus,jdbcType=SMALLINT}");
        }
        
        if (record.getOrderType() != null) {
            sql.SET("orderType = #{orderType,jdbcType=TINYINT}");
        }
        
        if (record.getOrderFrom() != null) {
            sql.SET("orderFrom = #{orderFrom,jdbcType=TINYINT}");
        }
        
        if (record.getpOrderId() != null) {
            sql.SET("pOrderId = #{pOrderId,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyerId() != null) {
            sql.SET("buyerId = #{buyerId,jdbcType=INTEGER}");
        }
        
        if (record.getConsignee() != null) {
            sql.SET("consignee = #{consignee,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.SET("province = #{province,jdbcType=INTEGER}");
        }
        
        if (record.getCity() != null) {
            sql.SET("city = #{city,jdbcType=INTEGER}");
        }
        
        if (record.getDistrict() != null) {
            sql.SET("district = #{district,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{tel,jdbcType=VARCHAR}");
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
        
        sql.WHERE("orderId = #{orderId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sat Apr 20 10:25:29 CST 2019
     */
    protected void applyWhere(SQL sql, OrderExample example, boolean includeExamplePhrase) {
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