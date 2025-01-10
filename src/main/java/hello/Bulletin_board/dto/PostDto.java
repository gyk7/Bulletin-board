package hello.Bulletin_board.dto;

import hello.Bulletin_board.model.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {
    private String title;
    private String content;

    public PostDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
    }

    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
