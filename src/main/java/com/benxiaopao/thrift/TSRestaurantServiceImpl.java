package com.benxiaopao.thrift;

import com.benxiaopao.provider.service.OrderService;
import com.benxiaopao.provider.service.ProductCategoryService;
import com.benxiaopao.provider.service.ProductService;
import com.benxiaopao.provider.service.RestaurantService;
import com.benxiaopao.thrift.model.*;
import com.benxiaopao.thrift.service.TSRestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * thrift接口实现
 *
 * Created by liupoyang
 * 2019-04-21
 */
@Component
@Slf4j
public class TSRestaurantServiceImpl implements TSRestaurantService.Iface {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public TRListRestaurant listRestaurantByPage(TPListRestaurant tpListRestaurant) throws TException {
        log.info("# TSRestaurantServiceImpl::listRestaurantByPage(..) -> entry: tpListRestaurant={}", tpListRestaurant);
        TRListRestaurant trListRestaurant = null;
        try {
            trListRestaurant = restaurantService.listRestaurantByPage(tpListRestaurant);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return trListRestaurant;
    }

    @Override
    public TRListRestaurant listRestaurant(TPListRestaurant tpListRestaurant) throws TException {
        log.info("# TSRestaurantServiceImpl::listRestaurant(..) -> entry: tpListRestaurant={}", tpListRestaurant);
        TRListRestaurant trListRestaurant = null;
        try {
            trListRestaurant = restaurantService.listRestaurant(tpListRestaurant);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return trListRestaurant;
    }

    @Override
    public int insertRestaurant(TPRestaurant tpRestaurant) throws TException {
        log.info("# TSRestaurantServiceImpl::insertRestaurant(..) -> entry: tpRestaurant={}", tpRestaurant);
        int records = 0;
        try {
            records = restaurantService.insertRestaurant(tpRestaurant);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return records;
    }

    @Override
    public int updateRestaurant(TPRestaurant tpRestaurant) throws TException {
        log.info("# TSRestaurantServiceImpl::updateRestaurant(..) -> entry: tpRestaurant={}", tpRestaurant);
        int records = 0;
        try {
            records = restaurantService.updateRestaurant(tpRestaurant);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return records;
    }

    @Override
    public int deleteRestaurant(int i) throws TException {
        log.info("# TSRestaurantServiceImpl::deleteRestaurant(..) -> entry: restaurantId={}", i);
        int records = 0;
        try {
            records = restaurantService.deleteRestaurant(i);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return records;
    }

    @Override
    public TRRestaurant getRestaurantById(int i) throws TException {
        log.info("# TSRestaurantServiceImpl::getRestaurantById(..) -> entry: restaurantId={}", i);
        TRRestaurant trRestaurant = null;
        try {
            trRestaurant = restaurantService.getTRRestaurantById(i);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return trRestaurant;
    }


    @Override
    public TRListOrder listOrderByPage(TPListOrder tpListOrder) throws TException {
        log.info("# TSOrderServiceImpl::listOrderByPage(..) -> entry: tpListOrder={}", tpListOrder);
        TRListOrder trListOrder = null;
        try {
            trListOrder = orderService.listOrderByPage(tpListOrder);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return trListOrder;
    }

    @Override
    public TRListOrder listOrder(TPListOrder tpListOrder) throws TException {
        log.info("# TSOrderServiceImpl::listOrder(..) -> entry: tpListOrder={}", tpListOrder);
        TRListOrder trListOrder = null;
        try {
            trListOrder = orderService.listOrder(tpListOrder);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return trListOrder;
    }

    @Override
    public TROrder getOrderById(String s) throws TException {
        log.info("# TSRestaurantServiceImpl::getOrderById(..) -> entry: orderId={}", s);
        TROrder trOrder = null;
        try {
            trOrder = orderService.getTROrderById(s);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return trOrder;
    }

    @Override
    public int closeOrderById(String s) throws TException {
        log.info("# TSRestaurantServiceImpl::closeOrderById(..) -> entry: orderId={}", s);
        int records = 0;
        try {
            records = orderService.closeOrderById(s);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return records;
    }

    @Override
    public TRListProduct listProductByPage(TPListProduct tpListProduct) throws TException {
        log.info("# TSProductServiceImpl::listProductByPage(..) -> entry: tpListProduct={}", tpListProduct);
        TRListProduct trListProduct = null;
        try {
            trListProduct = productService.listProductByPage(tpListProduct);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return trListProduct;
    }

    @Override
    public TRListProduct listProduct(TPListProduct tpListProduct) throws TException {
        log.info("# TSProductServiceImpl::listProduct(..) -> entry: tpListProduct={}", tpListProduct);
        TRListProduct trListProduct = null;
        try {
            trListProduct = productService.listProduct(tpListProduct);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return trListProduct;
    }

    @Override
    public int insertProduct(TPProduct tpProduct) throws TException {
        log.info("# TSRestaurantServiceImpl::insertProduct(..) -> entry: tpProduct={}", tpProduct);
        int records = 0;
        try {
            records = productService.insertProduct(tpProduct);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return records;
    }

    @Override
    public int updateProduct(TPProduct tpProduct) throws TException {
        log.info("# TSRestaurantServiceImpl::updateProduct(..) -> entry: tpProduct={}", tpProduct);
        int records = 0;
        try {
            records = productService.updateProduct(tpProduct);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return records;
    }

    @Override
    public int deleteProduct(String s) throws TException {
        log.info("# TSRestaurantServiceImpl::deleteProduct(..) -> entry: productId={}", s);
        int records = 0;
        try {
            records = productService.deleteProduct(s);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return records;
    }

    @Override
    public TRProduct getProductById(String s) throws TException {
        log.info("# TSRestaurantServiceImpl::getProductById(..) -> entry: productId={}", s);
        TRProduct trProduct = null;
        try {
            trProduct = productService.getTRProductById(s);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return trProduct;
    }

    @Override
    public TRListProductCategory listProductCategoryByPage(TPListProductCategory tpListProductCategory) throws TException {
        log.info("# TSProductServiceImpl::listProductCategoryByPage(..) -> entry: tpListProductCategory={}", tpListProductCategory);
        TRListProductCategory trListProductCategory = null;
        try {
            trListProductCategory = productCategoryService.listProductCategoryByPage(tpListProductCategory);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return trListProductCategory;
    }

    @Override
    public TRListProductCategory listProductCategory(TPListProductCategory tpListProductCategory) throws TException {
        log.info("# TSProductServiceImpl::listProductCategory(..) -> entry: tpListProductCategory={}", tpListProductCategory);
        TRListProductCategory trListProductCategory = null;
        try {
            trListProductCategory = productCategoryService.listProductCategory(tpListProductCategory);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return trListProductCategory;
    }

    @Override
    public int insertProductCategory(TPProductCategory tpProductCategory) throws TException {
        log.info("# TSRestaurantServiceImpl::insertProductCategory(..) -> entry: tpProductCategory={}", tpProductCategory);
        int records = 0;
        try {
            records = productCategoryService.insertProductCategory(tpProductCategory);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return records;
    }

    @Override
    public int updateProductCategory(TPProductCategory tpProductCategory) throws TException {
        log.info("# TSRestaurantServiceImpl::updateProductCategory(..) -> entry: tpProductCategory={}", tpProductCategory);
        int records = 0;
        try {
            records = productCategoryService.updateProductCategory(tpProductCategory);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return records;
    }

    @Override
    public int deleteProductCategory(int i) throws TException {
        log.info("# TSRestaurantServiceImpl::deleteProductCategory(..) -> entry: productCategoryId={}", i);
        int records = 0;
        try {
            records = productCategoryService.deleteProductCategory(i);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return records;
    }

    @Override
    public TRProductCategory getProductCategoryById(int i) throws TException {
        log.info("# TSRestaurantServiceImpl::getproductCategoryById(..) -> entry: productCategoryId={}", i);
        TRProductCategory trProductCategory = null;
        try {
            trProductCategory = productCategoryService.getTRProductCategoryById(i);
        } catch (Exception e) {
            log.error("# 出错：", e);
            throw new TException(e.getMessage());
        }
        return trProductCategory;
    }

}
