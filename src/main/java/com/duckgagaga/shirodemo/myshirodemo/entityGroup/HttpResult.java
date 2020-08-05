package com.duckgagaga.shirodemo.myshirodemo.entityGroup;

import java.io.Serializable;

public class HttpResult implements Serializable {

    private boolean success;//是否成功
    private String message;//返回

    public HttpResult() {
    }

    public HttpResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
