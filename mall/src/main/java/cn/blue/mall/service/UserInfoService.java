package cn.blue.mall.service;

import cn.blue.mall.bean.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息的服务层
 */
public interface UserInfoService {
    /**
     * 查询用户所有列表信息
     * @return UserInfo集合
     */
    public List<UserInfo> findAll(UserInfo userInfo);

    /**
     * 根据用户id修改用户状态
     * @param status 用户状态
     * @param id 用户id
     * @return 是否成功
     */
    boolean updateStatusById(UserInfo userInfo);

    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return 是否添加成功
     */
    boolean addUser(UserInfo userInfo);

    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return 是否修改成功
     */
    boolean updateUserById(UserInfo userInfo);

    /**
     * 新增用户
     * @param id 用户id
     * @return 是否删除成功
     */
    boolean deleteById(String id);
}
