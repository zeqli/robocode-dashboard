package app.dao.idao;


<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public interface IRoleDAO {
=======
import java.util.List;

import org.springframework.stereotype.Service;

import app.dao.entity.Role;

@Service
public interface IRoleDAO {
	Role getRoleById(Long id);
	List<Role> getAllRole();
>>>>>>> api commit
}
