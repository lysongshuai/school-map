package com.school.util;

import java.io.Serializable;

public abstract class AbstractApiCode implements Serializable {
    private int code;
    private String message;
    private final AbstractApiCode display;

    protected AbstractApiCode(int code, String messasge) {
        this.code = code;
        this.message = messasge;
        this.display = this;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public AbstractApiCode getDisplay() {
        return this.display;
    }
}
