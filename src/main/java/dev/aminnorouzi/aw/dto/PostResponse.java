package dev.aimnnorouzi.aw.dto;

import dev.aimnnorouzi.aw.model.Status;
import dev.aimnnorouzi.aw.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

    private Long id;
    private String title;
    private String body;
    private Status status;
    private User user;
    private LocalDateTime createdAt;
}
