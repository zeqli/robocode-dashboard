package app.dao.idao;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public interface IRoleAccessDAO {
=======
import java.util.List;

import org.springframework.stereotype.Service;

import app.dao.entity.RoleAccess;

@Service
public interface IRoleAccessDAO {
	RoleAccess getRoleAccessById(Long id);
	List<RoleAccess> getAllRoleAccess();
>>>>>>> api commit
}
