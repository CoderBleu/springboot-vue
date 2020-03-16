package cn.blue.mall.mapper;

import cn.blue.mall.bean.GoodsInfo;

import java.util.List;

public interface GoodsMapper {
    /**
     * 查找商品列表
     *
     * @param goodsInfo 商品信息
     * @return 商品列表
     */
    List<GoodsInfo> findAll(GoodsInfo goodsInfo);

    /**
     * 根据商品id修改分类信息
     *
     * @param goodsInfo 商品信息
     */
    void updateById(GoodsInfo goodsInfo);

    /**
     * 根据父级id来添加子分类
     *
     * @param goodsInfo 分类信息
     */
    void addCatByPId(GoodsInfo goodsInfo);
}
