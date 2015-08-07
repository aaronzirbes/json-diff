package org.zirbes.json.diff

import groovy.transform.CompileStatic

@CompileStatic
class JsonDiffer {

    static List<JsonDiff> diff(Map prev, Map current) {
        List<JsonDiff> changes = []

        if (current == prev) {
            return changes
        } else {
            Map prevFlat = MapFlattener.flatten(prev)
            Map currentFlat = MapFlattener.flatten(current)
            Set<String> keysAdded = currentFlat.keySet() - prevFlat.keySet()
            Set<String> keysRemoved = prevFlat.keySet() - currentFlat.keySet()
            Set<String> keysCommon = currentFlat.keySet() - keysAdded

            keysAdded.each{ changes << new JsonDiff(JsonDiff.ADD, it, currentFlat[it]) }
            keysRemoved.each{ changes << new JsonDiff(JsonDiff.REMOVE, it, prevFlat[it]) }
            keysCommon.each{ String key ->
                if (currentFlat[key] != prevFlat[key]) {
                    changes << new JsonDiff(JsonDiff.REMOVE, key, prevFlat[key])
                    changes << new JsonDiff(JsonDiff.ADD, key, currentFlat[key])
                }
            }
            return changes
        }
    }
}

