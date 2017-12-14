package app.dao.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GroupRole {

    @Id
    @Column(name = "group_id", nullable = false)
    private Long groupId;
}
