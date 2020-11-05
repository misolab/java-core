package com.misolab.core.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 리스트 유틸리티
 */
public interface ListUtils {

    /**
     * 리스트의 사이즈를 반환한다.
     *
     * @param list
     * @return
     */
    default int size(List<?> list) {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /**
     * 인수 값을 리스트로 추가한다.
     *
     * @param list
     * @param value
     * @return
     */
    default <T> List<T> add(List<T> list, T value) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(value);
        return list;
    }
}
