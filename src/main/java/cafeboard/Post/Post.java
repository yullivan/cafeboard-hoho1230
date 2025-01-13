package cafeboard.Post;

import cafeboard.Board.Board;
import cafeboard.Comment.Comment;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String writer;

    @CreatedDate
    private LocalDateTime createTime;

    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Comment> commentList=new ArrayList<>();

    private int commentCount=0;

    public Post(String title, String content, String writer, Board board) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.board = board;
        this.commentCount = commentList.size();
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Board getBoard() {
        return board;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void change(updatePostRequest request){
        title=request.title();
        content= request.content();
        writer= request.writer();
    }
}
