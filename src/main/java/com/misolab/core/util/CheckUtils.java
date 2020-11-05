package com.misolab.core.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public interface CheckUtils {

    /**
     * 인수 값의 참/거짓을 나타내는 값을 반환한다.
     *
     * @param value
     * @return
     */
    default boolean isTrue(Boolean value) {
        return value != null && value;
    }

    /**
     * 값의 참/거짓을 나타내는 값을 반환한다.
     *
     * @param value
     * @return
     */
    default boolean isFalse(Boolean value) {
        return !isTrue(value);
    }

    /**
     * 값의 존재 여부를 체크한다.
     *
     * @param value
     * @return
     */
    default boolean isEmpty(String value) {
        return StringUtils.isEmpty(value);
    }

    /**
     * 컬렉션의 존재 여부를 체크한다.
     *
     * @param collection
     * @return
     */
    default boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * 배열의 존재 여부를 체크한다.
     *
     * @param array
     * @return
     */
    default boolean isEmpty(Object[] array) {
        return (array == null || array.length == 0);
    }

    /**
     * 맵의 존재 여부를 체크한다.
     *
     * @param map
     * @return
     */
    default boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    /**
     * 존재 여부를 체크한다.
     *
     * @param value
     * @return
     */
    default boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    /**
     * 존재 여부를 체크한다.
     *
     * @param collection
     * @return
     */
    default boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 존재 여부를 체크한다.
     *
     * @param array
     * @return
     */
    default boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    /**
     * 존재 여부를 체크한다.
     *
     * @param map
     * @return
     */
    default boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * 문자열과 정규표현의 매치 여부를 체크한다.
     *
     * @param value
     * @param regex
     * @return
     */
    default boolean matches(String value, String regex) {
        return isNotEmpty(value) && value.matches(regex);
    }

    /**
     * 값이 숫자만인지를 체크한다.
     *
     * @param value
     * @return
     */
    default boolean isNumeric(String value) {
        return StringUtils.isNumeric(value);
    }

    /**
     * 값이 ASCII문자뿐인지 체크한다.
     *
     * @param value
     * @return
     */
    default boolean isAscii(String value) {
        return StringUtils.isAsciiPrintable(value);
    }

    /**
     * 인수끼리 동일한지 체크한다.
     *
     * @param obj1
     * @param obj2
     * @return
     */
    default boolean isEquals(Object obj1, Object obj2) {
        return Objects.equals(obj1, obj2);
    }

    /**
     * 인수끼리 동일한지 체크한다.
     *
     * @param obj1
     * @param obj2
     * @return
     */
    default boolean isNotEquals(Object obj1, Object obj2) {
        return !isEquals(obj1, obj2);
    }
}
