package app.dao.repo;

<<<<<<< HEAD
public interface UserRoleRepository {
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import app.dao.entity.UserRole;

@Service
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
>>>>>>> api commit
}
