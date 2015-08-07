package org.zirbes.json.diff

//import rs.Observable
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.core.type.TypeReference

import com.fasterxml.jackson.databind.node.ObjectNode

class JsonChangelog {

    /**
     * Takes in a map of JSON Maps.  The key is the id, or timestamp of the JSON.
     *
     * Example: [ '2015-06-15T12:34:56': [ foo: 'bar', wat: [ 1, 2, 3 ] ],
     *            '2015-07-26T23:45:07': [ foo: 'baz', wat: [ 1, 3, 5 ] ] ]
     */
    static Map<String, ChangeSet> changeLog(Map<String, Map> jsons) {

        Map<String, ChangeSet> log = [:] as TreeMap

        String lastKey
        Map last = null
        jsons.each{ String key, Map node ->
            if (lastKey) { log[key] = JsonDiffer.diff(last, node) }
            lastKey = key
            last = node
        }
        return log

    }

}
