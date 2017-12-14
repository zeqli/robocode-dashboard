package app.dao.entity;
import javax.persistence.*;

@Entity
public class RoleAccess {

    @Id
    @Column(name = "role_id", nullable = false)
    private Long roleId;
}
