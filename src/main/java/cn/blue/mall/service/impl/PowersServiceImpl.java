package cn.blue.mall.service.impl;

import cn.blue.mall.bean.Powers;
import cn.blue.mall.mapper.PowersMapper;
import cn.blue.mall.service.PowersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Blue
 * @date 2020/3/5
 **/
@Service("powersService")
public class PowersServiceImpl implements PowersService {
    @Resource
    private PowersMapper powersMapper;

    @Override
    public List<Powers> findAll(Powers powers) {
        return powersMapper.findAll(powers);
    }

    @Override
    public List<Powers> findPowersTree() {
        return powersMapper.findPowersTree();
    }

    @Override
    public Powers findThirdGrade(Integer powersId) {
        return powersMapper.findThirdGrade(powersId);
    }

    @Override
    public boolean setPidByRolesId(Integer rolesId) {
       return powersMapper.setPidByRolesId(rolesId) > 0;
    }

}
