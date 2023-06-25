package dev.aimnnorouzi.aw.mapper;

import dev.aimnnorouzi.aw.dto.PostResponse;
import dev.aimnnorouzi.aw.model.Post;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PostMapper {

    private final ModelMapper modelMapper;

    public PostResponse toDto(Post post) {
        return modelMapper.map(post, PostResponse.class);
    }

    public Post toEntity(PostResponse response) {
        return modelMapper.map(response, Post.class);
    }
}
