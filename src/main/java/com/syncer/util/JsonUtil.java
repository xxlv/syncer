package com.syncer.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtil {

    //无参的私有构造方法
    private JsonUtil() {
    }

    /**
     * 将对象转成json格式
     *
     * @param object
     * @return String
     */
    public static String toJson(Object object) {
        return JSON.toJSONString(object);
    }

    public static String toJson(Object object, SerializerFeature serializerFeature) {
        return JSON.toJSONString(object, serializerFeature);
    }

    /**
     * 将json转成特定的cls的对象
     *
     * @param jsonStr
     * @param clszz
     * @return
     */
    public static <T> T format(String jsonStr, Class<T> clszz) {
        return JSON.parseObject(jsonStr, clszz);
    }

    public static <T> T format(String jsonStr, TypeReference<T> clszz) {
        return JSON.parseObject(jsonStr, clszz);
    }
}