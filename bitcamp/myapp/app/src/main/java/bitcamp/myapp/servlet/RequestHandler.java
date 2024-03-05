package bitcamp.myapp.servlet;

import java.lang.reflect.Method;

public class RequestHandler {
    //requestHandler - 요청을 다루는 메소드
    Object controller;
    Method handler;

    public RequestHandler() {

    }

    public RequestHandler(Object controller, Method handler) {
        this.controller = controller;
        this.handler = handler;
    }



}
