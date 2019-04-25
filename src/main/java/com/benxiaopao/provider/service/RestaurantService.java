package com.benxiaopao.provider.service;

import com.benxiaopao.provider.dao.map.RestaurantMapper;
import com.benxiaopao.provider.dao.model.Restaurant;
import com.benxiaopao.provider.dao.model.RestaurantExample;
import com.benxiaopao.thrift.model.*;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;

/**
 * 餐馆业务逻辑服务处理类
 *
 * Created by liupoyang
 * 2019-04-21
 */
@Service
@Slf4j
public class RestaurantService {
    @Resource
    private RestaurantMapper restaurantMapper;

    /**
     * 根据条件获取餐馆列表，带分页
     * @param tpListRestaurant
     * @return
     * @throws Exception
     */
    public TRListRestaurant listRestaurantByPage(TPListRestaurant tpListRestaurant) throws Exception {
        TPPagination tpPagination = tpListRestaurant.getPagination();
        int pageSize = tpPagination.getPageSize();
        int pageNum = tpPagination.getPageNo();
        int start = (pageNum - 1) * pageSize;

        //查询列表
        Restaurant restaurant = new Restaurant();
        if(tpListRestaurant.getRestaurant() != null){
            BeanUtils.copyProperties(tpListRestaurant.getRestaurant(), restaurant, "createTime", "updateTime");
        }
        List<Restaurant> restaurants = this.listRestaurantByWhere(restaurant, start, pageSize);
        int count = this.countRestaurantByWhere(restaurant);

        TRListRestaurant trListRestaurant = new TRListRestaurant();
        TRResponse response = new TRResponse();
        response.setSuccess(true);
        trListRestaurant.setResponse(response);

        TRPagination trPagination = new TRPagination(pageNum, pageSize, count);
        trListRestaurant.setPagination(trPagination);

        List<TRRestaurant> trRestaurantList =  FluentIterable.from(restaurants).transform(new Function<Restaurant, TRRestaurant>() {
            @Override
            public TRRestaurant apply(Restaurant restaurant) {
                TRRestaurant trRestaurant = new TRRestaurant();
                BeanUtils.copyProperties(restaurant, trRestaurant, "createTime", "updateTime");
                trRestaurant.setCreateTime(restaurant.getCreateTime().getTime());
                trRestaurant.setUpdateTime(restaurant.getUpdateTime().getTime());
                return trRestaurant ;
            }
        }).toList();
        trListRestaurant.setRestaurantList(trRestaurantList);

        return trListRestaurant;
    }

    /**
     * 根据条件获取餐馆列表
     * @param tpListRestaurant
     * @return
     * @throws Exception
     */
    public TRListRestaurant listRestaurant(TPListRestaurant tpListRestaurant) throws Exception {
        Restaurant restaurant = new Restaurant();
        if(tpListRestaurant.getRestaurant() != null){
            BeanUtils.copyProperties(tpListRestaurant.getRestaurant(), restaurant, "createTime", "updateTime");
        }
        List<Restaurant> restaurants = this.listRestaurantByWhere(restaurant, null, null);

        TRListRestaurant trListRestaurant = new TRListRestaurant();
        TRResponse response = new TRResponse();
        response.setSuccess(true);
        trListRestaurant.setResponse(response);

        List<TRRestaurant> trRestaurantList =  FluentIterable.from(restaurants).transform(new Function<Restaurant, TRRestaurant>() {
            @Override
            public TRRestaurant apply(Restaurant restaurant) {
                TRRestaurant trRestaurant = new TRRestaurant();
                BeanUtils.copyProperties(restaurant, trRestaurant, "createTime", "updateTime");
                trRestaurant.setCreateTime(restaurant.getCreateTime().getTime());
                trRestaurant.setUpdateTime(restaurant.getUpdateTime().getTime());
                return trRestaurant ;
            }
        }).toList();
        trListRestaurant.setRestaurantList(trRestaurantList);

        return trListRestaurant;
    }

    /**
     * 根据条件获取餐馆列表，带分页
     * @param restaurant 条件参数餐馆对象
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return List<Restaurant> 餐馆列表
     */
    public List<Restaurant> listRestaurantByPage(Restaurant restaurant, int pageNum, int pageSize) throws Exception {
        int start = (pageNum - 1) * pageSize;
        //查询列表
        List<Restaurant> restaurants = this.listRestaurantByWhere(restaurant, start, pageSize);
        return restaurants;
    }

