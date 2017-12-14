package app.dao.entity;
import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @Column(name = "usr_id", nullable = false)
    private Long userId;

    @Column(name = "role_id", nullable = false)
    private Integer roleId;

}
