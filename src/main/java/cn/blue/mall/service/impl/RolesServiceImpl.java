package cn.blue.mall.service.impl;

import cn.blue.mall.bean.Roles;
import cn.blue.mall.mapper.PowersMapper;
import cn.blue.mall.mapper.RolesMapper;
import cn.blue.mall.service.RolesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Blue
 * @date 2020/3/5
 **/
@Service("rolesService")
public class RolesServiceImpl implements RolesService {
    @Resource
    private RolesMapper rolesMapper;
    @Resource
    private PowersMapper powersMapper;

    @Override
    public List<Roles> findAll(Roles roles) {
        return rolesMapper.findAll(roles);
    }

    @Override
    public List<Roles> findAllPowers(Roles roles) {
        return rolesMapper.findAllPowers(roles);
    }

    @Override
    public List<Roles> findTreeByRolesId(Integer rolesId) {
        return rolesMapper.findTreeByRolesId(rolesId);
    }

    @Override
    public boolean updateTreeByIds(Integer[] ids, Integer rolesId) {
        // 根据用户id删除中间表中已有的权限
        try {
            rolesMapper.deleteTreeByRolesId(rolesId);
            for (Integer id : ids
            ) {
                rolesMapper.addTreeByPowerId(rolesId, id);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Roles> findExpandTree() {
/*  1.先找到所有角色列表
    2.再给每个角色都赋予一级权限
    3.再根据角色rolesId找到角色有的二级三级权限
    4.找到二级权限对应的值 grade = 1
    5找到三级权限 grade = 2
 */
        return rolesMapper.findRolesAndFirstPower();
    }

    @Override
    public boolean addNewRole(Roles roles) {
        return rolesMapper.addNewRole(roles) > 0;
    }

}
