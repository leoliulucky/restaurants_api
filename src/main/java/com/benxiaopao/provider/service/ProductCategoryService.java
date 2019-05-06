package com.benxiaopao.provider.service;

import com.benxiaopao.provider.dao.map.ProductCategoryMapper;
import com.benxiaopao.provider.dao.model.Product;
import com.benxiaopao.provider.dao.model.ProductCategory;
import com.benxiaopao.provider.dao.model.ProductCategoryExample;
import com.benxiaopao.provider.dao.model.Restaurant;
import com.benxiaopao.thrift.model.*;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;

/**
 * 品类业务逻辑服务处理类
 *
 * Created by liupoyang
 * 2019-04-21
 */
@Service
@Slf4j
public class ProductCategoryService {
    @Resource
    private ProductCategoryMapper productCategoryMapper;
    @Resource
    private RestaurantService restaurantService;

    /**
     * 根据条件获取品类列表，带分页
     * @param tpListProductCategory
     * @return
     * @throws Exception
     */
    public TRListProductCategory listProductCategoryByPage(TPListProductCategory tpListProductCategory) throws Exception {
        TPPagination tpPagination = tpListProductCategory.getPagination();
        int pageSize = tpPagination.getPageSize();
        int pageNum = tpPagination.getPageNo();
        int start = (pageNum - 1) * pageSize;

        //查询列表
        ProductCategory productCategory = new ProductCategory();
        if(tpListProductCategory.getProductCategory() != null){
            BeanUtils.copyProperties(tpListProductCategory.getProductCategory(), productCategory, "createTime", "updateTime");
        }
        List<ProductCategory> productCategorys = this.listProductCategoryByWhere(productCategory, start, pageSize);
        int count = this.countProductCategoryByWhere(productCategory);

        TRListProductCategory trListProductCategory = new TRListProductCategory();
        TRResponse response = new TRResponse();
        response.setSuccess(true);
        trListProductCategory.setResponse(response);

        TRPagination trPagination = new TRPagination(pageNum, pageSize, count);
        trListProductCategory.setPagination(trPagination);

        List<TRProductCategory> trProductCategoryList =  FluentIterable.from(productCategorys).transform(new Function<ProductCategory, TRProductCategory>() {
            @Override
            public TRProductCategory apply(ProductCategory productCategory) {
                TRProductCategory trProductCategory = new TRProductCategory();
                BeanUtils.copyProperties(productCategory, trProductCategory, "createTime", "updateTime");
                trProductCategory.setCreateTime(productCategory.getCreateTime().getTime());
                trProductCategory.setUpdateTime(productCategory.getUpdateTime().getTime());

                String restaurantName = "";
                try {
                    Restaurant restaurant = restaurantService.getRestaurantById(productCategory.getRestaurantId());
                    restaurantName = restaurant.getRestaurantName();
                } catch (Exception e) {
                    log.error("# 根据ID获取餐馆出错", e);
                }
                trProductCategory.setRestaurantName(restaurantName);

                return trProductCategory ;
            }
        }).toList();
        trListProductCategory.setProductCategoryList(trProductCategoryList);

        return trListProductCategory;
    }

    /**
     * 根据条件获取品类列表
     * @param tpListProductCategory
     * @return
     * @throws Exception
     */
    public TRListProductCategory listProductCategory(TPListProductCategory tpListProductCategory) throws Exception {
        ProductCategory productCategory = new ProductCategory();
        if(tpListProductCategory.getProductCategory() != null){
            BeanUtils.copyProperties(tpListProductCategory.getProductCategory(), productCategory, "createTime", "updateTime");
        }
        List<ProductCategory> productCategorys = this.listProductCategoryByWhere(productCategory, null, null);

        TRListProductCategory trListProductCategory = new TRListProductCategory();
        TRResponse response = new TRResponse();
        response.setSuccess(true);
        trListProductCategory.setResponse(response);

        List<TRProductCategory> trProductCategoryList =  FluentIterable.from(productCategorys).transform(new Function<ProductCategory, TRProductCategory>() {
            @Override
            public TRProductCategory apply(ProductCategory productCategory) {
                TRProductCategory trProductCategory = new TRProductCategory();
                BeanUtils.copyProperties(productCategory, trProductCategory, "createTime", "updateTime");
                trProductCategory.setCreateTime(productCategory.getCreateTime().getTime());
                trProductCategory.setUpdateTime(productCategory.getUpdateTime().getTime());
                return trProductCategory ;
            }
        }).toList();
        trListProductCategory.setProductCategoryList(trProductCategoryList);

        return trListProductCategory;
    }

    /**
     * 根据条件获取品类列表，带分页
     * @param productCategory 条件参数品类对象
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return List<ProductCategory> 品类列表
     */
    public List<ProductCategory> listProductCategoryByPage(ProductCategory productCategory, int pageNum, int pageSize) throws Exception {
        int start = (pageNum - 1) * pageSize;
        //查询列表
        List<ProductCategory> productCategorys = this.listProductCategoryByWhere(productCategory, start, pageSize);
        return productCategorys;
    }

