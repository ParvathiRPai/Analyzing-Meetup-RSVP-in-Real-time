package com.rsvps;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;

@Component
//Connecting to spring cloud stream ( Binding source channel to kafka
@EnableBinding(Source.class)
public class RsvpsKafkaProducer {

    private static final int SENDING_MESSAGE_TIMEOUT_MS = 10000;
//Dependency injection
    private final Source source;

    public RsvpsKafkaProducer(Source source) {
        this.source = source;
    }
//Send message to channel
    public void sendRsvpMessage(WebSocketMessage<?> message) {

        source.output()
                .send(MessageBuilder.withPayload(message.getPayload())
                                .build(),
                        SENDING_MESSAGE_TIMEOUT_MS);
    }
}