package cn.blue.mall.utils;

import cn.blue.mall.face.Face_list;
import cn.blue.mall.face.Face_shape;
import cn.blue.mall.face.Face_type;
import cn.blue.mall.face.JsonRootBean;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FaceDetectTest {

    @Test
    void faceDetect() {
        String URL = "D://Temp//";
        File file=new File(URL);
        if (file.isDirectory()){//判断file是否是文件目录 若是返回TRUE
            String name[]=file.list();//name存储file文件夹中的文件名
            for (int i=0; i<name.length; i++){
                File f=new File(URL, name[i]);//此时就可得到文件夹中的文件
                f.delete();//删除文件
            }
        }

//        String resultJson = FaceDetect.faceDetect("D:\\pythonDemo\\1.jpg");
//        JsonRootBean jsonRootBean = GsonUtils.fromJson(resultJson, JsonRootBean.class);
//        System.err.println(jsonRootBean);
//        Face_type faceType = jsonRootBean.getResult().getFace_list().get(0).getFace_type();
//        Face_shape faceShape = jsonRootBean.getResult().getFace_list().get(0).getFace_shape();
//
//        System.out.println(faceType);
//        System.out.println(faceShape);
//        face_list.forEach(System.out::println);
    }

}