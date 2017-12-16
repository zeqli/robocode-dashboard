package app.dao.idao;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public interface IUserGroupDAO {
=======
import java.util.List;

import org.springframework.stereotype.Service;

import app.dao.entity.UserGroup;

@Service
public interface IUserGroupDAO {
	
	UserGroup getUserGroupById(Long id);
	List<UserGroup> getAllUserGroup();
>>>>>>> api commit
}
