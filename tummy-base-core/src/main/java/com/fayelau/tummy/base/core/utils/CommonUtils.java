package com.fayelau.tummy.base.core.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * 通用工具
 * 
 * @author 3g7 2019-09-07 01:05:01
 * @version 0.0.1
 *
 */
public class CommonUtils {

    /**
     * 获取当前系统的时间戳
     * 
     * @return
     */
    public static Long currentMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 获取32位UUID，去掉四个中横线
     * 
     * @return
     */
    public static String uuid32() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取36位UUID，原始UUID
     * 
     * @return
     */
    public static String uuid36() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取类中不为null的属性
     * 
     * @param target
     * @return
     */
    public static Set<String> getNotNullProperties(Object target) {
        BeanWrapper srcBean = new BeanWrapperImpl(target);
        PropertyDescriptor[] pds = srcBean.getPropertyDescriptors();
        Set<String> noEmptyName = new HashSet<>();
        for (PropertyDescriptor p : pds) {
            if (p.getName().equals("class")) {
                continue;
            }
            Object value = srcBean.getPropertyValue(p.getName());
            if (value != null)
                noEmptyName.add(p.getName());
        }
        return noEmptyName;
    }

    /**
     * 根据属性名获取属性值
     * 
     * @param fieldName
     * @param object
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public static Object getFieldValueByFieldName(String fieldName, Object object) {
        Field field = null;
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
            } catch (Exception e) {
                // 这里甚么都不能抛出去。
                // 如果这里的异常打印或者往外抛，则就不会进入

            }
        }
        try {
            return field.get(object);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
