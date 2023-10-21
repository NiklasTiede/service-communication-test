package com.server.server.restexample.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    NOT_AVAILABLE("Not Available"),
    PERSON_IN_VACATION("Person's in vacation"),
    UNKNOWN("Unknown");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Status fromValue(String value) {
        for (Status status : Status.values()) {
            if (status.value.equals(value)) {
                return status;
            }
        }
        return UNKNOWN;
    }
}
