package com.benxiaopao.provider.service;

import com.benxiaopao.provider.dao.map.OrderMapper;
import com.benxiaopao.provider.dao.map.ProductMapper;
import com.benxiaopao.provider.dao.model.*;
import com.benxiaopao.thrift.model.*;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单业务逻辑服务处理类
 *
 * Created by liupoyang
 * 2019-04-21
 */
@Service
@Slf4j
public class OrderService {
    @Resource
    private OrderMapper orderMapper;

    /**
     * 根据条件获取订单列表，带分页
     * @param tpListOrder
     * @return
     * @throws Exception
     */
    public TRListOrder listOrderByPage(TPListOrder tpListOrder) throws Exception {
        TPPagination tpPagination = tpListOrder.getPagination();
        int pageSize = tpPagination.getPageSize();
        int pageNum = tpPagination.getPageNo();
        int start = (pageNum - 1) * pageSize;

        //查询列表
        Order order = new Order();
        if(tpListOrder.getOrder() != null){
            BeanUtils.copyProperties(tpListOrder.getOrder(), order, "createTime", "updateTime");
        }
        List<Order> orders = this.listOrderByWhere(order, start, pageSize);
        int count = this.countOrderByWhere(order);

        TRListOrder trListOrder = new TRListOrder();
        TRResponse response = new TRResponse();
        response.setSuccess(true);
        trListOrder.setResponse(response);

        TRPagination trPagination = new TRPagination(pageNum, pageSize, count);
        trListOrder.setPagination(trPagination);

        List<TROrder> trOrderList =  FluentIterable.from(orders).transform(new Function<Order, TROrder>() {
            @Override
            public TROrder apply(Order order) {
                TROrder trOrder = new TROrder();
                BeanUtils.copyProperties(order, trOrder, "createTime", "updateTime");
                trOrder.setCreateTime(order.getCreateTime().getTime());
                trOrder.setUpdateTime(order.getUpdateTime().getTime());
                return trOrder ;
            }
        }).toList();
        trListOrder.setOrderList(trOrderList);

        return trListOrder;
    }

    /**
     * 根据条件获取订单列表
     * @param tpListOrder
     * @return
     * @throws Exception
     */
    public TRListOrder listOrder(TPListOrder tpListOrder) throws Exception {
        Order order = new Order();
        if(tpListOrder.getOrder() != null){
            BeanUtils.copyProperties(tpListOrder.getOrder(), order, "createTime", "updateTime");
        }
        List<Order> orders = this.listOrderByWhere(order, null, null);

        TRListOrder trListOrder = new TRListOrder();
        TRResponse response = new TRResponse();
        response.setSuccess(true);
        trListOrder.setResponse(response);

        List<TROrder> trOrderList =  FluentIterable.from(orders).transform(new Function<Order, TROrder>() {
            @Override
            public TROrder apply(Order order) {
                TROrder trOrder = new TROrder();
                BeanUtils.copyProperties(order, trOrder, "createTime", "updateTime");
                trOrder.setCreateTime(order.getCreateTime().getTime());
                trOrder.setUpdateTime(order.getUpdateTime().getTime());
                return trOrder ;
            }
        }).toList();
        trListOrder.setOrderList(trOrderList);

        return trListOrder;
    }

    /**
     * 根据条件获取订单列表，带分页
     * @param order 条件参数订单对象
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return List<Order> 订单列表
     */
    public List<Order> listOrderByPage(Order order, int pageNum, int pageSize) throws Exception {
        int start = (pageNum - 1) * pageSize;
        //查询列表
        List<Order> orders = this.listOrderByWhere(order, start, pageSize);
        return orders;
    }

    public List<Order> listOrderByWhere(Order order, Integer start, Integer offset)
            throws Exception {
        OrderExample example = _buildExampleByWhere(order);

        //由参数决定是否进行分页
        if(start != null && start >= 0 && offset != null && offset > 0){
            //排序条件、限制查询记录数
            example.setOrderByClause("orderId asc limit " + start + ", " + offset);
        }

        return orderMapper.selectByExample(example);
    }

    public int countOrderByWhere(Order order) throws Exception {
        OrderExample example = _buildExampleByWhere(order);
        long count = orderMapper.countByExample(example);
        return Integer.valueOf(String.valueOf(count));
    }

    /**
     * 构建查询条件对象<br />私有方法
     * @param order 查询条件参数对象
     * @return OrderExample
     */
    private OrderExample _buildExampleByWhere(Order order){
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();

        //名称
        if(order != null && StringUtils.hasText(order.getOrderId())){
            criteria.andOrderIdEqualTo(order.getOrderId());
        }
        return example;
    }

    /**
     * 新增订单
     * @param order 要插入的订单数据对象
     */
    public void insertOrder(Order order) throws Exception {
        //新增订单
        log.info("#新增订单，其中 orderId=" + order.getOrderId() + " tel=" + order.getTel());
        int records = orderMapper.insert(order);
        Preconditions.checkArgument(records > 0, "新增订单失败");
    }

    /**
     * 修改订单
     * @param order 要更新的订单数据对象
     */
    public void updateOrder(Order order) throws Exception {
        //更新订单
        log.info("#更新订单，其中orderId=" + order.getOrderId() + " tel=" + order.getTel());
        int records = orderMapper.updateByPrimaryKeySelective(order);
        Preconditions.checkArgument(records > 0, "修改订单失败");
    }

    /**
     * 删除订单
     * @param orderId 订单id
     */
    public void deleteOrder(String orderId) throws Exception {
        Order queryOrder = this.getOrderById(orderId);
        Preconditions.checkNotNull(queryOrder, "要删除的订单不存在");

        //删除订单
        log.info("#删除订单，其中orderId=" + orderId);
        int records = orderMapper.deleteByPrimaryKey(orderId);
        Preconditions.checkArgument(records > 0, "删除订单失败");
    }

    /**
     * 根据订单id获取订单对象
     * @param orderId 订单id
     */
    public TROrder getTROrderById(String orderId) throws Exception {
        TROrder trOrder = null;

        Order order = this.getOrderById(orderId);
        if(order != null){
            trOrder = new TROrder();
            BeanUtils.copyProperties(order, trOrder, "createTime", "updateTime");
            trOrder.setCreateTime(order.getCreateTime().getTime());
            trOrder.setUpdateTime(order.getUpdateTime().getTime());
        }
        return trOrder;
    }

    /**
     * 根据订单id获取订单对象
     * @param orderId 订单id
     */
    public Order getOrderById(String orderId) throws Exception {
        //根据订单id查询订单对象
        Order order = orderMapper.selectByPrimaryKey(orderId);
        Preconditions.checkNotNull(order, "获取订单成员失败");
        return order;
    }
}
