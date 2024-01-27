package com.example.webexam.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

@Component
public class RequestHandlerEventListener implements ApplicationListener<RequestHandledEvent> {
    @Override
    public void onApplicationEvent(RequestHandledEvent event) {
        System.out.println(event);
    }
}
