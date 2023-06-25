package dev.aimnnorouzi.aw.service;

import dev.aimnnorouzi.aw.exception.RoleNotFoundException;
import dev.aimnnorouzi.aw.model.Role;
import dev.aimnnorouzi.aw.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role create(String name) {
        Role role = Role.builder()
                .name(name.toUpperCase())
                .build();

        Role saved = roleRepository.save(role);

        log.info("Created new role: {}", role);
        return saved;
    }

    public Role get(Long id) {
        Role found = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));

        log.info("Found a role: {}", found);
        return found;
    }

    public Role get(String name) {
        Role found = roleRepository.findByName(name.toUpperCase())
                .orElseThrow(RoleNotFoundException::new);

        log.info("Found a role: {}", found);
        return found;
    }
}
