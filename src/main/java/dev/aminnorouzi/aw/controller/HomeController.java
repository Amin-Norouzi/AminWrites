package dev.aimnnorouzi.aw.controller;

import dev.aimnnorouzi.aw.dto.PostResponse;
import dev.aimnnorouzi.aw.mapper.PostMapper;
import dev.aimnnorouzi.aw.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;
    private final PostMapper postMapper;

    @GetMapping("/")
    public String home(Model model) {
        List<PostResponse> responses = postService.getAll(true)
                .stream()
                .map(postMapper::toDto)
                .toList();

        model.addAttribute("posts", responses);
        return "./main/home";
    }
}