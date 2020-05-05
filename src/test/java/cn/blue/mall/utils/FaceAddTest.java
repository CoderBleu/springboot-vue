package cn.blue.mall.utils;

import cn.blue.mall.bean.FaceInfo;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FaceAddTest {

    @SneakyThrows
    @Test
    void faceAdd() {
        String encode = Base64Util.encode(FileUtil.readFileByBytes("D:\\pythonDemo\\7.jpg"));
        System.out.println("encode:" + encode);
        String resultJson = FaceAdd.faceAdd(encode);
        System.out.println(resultJson);
    }
}