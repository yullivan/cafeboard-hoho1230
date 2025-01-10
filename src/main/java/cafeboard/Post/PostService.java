package cafeboard.Post;

import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository Repository;

    public PostService(PostRepository repository) {
        Repository = repository;
    }

    public void create(CreatePostRequest request) {
        Repository.save(new Post(request.title(),request.content(), request.writer(), request.board()));
    }
}
