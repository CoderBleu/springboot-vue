/**
 * Copyright 2020 bejson.com
 */
package cn.blue.mall.face;

import lombok.Data;

/**
 * Auto-generated: 2020-05-04 17:32:26
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class Face_list {

    private String face_token;
    private Location location;
    private double face_probability;
    private Angle angle;
    private Integer age;
    private double beauty;
    private Expression expression;
    private Face_shape face_shape;
    private Gender gender;
    private Glasses glasses;
    private Race race;
    private Quality quality;
    private Eye_status eye_status;
    private Emotion emotion;
    private Face_type face_type;

}