package cafeboard.Post;

import cafeboard.Board.Board;
import jakarta.persistence.*;

@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Board board;
}
