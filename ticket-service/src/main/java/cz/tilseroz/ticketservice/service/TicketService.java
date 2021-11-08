package cz.tilseroz.ticketservice.service;

import cz.tilseroz.ticketservice.payload.UserEventPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TicketService {

    public void createTicketForUser(UserEventPayload userEventPayload) {
        String message = String.format("Creating ticket for user %s", userEventPayload);
        log.info(message);
    }
}
