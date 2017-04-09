package java4web.entity;

import javax.persistence.*;

@Entity
@Table(name="user_role")
public class UserRole{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="role")
    private String role;

    public UserRole(Integer userId, String role) {
        this.role = role;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
