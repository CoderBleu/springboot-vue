package cn.blue.mall.mapper;

import cn.blue.mall.bean.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RolesMapper {
    /**
     * 查询角色所有列表信息
     *
     * @return roles
     */
    public List<Roles> findAll(Roles roles);

    /**
     * 根据角色id来查权限树
     *
     * @param rolesId 角色id
     * @return 权限树
     */
    List<Roles> findTreeByRolesId(@Param("rolesId") Integer rolesId);

    /**
     * 根据角色id删除权限
     *
     * @param rolesId 角色id
     */
    void deleteTreeByRolesId(@Param("rolesId") Integer rolesId);

    /**
     * @param ids 权限的数组
     * @return 受影响的行数目
     */
//    int addTreeByPowerIds(@Param("rolesId") Integer rolesId, @Param("powersIds") Integer... ids);

    /**
     * 添加用户和权限的中间表
     * @param rolesId 角色id
     * @param powersId 权限id
     */
    void addTreeByPowerId(Integer rolesId, Integer powersId);

    /**
     * 根据角色id来查展开后的权限树
     *
     * @param roles 角色id
     * @return 权限树
     */
    List<Roles> findAllPowers(Roles roles);

    /**
     * 根据角色id查询用户分配的角色
     * @param roles 角色id
     * @return 角色信息
     */
    Roles findSetRoleByRoleId(@Param("rolesId") Integer roles);

    List<Roles> findRolesAndFirstPower();

    /**
     * 新增角色
     * @param roles 角色信息
     * @return 受影响的行数目
     */
    int addNewRole(Roles roles);
}
