package cafeboard.Board;

import cafeboard.Post.Post;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;

    @CreatedDate
    private LocalDateTime createTime;

    @OneToMany(mappedBy = "board",cascade = CascadeType.REMOVE)
    private List<Post> PostList;

    public Board() {
    }

    public Board(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public List<Post> getPostList() {
        return PostList;
    }
    public void updateAll(String title){
        this.title=title;

    }
}
