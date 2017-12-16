package app.dao.repo;

<<<<<<< HEAD
public interface RoleAccessRepository {
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import app.dao.entity.RoleAccess;

@Service
public interface RoleAccessRepository extends JpaRepository<RoleAccess, Long> {
	
>>>>>>> api commit
}
