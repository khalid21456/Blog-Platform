package com.Edaoudi.blog.domain.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")

public class CreateCategoryRequest {
    @NotBlank(message = "Category_name is required")
    @Size(min = 2, max = 50, message = "Category_name must be between {min} and {max} characters")
    @Pattern(regexp = "^[\\w\\s-]+$", message = "Category_name can only contain letters, numbers, spaces and hyphens")
    private String name;
}