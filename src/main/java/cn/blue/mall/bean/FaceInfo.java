package cn.blue.mall.bean;

import cn.blue.mall.face.Result;
import lombok.Data;
import org.springframework.data.relational.core.sql.In;

/**
 * @author Blue
 * @date 2020/5/4
 * 人脸识别反馈信息
 **/
@Data
public class FaceInfo {
    /**
     * 状态码 0
     */
    private Integer error_code;
    /**
     * 成功返回 SUCCESS
     */
    private String error_msg;

    private long  log_id;

    private long  timestamp;

    private double cached;

    private Result result;
}
