package dev.aimnnorouzi.aw.service;

import dev.aimnnorouzi.aw.exception.PostNotFoundException;
import dev.aimnnorouzi.aw.dto.PostRequest;
import dev.aimnnorouzi.aw.model.Post;
import dev.aimnnorouzi.aw.model.Status;
import dev.aimnnorouzi.aw.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post create(PostRequest request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .status(request.getStatus())
                .user(request.getUser())
                .build();

        Post saved = postRepository.save(post);

        log.info("Created new post: {}", saved);
        return saved;
    }

    public Post get(Long id) {
        Post found = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        log.info("Found a post: {}", found);
        return found;
    }

    public List<Post> getAll(boolean available) {
        List<Post> found = postRepository.findAll();
        found.sort(Comparator.comparing(Post::getCreatedAt).reversed());

        if (available) {
            found.removeIf(p -> p.getStatus().equals(Status.PENDING));
        }

        log.info("Found all posts: {}", found);
        return found;
    }

    public List<Post> getAll() {
        return getAll(false);
    }
}
