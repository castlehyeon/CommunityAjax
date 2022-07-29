package com.ll.exam.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.exam.article.dto.ArticleDto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ut {
    public static Map<String, Object> mapOf(Object... args) {
        int dataSize = args.length / 2;

        Map<String, Object> map = new LinkedHashMap<>();

        for ( int i = 0; i < dataSize; i++ ) {
            int keyIndex = i * 2 + 0;
            int valueIndex = i * 2 + 1;

            String key = (String)args[keyIndex];
            Object value = args[valueIndex];

            map.put(key, value);
        }

        return map;
    }

    public static class json {
        //ut클래스 내부에 static으로 클래스를 만듦.
//        public static String toStr(Object obj, String defaultValue) {
//            ObjectMapper om = new ObjectMapper();
//        private static String resultCode;
//        private static String msg;
            private static final ObjectMapper om;

            static {
                om = new ObjectMapper();
//                resultCode = "S - 1";
//                msg = "성공";
            }
        public static String toStr(Object obj, String defaultValue) {
            try {
                return om.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }
        //json을 다시 객체화
        public static <T> T toObj(String jsonStr, Class<T> cls, T defaultValue) {
            try {
                //return (T) om.readValue(jsonStr, cls);
                return om.readValue(jsonStr, cls);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

//        public static <T> List<T> toObj(String jsonStr, TypeReference<List<T>> typeReference, List<T> defaultValue) {
//            try {
//                return om.readValue(jsonStr, typeReference);
//            } catch (JsonProcessingException e) {
//                return defaultValue;
//            }
//        }
//        public static <K, V> Map<K, V> toMap(String jsonStr, TypeReference<Map<K, V>> typeReference, Map<K, V> defaultValue) {
        public static <T> T toObj(String jsonStr, TypeReference<T> typeReference, T defaultValue) {
            try {
                return om.readValue(jsonStr, typeReference);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }
    }
}
