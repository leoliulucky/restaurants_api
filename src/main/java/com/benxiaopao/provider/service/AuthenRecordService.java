package com.benxiaopao.provider.service;

import com.benxiaopao.common.util.DateUtil;
import com.benxiaopao.provider.common.util.MD5;
import com.benxiaopao.provider.common.util.MobileVerifyCode;
import com.benxiaopao.provider.common.util.RegExpValidator;
import com.benxiaopao.provider.dao.map.*;
import com.benxiaopao.provider.dao.model.*;
import com.google.common.base.Preconditions;
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
 * 验证服务
 *
 * Created by liupoyang
 * 2019-05-05
 */
@Service
@Slf4j
public class AuthenRecordService {
    @Resource
    private MobileAuthenMapper mobileAuthenMapper;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public long addMobileAuthen(MobileAuthen mobileAuthen) throws Exception{
        log.info("添加短信验证码,mobile：" + mobileAuthen.getMobile() + " userId:" + mobileAuthen.getUserId());
        try {
            mobileAuthenMapper.insert(mobileAuthen);
            long mobileAuthenId = mobileAuthen.getMobileAuthenId();
            return mobileAuthenId;
        } catch (Exception e) {
            return -1;
        }
    }

    public MobileAuthen getMobileAuthenById(long mobileAuthenId) {
        MobileAuthen mobileAuthen = mobileAuthenMapper.selectByPrimaryKey(mobileAuthenId);
        return mobileAuthen;
    }
}