    public List<ProductCategory> listProductCategoryByWhere(ProductCategory productCategory, Integer start, Integer offset)
            throws Exception {
        ProductCategoryExample example = _buildExampleByWhere(productCategory);

        //由参数决定是否进行分页
        if(start != null && start >= 0 && offset != null && offset > 0){
            //排序条件、限制查询记录数
            example.setOrderByClause("categoryId asc limit " + start + ", " + offset);
        }

        return productCategoryMapper.selectByExample(example);
    }

    public int countProductCategoryByWhere(ProductCategory productCategory) throws Exception {
        ProductCategoryExample example = _buildExampleByWhere(productCategory);
        long count = productCategoryMapper.countByExample(example);
        return Integer.valueOf(String.valueOf(count));
    }

    /**
     * 构建查询条件对象<br />私有方法
     * @param productCategory 查询条件参数对象
     * @return ProductCategoryExample
     */
    private ProductCategoryExample _buildExampleByWhere(ProductCategory productCategory){
        ProductCategoryExample example = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();

        // 名称
        if(productCategory != null && StringUtils.hasText(productCategory.getCategoryName())){
            criteria.andCategoryNameEqualTo(productCategory.getCategoryName());
        }
        // 餐饮ID
        if(productCategory != null && productCategory.getRestaurantId() != null && productCategory.getRestaurantId() > 0){
            criteria.andRestaurantIdEqualTo(productCategory.getRestaurantId());
        }
        return example;
    }

    /**
     * 新增品类
     * @param tpProductCategory 要插入的品类数据对象
     */
    public int insertProductCategory(TPProductCategory tpProductCategory) throws Exception {
        ProductCategory productCategory = new ProductCategory();
        BeanUtils.copyProperties(tpProductCategory, productCategory, "createTime", "updateTime");
        return this.insertProductCategory(productCategory);
    }

    /**
     * 新增品类
     * @param productCategory 要插入的品类数据对象
     */
    public int insertProductCategory(ProductCategory productCategory) throws Exception {
        //新增品类
        log.info("#新增品类，其中 categoryName=" + productCategory.getCategoryName() + " categoryType=" + productCategory.getCategoryType());
        int records = productCategoryMapper.insert(productCategory);
//        Preconditions.checkArgument(records > 0, "新增品类失败");
        return records;
    }

    /**
     * 修改品类
     * @param tpProductCategory 要更新的品类数据对象
     */
    public int updateProductCategory(TPProductCategory tpProductCategory) throws Exception {
        ProductCategory productCategory = new ProductCategory();
        BeanUtils.copyProperties(tpProductCategory, productCategory, "createTime", "updateTime");
        return this.updateProductCategory(productCategory);
    }

    /**
     * 修改品类
     * @param productCategory 要更新的品类数据对象
     */
    public int updateProductCategory(ProductCategory productCategory) throws Exception {
        //更新品类
        log.info("#更新品类，其中productCategoryId=" + productCategory.getCategoryId() + " categoryName=" + productCategory.getCategoryName() + " categoryType=" + productCategory.getCategoryType());
        int records = productCategoryMapper.updateByPrimaryKeySelective(productCategory);
//        Preconditions.checkArgument(records > 0, "修改品类失败");
        return records;
    }

    /**
     * 删除品类
     * @param productCategoryId 品类id
     */
    public int deleteProductCategory(int productCategoryId) throws Exception {
        ProductCategory queryProductCategory = this.getProductCategoryById(productCategoryId);
        Preconditions.checkNotNull(queryProductCategory, "要删除的品类不存在");

        //删除品类
        log.info("#删除品类，其中productCategoryId=" + productCategoryId);
        int records = productCategoryMapper.deleteByPrimaryKey(productCategoryId);
//        Preconditions.checkArgument(records > 0, "删除品类失败");
        return records;
    }

    /**
     * 根据品类id获取品类对象
     * @param productCategoryId 品类id
     */
    public TRProductCategory getTRProductCategoryById(int productCategoryId) throws Exception {
        TRProductCategory trProductCategory = null;

        ProductCategory productCategory = this.getProductCategoryById(productCategoryId);
        if(productCategory != null){
            trProductCategory = new TRProductCategory();
            BeanUtils.copyProperties(productCategory, trProductCategory, "createTime", "updateTime");
            trProductCategory.setCreateTime(productCategory.getCreateTime().getTime());
            trProductCategory.setUpdateTime(productCategory.getUpdateTime().getTime());
        }
        return trProductCategory;
    }

    /**
     * 根据品类id获取品类对象
     * @param productCategoryId 品类id
     */
    public ProductCategory getProductCategoryById(int productCategoryId) throws Exception {
        //根据品类id查询品类对象
        ProductCategory productCategory = productCategoryMapper.selectByPrimaryKey(productCategoryId);
        Preconditions.checkNotNull(productCategory, "获取品类成员失败");
        return productCategory;
    }
    
}
