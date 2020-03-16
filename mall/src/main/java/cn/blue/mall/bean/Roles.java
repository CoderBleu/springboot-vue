package cn.blue.mall.bean;

import lombok.Data;

import java.util.List;

/**
 * @author Blue
 * @date 2020/3/10
 **/
@Data
public class Roles {
    /**
     * 权限id
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDesc;
    /**
     * 一级权限
     */
    private List<Powers> roles;

    /**
     * 一个角色可以拥有多个权限
     */
    private List<Powers> powers;
}
