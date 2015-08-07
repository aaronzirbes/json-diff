package org.zirbes.json.diff

import groovy.transform.CompileStatic

@CompileStatic
class JsonDiff {

    ChangeType changeType
    String field
    String value

    JsonDiff() { }

    JsonDiff(ChangeType changeType,
             String field,
             String value) {
        this.changeType = changeType
        this.field = field
        this.value = value
    }

    @Override
    String toString() {
        return "${changeType} \"${field}\": \"${value}\""
    }

    static enum ChangeType {
        ADD('+'),
        REMOVE('-')

        final String code

        ChangeType(String code) {
            this.code = code
        }

        @Override
        String toString() { code }
    }

}
