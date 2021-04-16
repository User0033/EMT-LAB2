package lab2.model.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private Long id;
    private String name;
    private String surname;
    private String country;
}
