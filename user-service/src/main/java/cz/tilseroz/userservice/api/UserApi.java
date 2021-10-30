package cz.tilseroz.userservice.api;

import cz.tilseroz.userservice.entity.User;
import cz.tilseroz.userservice.payload.ApiResponse;
import cz.tilseroz.userservice.payload.CreateUserRequest;
import cz.tilseroz.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class UserApi {

    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequest request) {
        log.info("Received create user request with username {}", request.getUsername());

        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .build();

        userService.createUser(user);

        return ResponseEntity.ok().body(new ApiResponse(true, "User has been created."));

    }
}
