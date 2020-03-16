package cn.blue.mall.bean;

import lombok.Data;

import java.util.List;

/**
 * @author Blue
 * @date 2020/3/15
 **/
@Data
public class GoodsInfo {
    private Integer id;
    /**
     * 商品名字
     */
    private String catName;
    /**
     * 父级id
     */
    private Integer catPid;
    /**
     * 是否有效
     */
    private Integer catDeleted;
    /**
     * 几级分类
     */
    private Integer catLevel;
    /**
     * 下级分类信息
     */
    private List<GoodsInfo> children;
}
