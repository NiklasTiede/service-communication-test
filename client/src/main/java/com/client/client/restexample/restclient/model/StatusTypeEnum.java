package com.client.client.restexample.restclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * lower-case enums: enums can be upper/lowercase when serialized
 */
public enum StatusTypeEnum {
    ONE,
    TWO,

    /**
     * Default value returned when unknown string causes serialization issue.
     */
    UNKNOWN;

    @JsonCreator
    public static StatusTypeEnum fromString(String value) {
        try {
            return StatusTypeEnum.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
