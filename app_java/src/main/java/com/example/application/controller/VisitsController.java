package com.example.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitsController {

    static class MessageInfo {
        private int counter;

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }
    }

    public static int counter = 0;

    @GetMapping("/visits")
    public MessageInfo getCounter() {
        MessageInfo message = new MessageInfo();
        message.setCounter(counter);
        return message;
    }
}
