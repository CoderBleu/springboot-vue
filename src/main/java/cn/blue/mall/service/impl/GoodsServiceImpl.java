package cn.blue.mall.service.impl;

import cn.blue.mall.bean.GoodsInfo;
import cn.blue.mall.mapper.GoodsMapper;
import cn.blue.mall.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Blue
 * @date 2020/3/15
 **/
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsInfo> findAll(GoodsInfo goodsInfo) {
        return goodsMapper.findAll(goodsInfo);
    }

    @Override
    public void updateById(GoodsInfo goodsInfo) {
        goodsMapper.updateById(goodsInfo);
    }

    @Override
    public void addCatByPId(GoodsInfo goodsInfo) {
        goodsMapper.addCatByPId(goodsInfo);
    }
}
