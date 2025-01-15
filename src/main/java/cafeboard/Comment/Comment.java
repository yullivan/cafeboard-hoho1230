package cafeboard.Comment;

import cafeboard.Post.Post;
import jakarta.persistence.*;

@Entity
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String content;
    private String writer;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Post post;

    protected Comment() {
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

    public void update(UpdateCommnetRequest request) {
        content= request.content();
    }
}
