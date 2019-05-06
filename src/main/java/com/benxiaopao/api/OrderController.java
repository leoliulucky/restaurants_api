package com.benxiaopao.api;

import com.benxiaopao.common.util.ViewResult;
import com.benxiaopao.provider.dao.model.Order;
import com.benxiaopao.provider.dao.model.OrderItem;
import com.benxiaopao.provider.dao.model.Product;
import com.benxiaopao.provider.service.OrderService;
import com.benxiaopao.provider.service.ProductService;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 订单api
 *
 * Created by liupoyang
 * 2019-05-03
 */
@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    /**
     * 选好商品展示
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/goods")
    public String chooseGoods(String productIds, String productCounts) throws Exception {
        try {
            List<Product> productList = Lists.newArrayList();

            String[] productIdArray = productIds.split(",");
            String[] productCountArray = productCounts.split(",");
            for(int i = 0; i < productIdArray.length; i++){
                String productId = productIdArray[i];
                String productCount = productCountArray[i];

                Product product = productService.getProductById(productId);
                product.setStock(Integer.valueOf(productCount));
                productList.add(product);
            }

            return ViewResult.newInstance()
                    .code(1).msg("选好商品展示成功")
                    .put("productList", productList)
                    .json();
        } catch (Exception e) {
            log.error("#选好商品展示出错：", e);
            return ViewResult.newInstance().code(-1).msg(e.getMessage()).json();
        }
    }

    /**
     * 创建订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/create")
    public String createOrder(int userId, String productIds, String productCounts) throws Exception {
        try {
            List<String> productIdList = Lists.newArrayList();
            List<Integer> productCountList = Lists.newArrayList();

            String[] productIdArray = productIds.split(",");
            String[] productCountArray = productCounts.split(",");
            for(int i = 0; i < productIdArray.length; i++){
                String productId = productIdArray[i];
                String productCount = productCountArray[i];

                productIdList.add(productId);
                productCountList.add(Integer.valueOf(productCount));
            }

            String orderId = orderService.createOrder(userId, productIdList, productCountList);

            return ViewResult.newInstance()
                    .code(1).msg("创建订单成功")
                    .put("orderId", orderId)
                    .json();
        } catch (Exception e) {
            log.error("#创建订单出错：", e);
            return ViewResult.newInstance().code(-1).msg(e.getMessage()).json();
        }
    }

    /**
     * 获取订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/get")
    public String createOrder(int userId, String orderId) throws Exception {
        try {
            Order order = orderService.getOrderById(orderId);
            Preconditions.checkNotNull(order, "订单号有误，查无此单");
            Preconditions.checkArgument(order.getBuyerId().intValue() == userId, "订单数据有误，请确认参数是否正确");
            List<OrderItem> orderItemList = orderService.listOrderItemByOrderId(order.getOrderId());
            Preconditions.checkArgument(!CollectionUtils.isEmpty(orderItemList), "订单数据有误，请联系管理员");

            return ViewResult.newInstance()
                    .code(1).msg("获取订单成功")
                    .put("order", order)
                    .put("orderItemList", orderItemList)
                    .json();
        } catch (Exception e) {
            log.error("#获取订单出错：", e);
            return ViewResult.newInstance().code(-1).msg(e.getMessage()).json();
        }
    }

    /**
     * 支付订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/pay")
    public String payOrder(int userId, String orderId) throws Exception {
        try {
            orderService.payOrder(userId, orderId);

            return ViewResult.newInstance()
                    .code(1).msg("获取订单成功")
                    .json();
        } catch (Exception e) {
            log.error("#获取订单出错：", e);
            return ViewResult.newInstance().code(-1).msg(e.getMessage()).json();
        }
    }
}
