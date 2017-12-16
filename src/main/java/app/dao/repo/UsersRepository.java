package app.dao.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import app.dao.entity.Users;

@Service
public interface UsersRepository extends JpaRepository<Users, Long>{
	
}
