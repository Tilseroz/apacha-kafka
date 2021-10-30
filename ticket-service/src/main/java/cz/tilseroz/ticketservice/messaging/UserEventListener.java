package cz.tilseroz.ticketservice.messaging;

import cz.tilseroz.ticketservice.exception.PayloadException;
import cz.tilseroz.ticketservice.payload.UserEventPayload;
import cz.tilseroz.ticketservice.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserEventListener {

    private final TicketService ticketService;

    public UserEventListener(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @StreamListener(UserEventChannel.INPUT)
    public void onCreateUserEvent(Message<UserEventPayload> userEventPayloadMessage) {

        if (userEventPayloadMessage == null) {
            throw new PayloadException("Payload message is null for topic createdUser");
        }

        Acknowledgment acknowledgment =
                userEventPayloadMessage.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);

        ticketService.createTicketForUser(userEventPayloadMessage.getPayload());

        if (acknowledgment != null) {
            acknowledgment.acknowledge();
        }
    }

}
