package com.client.client.restexample.restclient.model;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * very inconsistent enums: value are enums, only serialization done
 */
public enum Status {
    NOT_AVAILABLE("Not Available"),
    PERSON_IN_VACATION("Person's in vacation"),

    /**
     * Default value returned when unknown string causes serialization issue.
     */
    UNKNOWN("Unknown");

    private final String value;

    Status(String value) {
        this.value = value;
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
