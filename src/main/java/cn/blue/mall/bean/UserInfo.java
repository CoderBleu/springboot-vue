package cn.blue.mall.bean;

import lombok.Data;

/**
 * @author Blue
 * @date 2020/3/5
 **/
@Data
public class UserInfo {
    /**
     * 用户表主键
     */
    private String id;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户电话
     */
    private String telephone;
    /**
     * 用户角色id：0超管，1管理员，2销售
     */
    private Integer role;
    /**
     * 用户状态：0正常，1删除
     */
    private Integer status;

    /**
     * 分配的角色
     */
    private Roles roles;
    /**
     *
     */
    private FaceInfo faceInfo;
}
