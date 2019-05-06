package com.benxiaopao.provider.dao.map;

import com.benxiaopao.provider.dao.model.UserLoginFailure;
import com.benxiaopao.provider.dao.model.UserLoginFailureExample.Criteria;
import com.benxiaopao.provider.dao.model.UserLoginFailureExample.Criterion;
import com.benxiaopao.provider.dao.model.UserLoginFailureExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserLoginFailureSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_failure
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public String countByExample(UserLoginFailureExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("user_login_failure");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_failure
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public String deleteByExample(UserLoginFailureExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("user_login_failure");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_failure
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public String insertSelective(UserLoginFailure record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_login_failure");
        
        if (record.getUserId() != null) {
            sql.VALUES("userId", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getAttemptTimes() != null) {
            sql.VALUES("attemptTimes", "#{attemptTimes,jdbcType=INTEGER}");
        }
        
        if (record.getLastAttemped() != null) {
            sql.VALUES("lastAttemped", "#{lastAttemped,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLocked() != null) {
            sql.VALUES("lastLocked", "#{lastLocked,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginIP() != null) {
            sql.VALUES("lastLoginIP", "#{lastLoginIP,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_failure
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public String selectByExample(UserLoginFailureExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("userId");
        } else {
            sql.SELECT("userId");
        }
        sql.SELECT("attemptTimes");
        sql.SELECT("lastAttemped");
        sql.SELECT("lastLocked");
        sql.SELECT("lastLoginIP");
        sql.FROM("user_login_failure");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_failure
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserLoginFailure record = (UserLoginFailure) parameter.get("record");
        UserLoginFailureExample example = (UserLoginFailureExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("user_login_failure");
        
        if (record.getUserId() != null) {
            sql.SET("userId = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getAttemptTimes() != null) {
            sql.SET("attemptTimes = #{record.attemptTimes,jdbcType=INTEGER}");
        }
        
        if (record.getLastAttemped() != null) {
            sql.SET("lastAttemped = #{record.lastAttemped,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLocked() != null) {
            sql.SET("lastLocked = #{record.lastLocked,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginIP() != null) {
            sql.SET("lastLoginIP = #{record.lastLoginIP,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_failure
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("user_login_failure");
        
        sql.SET("userId = #{record.userId,jdbcType=INTEGER}");
        sql.SET("attemptTimes = #{record.attemptTimes,jdbcType=INTEGER}");
        sql.SET("lastAttemped = #{record.lastAttemped,jdbcType=TIMESTAMP}");
        sql.SET("lastLocked = #{record.lastLocked,jdbcType=TIMESTAMP}");
        sql.SET("lastLoginIP = #{record.lastLoginIP,jdbcType=BIGINT}");
        
        UserLoginFailureExample example = (UserLoginFailureExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_failure
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    public String updateByPrimaryKeySelective(UserLoginFailure record) {
        SQL sql = new SQL();
        sql.UPDATE("user_login_failure");
        
        if (record.getAttemptTimes() != null) {
            sql.SET("attemptTimes = #{attemptTimes,jdbcType=INTEGER}");
        }
        
        if (record.getLastAttemped() != null) {
            sql.SET("lastAttemped = #{lastAttemped,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLocked() != null) {
            sql.SET("lastLocked = #{lastLocked,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginIP() != null) {
            sql.SET("lastLoginIP = #{lastLoginIP,jdbcType=BIGINT}");
        }
        
        sql.WHERE("userId = #{userId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_failure
     *
     * @mbg.generated Sun May 05 00:45:08 CST 2019
     */
    protected void applyWhere(SQL sql, UserLoginFailureExample example, boolean includeExamplePhrase) {
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