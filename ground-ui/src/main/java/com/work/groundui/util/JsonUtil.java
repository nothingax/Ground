package com.work.groundui.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;


/**
 * Program Name: spring-cloud-demo
 * <p>
 * Description: JsonUtil
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2019/6/17 7:14 PM
 */
@Slf4j
public class JsonUtil {

    public static <T> T jsonToBean(String jsonData, Class<T> clazz) {
        return JSON.parseObject(jsonData, clazz);
    }

    public static String beanToJson(Object object) {
        return JSON.toJSONString(object);

    }

    public static <T> List<T> jsonToList(String jsonData, Class<T> clazz) {
        return JSON.parseArray(jsonData, clazz);
    }

    public static List<Map<String, Object>> getJsonToListMap(String jsonData) {
        return JSON.parseObject(jsonData, new TypeReference<List<Map<String, Object>>>() {
        });
    }

    public static Map jsonToMap(String jsonString) {
        Map mapObj = JSONObject.parseObject(jsonString, Map.class);
        return mapObj;
    }

}