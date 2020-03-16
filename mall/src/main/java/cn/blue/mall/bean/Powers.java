package cn.blue.mall.bean;

import lombok.Data;

import java.util.List;

/**
 * @author Blue
 * @date 2020/3/10
 **/
@Data
public class Powers {
    /**
     * 权限id
     */
    private Integer id;
    /**
     * 权限名称
     */
    private String authName;
    /**
     * 权限等级
     */
    private Integer grade;
    /**
     * 父权限id
     */
    private Integer pid;
    /**
     * 权限路径
     */
    private String path;
    /**
     * 二级权限
     */
    private List<Powers> children;

    private boolean isHaveChildren;

    private List<RolesPowers> rp;
}
