package com.benxiaopao.provider.service;

import com.benxiaopao.provider.common.util.KeyUtil;
import com.benxiaopao.provider.dao.map.ProductMapper;
import com.benxiaopao.provider.dao.model.Product;
import com.benxiaopao.provider.dao.model.ProductExample;
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
import java.math.BigDecimal;
import java.util.List;

/**
 * 菜品业务逻辑服务处理类
 *
 * Created by liupoyang
 * 2019-04-21
 */
@Service
@Slf4j
public class ProductService {
    @Resource
    private ProductMapper productMapper;

    /**
     * 根据条件获取菜品列表，带分页
     * @param tpListProduct
     * @return
     * @throws Exception
     */
    public TRListProduct listProductByPage(TPListProduct tpListProduct) throws Exception {
        TPPagination tpPagination = tpListProduct.getPagination();
        int pageSize = tpPagination.getPageSize();
        int pageNum = tpPagination.getPageNo();
        int start = (pageNum - 1) * pageSize;

        //查询列表
        Product product = new Product();
        if(tpListProduct.getProduct() != null){
            BeanUtils.copyProperties(tpListProduct.getProduct(), product, "createTime", "updateTime", "price");
        }
        List<Product> products = this.listProductByWhere(product, start, pageSize);
        int count = this.countProductByWhere(product);

        TRListProduct trListProduct = new TRListProduct();
        TRResponse response = new TRResponse();
        response.setSuccess(true);
        trListProduct.setResponse(response);

        TRPagination trPagination = new TRPagination(pageNum, pageSize, count);
        trListProduct.setPagination(trPagination);

        List<TRProduct> trProductList =  FluentIterable.from(products).transform(new Function<Product, TRProduct>() {
            @Override
            public TRProduct apply(Product product) {
                TRProduct trProduct = new TRProduct();
                BeanUtils.copyProperties(product, trProduct, "createTime", "updateTime", "price");
                trProduct.setCreateTime(product.getCreateTime().getTime());
                trProduct.setUpdateTime(product.getUpdateTime().getTime());
                trProduct.setPrice(product.getPrice().doubleValue());
                return trProduct ;
            }
        }).toList();
        trListProduct.setProductList(trProductList);

        return trListProduct;
    }

    /**
     * 根据条件获取菜品列表
     * @param tpListProduct
     * @return
     * @throws Exception
     */
    public TRListProduct listProduct(TPListProduct tpListProduct) throws Exception {
        Product product = new Product();
        if(tpListProduct.getProduct() != null){
            BeanUtils.copyProperties(tpListProduct.getProduct(), product, "createTime", "updateTime", "price");
        }
        List<Product> products = this.listProductByWhere(product, null, null);

        TRListProduct trListProduct = new TRListProduct();
        TRResponse response = new TRResponse();
        response.setSuccess(true);
        trListProduct.setResponse(response);

        List<TRProduct> trProductList =  FluentIterable.from(products).transform(new Function<Product, TRProduct>() {
            @Override
            public TRProduct apply(Product product) {
                TRProduct trProduct = new TRProduct();
                BeanUtils.copyProperties(product, trProduct, "createTime", "updateTime", "price");
                trProduct.setCreateTime(product.getCreateTime().getTime());
                trProduct.setUpdateTime(product.getUpdateTime().getTime());
                trProduct.setPrice(product.getPrice().doubleValue());
                return trProduct ;
            }
        }).toList();
        trListProduct.setProductList(trProductList);

        return trListProduct;
    }

    /**
     * 根据条件获取菜品列表，带分页
     * @param product 条件参数菜品对象
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return List<Product> 菜品列表
     */
    public List<Product> listProductByPage(Product product, int pageNum, int pageSize) throws Exception {
        int start = (pageNum - 1) * pageSize;
        //查询列表
        List<Product> products = this.listProductByWhere(product, start, pageSize);
        return products;
    }

    public List<Product> listProductByWhere(Product product, Integer start, Integer offset)
            throws Exception {
        ProductExample example = _buildExampleByWhere(product);

        //由参数决定是否进行分页
        if(start != null && start >= 0 && offset != null && offset > 0){
            //排序条件、限制查询记录数
            example.setOrderByClause("productId asc limit " + start + ", " + offset);
        }

        return productMapper.selectByExample(example);
    }

