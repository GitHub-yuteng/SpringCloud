package com.pm.consumer.component.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: HuYi.Zhang
 * @create: 2018-04-24 17:20
 **/
public class JsonUtils {

    public static final ObjectMapper mapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static String serialize(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json序列化出错：" + obj, e);
            return null;
        }
    }

    public static <T> T parse(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <E> List<E> parseList(String json, Class<E> eClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <K, V> Map<K, V> parseMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class User {
        String name;
        Integer age;
    }

    public static void main(String[] args) {

        User user = new User("User", 21);
        //序列化
        String json = serialize(user);
        System.out.println("json = " + json);

        //反序列化
        User user1 = parse(json, User.class);
        System.out.println("user1 = " + user1);

        //List
        String list = "[20, 10, 5, 15]";
        List<Integer> list1 = parseList(list, Integer.class);
        System.out.println("list1 = " + list1);

        //Map
        //language=JSON
        String map = "{\"name\": \"Jack\",\"age\": \"21\"}";

        Map<String, String> map1 = parseMap(map, String.class, String.class);
        System.out.println("map1 = " + map1);

        // 对象
        String obj = "[{\"name\": \"Jack\",\"age\": \"21\"},{\"name\": \"Rose\",\"age\": \"22\"}]";
        List<Map<String, String>> maps = nativeRead(obj, new TypeReference<List<Map<String, String>>>() {
        });

        for (Map<String,String> map2 : maps){
            System.out.println("mapobj = " + map2);
        }
    }

}
