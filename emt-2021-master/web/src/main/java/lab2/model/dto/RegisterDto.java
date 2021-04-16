package lab2.model.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private String repeatPassword;
    private String name;
    private String surname;
}
