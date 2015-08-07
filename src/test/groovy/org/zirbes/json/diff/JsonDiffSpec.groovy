package org.zirbes.json.diff

import com.fasterxml.jackson.databind.ObjectMapper

import spock.lang.Specification

class JsonDiffSpec extends Specification {

    static ObjectMapper objectMapper = new ObjectMapper()

    void 'can generate change log for fancy JSONs'() {
        given: 'some JSON with a list of objects'
        String json = jsonFromFixture('things')

        and: 'we convert it to a list of maps'
        TypeReference typeRef = new TypeReference<List<Map>>(){}
        List<Map> jsonList = objectMapper.readValue(inputText, typeRef)

        and: 'we assign a key to each JSON Map'
        Map<String, Map> jsons = jsonList.collectEntries([:]) { [ it.timestamp, it ] }

        when:
        Map<String, List<JsonDiff>> log = JsonChangelog.changeLog(jsons)

        then:
        log == [:]

    }

    private String jsonFromFixture(String fixture) {
        String path = "/fixtures/${fixture}.json"
        return jsonFromResource(path)
    }

    private String jsonFromResource(String resourcePath) {
        InputStream inputStream = this.class.getResourceAsStream(resourcePath)
        if (inputStream) {
            return stripWhiteSpace(inputStream.text)
        }
        throw new FileNotFoundException(resourcePath)
    }

    private String stripWhiteSpace(String str) {
        StringBuffer out = new StringBuffer()
        str.eachLine{
            out << it.replaceFirst(/": /, '":').replaceFirst(/" : /, '":').trim()
        }
        return out.toString()
    }

}
