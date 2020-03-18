package cn.blue.mall.service;

import cn.blue.mall.bean.Powers;
import cn.blue.mall.bean.Roles;

import java.util.List;

/**
 * 用户信息的服务层
 */
public interface RolesService {
    /**
     * 查询角色所有列表信息
     * @return roles
     */
    public List<Roles> findAll(Roles roles);

    /**
     * 查询角色下权限列表信息
     * @return roles
     */
    public List<Roles> findAllPowers(Roles roles);

    /**
     * 根据角色id来查权限树
     * @param rolesId 角色id
     * @return 权限树
     */
    List<Roles> findTreeByRolesId(Integer rolesId);

    /**
     * 根据用户id来更新中间表信息，即更新权限的分配
     * @param ids 权限ids
     * @param rolesId 角色id
     * @return 是否成功
     */
    boolean updateTreeByIds(Integer[] ids, Integer rolesId);

    List<Roles> findExpandTree();

    /**
     * 新增角色
     * @param roles 角色信息
     * @return 是否成功
     */
    boolean addNewRole(Roles roles);
}
