package com.sriv.shivam.chatwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//This class deals with all the configurations of web socket broker and server connectivity.
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    //Below function defines the overall end point for server connectivity.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/server").withSockJS();
    }

    /*
        Below method is used to configure message broker to handle send/receive functionalities.
        It enables simple broker for "/topic" end point. Also, it sets "/app" as the prefix
        end point for the application which means every end point will be accessed after this,
        e.g. "/app/message"
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}
