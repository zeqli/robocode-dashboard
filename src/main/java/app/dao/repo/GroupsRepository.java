package app.dao.repo;

<<<<<<< HEAD
public interface GroupsRepository {
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import app.dao.entity.Groups;

@Service
public interface GroupsRepository extends JpaRepository<Groups, Long> {
	
>>>>>>> api commit
}
