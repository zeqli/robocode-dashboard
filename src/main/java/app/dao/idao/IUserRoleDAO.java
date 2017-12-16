package app.dao.idao;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public interface IUserRoleDAO {
=======
import java.util.List;

import org.springframework.stereotype.Service;

import app.dao.entity.UserRole;

@Service
public interface IUserRoleDAO {
	UserRole getUserRoleById(Long id);
	List<UserRole> getAllUserRole();
>>>>>>> api commit
}
