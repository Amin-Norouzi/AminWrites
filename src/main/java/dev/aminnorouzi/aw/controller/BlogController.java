package dev.aimnnorouzi.aw.controller;

import dev.aimnnorouzi.aw.dto.PostResponse;
import dev.aimnnorouzi.aw.mapper.PostMapper;
import dev.aimnnorouzi.aw.model.Post;
import dev.aimnnorouzi.aw.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class BlogController {

    private final PostService postService;
    private final PostMapper postMapper;

    @GetMapping("/{id}")
    public String getPost(@PathVariable Long id, Model model) {
        Post post = postService.get(id);
        PostResponse response = postMapper.toDto(post);

        model.addAttribute("post", response);
        return "./blog/post";
    }

    @GetMapping
    public String getPosts(Model model) {
        List<PostResponse> responses = postService.getAll(true)
                .stream()
                .map(postMapper::toDto)
                .toList();

        model.addAttribute("posts", responses);
        return "./blog/posts";
    }
}
