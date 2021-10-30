package cz.tilseroz.userservice.service;

import cz.tilseroz.userservice.entity.User;
import cz.tilseroz.userservice.messaging.UserEventSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final UserEventSender userEventSender;

    public UserService(UserEventSender userEventSender) {
        this.userEventSender = userEventSender;
    }

    public void createUser(User user) {
        log.info(String.format("Creating new user %s", user.getUsername()));

        // Here we would save record to the database. But this project is for practicing of Kafka,
        // so we won't implement repository and nothing about database.

        userEventSender.sendUserCreated(retrieveUserWithRandomId(user));
    }

    /**
     * Just generating of random id, normally we would get it from database.
     */
    private User retrieveUserWithRandomId(User user) {
        long leftLimit = 1L;
        long rightLimit = 10L;
        user.setId(leftLimit + (long) (Math.random() * (rightLimit - leftLimit)));
        return user;
    }
}