    public int countProductByWhere(Product product) throws Exception {
        ProductExample example = _buildExampleByWhere(product);
        long count = productMapper.countByExample(example);
        return Integer.valueOf(String.valueOf(count));
    }

    /**
     * 构建查询条件对象<br />私有方法
     * @param product 查询条件参数对象
     * @return ProductExample
     */
    private ProductExample _buildExampleByWhere(Product product){
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();

        //名称
        if(product != null && StringUtils.hasText(product.getProductName())){
            criteria.andProductNameEqualTo(product.getProductName());
        }

        if(product != null && product.getRestaurantId() != null && product.getRestaurantId() > 0){
            criteria.andRestaurantIdEqualTo(product.getRestaurantId());
        }
        if(product != null && product.getCategoryType() != null && product.getCategoryType() > 0){
            criteria.andCategoryTypeEqualTo(product.getCategoryType());
        }
        return example;
    }

    /**
     * 新增菜品
     * @param tpProduct 要插入的菜品数据对象
     */
    public int insertProduct(TPProduct tpProduct) throws Exception {
        Product product = new Product();
        BeanUtils.copyProperties(tpProduct, product, "createTime", "updateTime", "price");
        product.setProductId(KeyUtil.genUniqueKey());
        product.setPrice(BigDecimal.valueOf(tpProduct.getPrice()));
        return this.insertProduct(product);
    }

    /**
     * 新增菜品
     * @param product 要插入的菜品数据对象
     */
    public int insertProduct(Product product) throws Exception {
        //新增菜品
        log.info("#新增菜品，其中 productName=" + product.getProductName() + " productId=" + product.getProductId());
        int records = productMapper.insert(product);
//        Preconditions.checkArgument(records > 0, "新增菜品失败");
        return records;
    }

    /**
     * 修改菜品
     * @param tpProduct 要更新的菜品数据对象
     */
    public int updateProduct(TPProduct tpProduct) throws Exception {
        Product product = new Product();
        BeanUtils.copyProperties(tpProduct, product, "createTime", "updateTime", "price");
        product.setPrice(BigDecimal.valueOf(tpProduct.getPrice()));
        if(product.getRestaurantId() <= 0){
            product.setRestaurantId(null);
        }
        return this.updateProduct(product);
    }

    /**
     * 修改菜品
     * @param product 要更新的菜品数据对象
     */
    public int updateProduct(Product product) throws Exception {
        //更新菜品
        log.info("#更新菜品，其中productId=" + product.getProductId() + " productName=" + product.getProductName() + " proudctId=" + product.getProductId());
        int records = productMapper.updateByPrimaryKeySelective(product);
//        Preconditions.checkArgument(records > 0, "修改菜品失败");
        return records;
    }

    /**
     * 删除菜品
     * @param productId 菜品id
     */
    public int deleteProduct(String productId) throws Exception {
        Product queryProduct = this.getProductById(productId);
        Preconditions.checkNotNull(queryProduct, "要删除的菜品不存在");

        //删除菜品
        log.info("#删除菜品，其中productId=" + productId);
        int records = productMapper.deleteByPrimaryKey(productId);
//        Preconditions.checkArgument(records > 0, "删除菜品失败");
        return records;
    }

    /**
     * 根据菜品id获取菜品对象
     * @param productId 菜品id
     */
    public TRProduct getTRProductById(String productId) throws Exception {
        TRProduct trProduct = null;

        Product product = this.getProductById(productId);
        if(product != null){
            trProduct = new TRProduct();
            BeanUtils.copyProperties(product, trProduct, "createTime", "updateTime", "price");
            trProduct.setCreateTime(product.getCreateTime().getTime());
            trProduct.setUpdateTime(product.getUpdateTime().getTime());
            trProduct.setPrice(product.getPrice().doubleValue());
        }
        return trProduct;
    }

    /**
     * 根据菜品id获取菜品对象
     * @param productId 菜品id
     */
    public Product getProductById(String productId) throws Exception {
        //根据菜品id查询菜品对象
        Product product = productMapper.selectByPrimaryKey(productId);
        Preconditions.checkNotNull(product, "获取菜品成员失败");
        return product;
    }
}