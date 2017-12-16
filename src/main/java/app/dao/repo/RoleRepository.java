package app.dao.repo;

<<<<<<< HEAD
public interface RoleRepository {
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import app.dao.entity.Role;

@Service
public interface RoleRepository extends JpaRepository<Role, Long> {
	
>>>>>>> api commit
}
