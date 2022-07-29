package com.sriv.shivam.chatwebsocket.controller;

import com.sriv.shivam.chatwebsocket.models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    /*
        This method will receive message from a client who sends the message on "/message" end point
        and send that message to everyone subscribed to "/topic/return" end point.
     */
    @MessageMapping("/message")
    @SendTo("/topic/return")
    public Message getContent(@RequestBody Message message) {
        //Try-Catch block to provide a delay of 2000ms.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return message;
    }
}
