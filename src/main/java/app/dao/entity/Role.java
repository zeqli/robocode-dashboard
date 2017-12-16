package app.dao.entity;
<<<<<<< HEAD
import javax.persistence.*;

@Entity
=======
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Role")
>>>>>>> api commit
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

<<<<<<< HEAD
=======
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
    
    
>>>>>>> api commit
}
