package cafeboard.Member;

import jakarta.persistence.*;

import static cafeboard.SecurityUtils.sha256EncryptHex2;

@Entity
public class Member {
    @Id @Column (unique = true)
    private String id;

    private String password;
    private String name;
    @Column (unique = true)
    private String nickname;

    protected Member() {
    }

    public Member(String id, String password, String name, String nickname) {
        this.id = id;
        this.password = sha256EncryptHex2(password);
        this.name = name;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public void update(UpdateMemberRequest request) {
        password =sha256EncryptHex2(request.password());
        name=request.name();
        nickname= request.nickname();
    }

}
