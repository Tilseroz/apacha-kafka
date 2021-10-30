package cz.tilseroz.ticketservice.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserEventChannel {

    String INPUT = "createdUser";

    @Input(INPUT)
    SubscribableChannel createdUser();
}
