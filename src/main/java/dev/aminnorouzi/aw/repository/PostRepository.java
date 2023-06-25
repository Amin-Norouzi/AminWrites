package dev.aimnnorouzi.aw.repository;

import dev.aimnnorouzi.aw.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
