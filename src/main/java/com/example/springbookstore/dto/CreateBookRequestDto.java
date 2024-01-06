package com.example.springbookstore.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class CreateBookRequestDto {
    @NotBlank(message = "Title is mandatory")
    @Size(min = 2, max = 100, message = "Title length must be between 2 and 100 characters")
    private String title;

    @NotBlank(message = "Author is mandatory")
    @Size(min = 2, max = 50, message = "Author length must be between 2 and 50 characters")
    private String author;

    @NotBlank(message = "ISBN is mandatory")
    @Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$", message = "ISBN format is not correct.")
    private String isbn;

    @NotNull(message = "Price is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal price;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 10, max = 2000, message = "Description length must be between 10 and 2000 characters")
    private String description;

    private String coverImage;
}
