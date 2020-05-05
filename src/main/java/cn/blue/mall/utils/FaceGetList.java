package cn.blue.mall.utils;

import cn.blue.mall.consts.FaceConst;
import cn.blue.mall.service.impl.AuthServiceImpl;

import java.util.*;

/**
 * 获取用户人脸列表
 * @author Blue
 * @date 2020/5/4
 */
public class FaceGetList {

    public static String faceGetList() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/getusers";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("group_id", FaceConst.GROUP_ID);

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthServiceImpl.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}