package cn.blue.mall.mapper;

import cn.blue.mall.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    /**
     * 查询用户所有列表信息
     *
     * @return UserInfo集合
     */
    public List<UserInfo> findAll(UserInfo userInfo);

    /**
     * 根据用户id修改用户状态
     *
     * @param userInfo 用户id 用户状态
     * @return 受影响行数
     */
    int updateStatusById(@Param("userInfo") UserInfo userInfo);

    /**
     * 新增用户
     *
     * @param userInfo 用户信息
     * @return 受影响行数
     */
    int addUser(UserInfo userInfo);

    /**
     * 新增用户
     *
     * @param userInfo 用户信息
     * @return 受影响行数
     */
    int updateUserById(UserInfo userInfo);

    /**
     * 新增用户
     * @param id 用户id
     * @return 是否删除成功
     */
    int deleteById(String id);
}
