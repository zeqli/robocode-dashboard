package app.dao.idao;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public interface IUsersDAO {

=======
import java.util.List;

import org.springframework.stereotype.Service;

import app.dao.entity.Users;

@Service
public interface IUsersDAO {
	Users getUserById(Long id);
	List<Users> getAllUser();
>>>>>>> api commit
}
