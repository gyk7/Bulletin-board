package hello.Bulletin_board.service;

import hello.Bulletin_board.dto.PostDto;
import org.springframework.stereotype.Service;


public interface PostWriteService {
    PostDto create(PostDto postDto);
}
