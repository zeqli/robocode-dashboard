package app.dao.entity;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name = "Group_Role")
public class GroupRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "group_id")
    private Long group_id;
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    
    @Column(name = "create_time")
    private Date create_time;

	public Long getId() {
		return id;
	}

	public Long getGroup_id() {
		return group_id;
	}

	public Role getRole() {
		return role;
	}

	public Date getCreate_time() {
		return create_time;
	}
    
   
}
