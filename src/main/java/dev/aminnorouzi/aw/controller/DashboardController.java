package dev.aimnnorouzi.aw.controller;

import dev.aimnnorouzi.aw.mapper.PostMapper;
import dev.aimnnorouzi.aw.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class DashboardController {

    private final PostService postService;
    private final PostMapper postMapper;

    @GetMapping
    public String index() {
        return "./admin/dashboard";
    }

//    @GetMapping("/posts/new")
//    public String createPost(Model model, Principal principal) {
////        User user = userRepository.findById(1L)
////                .orElseThrow();
//
//        PostRequest request = new PostRequest();
////        request.setUser(user);
//
//        model.addAttribute("post", request);
//        return "./admin/new-post";
//    }
//
//    @PostMapping("/posts/new")
//    public String createPost(@ModelAttribute PostRequest request, Principal principal) {
//        Post post = postService.create(request);
//
//        return "redirect:/posts/" + post.getId();
//    }
}
