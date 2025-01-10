package cafeboard.Comment;

import cafeboard.Board.Board;
import cafeboard.Post.Post;
import jakarta.persistence.*;

@Entity
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Post post;
}
