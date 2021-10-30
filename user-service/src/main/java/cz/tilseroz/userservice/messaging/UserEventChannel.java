package cz.tilseroz.userservice.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserEventChannel {

    String OUTPUT = "createdUser";

    @Output(OUTPUT)
    MessageChannel createdUser();
}
