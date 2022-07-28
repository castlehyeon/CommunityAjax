package com.ll.exam.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ut {
    public static class json {
        //ut클래스 내부에 static으로 클래스를 만듦.
//        public static String toStr(Object obj, String defaultValue) {
//            ObjectMapper om = new ObjectMapper();

            private static final ObjectMapper om;

            static {
                om = new ObjectMapper();
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
                return (T) om.readValue(jsonStr, cls);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }
    }
}
