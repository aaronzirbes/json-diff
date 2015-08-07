package org.zirbes.json.diff

import groovy.transform.CompileStatic

import static org.zirbes.json.diff.JsonDiff.ChangeType.*

@CompileStatic
class JsonDiffer {

    static ChangeSet diff(Map prev, Map current) {

        ChangeSet changes = [] as ChangeSet

        if (current == prev) {
            return changes
        } else {
            Map prevFlat = MapFlattener.flatten(prev)
            Map currentFlat = MapFlattener.flatten(current)
            Set<String> keysAdded = currentFlat.keySet() - prevFlat.keySet()
            Set<String> keysRemoved = prevFlat.keySet() - currentFlat.keySet()
            Set<String> keysCommon = currentFlat.keySet() - keysAdded

            keysAdded.each{ changes << new JsonDiff(ADD, it, currentFlat[it]) }
            keysRemoved.each{ changes << new JsonDiff(REMOVE, it, prevFlat[it]) }
            keysCommon.each{ String key ->
                if (currentFlat[key] != prevFlat[key]) {
                    changes << new JsonDiff(REMOVE, key, prevFlat[key])
                    changes << new JsonDiff(ADD, key, currentFlat[key])
                }
            }
            return changes
        }
    }
}

