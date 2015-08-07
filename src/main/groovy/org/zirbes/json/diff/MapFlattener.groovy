package org.zirbes.json.diff

import groovy.transform.CompileStatic

@CompileStatic
class MapFlattener {

    Map flatten(Map sourceMap) {
        flattenMap(sourceMap, '')
    }

    static protected Map flattenMap(Map sourceMap, String prefix) {
        if (prefix) { prefix += '.' }
        Map flatMap = [:] as TreeMap
        sourceMap.each{ key, value ->
            if ( value instanceof Map || value instanceof List ) {
                flatMap += flattenMap( value, key )
            } else {
                flatMap["${prefix}${key}"] = value
            }
        }
        return flatMap
    }

    static protected Map flattenMap(List sourceList, String prefix) {
        Map flatMap = [:] as TreeMap
        sourceList.eachWithIndex{ item, int i ->
            if ( item instanceof Map || item instanceof List ) {
                flatMap += flattenMap(item, "${prefix}[${i}]" as String)
            } else {
                flatMap["${prefix}[${i}]"] = item
            }
        }
        return flatMap
    }
}
