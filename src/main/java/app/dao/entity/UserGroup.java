package app.dao.entity;
<<<<<<< HEAD
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
=======
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "User_Group")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "Usr_id")
    private Long usr_id;
    
    @Column(name = "Group_id")
    private Long group_id;
    
    @Column(name = "create_time")
    private Date create_time;

	public Long getId() {
		return id;
	}

	public Long getUsr_id() {
		return usr_id;
	}

	public Long getGroup_id() {
		return group_id;
	}

	public Date getCreate_time() {
		return create_time;
	}
    
    
>>>>>>> api commit
}
