package dev.aimnnorouzi.aw.controller;

import dev.aimnnorouzi.aw.dto.UserRequest;
import dev.aimnnorouzi.aw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        UserRequest request = new UserRequest();

        model.addAttribute("request", request);
        return "./security/login";
    }
}
