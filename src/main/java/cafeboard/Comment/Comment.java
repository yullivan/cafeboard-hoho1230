package cafeboard.Comment;

import cafeboard.Board.Board;
import cafeboard.Post.Post;
import jakarta.persistence.*;

@Entity
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String writer;

    @ManyToOne
    private Post post;

    public Comment() {
    }

    public Comment(String content, String writer, Post post) {
        this.content = content;
        this.writer = writer;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public Post getPost() {
        return post;
    }
}