    public List<Restaurant> listRestaurantByWhere(Restaurant restaurant, Integer start, Integer offset)
            throws Exception {
        RestaurantExample example = _buildExampleByWhere(restaurant);

        //由参数决定是否进行分页
        if(start != null && start >= 0 && offset != null && offset > 0){
            //排序条件、限制查询记录数
            example.setOrderByClause("restaurantId asc limit " + start + ", " + offset);
        }

        return restaurantMapper.selectByExample(example);
    }

    public int countRestaurantByWhere(Restaurant restaurant) throws Exception {
        RestaurantExample example = _buildExampleByWhere(restaurant);
        long count = restaurantMapper.countByExample(example);
        return Integer.valueOf(String.valueOf(count));
    }

    /**
     * 构建查询条件对象<br />私有方法
     * @param restaurant 查询条件参数对象
     * @return RestaurantExample
     */
    private RestaurantExample _buildExampleByWhere(Restaurant restaurant){
        RestaurantExample example = new RestaurantExample();
        RestaurantExample.Criteria criteria = example.createCriteria();

        //名称
        if(restaurant != null && StringUtils.hasText(restaurant.getRestaurantName())){
            criteria.andRestaurantNameEqualTo(restaurant.getRestaurantName());
        }
        return example;
    }

    /**
     * 新增餐馆
     * @param tpRestaurant 要插入的餐馆数据对象
     */
    public int insertRestaurant(TPRestaurant tpRestaurant) throws Exception {
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(tpRestaurant, restaurant, "createTime", "updateTime");
        return this.insertRestaurant(restaurant);
    }

    /**
     * 新增餐馆
     * @param restaurant 要插入的餐馆数据对象
     */
    public int insertRestaurant(Restaurant restaurant) throws Exception {
        //新增餐馆
        log.info("#新增餐馆，其中 restaurantName=" + restaurant.getRestaurantName() + " tel=" + restaurant.getTel());
        int records = restaurantMapper.insert(restaurant);
//        Preconditions.checkArgument(records > 0, "新增餐馆失败");
        return records;
    }

    /**
     * 修改餐馆
     * @param tpRestaurant 要更新的餐馆数据对象
     */
    public int updateRestaurant(TPRestaurant tpRestaurant) throws Exception {
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(tpRestaurant, restaurant, "createTime", "updateTime");
        return this.updateRestaurant(restaurant);
    }

    /**
     * 修改餐馆
     * @param restaurant 要更新的餐馆数据对象
     */
    public int updateRestaurant(Restaurant restaurant) throws Exception {
        //更新餐馆
        log.info("#更新餐馆，其中restaurantId=" + restaurant.getRestaurantId() + " restaurantName=" + restaurant.getRestaurantName() + " tel=" + restaurant.getTel());
        int records = restaurantMapper.updateByPrimaryKeySelective(restaurant);
//        Preconditions.checkArgument(records > 0, "修改餐馆失败");
        return records;
    }

    /**
     * 删除餐馆
     * @param restaurantId 餐馆id
     */
    public int deleteRestaurant(int restaurantId) throws Exception {
        Restaurant queryRestaurant = this.getRestaurantById(restaurantId);
        Preconditions.checkNotNull(queryRestaurant, "要删除的餐馆不存在");

        //删除餐馆
        log.info("#删除餐馆，其中restaurantId=" + restaurantId);
        int records = restaurantMapper.deleteByPrimaryKey(restaurantId);
//        Preconditions.checkArgument(records > 0, "删除餐馆失败");
        return records;
    }

    /**
     * 根据餐馆id获取餐馆对象
     * @param restaurantId 餐馆id
     */
    public TRRestaurant getTRRestaurantById(int restaurantId) throws Exception {
        TRRestaurant trRestaurant = null;

        Restaurant restaurant = this.getRestaurantById(restaurantId);
        if(restaurant != null){
            trRestaurant = new TRRestaurant();
            BeanUtils.copyProperties(restaurant, trRestaurant, "createTime", "updateTime");
            trRestaurant.setCreateTime(restaurant.getCreateTime().getTime());
            trRestaurant.setUpdateTime(restaurant.getUpdateTime().getTime());
        }
        return trRestaurant;
    }

    /**
     * 根据餐馆id获取餐馆对象
     * @param restaurantId 餐馆id
     */
    public Restaurant getRestaurantById(int restaurantId) throws Exception {
        //根据餐馆id查询餐馆对象
        Restaurant restaurant = restaurantMapper.selectByPrimaryKey(restaurantId);
        Preconditions.checkNotNull(restaurant, "获取餐馆成员失败");
        return restaurant;
    }
}
