package app.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "Access")
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

<<<<<<< HEAD

=======
>>>>>>> api commit
    @Column(name = "name")
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
