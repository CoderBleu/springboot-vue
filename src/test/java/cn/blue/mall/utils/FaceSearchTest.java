package cn.blue.mall.utils;

import cn.blue.mall.bean.FaceInfo;
import cn.blue.mall.face.Face_list;
import cn.blue.mall.face.JsonRootBean;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FaceSearchTest {

    @Test
    void faceSearch() {
        // 上传的图片不宜太大了，不然不好处理。
        String resultJson = FaceSearch.faceSearch("D:\\pythonDemo\\8.jpg");
        FaceInfo faceInfo = GsonUtils.fromJson(resultJson, FaceInfo.class);
        System.err.println("人脸搜索：" + faceInfo.getResult().getUser_list().get(0).getScore());
    }
}