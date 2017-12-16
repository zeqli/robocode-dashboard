package app.dao.repo;

<<<<<<< HEAD
public interface GroupRoleRepository {
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import app.dao.entity.GroupRole;

@Service
public interface GroupRoleRepository extends JpaRepository<GroupRole, Long> {
	
>>>>>>> api commit
}
