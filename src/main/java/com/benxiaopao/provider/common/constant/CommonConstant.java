package com.benxiaopao.provider.common.constant;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

/**
 * 常量类
 *
 * Created by liupoyang
 * 2019-05-12
 */
public class CommonConstant {
    /**
     * 推荐数据容器
     */
    public static Map<Integer, List<String>> recommedDataMap;

    /**
     * 获取推荐数据
     * @param userId
     * @return
     */
    public static List<String> getRecommendDataByUserId(int userId) {
        List<String> list = recommedDataMap.get(userId);
        if(list == null){
            list = Lists.newArrayList();
        }
        return list;
    }
}
