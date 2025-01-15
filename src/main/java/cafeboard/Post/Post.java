package cafeboard.Post;

import cafeboard.Board.Board;
import cafeboard.Comment.Comment;
import cafeboard.Member.Member;
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
    @ManyToOne
    @JoinColumn(nullable = false)
    private Member writer;

    @CreatedDate
    private LocalDateTime createTime;

    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Comment> commentList=new ArrayList<>();


    public Post(String title, String content, Member writer, Board board) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.board = board;

    }

    protected Post() {
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

    public Member getWriter() {
        return writer;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Board getBoard() {
        return board;
    }

    public int getCommentCount() {
        return commentList.size();
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

    public void setWriter(Member writer) {
        this.writer = writer;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void change(UpdatePostRequest request){
        title=request.title();
        content= request.content();
    }



}
