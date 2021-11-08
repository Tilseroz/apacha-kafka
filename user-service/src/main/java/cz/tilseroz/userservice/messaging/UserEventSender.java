package cz.tilseroz.userservice.messaging;

import cz.tilseroz.userservice.entity.User;
import cz.tilseroz.userservice.enums.UserStatus;
import cz.tilseroz.userservice.payload.UserEventPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserEventSender {

    private final UserEventChannel userEventChannel;

    public UserEventSender(UserEventChannel userEventChannel) {
        this.userEventChannel = userEventChannel;
    }

    /**
     * This is old method how work with Kafka. As you can see, StreamListener, INPUT and OUTPUT are deprecated.
     */
    public void sendUserCreated(User user) {
        log.info("Sending event about creation of user {}", user.getUsername());

        UserEventPayload userEventPayload = convertTo(user);

        Message<UserEventPayload> message =
                MessageBuilder
                        .withPayload(userEventPayload)
                        .setHeader(KafkaHeaders.MESSAGE_KEY, String.valueOf(userEventPayload.getId()))
                        .build();

        userEventChannel.createdUser().send(message);

        log.info("User event {} has been sent to topic {} for user {}",
                message.getPayload().getStatus().name(),
                userEventChannel.OUTPUT,
                message.getPayload().getUsername());
    }

    private UserEventPayload convertTo(User user) {
        return UserEventPayload.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .status(UserStatus.NEW)
                .build();
    }

}
