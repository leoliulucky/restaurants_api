package com.benxiaopao.provider.service;

import com.benxiaopao.provider.dao.map.UserMapper;
import com.benxiaopao.provider.dao.map.UserRegisterTempMapper;
import com.benxiaopao.provider.dao.model.*;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户业务逻辑服务处理类
 *
 * Created by liupoyang
 * 2019-04-21
 */
@Service
@Slf4j
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRegisterTempMapper userRegisterTempMapper;

    /**
     * 根据条件获取用户列表，带分页
     * @param user 条件参数用户对象
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return List<User> 用户列表
     */
    public List<User> listUserByPage(User user, int pageNum, int pageSize) throws Exception {
        int start = (pageNum - 1) * pageSize;
        //查询列表
        List<User> users = this.listUserByWhere(user, start, pageSize);
        return users;
    }

    public List<User> listUserByWhere(User user, Integer start, Integer offset)
            throws Exception {
        UserExample example = _buildExampleByWhere(user);

        //由参数决定是否进行分页
        if(start != null && start >= 0 && offset != null && offset > 0){
            //排序条件、限制查询记录数
            example.setOrderByClause("userId asc limit " + start + ", " + offset);
        }

        return userMapper.selectByExample(example);
    }

    public int countUserByWhere(User user) throws Exception {
        UserExample example = _buildExampleByWhere(user);
        long count = userMapper.countByExample(example);
        return Integer.valueOf(String.valueOf(count));
    }

    /**
     * 构建查询条件对象<br />私有方法
     * @param user 查询条件参数对象
     * @return UserExample
     */
    private UserExample _buildExampleByWhere(User user){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        if(user != null && StringUtils.hasText(user.getNickName())){
            criteria.andNickNameEqualTo(user.getNickName());
        }
        return example;
    }

    /**
     * 新增用户
     * @param user 要插入的用户数据对象
     */
    public void insertUser(User user) throws Exception {
        //新增用户
        log.info("#新增用户，其中 userName=" + user.getNickName() + " mobile=" + user.getMobile());
        int records = userMapper.insert(user);
        Preconditions.checkArgument(records > 0, "新增用户失败");
    }

    /**
     * 修改用户
     * @param user 要更新的用户数据对象
     */
    public void updateUser(User user) throws Exception {
        //更新用户
        log.info("#更新用户，其中userId=" + user.getUserId() + " nickName=" + user.getNickName() + " mobile=" + user.getMobile());
        int records = userMapper.updateByPrimaryKeySelective(user);
        Preconditions.checkArgument(records > 0, "修改用户失败");
    }

    /**
     * 删除用户
     * @param userId 用户id
     */
    public void deleteUser(int userId) throws Exception {
        User queryUser = this.getUserById(userId);
        Preconditions.checkNotNull(queryUser, "要删除的用户不存在");

        //删除用户
        log.info("#删除用户，其中userId=" + userId);
        int records = userMapper.deleteByPrimaryKey(userId);
        Preconditions.checkArgument(records > 0, "删除用户失败");
    }

    /**
     * 根据用户id获取用户对象
     * @param userId 用户id
     */
    public User getUserById(int userId) throws Exception {
        //根据用户id查询用户对象
        User user = userMapper.selectByPrimaryKey(userId);
        Preconditions.checkNotNull(user, "获取用户成员失败");
        return user;
    }

    /**
     * 根据条件获取临时注册用户列表，带分页
     * @param userRegisterTemp 条件参数临时注册用户对象
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return List<UserRegisterTemp> 临时注册用户列表
     */
    public List<UserRegisterTemp> listUserRegisterTempByPage(UserRegisterTemp userRegisterTemp, int pageNum, int pageSize) throws Exception {
        int start = (pageNum - 1) * pageSize;
        //查询列表
        List<UserRegisterTemp> userRegisterTemps = this.listUserRegisterTempByWhere(userRegisterTemp, start, pageSize);
        return userRegisterTemps;
    }

    public List<UserRegisterTemp> listUserRegisterTempByWhere(UserRegisterTemp userRegisterTemp, Integer start, Integer offset)
            throws Exception {
        UserRegisterTempExample example = _buildExampleByWhere(userRegisterTemp);

        //由参数决定是否进行分页
        if(start != null && start >= 0 && offset != null && offset > 0){
            //排序条件、限制查询记录数
            example.setOrderByClause("id asc limit " + start + ", " + offset);
        }

        return userRegisterTempMapper.selectByExample(example);
    }

    public int countUserRegisterTempByWhere(UserRegisterTemp userRegisterTemp) throws Exception {
        UserRegisterTempExample example = _buildExampleByWhere(userRegisterTemp);
        long count = userRegisterTempMapper.countByExample(example);
        return Integer.valueOf(String.valueOf(count));
    }

    /**
     * 构建查询条件对象<br />私有方法
     * @param userRegisterTemp 查询条件参数对象
     * @return UserRegisterTempExample
     */
    private UserRegisterTempExample _buildExampleByWhere(UserRegisterTemp userRegisterTemp){
        UserRegisterTempExample example = new UserRegisterTempExample();
        UserRegisterTempExample.Criteria criteria = example.createCriteria();

        if(userRegisterTemp != null && StringUtils.hasText(userRegisterTemp.getNickName())){
            criteria.andNickNameEqualTo(userRegisterTemp.getNickName());
        }
        return example;
    }

    /**
     * 新增临时注册用户
     * @param userRegisterTemp 要插入的临时注册用户数据对象
     */
    public void insertUserRegisterTemp(UserRegisterTemp userRegisterTemp) throws Exception {
        //新增临时注册用户
        log.info("#新增临时注册用户，其中 userRegisterTempName=" + userRegisterTemp.getNickName() + " mobile=" + userRegisterTemp.getMobile());
        int records = userRegisterTempMapper.insert(userRegisterTemp);
        Preconditions.checkArgument(records > 0, "新增临时注册用户失败");
    }

    /**
     * 修改临时注册用户
     * @param userRegisterTemp 要更新的临时注册用户数据对象
     */
    public void updateUserRegisterTemp(UserRegisterTemp userRegisterTemp) throws Exception {
        //更新临时注册用户
        log.info("#更新临时注册用户，其中userRegisterTempId=" + userRegisterTemp.getId() + " nickName=" + userRegisterTemp.getNickName() + " mobile=" + userRegisterTemp.getMobile());
        int records = userRegisterTempMapper.updateByPrimaryKeySelective(userRegisterTemp);
        Preconditions.checkArgument(records > 0, "修改临时注册用户失败");
    }

    /**
     * 删除临时注册用户
     * @param userRegisterTempId 临时注册用户id
     */
    public void deleteUserRegisterTemp(int userRegisterTempId) throws Exception {
        UserRegisterTemp queryUserRegisterTemp = this.getUserRegisterTempById(userRegisterTempId);
        Preconditions.checkNotNull(queryUserRegisterTemp, "要删除的临时注册用户不存在");

        //删除临时注册用户
        log.info("#删除临时注册用户，其中userRegisterTempId=" + userRegisterTempId);
        int records = userRegisterTempMapper.deleteByPrimaryKey(userRegisterTempId);
        Preconditions.checkArgument(records > 0, "删除临时注册用户失败");
    }

    /**
     * 根据id获取临时注册用户对象
     * @param userRegisterTempId 临时注册用户id
     */
    public UserRegisterTemp getUserRegisterTempById(int userRegisterTempId) throws Exception {
        //根据id查询临时注册用户对象
        UserRegisterTemp userRegisterTemp = userRegisterTempMapper.selectByPrimaryKey(userRegisterTempId);
        Preconditions.checkNotNull(userRegisterTemp, "获取临时注册用户时失败");
        return userRegisterTemp;
    }
}
