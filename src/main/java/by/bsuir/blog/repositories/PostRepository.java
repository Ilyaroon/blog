package by.bsuir.blog.repositories;

import by.bsuir.blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
