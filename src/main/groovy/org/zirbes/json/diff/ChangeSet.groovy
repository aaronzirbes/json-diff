package org.zirbes.json.diff

class ChangeSet extends ArrayList<JsonDiff> {

    JsonDiff added(String field) {
        this.find{ JsonDiff diff -> diff.add && diff.field == field }
    }

    JsonDiff removed(String field) {
        this.find{ JsonDiff diff -> diff.remove && diff.field == field }
    }

    List<JsonDiff> getAdded() {
        this.findAll{ JsonDiff diff -> diff.add }
    }

    List<JsonDiff> getRemoved() {
        this.findAll{ JsonDiff diff -> diff.remove }
    }

    List<JsonDiff> forField(String field) {
        this.findAll{ JsonDiff diff -> diff.field == field }
    }

}
