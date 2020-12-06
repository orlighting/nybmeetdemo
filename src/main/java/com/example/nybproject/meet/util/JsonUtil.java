package com.example.nybproject.meet.util;


import net.sf.json.JSONObject;

/**
 * @author ZhaoDesong
 * @date 2020/12/6 20:26
 */
public class JsonUtil {

    public static String toJson(Object o) {
        return JSONObject.fromObject(o).toString();
    }

    public static <T> T toJson(String jsonStr, Class<T> clazz) {
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        return (T) JSONObject.toBean(jsonObject, clazz);
    }

    public static <T> T convertObject(Object o, Class<T> clazz) {
        JSONObject jsonObject = JSONObject.fromObject(o);
        return (T) JSONObject.toBean(jsonObject, clazz);
    }
}
