package dev.aimnnorouzi.aw.controller;

import dev.aimnnorouzi.aw.mapper.UserMapper;
import dev.aimnnorouzi.aw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


}
