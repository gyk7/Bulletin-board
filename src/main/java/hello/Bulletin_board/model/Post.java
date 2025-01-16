package hello.Bulletin_board.model;

import hello.Bulletin_board.dto.PostDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_num;
    private String title;
    private String content;


    public Post update(PostDto postDto) {
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
        return this;
    }
}
