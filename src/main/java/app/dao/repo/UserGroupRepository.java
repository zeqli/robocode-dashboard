package app.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import app.dao.entity.UserGroup;

@Service
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

}
