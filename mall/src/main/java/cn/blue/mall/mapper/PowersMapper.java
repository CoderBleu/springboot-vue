package cn.blue.mall.mapper;

import cn.blue.mall.bean.Powers;
import cn.blue.mall.bean.Roles;
import cn.blue.mall.bean.RolesPowers;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface PowersMapper {
    /**
     * 查询权限所有列表信息
     *
     * @return Powers集合
     */
    public List<Powers> findAll(Powers powers);

    /**
     * 查询一级权限下的所有列表信息
     *
     * @return Powers集合
     */
    public List<Powers> findAllFirstPowers(@Param("roles") Integer id);

    /**
     * 仅仅查询一级权限下的所有列表信息
     *
     * @return Powers集合
     */
    public List<Powers> findFirstPowers(@Param("roles") Integer id);

    /**
     * 权限树
     *
     * @return 权限树
     */
    List<Powers> findPowersTree();

    /**
     *
     * @param id 角色id
     * @return 中间表角色对应的ids
     */
    List<RolesPowers> findTreeByRolesId(Integer rolesId);

    /**
     * 查找是不是三级权限
     * @param powersId 角色id
     * @return 权限信息
     */
    Powers findThirdGrade(Integer powersId);

    /**
     * 根据角色的id设置一级权限的pid
     * @param id 角色的id
     */
    int setPidByRolesId(Integer rolesId);
}
