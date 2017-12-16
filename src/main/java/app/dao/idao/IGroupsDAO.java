package app.dao.idao;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public interface IGroupsDAO {
=======
import java.util.List;

import org.springframework.stereotype.Service;

import app.dao.entity.Groups;

@Service
public interface IGroupsDAO {
	
	Groups getGroupById(Long id);
	List<Groups> getAllGroup();
>>>>>>> api commit
}
