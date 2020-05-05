package cn.blue.mall.controller;

import cn.blue.mall.bean.FaceInfo;
import cn.blue.mall.consts.FaceConst;
import cn.blue.mall.face.Face_type;
import cn.blue.mall.face.JsonRootBean;
import cn.blue.mall.utils.*;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Blue
 * @date 2020/5/4
 * 人脸识别接口调用
 **/
@Controller
@RequestMapping("/login")
public class FaceController {
    /**
     * 登录访问次数
     */
    static Integer COUNT = 0;

    @SneakyThrows
    @ResponseBody
    @PostMapping("/face")
    public Result loginByFace(String imgSrc) {
        //对字节数组字符串进行Base64解码并生成图片
        if (imgSrc == null) {
            return Result.error(500).setMsg("参数异常");
        }
        BASE64Decoder decoder = new BASE64Decoder();
        String imgFilePath = FaceConst.PATH_PRE + System.currentTimeMillis() + FaceConst.PATH_SUF;
        try (OutputStream out = new FileOutputStream(imgFilePath)) {
            //Base64解码
            //生成jpeg图片
            byte[] decoderBytes = decoder.decodeBuffer(imgSrc.split(",")[1]);
            out.write(decoderBytes);
            // 搜索人脸库
            String resultJson = FaceSearch.faceSearch(imgFilePath);
            FaceInfo faceInfo = GsonUtils.fromJson(resultJson, FaceInfo.class);

            COUNT ++;
            if(COUNT % 10 == 0) {
                File file = new File(FaceConst.PATH_PRE);
                // 判断file是否是文件目录 若是返回TRUE
                if (file.isDirectory()) {
                    //  name存储file文件夹中的文件名
                    String name[] = file.list();
                    for (int i = 0; i < name.length; i++) {
                        // 此时就可得到文件夹中的文件
                        File f = new File(FaceConst.PATH_PRE, name[i]);
                        // 删除文件
                        f.delete();
                    }
                }
            }

            if (!faceInfo.getError_msg().equals(FaceConst.ERROR_MSG)) {
                return Result.error(500).setMsg("请正确拍摄到人像");
            }
            if (faceInfo.getResult().getUser_list().get(0).getScore() >= FaceConst.SCORE) {
                return Result.success().setMsg("人脸识别成功");
            } else {
                return Result.error(500).setMsg("人脸库未匹配成功,请先注册!");
            }
        }
    }

    @ResponseBody
    @PostMapping("/register")
    public Result registerByFace(String imgSrc) {
        if (imgSrc == null) {
            return Result.error(500).setMsg("参数异常");
        }
        BASE64Decoder decoder = new BASE64Decoder();
        String imgFilePath = "D:\\Temp\\" + System.currentTimeMillis() + "_face.jpg";
        try (OutputStream out = new FileOutputStream(imgFilePath)) {
            //Base64解码
            //生成jpeg图片
            byte[] decoderBytes = decoder.decodeBuffer(imgSrc.split(",")[1]);
            out.write(decoderBytes);
            String resultJson = FaceDetect.faceDetect(imgFilePath);
            JsonRootBean jsonRootBean = GsonUtils.fromJson(resultJson, JsonRootBean.class);
            if (!jsonRootBean.getError_msg().equals(FaceConst.ERROR_MSG)) {
                return Result.error(500).setMsg("请正确拍摄到人像");
            }
            Face_type faceType = jsonRootBean.getResult().getFace_list().get(0).getFace_type();
            if (!("human".equals(faceType.getType()) &&
                    faceType.getProbability() >= 0.80)) {
                return Result.error(500).setMsg("人脸完整度不够");
            }
            String resultJson1 = FaceAdd.faceAdd(imgFilePath);
            if (resultJson1 != null) {
                return Result.success().setMsg("人脸注册成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.error(500).setMsg("人脸注册失败");
    }
}
