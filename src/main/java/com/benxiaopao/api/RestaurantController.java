package com.benxiaopao.api;

import com.benxiaopao.common.util.ViewResult;
import com.benxiaopao.provider.common.constant.CommonConstant;
import com.benxiaopao.provider.dao.model.Product;
import com.benxiaopao.provider.dao.model.ProductCategory;
import com.benxiaopao.provider.dao.model.Restaurant;
import com.benxiaopao.provider.service.ProductCategoryService;
import com.benxiaopao.provider.service.ProductService;
import com.benxiaopao.provider.service.RestaurantService;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * 餐馆api
 *
 * Created by liupoyang
 * 2019-05-03
 */
@RestController
@RequestMapping("/api/restaurant")
@Slf4j
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductService productService;

    /**
     * 餐馆列表
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/list")
    public String listRestaurantByPage(Restaurant restaurant, @RequestParam(defaultValue="1")int pageNum, @RequestParam(defaultValue="10")int pageSize, int userId) throws Exception{
        try{
            List<Restaurant> restaurantList = restaurantService.listRestaurantByPage(restaurant, pageNum, pageSize);
            int totalCount = restaurantService.countRestaurantByWhere(restaurant);
            log.info("# restaurantList.size()={}", restaurantList.size());

//            Pagination pagination = Pagination.currentPagination(pageNum, pageSize);
//            pagination.setTotalCount(totalCount);

            List<String> recommendDataList = CommonConstant.getRecommendDataByUserId(userId);
            log.info("# recommendDataList.size()={}", recommendDataList.size());

            return ViewResult.newInstance()
                    .code(1).msg("获取餐馆列表成功")
                    .put("restaurantList", restaurantList)
                    .put("totalCount", totalCount)
                    .put("recommendDataList", recommendDataList)
                    .json();
        } catch (Exception e) {
            log.error("#获取餐馆列表出错：", e);
            return ViewResult.newInstance().code(-1).msg(e.getMessage()).json();
        }
    }

    /**
     * 餐馆详情
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/detail")
    public String getRestaurantById(int restaurantId) throws Exception{
        try{
            Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
            Preconditions.checkNotNull(restaurant, "餐馆不存在");

            ProductCategory productCategory = new ProductCategory();
            productCategory.setRestaurantId(restaurantId);
            List<ProductCategory> productCategoryList = productCategoryService.listProductCategoryByWhere(productCategory, null, null);

            Map<Integer, List<Product>> productMap = Maps.newHashMap();
            for(ProductCategory item : productCategoryList){
                Product product = new Product();
                product.setRestaurantId(item.getRestaurantId());
                product.setCategoryType(item.getCategoryType());
                List<Product> productList = productService.listProductByWhere(product, null, null);
                log.info("# productList's size={}", productList.size());
                productMap.put(item.getCategoryId(), productList);
            }

            return ViewResult.newInstance()
                    .code(1).msg("获取餐馆详情成功")
                    .put("restaurant", restaurant)
                    .put("productCategoryList", productCategoryList)
                    .put("productMap", productMap)
                    .json();
        } catch (Exception e) {
            log.error("#获取餐馆详情出错：", e);
            return ViewResult.newInstance().code(-1).msg(e.getMessage()).json();
        }
    }
}
