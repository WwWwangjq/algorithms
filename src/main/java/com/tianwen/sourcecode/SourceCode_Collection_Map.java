package com.tianwen.sourcecode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * wangjq
 * 2020年11月09日  21:27
 */
public class SourceCode_Collection_Map {

    public static void main(String[] args) throws Exception {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("1", 1);

        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("1", 1);

        List<String> arrayList = new ArrayList<>();
        arrayList.add("1");

        List<String> linkedList = new LinkedList<>();
        linkedList.add("1");

        Set<String> hashSet = new HashSet<>();
        hashSet.add("1");

        Set<String> linkedHashSet = new HashSet<>();
        linkedHashSet.add("1");

        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1", 1);

    }
}
