package com.to4ka.auxiliary;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by User on 3/17/2018.
 */
public class To4kaRequest {
    private JSONObject header;
    private JSONObject requestBody;

    public void setRequestBody(JSONObject requestBody) {
        this.requestBody = requestBody;
    }

    public Map<String, Object> getRequestBody() {
        return requestBody.toMap();
    }

    public void setHeader(JSONObject header) {
        this.header = header;
    }

    public Map<String, Object> getHeader() {
        return header.toMap();
    }

    public To4kaRequest() {}
}
