package app.dao.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "create_time")
    private Date create_time;
    
    @Column(name = "update_time")
    private Date update_time;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}
    
}
