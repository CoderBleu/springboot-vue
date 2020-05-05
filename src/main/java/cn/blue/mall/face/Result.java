/**
  * Copyright 2020 bejson.com
  */
package cn.blue.mall.face;
import cn.blue.mall.bean.Userlist;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2020-05-04 17:32:26
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class Result {

    private Integer face_num;
    private List<Face_list> face_list;
    /**
     * face_token值
     */
    private String face_token;
    /**
     * 查询的用户列表信息
     */
    private List<Userlist> user_list;
}