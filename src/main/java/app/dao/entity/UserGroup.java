package app.dao.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserGroup {

    @Id
    @Column(name = "usr_id", nullable = false)
    private Long userId;

    @Column(name = "group_id", nullable = false)
    private Integer groupId;
}
