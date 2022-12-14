package com.unrealdinnerbone.unreallib.apiutils;


public class WebResultException extends Exception {

    public WebResultException(String url, String body, int code) {
        super(url + " returned an " + code + " with body: " + body);
    }

}
