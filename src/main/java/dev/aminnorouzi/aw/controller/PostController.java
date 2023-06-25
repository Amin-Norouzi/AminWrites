package dev.aimnnorouzi.aw.controller;

import dev.aimnnorouzi.aw.dto.PostRequest;
import dev.aimnnorouzi.aw.dto.PostResponse;
import dev.aimnnorouzi.aw.mapper.PostMapper;
import dev.aimnnorouzi.aw.model.Post;
import dev.aimnnorouzi.aw.model.User;
import dev.aimnnorouzi.aw.security.CurrentUser;
import dev.aimnnorouzi.aw.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getPost(@PathVariable Long id, Model model) {
        Post post = postService.get(id);
        PostResponse response = postMapper.toDto(post);

        model.addAttribute("post", response);
        return "./admin/post";
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public String getPosts(Model model) {
        List<PostResponse> responses = postService.getAll()
                .stream()
                .map(postMapper::toDto)
                .toList();

        model.addAttribute("posts", responses);
        return "./admin/posts";
    }

    @GetMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String createPost(Model model, @CurrentUser User user) {
        PostRequest request = new PostRequest();
        request.setUser(user);

        model.addAttribute("post", request);
        return "./admin/new-post";
    }

    @PostMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String createPost(@ModelAttribute PostRequest request) {
        Post post = postService.create(request);
        PostResponse response = postMapper.toDto(post);

        return "redirect:/posts/" + post.getId();
    }
}