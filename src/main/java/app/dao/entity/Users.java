package app.dao.entity;

import java.sql.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "userID")
    private String userID;
    
    @CreationTimestamp
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
    
}
