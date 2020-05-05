package cn.blue.mall.consts;

/**
 * @author Blue
 * @date 2020/5/4
 * 人脸识别常量
 **/
public interface FaceConst {

    /**
     * 路径前缀
     */
    String PATH_PRE = "D:\\Temp\\";

    /**
     * 路径后缀
     */
    String PATH_SUF = "_face.jpg";

    /**
     * 人脸比对的成绩
     */
    Integer SCORE = 80;

    /**
     * 人脸比对的成绩
     */
    String NO_FACE = "pic not has face";

    /**
     * 人脸比对的成绩
     */
    String ERROR_MSG = "SUCCESS";

    /**
     * 百度云应用的AK
     */
    String CLIENT_ID = "Pr9pmCNIHsozqlqAOT18f3S7";

    /**
     * 百度云应用的SK
     */
    String CLIENT_SECRET = "2FhMGEuyREsy5vy7vC55GaNV8TTVfZfv";

    /**
     * 人脸库
     */
    String GROUP_ID = "mall_vue";
}
