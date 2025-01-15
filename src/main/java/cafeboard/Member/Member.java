package cafeboard.Member;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id @Column (unique = true)
    private String id;

    private String passWord;
    private String name;
    @Column (unique = true)
    private String nickname;

    protected Member() {
    }

    public Member(String id, String passWord, String name, String nickname) {
        this.id = id;
        this.passWord = passWord;
        this.name = name;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }
}
