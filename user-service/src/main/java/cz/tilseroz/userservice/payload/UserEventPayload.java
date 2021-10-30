package cz.tilseroz.userservice.payload;

import cz.tilseroz.userservice.enums.UserStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEventPayload {

    private Long id;
    private String username;
    private String email;
    private UserStatus status;
}
