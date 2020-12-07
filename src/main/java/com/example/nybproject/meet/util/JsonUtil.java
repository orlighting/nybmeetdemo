package com.example.nybproject.meet.util;


import com.google.gson.Gson;

/**
 * @author ZhaoDesong
 * @date 2020/12/6 20:26
 */
public class JsonUtil {
    private static Gson gson = new Gson();

    public static <T> T convertObject(Object o, Class<T> clazz) {
        String jsonStr = gson.toJson(o);
        return gson.fromJson(jsonStr, clazz);
    }
}
