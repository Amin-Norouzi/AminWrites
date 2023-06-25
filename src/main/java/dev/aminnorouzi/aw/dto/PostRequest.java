package dev.aimnnorouzi.aw.dto;

import dev.aimnnorouzi.aw.model.Status;
import dev.aimnnorouzi.aw.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String body;

    @NotNull
    private Status status;

    @NotNull
    private User user;
}
