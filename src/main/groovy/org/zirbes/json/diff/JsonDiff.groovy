package org.zirbes.json.diff

import groovy.transform.CompileStatic

@CompileStatic
class JsonDiff {

    ChangeType changeType
    String field
    Object value

    JsonDiff() { }

    JsonDiff(ChangeType changeType,
             String field,
             Object value) {
        this.changeType = changeType
        this.field = field
        this.value = value
    }

    boolean isAdd() { changeType == ChangeType.ADD }

    boolean isRemove() { changeType == ChangeType.REMOVE }

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
