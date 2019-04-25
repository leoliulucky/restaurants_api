package com.benxiaopao.provider.common.util;

import java.util.Random;

/**
 * 生成主键工具
 *
 * Created by liupoyang
 * 2019-04-25
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
