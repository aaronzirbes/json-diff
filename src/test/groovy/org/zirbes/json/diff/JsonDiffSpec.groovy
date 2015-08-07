package org.zirbes.json.diff

import com.fasterxml.jackson.core.type.TypeReference

class JsonDiffSpec extends JsonSpecification {

    void 'can generate change log for fancy JSONs'() {
        given: 'some JSON with a list of objects'
        String json = jsonFromFixture('things')

        when: 'we convert it to a list of maps'
        TypeReference typeRef = new TypeReference<List<Map>>(){}
        List<Map> jsonList = objectMapper.readValue(json, typeRef)

        then: 'there should be 5 entries in the JSON list'
        jsonList.size() == 5

        when: 'we assign a key to each JSON Map'
        Map<String, Map> jsons = jsonList.collectEntries([:]) { [ it.sha, it ] }

        then: 'we should still have 5 entries'
        jsons.size() == 5

        when:
        Map<String, List<JsonDiff>> log = JsonChangelog.changeLog(jsons)
        printLog log

        then:
        'stablizing destroy' == log['90cdff26502839b4d5565dfcf4bdc60098852c81'].added('commit.message').value
        'progress' == log['c101307357806a5993e0876c6626e46929108f12'].removed('commit.message').value

    }

}
