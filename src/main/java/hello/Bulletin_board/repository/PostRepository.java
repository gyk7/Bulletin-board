package hello.Bulletin_board.repository;

import hello.Bulletin_board.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    @Query("SELECT p From Post p WHERE p.title = :title")
    Optional <Post> findByTitle(String title);

    @Transactional
    @Modifying
    @Query("DELETE FROM Post p WHERE p.title = :title")
    void deleteByTitle(@Param("title") String title);
}
