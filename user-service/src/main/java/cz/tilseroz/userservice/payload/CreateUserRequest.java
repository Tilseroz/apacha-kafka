package cz.tilseroz.userservice.payload;

import lombok.Data;

@Data
public class CreateUserRequest {

    private String username;
    private String password;
    private String email;
}
