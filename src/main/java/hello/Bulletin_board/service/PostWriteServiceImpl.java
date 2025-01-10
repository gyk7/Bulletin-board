package hello.Bulletin_board.service;

import hello.Bulletin_board.dto.PostDto;
import hello.Bulletin_board.repository.PostRepository;
import org.springframework.stereotype.Service;

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
}
