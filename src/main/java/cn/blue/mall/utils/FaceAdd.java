package cn.blue.mall.utils;

import cn.blue.mall.consts.FaceConst;
import cn.blue.mall.service.impl.AuthServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 人脸注册
 * @author Blue
 */
public class FaceAdd {

    public static String faceAdd(String filePath) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", Base64Util.encode(FileUtil.readFileByBytes(filePath)));
            String userId = UUID.randomUUID().toString().replace("-", "").substring(16) + System.currentTimeMillis();
            map.put("group_id", FaceConst.GROUP_ID);
            map.put("user_id", userId);
            map.put("user_info", "abc");
            map.put("liveness_control", "NONE");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

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
