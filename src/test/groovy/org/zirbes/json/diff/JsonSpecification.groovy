package org.zirbes.json.diff

import com.fasterxml.jackson.databind.ObjectMapper

import spock.lang.Specification

class JsonSpecification extends Specification {

    static ObjectMapper objectMapper = new ObjectMapper()

    protected void printLog(Map log) {
        log.each{ sha, difflog ->
            println "@@ ${sha}"
            difflog.each{ diff ->
                println diff
            }
        }
    }

    protected String jsonFromFixture(String fixture) {
        String path = "/fixtures/${fixture}.json"
        return jsonFromResource(path)
    }

    protected String jsonFromResource(String resourcePath) {
        InputStream inputStream = this.class.getResourceAsStream(resourcePath)
        if (inputStream) {
            return stripWhiteSpace(inputStream.text)
        }
        throw new FileNotFoundException(resourcePath)
    }

    protected String stripWhiteSpace(String str) {
        StringBuffer out = new StringBuffer()
        str.eachLine{
            out << it.replaceFirst(/": /, '":').replaceFirst(/" : /, '":').trim()
        }
        return out.toString()
    }

}

