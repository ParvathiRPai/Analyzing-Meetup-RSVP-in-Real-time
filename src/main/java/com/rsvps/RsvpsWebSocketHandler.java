package com.rsvps;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
class RsvpsWebSocketHandler extends AbstractWebSocketHandler {

    private static final Logger logger =
            Logger.getLogger(RsvpsWebSocketHandler.class.getName());
//    Dependency injection from kafkaproducer instance
    private final RsvpsKafkaProducer rsvpsKafkaProducer;

    public RsvpsWebSocketHandler(RsvpsKafkaProducer rsvpsKafkaProducer) {
        this.rsvpsKafkaProducer = rsvpsKafkaProducer;
    }

    @Override
    public void handleMessage(WebSocketSession session,
                              WebSocketMessage<?> message) {
      System.out.println(message.getPayload());


    }
}
