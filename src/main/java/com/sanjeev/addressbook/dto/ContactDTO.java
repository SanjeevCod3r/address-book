package com.sanjeev.addressbook.dto;


import lombok.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @Size(min = 1, message = "At least one phone number is required")
    private List<@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits") String> phoneNumbers;
}
