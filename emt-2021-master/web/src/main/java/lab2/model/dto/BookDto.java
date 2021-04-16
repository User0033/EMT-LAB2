package lab2.model.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String name;
    private int categoryId;
    private Long authorId;
    private Integer availableCopies;

}
