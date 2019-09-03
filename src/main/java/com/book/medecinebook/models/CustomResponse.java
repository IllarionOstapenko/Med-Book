package com.book.medecinebook.models;

import lombok.Data;

@Data
public class CustomResponse {
    private String msg;
    private boolean success;

    public CustomResponse(String msg, boolean success) {
        this.msg = msg;
        this.success = success;
    }

    public CustomResponse() {
    }

    @Override
    public String toString() {
        return "CustomResponse{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }
}
