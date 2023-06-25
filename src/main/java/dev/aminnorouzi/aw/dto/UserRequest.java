package dev.aimnnorouzi.aw.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotNull
    @NotBlank
    private String fullName;

    @NotNull
    @NotBlank
    @Column(unique = true)
    @Email(regexp = "^(.+)@(\\S+)$")
    private String email;

    @NotNull
    @NotBlank
    @ToString.Exclude
    private String password;

    @NotNull
    @NotEmpty
    private List<String> roles;
}
