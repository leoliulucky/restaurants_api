package com.benxiaopao.provider.service;

import com.benxiaopao.common.exception.BizException;
import com.benxiaopao.common.util.DateUtil;
import com.benxiaopao.common.util.HttpClientUtil;
import com.benxiaopao.common.util.ThreadContent;
import com.benxiaopao.provider.common.util.MD5;
import com.benxiaopao.provider.common.util.MobileVerifyCode;
import com.benxiaopao.provider.common.util.RegExpValidator;
import com.benxiaopao.provider.dao.map.*;
import com.benxiaopao.provider.dao.model.*;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Resource
    private UserLoginIpMapper userLoginIpMapper;
    @Resource
    private UserLoginFailureMapper userLoginFailureMapper;
    @Resource
    private IpaddressMapper ipaddressMapper;
    @Resource
    private AuthenRecordService authenRecordService;

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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
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

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
    public Map<String, Object> login(String loginId, String password, long loginIP,
                                     short browserType, short osType) throws Exception {
//        UserVo userVo = new UserVo();
        Map<String, Object> result = Maps.newHashMap();
        if (loginId == null || password == null || loginId.length() < 2 || password.length() < 2 || loginId.equalsIgnoreCase("null"))
        {
            throw new Exception("登录时传入的用户名或密码为空或过短");
        }
        User user = null;
        UserRegisterTemp userRegisterTemp = null;
//        UserRegisterTempMapper userRegisterTempMapper = readonlySQLSession.getMapper(UserRegisterTempMapper.class);
        int userId = 0;
        Date loginTime = new Date();
        //判断临时用户使用何种方式登录
        int loginType = 3;
        //先用VIP用户登录
        //判断登录名类型
        try {
            if (RegExpValidator.isEmail(loginId))
            {
                user = verifyLogin(loginId, password, 1, loginIP);
                loginType = 1;
            }
            else if (RegExpValidator.IsTelephone(loginId))
            {
                user = verifyLogin(loginId, password, 2, loginIP);
                loginType = 2;
            }
            else
            {
                user = verifyLogin(loginId, password, 3, loginIP);
            }
        } catch (Exception e) {
            log.error("进行登录检查时发生异常", e);
        }
        // 登录名正确，但密码错误。查询登录名对应的用户id
        if(user.getUserId().intValue() == -4) {
//            UserMapper userMapper = writableSQLSession.getMapper(UserMapper.class);
            User correctUser = new User();
            switch (loginType) {
                case 1:
                    correctUser = userMapper.getUserByEmail(loginId);
                    break;
                case 2:
                    correctUser = userMapper.getUserByMobile(loginId);
                    break;
                case 3:
                    correctUser = userMapper.getUserByNickName(loginId);
            }
//            userVo.setCorrectUserId(correctUser.getUserId());
            result.put("correctUserId", correctUser.getUserId());
        }

        if (user.getUserId().intValue() > 0 || user.getUserId().intValue() == -4 ||
                user.getUserId().intValue() == -98|| user.getUserId().intValue() == -99 ||
                user.getUserId().intValue() == -100)
        {
            userId = user.getUserId();
            if(user.getUserId().intValue() > 0){
                addLoginRecord(userId, loginIP, browserType, osType, loginTime);
            }
        }else{//VIP用户表中昵称不存在
            //修改临时用户可以使用mobile、email、nickname登录
            if(loginType == 3){
                userRegisterTemp = userRegisterTempMapper.getUserRegisterTempByNickName(loginId);
            }else if(loginType == 2){
                userRegisterTemp = userRegisterTempMapper.getUserRegisterTempByMobile(loginId);
            }else if(loginType == 1){
                userRegisterTemp = userRegisterTempMapper.getUserRegisterTempByEmail(loginId);
            }
            if(userRegisterTemp == null){
                userRegisterTemp = new UserRegisterTemp();
                //临时用户表中昵称不存在
                userRegisterTemp.setId(-3);
            }else{
                if(!userRegisterTemp.getPasswd().equals(MD5.encodeByMd5AndSalt(password))){
                    log.info("临时用户（" + loginId + "）使用" + getLoginType(loginType) + "登录，密码错误");
                    //临时用户密码错误
                    userRegisterTemp.setId(-4);
                }
            }
        }
//        userVo.setUserRegisterTemp(userRegisterTemp);
//        userVo.setUser(user);
//        return userVo;
        result.put("userRegisterTemp", userRegisterTemp);
        result.put("user", user);
        return result;
    }

    private User verifyLogin(String loginId, String password, int loginIdType, long loginIP) throws Exception
    {
//        UserMapper userMapper = writableSQLSession.getMapper(UserMapper.class);
        User user = new User();
        int isSet = 0;
        switch (loginIdType) {
            case 1:
                isSet = userMapper.isEmailExist(loginId);
                break;
            case 2:
                isSet = userMapper.isMobileExist(loginId);
                break;
            case 3:
                isSet = userMapper.isNickNameExist(loginId);
        }

        if (isSet == 0)
        {
            //未注册
            user = new User();
            user.setUserId((0 - loginIdType));
            log.info("用户（" + loginId + "）尝试使用" + getLoginType(loginIdType) + "登录，但" + getLoginType(loginIdType)
                    + "不存在");
        }
        else
        {
            //判断密码是否正确
            switch (loginIdType) {
                case 1:
                    user = userMapper.getUserByEmail(loginId);
                    break;
                case 2: {
                    user = userMapper.getUserByMobile(loginId);
                    break;
                }
                case 3:
                    user = userMapper.getUserByNickName(loginId);
            }

            //登录尝试锁定
            if (user != null) {
                UserLoginFailure userLoginFailure = userLoginFailureMapper.selectByPrimaryKey(user.getUserId());
                //尝试登录失败次数大于等于三次时，禁止用昵称登陆
                if(loginIdType == 3 && userLoginFailure != null && userLoginFailure.getAttemptTimes() >= 3){
                    user = new User();
                    user.setUserId(-100);
                    log.info("用户（" + loginId + "）尝试使用昵称登录，但尝试登陆失败次数大于等于3，禁止用昵称登陆，返回-100");
                    return user;
                }

                if (userLoginFailure != null && userLoginFailure.getAttemptTimes() != null
                        && userLoginFailure.getAttemptTimes() >= UserLoginFailure.MAX_ATTEMPTS_LOCKED) {
                    userLoginFailure.setLastLocked(new Date());
                    userLoginFailure.setAttemptTimes(0);
                    userLoginFailureMapper.updateByPrimaryKey(userLoginFailure);
                }
                if (userLoginFailure != null && userLoginFailure.getLastLocked() != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(userLoginFailure.getLastLocked());
                    calendar.set(Calendar.HOUR_OF_DAY, 23);
                    calendar.set(Calendar.MINUTE, 59);
                    calendar.set(Calendar.SECOND, 59);
                    if (calendar.getTime().after(new Date())) {
                        user = new User();
                        user.setUserId(-99);
                        log.info("用户（" + loginId + "）尝试使用" + getLoginType(loginIdType) + "登录，但账户已被锁定，返回-99");
                        return user;
                    }
                }
            }

            if (user != null && user.getPassword().equals(MD5.encodeByMd5AndSalt(password)))
            {
                log.info("用户（" + user.getUserId() + "，" + user.getNickName() + "，" + user.getEmail() + "）使用"
                        + getLoginType(loginIdType) + "登录成功");
            }
            else
            {
                // 密码错误
                //登录尝试锁定
                if (user != null) {
                    userLoginFailureMapper.increaseAttemptTimesByUserId(user.getUserId());
                    userLoginFailureMapper.updateLastLoginIPByUserId(user.getUserId(), loginIP);
                }
                user = new User();
                user.setUserId(-4);
                log.info("用户（" + loginId + "）尝试使用" + getLoginType(loginIdType) + "登录，但密码错误，返回-4");
                return user;
            }
        }
        return user;
    }

    private static String getLoginType(int type)
    {
        if (type == 1)
        {
            return "邮箱";
        }
        else if (type == 2)
        {
            return "手机";
        }
        else
        {
            return "昵称";
        }
    }

    private void addLoginRecord(Integer userId, long loginIP, short browserType,
                               short osType, Date loginTime) {
        UserLoginIp userLoginIP = new UserLoginIp();
        userLoginIP.setUserId(userId);
        userLoginIP.setLoginIP(loginIP);
        userLoginIP.setOsType(osType);
        userLoginIP.setBrowserType(browserType);
        userLoginIP.setLoginTime(loginTime);
        String loginaddress;
        // 通过ip地址查询用户登录地址信息
        Ipaddress ipAddress = null;
        try {
            ipAddress = ipaddressMapper.queryLoacationByIp(loginIP);
        } catch (Exception e) {
            log.error("通过ip地址查询用户登录地址信息错误："+e.getMessage());
        }
        if (ipAddress == null)
        {
            loginaddress = "未知地址";
        }
        else
        {
            loginaddress = ipAddress.getAddress() + " " + ipAddress.getDetail();
            if (loginaddress.length() > 64)
                loginaddress = loginaddress.substring(0, 64);
        }
        userLoginIP.setLoginAddress(loginaddress);
        userLoginIpMapper.insert(userLoginIP);
    }

    public void resetLoginAttemptTimes(Integer userId) throws Exception {
        userLoginFailureMapper.resetAttemptTimesByUserId(userId);
    }

    public boolean requireValidateCode(Integer userId) throws Exception {
        UserLoginFailure userLoginFailure = userLoginFailureMapper.selectByPrimaryKey(userId);
        if (userLoginFailure != null && userLoginFailure.getAttemptTimes() != null
                && userLoginFailure.getAttemptTimes() >= UserLoginFailure.MAX_ATTEMPTS_VALIDATE) {
            return true;
        }
        return false;
    }

    public int registerNewUser(UserRegisterTemp newUser) throws Exception {
        log.info("开始注册新用户昵称:" + newUser.getNickName());

        Preconditions.checkArgument(!this.existNickName(newUser.getNickName()), "此用户名已存在，请重新输入");
        newUser.setPasswd(MD5.encodeByMd5AndSalt(newUser.getPasswd()));
        userRegisterTempMapper.insertSelective(newUser);
        int userRegisterTempId = newUser.getId();
        return userRegisterTempId;
    }

    public boolean existNickName(String nickName) throws Exception {
        int istempExists = userRegisterTempMapper.isNickNameExist(nickName);
        int isExists = userMapper.isNickNameExist(nickName);
        if (isExists == 0 && istempExists == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 注册激活获取手机验证码
     * @param mobile 手机号
     * @return long 手机认证id
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
    public long getMobileCode4Register(String mobile, int tempUserId) throws Exception {
        boolean isExistMobile = this.isMobileExists(mobile);
        Preconditions.checkArgument(!isExistMobile, "此手机号已与其他账号绑定，请更换手机号");

        UserRegisterTemp userRegisterTemp = userRegisterTempMapper.selectByPrimaryKey(tempUserId);
        Preconditions.checkNotNull(userRegisterTemp, "找不到对应的注册信息，请检查");
        userRegisterTemp.setMobile(mobile);
        userRegisterTemp.setEmail(null);
        this.updateUserRegisterTemp(userRegisterTemp);

        MobileAuthen mobileAuthen = new MobileAuthen();
        mobileAuthen.setMobile(mobile);
        mobileAuthen.setSendTime(DateUtil.now());
        mobileAuthen.setUserId(tempUserId);
        String verifyCode = MobileVerifyCode.MobileVfCode();
        mobileAuthen.setValidCode(verifyCode);
        long mobileAuthenId = authenRecordService.addMobileAuthen(mobileAuthen);
        Preconditions.checkArgument(mobileAuthenId > 0, "获取手机验证码出错，请联系客服");
        log.info("# 手机 {} 获取验证码 {} 成功", mobile, verifyCode);
        ThreadContent.set(null, null);
        ThreadContent.addData("verifyCode", verifyCode);

        return mobileAuthenId;
    }

    public boolean isMobileExists(String mobile) throws Exception {
        log.info("检查用户手机是否存在，手机号：" + mobile);
        int isExists = userMapper.isMobileExist(mobile);
        if (isExists == 0) {
//			log.info("手机" + mobile + "不存在，可以注册");
            return false;
        } else {
//			log.info("手机" + mobile + "存在，不可注册");
            return true;
        }
    }

    public UserRegisterTemp getUserRegisterTempById(Integer userRegisterTempId) {
        UserRegisterTemp userRegisterTemp = userRegisterTempMapper.selectByPrimaryKey(userRegisterTempId);
        return userRegisterTemp;
    }

    /**
     * 注册激活验证手机验证码
     * @param mobile 手机号
     * @param verifyCode 验证码
     * @param mobileAuthenId 手机认证id
     * @return
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public User verifyMobileCode4Register(String mobile, String verifyCode, long mobileAuthenId, int userRegisterTempId) throws Exception {
        MobileAuthen mobileAuthen = authenRecordService.getMobileAuthenById(mobileAuthenId);
        Preconditions.checkNotNull(mobileAuthen, "请刷新页面后重新验证");
        Preconditions.checkArgument(mobileAuthen.getMobile().equals(mobile), "请刷新页面后重新验证");
        Preconditions.checkArgument(mobileAuthen.getValidCode().equalsIgnoreCase(verifyCode), "验证码输入错误，请检查");

        int userId = this.verifyUser(userRegisterTempId);
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }

    private int verifyUser(int userRegisterTempId) throws Exception {
        log.info("根据userRegisterTempId获取UserRegisterTemp对象，以添加User对象，userRegisterTempId：" + userRegisterTempId);
        UserRegisterTemp userRegisterTemp = userRegisterTempMapper.getUserRegisterTempByIdForUpdate(userRegisterTempId);
        Preconditions.checkNotNull(userRegisterTemp, "该用户已激活");

        if(userMapper.isNickNameExist(userRegisterTemp.getNickName())>0){
            throw new Exception("用户昵称：（"+userRegisterTemp.getNickName()+"）已存在");
        }
        User user = new User();
        user.setEmail(userRegisterTemp.getEmail());
        user.setNickName(userRegisterTemp.getNickName());
        user.setPassword(userRegisterTemp.getPasswd());
        user.setRegisterTime(userRegisterTemp.getRegisterTime());
        user.setWeiboUId(userRegisterTemp.getWeiboUId());
        user.setWeiboAccessToken(userRegisterTemp.getWeiboAccessToken());
        user.setQqUId(userRegisterTemp.getQqUId());
        user.setQqAccessToken(userRegisterTemp.getQqAccessToken());
        user.setMobile(userRegisterTemp.getMobile());
        Date now = new Date();
        user.setActiveTime(now);
        user.setRegisterChannelId(userRegisterTemp.getRegisterChannelId());
        // 注册新用户到user_main表
        try {
            userMapper.insertSelective(user);
        } catch (Exception e) {
            throw new Exception("激活用户失败",e);
        }
        // 新用户验证成功后，将临时表中的数据删除
        userRegisterTempMapper.deleteByPrimaryKey(userRegisterTempId);
        return user.getUserId();
    }

    /**
     * 找回密码获取手机验证码
     * @param mobile 手机号
     * @return long 手机认证id
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
    public long getMobileCode4ResetPwd(String mobile) throws Exception {
        User user = user = userMapper.getUserByMobile(mobile);
        Preconditions.checkNotNull(user, "没有与此手机号对应的账户");

        //是否被锁定
        UserLoginFailure userLoginFailure = userLoginFailureMapper.selectByPrimaryKey(user.getUserId());
        boolean isLocked = false;
        if(userLoginFailure != null && userLoginFailure.getLastLocked() != null){
            String lockTimeStr = DateUtil.formatDate(userLoginFailure.getLastLocked(), "yyyy-MM-dd") + " 23:59:59";
            Date lockTime = DateUtil.parseDate(lockTimeStr, "yyyy-MM-dd HH:mm:ss");
            isLocked = lockTime.after(DateUtil.now());
        }
        Preconditions.checkArgument(!isLocked, "为保证账户安全，此账号已被锁定，请联系客服人工解锁");

        MobileAuthen mobileAuthen = new MobileAuthen();
        mobileAuthen.setMobile(mobile);
        mobileAuthen.setSendTime(DateUtil.now());
        mobileAuthen.setUserId(user.getUserId());
        String verifyCode = MobileVerifyCode.MobileVfCode();
        mobileAuthen.setValidCode(verifyCode);
        long mobileAuthenId = authenRecordService.addMobileAuthen(mobileAuthen);
        Preconditions.checkArgument(mobileAuthenId > 0, "获取手机验证码出错，请联系客服");
        log.info("# 手机 {} 获取验证码 {} 成功", mobile, verifyCode);
        ThreadContent.set(null, null);
        ThreadContent.addData("verifyCode", verifyCode);

        return mobileAuthenId;
    }

    /**
     * 找回密码验证手机验证码
     * @param mobile 手机号
     * @param code 验证码
     * @param mobileAuthenId 手机认证id
     */
    public User verifyMobileCode4ResetPwd(String mobile, String code, long mobileAuthenId) throws Exception {
        User user = userMapper.getUserByMobile(mobile);
        Preconditions.checkNotNull(user, "没有与此手机号对应的账户");

        MobileAuthen mobileAuthen = authenRecordService.getMobileAuthenById(mobileAuthenId);
        Preconditions.checkNotNull(mobileAuthen, "请刷新页面后重新验证");
        Preconditions.checkArgument(mobileAuthen.getMobile().equals(mobile), "请刷新页面后重新验证");
        Preconditions.checkArgument(mobileAuthen.getValidCode().equalsIgnoreCase(code), "验证码输入错误，请检查");
        //验证码时效为30分钟
        Preconditions.checkArgument(DateUtil.now().getTime() < mobileAuthen.getSendTime().getTime() + 30 * 60 * 1000, "验证码失效，请重新获取验证码后重试");

        return user;
    }

    /**
     * 重置密码
     * @param password 新密码
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
    public void resetPwd(int userId, String password) throws Exception {
        User user = userMapper.selectByPrimaryKey(userId);
        Preconditions.checkNotNull(user, "重置密码的账户信息不存在");

        if(!Strings.isNullOrEmpty(user.getEmail())){
            this.resetUserPassword(user.getEmail(), password);
        }else{
            this.resetUserPasswordByMobile(user.getMobile(), password);
        }

        // 重置最大尝试次数
        this.resetLoginAttemptTimes(user.getUserId());
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
    public void resetUserPassword(String email, String newPassword)
            throws Exception {
        log.debug("重置用户登录密码，用户邮箱(" + email+")");
        try {
            User user = userMapper.getUserByEmailForUpdate(email);
            userMapper.resetUserPassword(user.getEmail(), MD5.encodeByMd5AndSalt(newPassword));
        } catch (Exception e) {
            log.error("通过邮箱("+email+")重置用户密码异常", e);
            throw new Exception("通过邮箱("+email+")重置用户密码异常",e);
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
    public void resetUserPasswordByMobile(String mobile, String newPassword)
            throws Exception {
        log.debug("重置用户登录密码，用户手机(" + mobile+")");
        try {
            User user = userMapper.getUserByMobileForUpdate(mobile);
            userMapper.resetUserPasswordByMobile(user.getMobile(), MD5.encodeByMd5AndSalt(newPassword));
        } catch (Exception e) {
            log.error("通过手机("+mobile+")重置用户密码异常", e);
            throw new Exception("通过手机("+mobile+")重置用户密码异常",e);
        }
    }

}
