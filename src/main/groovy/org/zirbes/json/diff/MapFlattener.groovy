package org.zirbes.json.diff

import groovy.transform.CompileStatic

@CompileStatic
class MapFlattener {

    static Map<String, Object> flatten(Map<String, Object> sourceMap) {
        return flattenMap(sourceMap, '')
    }

    static protected Map<String, Object> flattenMap(Map<String, Object> sourceMap, String pre) {
        String prefix = pre ? (pre + '.') : pre
        Map<String, Object> map = [:] as TreeMap
        sourceMap.each{ String k, Object value ->
            String key = "${prefix}${k}"
            map.putAll(addNode(map, value, key))
        }
        return map
    }

    static protected Map<String, Object> flattenMap(List sourceList, String prefix) {
        Map<String, Object> map = [:] as TreeMap
        sourceList.eachWithIndex{ Object value, int i ->
            String key = "${prefix}[${i}]"
            map.putAll(addNode(map, value, key))
        }
        return map
    }

    static protected Map<String, Object> addNode(Map<String, Object> map, Object value, String key) {
        if ( value instanceof Map) {
            return flattenMap(value as Map<String, Object>, key)
        } else if (value instanceof Collection ) {
            return flattenMap(value as List, key)
        } else {
            return [ (key): value ]
        }
    }

}
