package app.dao.entity;
<<<<<<< HEAD
import javax.persistence.*;

@Entity
public class RoleAccess {

    @Id
    @Column(name = "role_id", nullable = false)
    private Long roleId;
=======
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Role_access")
public class RoleAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "role_id", nullable = false)
    private Long role_id;
    
    @ManyToOne
    @JoinColumn(name = "access_id")
    private Access access;
    
    @Column(name = "create_time")
    private Date create_time;

	public Long getId() {
		return id;
	}

	public Long getRole_id() {
		return role_id;
	}

	public Access getAccess() {
		return access;
	}

	public Date getCreate_time() {
		return create_time;
	}
    
    
>>>>>>> api commit
}
