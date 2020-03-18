package cn.blue.mall.service;

import cn.blue.mall.bean.Powers;

import java.util.List;

/**
 * 用户信息的服务层
 */
public interface PowersService {
    /**
     * 查询用户所有列表信息
     * @return powers
     */
    public List<Powers> findAll(Powers powers);
    /**
     * 查询用户所有列表信息
     * @return powers
     */
    List<Powers> findPowersTree();

    /**
     * 查找是否是三级权限
     * @param id
     * @return
     */
    Powers findThirdGrade(Integer powersId);

    /**
     * 根据角色的id设置一级权限的pid
     * @param id 角色的id
     */
    boolean setPidByRolesId(Integer id);
}
