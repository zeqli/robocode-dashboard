package app.dao.repo;

<<<<<<< HEAD
public interface UserGroupRepository {
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import app.dao.entity.UserGroup;

@Service
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
>>>>>>> api commit
}
