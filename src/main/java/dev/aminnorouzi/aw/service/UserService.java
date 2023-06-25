package dev.aimnnorouzi.aw.service;

import dev.aimnnorouzi.aw.dto.UserRequest;
import dev.aimnnorouzi.aw.model.Role;
import dev.aimnnorouzi.aw.model.User;
import dev.aimnnorouzi.aw.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public User create(UserRequest request) {
        String hashed = passwordEncoder.encode(request.getPassword());

        List<Role> roles = request.getRoles().stream()
                .map(roleService::get)
                .toList();

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(hashed)
                .roles(roles)
//                .posts(new ArrayList<>())
                .build();

        User saved = userRepository.save(user);

        log.info("Created new user: {}", saved);
        return saved;
    }

    public User get(String email) {
        User found = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Wrong credentials for user!"));

        log.info("Found an user: {}", found);
        return found;
    }
}
