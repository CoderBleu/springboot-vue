package cn.blue.mall.service.impl;

import cn.blue.mall.bean.UserInfo;
import cn.blue.mall.mapper.UserInfoMapper;
import cn.blue.mall.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author Blue
 * @date 2020/3/5
 **/
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAll(UserInfo userInfo) {
        return userInfoMapper.findAll(userInfo);
    }

    @Override
    public boolean updateStatusById(UserInfo userInfo) {
        return userInfoMapper.updateStatusById(userInfo) > 0;
    }

    @Override
    public boolean addUser(UserInfo userInfo) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        userInfo.setId(id);
        return userInfoMapper.addUser(userInfo) > 0;
    }

    @Override
    public boolean updateUserById(UserInfo userInfo) {
        return userInfoMapper.updateUserById(userInfo) > 0;
    }

    @Override
    public boolean deleteById(String id) {
        return userInfoMapper.deleteById(id) > 0;
    }
}
