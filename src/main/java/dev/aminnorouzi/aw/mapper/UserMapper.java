package dev.aimnnorouzi.aw.mapper;

import dev.aimnnorouzi.aw.dto.UserResponse;
import dev.aimnnorouzi.aw.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserResponse fromUser(User user) {
        return modelMapper.map(user, UserResponse.class);
    }
}
