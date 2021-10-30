package cz.tilseroz.ticketservice.payload;

import cz.tilseroz.ticketservice.enums.UserStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserEventPayload {

    private Long id;
    private String username;
    private String email;
    private UserStatus status;
}
