package app.dao.entity;
<<<<<<< HEAD
import javax.persistence.*;

@Entity
=======
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "user")
>>>>>>> api commit
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

<<<<<<< HEAD
=======
    @Column(name = "userID")
    private String userID;
    
    @Column(name = "create_time")
    private Date create_time;

	public Long getId() {
		return id;
	}

	public String getUserID() {
		return userID;
	}

	public Date getCreate_time() {
		return create_time;
	}
    
    
>>>>>>> api commit
}
