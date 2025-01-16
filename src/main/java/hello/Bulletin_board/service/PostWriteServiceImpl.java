package hello.Bulletin_board.service;

import hello.Bulletin_board.dto.PostDto;
import hello.Bulletin_board.model.Post;
import hello.Bulletin_board.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostWriteServiceImpl implements PostWriteService{

    private final PostRepository postRepository;

    public PostWriteServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto create(PostDto postDto) {
        return new PostDto(postRepository.save(postDto.toEntity()));
    }

    @Override
    public PostDto update(PostDto postDto) {
        Post entity = postRepository.findByTitle(postDto.getTitle()).orElseThrow(
                () -> new IllegalArgumentException("그 제목은 찾을 수 없습니다." + postDto.getTitle()));
        return new PostDto(postRepository.save(entity.update(postDto)));
    }

    @Override
    public void delete(String title) {
        postRepository.deleteByTitle(title);
    }


}
