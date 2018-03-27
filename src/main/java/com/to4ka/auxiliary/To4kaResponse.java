package com.to4ka.auxiliary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Created by User on 3/17/2018.
 */
public class To4kaResponse<T extends EntityJSONInterface> {

    private static final Logger log = LoggerFactory.getLogger(To4kaResponse.class);

    private StringBuilder jsonBuilder;

    public void appendData(String key, T object) {
        jsonBuilder.append(String.format("\"%s\":%s\n", key, object.toJSONObject().toString()));
    }

    public void appendData(String key, String data) {
        jsonBuilder.append(String.format("{\"%s\":\"%s\"}", key, data));
    }

    public void appendData(String key, Collection<T> objectArray) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (T object : objectArray) {
            stringBuilder.append(object.toJSONObject().toString() + ",");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        jsonBuilder.append(String.format("\"%s\":%s", key, stringBuilder.toString()));
    }

    public String getResponse() { //Map<String, Object>
        return String.format("{%s}",jsonBuilder.toString());
    }

    public To4kaResponse() {
        log.debug("Create response");
        this.jsonBuilder = new StringBuilder();
    }

    public static To4kaResponse success() {
        To4kaResponse response = new To4kaResponse();
        response.appendData("message", "Operation successfully");
        return response;

    }

    public static To4kaResponse error(String message) {
        To4kaResponse response = new To4kaResponse();
        response.jsonBuilder.append(String.format("{\"error\":\"%s\"}", message));
        return response;
    }
}
