package app.dao.entity;

import java.sql.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    
    @CreationTimestamp
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsr_id(Long usr_id) {
		this.usr_id = usr_id;
	}

	public void setGroup_id(Long group_id) {
		this.group_id = group_id;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
    

}
