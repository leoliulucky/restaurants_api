package com.benxiaopao.provider.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.benxiaopao.common.exception.BizException;
import com.benxiaopao.common.util.HttpClientUtil;
import com.benxiaopao.provider.common.util.KeyUtil;
import com.benxiaopao.provider.dao.map.OrderItemMapper;
import com.benxiaopao.provider.dao.map.OrderMapper;
import com.benxiaopao.provider.dao.map.ProductMapper;
import com.benxiaopao.provider.dao.model.*;
import com.benxiaopao.thrift.model.*;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
    @Resource
    private OrderItemMapper orderItemMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    private static String MGMT_URL = "http://localhost:8081";

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
            BeanUtils.copyProperties(tpListOrder.getOrder(), order, "createTime", "updateTime", "totalAmout", "realTotalAmout", "shipmentExpense");
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
                BeanUtils.copyProperties(order, trOrder, "createTime", "updateTime", "totalAmout", "realTotalAmout", "shipmentExpense");
                trOrder.setCreateTime(order.getCreateTime().getTime());
                trOrder.setUpdateTime(order.getUpdateTime().getTime());
                trOrder.setTotalAmout(order.getTotalAmout().doubleValue());
                trOrder.setRealTotalAmout(order.getRealTotalAmout().doubleValue());
                trOrder.setShipmentExpense(order.getShipmentExpense().doubleValue());
                trOrder.setOrderStatus(order.getOrderStatus());
                trOrder.setOrderFrom(order.getOrderFrom());
                trOrder.setOrderType(order.getOrderType());
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
            BeanUtils.copyProperties(tpListOrder.getOrder(), order, "createTime", "updateTime", "totalAmout", "realTotalAmout", "shipmentExpense");
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
                BeanUtils.copyProperties(order, trOrder, "createTime", "updateTime", "totalAmout", "realTotalAmout", "shipmentExpense");
                trOrder.setCreateTime(order.getCreateTime().getTime());
                trOrder.setUpdateTime(order.getUpdateTime().getTime());
                trOrder.setTotalAmout(order.getTotalAmout().doubleValue());
                trOrder.setRealTotalAmout(order.getRealTotalAmout().doubleValue());
                trOrder.setShipmentExpense(order.getShipmentExpense().doubleValue());
                trOrder.setOrderStatus(order.getOrderStatus());
                trOrder.setOrderFrom(order.getOrderFrom());
                trOrder.setOrderType(order.getOrderType());
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
            example.setOrderByClause("createTime desc limit " + start + ", " + offset);
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
        if(order != null && order.getRestaurantId() > 0){
            criteria.andRestaurantIdEqualTo(order.getRestaurantId());
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
            BeanUtils.copyProperties(order, trOrder, "createTime", "updateTime", "totalAmout", "realTotalAmout", "shipmentExpense");
            trOrder.setCreateTime(order.getCreateTime().getTime());
            trOrder.setUpdateTime(order.getUpdateTime().getTime());
            trOrder.setTotalAmout(order.getTotalAmout().doubleValue());
            trOrder.setRealTotalAmout(order.getRealTotalAmout().doubleValue());
            trOrder.setShipmentExpense(order.getShipmentExpense().doubleValue());
            trOrder.setOrderStatus(order.getOrderStatus());
            trOrder.setOrderFrom(order.getOrderFrom());
            trOrder.setOrderType(order.getOrderType());
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

    /**
     * 创建订单
     * @param productIdList
     * @param productCountList
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
    public String createOrder(int userId, List<String> productIdList, List<Integer> productCountList) throws Exception {
        User user = userService.getUserById(userId);
        String orderId = KeyUtil.genUniqueKey();

        // 订单明细表
        BigDecimal totalAmount = BigDecimal.ZERO;
        BigDecimal realTotalAmount = BigDecimal.ZERO;
        Product product = null;
        String productId = null;
        Integer productCount = 0;
        OrderItem orderItem = null;
        int orderItemRecords = 0;
        for(int i = 0; i < productIdList.size(); i++){
            productId = productIdList.get(i);
            productCount = productCountList.get(i);

            product = productService.getProductById(productId);

            orderItem = new OrderItem();
            orderItem.setItemId(KeyUtil.genUniqueKey());
            orderItem.setOrderId(orderId);
            orderItem.setProductId(product.getProductId());
            orderItem.setProductName(product.getProductName());
            orderItem.setProductIcon(product.getIcon());
            orderItem.setOriginPrice(product.getPrice());
            orderItem.setShopPrice(product.getPrice());
            orderItem.setProductCount(productCount);


            totalAmount = totalAmount.add(orderItem.getOriginPrice().multiply(BigDecimal.valueOf(orderItem.getProductCount())));
            realTotalAmount = realTotalAmount.add(orderItem.getShopPrice().multiply(BigDecimal.valueOf(orderItem.getProductCount())));

            orderItemRecords = orderItemMapper.insertSelective(orderItem);
            Preconditions.checkArgument(orderItemRecords > 0, "创建订单失败");
        }

        // 订单表
        Order order = new Order();
        order.setOrderId(orderId);
        order.setTotalAmout(totalAmount);
        order.setRealTotalAmout(realTotalAmount);
        order.setShipmentExpense(BigDecimal.ZERO);
        order.setOrderStatus((short)1);
        order.setOrderType((byte)1);
        order.setOrderFrom((byte)3);
        order.setBuyerId(user.getUserId());
        order.setConsignee(Strings.isNullOrEmpty(user.getRealName())? user.getNickName() : user.getRealName());
        order.setTel(user.getMobile());
        order.setRestaurantId(product.getRestaurantId());
        int orderRecords = orderMapper.insertSelective(order);
        Preconditions.checkArgument(orderRecords > 0, "创建订单失败");

        // 通知后台管理中心有新订单消息了
        try{
            //调用接口
            Map<String, Object> params = Maps.newHashMap();
            params.put("orderId", orderId);
            String response = HttpClientUtil.doPost(MGMT_URL + "/biz/order/notify", params);
            log.info("# order notify response = {}", response);
            JSONObject responseObj = JSON.parseObject(response);
            int code = responseObj.getInteger("code");
            if(code <= 0){
                log.info("# 调用通知订单API接口出错：{}", responseObj.getString("msg"));
                throw new BizException("通知订单API接口出错: " + responseObj.getString("msg"));
            }
        }catch (Exception e){
            log.error("#通知管理中心有新订单失败", e);
        }

        return orderId;
    }

    public List<OrderItem> listOrderItemByOrderId(String orderId) throws Exception {
        OrderItemExample example = new OrderItemExample();
        OrderItemExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<OrderItem> orderItemList = orderItemMapper.selectByExample(example);
        return orderItemList;
    }

    /**
     * 支付订单
     * @param userId
     * @param orderId
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
    public void payOrder(int userId, String orderId) throws Exception {
        Order order = this.getOrderById(orderId);
        Preconditions.checkNotNull(order, "订单号有误，查无此单");
        Preconditions.checkArgument(order.getBuyerId().intValue() == userId, "订单数据有误，请确认参数是否正确");

        order = orderMapper.getOrderByIdForUpdate(orderId);
        // 订单表
        Order updateOrder = new Order();
        updateOrder.setOrderId(order.getOrderId());
        updateOrder.setOrderStatus((short)2);
        int records = orderMapper.updateByPrimaryKeySelective(updateOrder);
        Preconditions.checkArgument(records > 0, "支付订单失败");
    }

    /**
     * 关闭订单
     * @param orderId 订单id
     */
    public int closeOrderById(String orderId) throws Exception {
        Order order = this.getOrderById(orderId);
        Preconditions.checkNotNull(order, "要关闭的订单不存在");

        log.info("#关闭订单，其中orderId=" + orderId);
        order = orderMapper.getOrderByIdForUpdate(orderId);
        Order updateOrder = new Order();
        updateOrder.setOrderId(order.getOrderId());
        updateOrder.setOrderStatus((short)5);
        int records = orderMapper.updateByPrimaryKeySelective(updateOrder);
        Preconditions.checkArgument(records > 0, "关闭订单失败");
        return records;
    }
}
