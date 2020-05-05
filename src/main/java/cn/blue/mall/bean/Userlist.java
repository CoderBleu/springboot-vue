package cn.blue.mall.bean;

import lombok.Data;

/**
 * @author Blue
 * @date 2020/5/4
 * 人脸识别后的用户列表信息
 **/
@Data
public class Userlist {
    /**
     * 人脸库id
     */
    private String group_id;
    /**
     * 图片的id
     */
    private String user_id;

    private String user_info;
    /**
     * 比对分数
     */
    private double score;
}
