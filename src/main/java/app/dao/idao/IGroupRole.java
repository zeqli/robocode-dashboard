package app.dao.idao;


<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public interface IGroupRole {
=======
import java.util.List;

import org.springframework.stereotype.Service;

import app.dao.entity.GroupRole;

@Service
public interface IGroupRole {
	GroupRole getGroupRoleById(Long id);
	List<GroupRole> getAllGroupRole();
>>>>>>> api commit
}
