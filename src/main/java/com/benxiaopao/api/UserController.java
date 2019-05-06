package com.benxiaopao.api;

import com.benxiaopao.common.util.DateUtil;
import com.benxiaopao.common.util.ThreadContent;
import com.benxiaopao.common.util.ViewResult;
import com.benxiaopao.provider.dao.model.Restaurant;
import com.benxiaopao.provider.dao.model.User;
import com.benxiaopao.provider.dao.model.UserRegisterTemp;
import com.benxiaopao.provider.service.ProductService;
import com.benxiaopao.provider.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 用户api
 *
 * Created by liupoyang
 * 2019-05-03
 */
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/login")
    public String login(String loginId, String password, long loginIP,
                        short browserType, short osType) throws Exception {
        try {
            Map<String, Object> userInfoMap = userService.login(loginId, password, loginIP, browserType, osType);
            User user = (User) userInfoMap.get("user");
            UserRegisterTemp userRegisterTemp = (UserRegisterTemp) userInfoMap.get("userRegisterTemp");
            boolean requireValidateCode = false;
            if (user != null && user.getUserId() > 0) {
                // 重置最大尝试次数
                userService.resetLoginAttemptTimes(user.getUserId());
                //要求验证码
                requireValidateCode = userService.requireValidateCode(user.getUserId());
            }
            if (user != null && user.getUserId() == -4) {
                int correctUserId = (int) userInfoMap.get("correctUserId");
                //要求验证码
                requireValidateCode = userService.requireValidateCode(correctUserId);
            }

            return ViewResult.newInstance()
                    .code(1).msg("用户登录成功")
                    .put("userInfoMap", userInfoMap)
                    .put("requireValidateCode", requireValidateCode)
                    .json();
        } catch (Exception e) {
            log.error("#用户登录出错：", e);
            return ViewResult.newInstance().code(-1).msg(e.getMessage()).json();
        }
    }

    /**
     * 用户注册
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/register")
    public String register(String account, String password) throws Exception {
        try {
            UserRegisterTemp userRegisterTemp = new UserRegisterTemp();
            userRegisterTemp.setNickName(account);
            userRegisterTemp.setPasswd(password);
            userRegisterTemp.setRegisterTime(DateUtil.now());
            int userRegisterTempId = userService.registerNewUser(userRegisterTemp);

            return ViewResult.newInstance()
                    .code(1).msg("用户注册成功")
                    .put("userRegisterTempId", userRegisterTempId)
                    .json();
        } catch (Exception e) {
            log.error("#用户注册出错：", e);
            return ViewResult.newInstance().code(-1).msg(e.getMessage()).json();
        }
    }

    /**
     * 注册激活获取手机验证码
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/register/fetchcode")
    public String getMobileCode4Register(String mobile, int userRegisterTempId) throws Exception {
        try {
            long mobileAuthenId = userService.getMobileCode4Register(mobile, userRegisterTempId);

            return ViewResult.newInstance()
                    .code(1).msg("注册激活获取手机验证码成功")
                    .put("mobileAuthenId", mobileAuthenId)
                    .put("verifyCode", ThreadContent.getData("verifyCode"))
                    .json();
        } catch (Exception e) {
            log.error("#注册激活获取手机验证码出错：", e);
            return ViewResult.newInstance().code(-1).msg(e.getMessage()).json();
        }
    }

    /**
     * 注册激活验证手机验证码
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/register/verifycode")
    public String verifyMobileCode4Register(String mobile, String verifyCode, long mobileAuthenId, int userRegisterTempId) throws Exception {
        try {
            User user = userService.verifyMobileCode4Register(mobile, verifyCode, mobileAuthenId, userRegisterTempId);

            return ViewResult.newInstance()
                    .code(1).msg("注册激活验证手机验证码成功")
                    .put("user", user)
                    .json();
        } catch (Exception e) {
            log.error("#注册激活验证手机验证码出错：", e);
            return ViewResult.newInstance().code(-1).msg(e.getMessage()).json();
        }
    }

    /**
     * 找回密码获取手机验证码
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/resetpwd/fetchcode")
    public String getMobileCode4ResetPwd(String mobile) throws Exception {
        try {
            long mobileAuthenId = userService.getMobileCode4ResetPwd(mobile);

            return ViewResult.newInstance()
                    .code(1).msg("找回密码获取手机验证码成功")
                    .put("mobileAuthenId", mobileAuthenId)
                    .put("verifyCode", ThreadContent.getData("verifyCode"))
                    .json();
        } catch (Exception e) {
            log.error("#找回密码获取手机验证码出错：", e);
            return ViewResult.newInstance().code(-1).msg(e.getMessage()).json();
        }
    }

    /**
     * 找回密码验证手机验证码
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/resetpwd/verifycode")
    public String verifyMobileCode4Register(String mobile, String verifyCode, long mobileAuthenId) throws Exception {
        try {
            User user = userService.verifyMobileCode4ResetPwd(mobile, verifyCode, mobileAuthenId);

            return ViewResult.newInstance()
                    .code(1).msg("找回密码验证手机验证码成功")
                    .put("user", user)
                    .json();
        } catch (Exception e) {
            log.error("#找回密码验证手机验证码出错：", e);
            return ViewResult.newInstance().code(-1).msg(e.getMessage()).json();
        }
    }

    /**
     * 重置密码
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/resetpwd")
    public String resetPwd(int userId, String password) throws Exception {
        try {
            userService.resetPwd(userId, password);

            return ViewResult.newInstance()
                    .code(1).msg("重置密码成功")
                    .json();
        } catch (Exception e) {
            log.error("#重置密码出错：", e);
            return ViewResult.newInstance().code(-1).msg(e.getMessage()).json();
        }
    }
}