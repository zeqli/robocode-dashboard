package app.dashboard;


import app.dao.entity.Access;
import app.dao.entity.GroupRole;
import app.dao.entity.GroupRoleMap;
import app.dao.entity.Groups;
import app.dao.entity.Role;
import app.dao.entity.RoleAccess;
import app.dao.entity.UserGroup;
import app.dao.entity.UserRole;
import app.dao.entity.Users;
import app.dao.idao.IAccessDAO;
import app.dao.idao.IGroupRole;
import app.dao.idao.IGroupRoleMapDAO;
import app.dao.idao.IGroupsDAO;
import app.dao.idao.IRoleAccessDAO;
import app.dao.idao.IRoleDAO;
import app.dao.idao.IUserGroupDAO;
import app.dao.idao.IUserRoleDAO;
import app.dao.idao.IUsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {


    @Autowired
    private IAccessDAO accessDAO;
    
    @Autowired
    private IRoleDAO roleDAO;
    
    @Autowired
    private IUsersDAO usersDAO;
    
    @Autowired
    private IGroupsDAO groupsDAO;
    
    @Autowired
    private IRoleAccessDAO roleAccessDAO;
    
    @Autowired
    private IUserRoleDAO userRoleDAO;
    
    @Autowired
    private IUserGroupDAO userGroupDAO;
    
    @Autowired
    private IGroupRole groupRoleDAO;
    
    @Autowired
    private IGroupRoleMapDAO groupRoleMapDAO;

    @RequestMapping("/")
    public String home() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value ="/access/{id}", method = RequestMethod.GET, produces = "application/json")
    public Access getAccessById(@PathVariable String id){
        Long idL = null;
        Access response = null;

        try {
            idL = Long.parseLong(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (idL != null) {
             response = accessDAO.getAccessById(idL);
        }
        return response;
    }

    @RequestMapping(value ="/access/list", method = RequestMethod.GET, produces = "application/json")
    public List<Access> getAllAccessInfo(){
        List<Access> response = null;
        response = accessDAO.getAllAccess();
        return response;
    }
    
    @RequestMapping(value ="/role/{id}", method = RequestMethod.GET, produces = "application/json")
    public Role getRoleById(@PathVariable String id) {
    	Long idL = null;
    	Role response = null;
    	
    	try {
    		idL = Long.parseLong(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if (idL != null) {
    		response = roleDAO.getRoleById(idL);
    	}
    	
    	return response;
    }
    
    @RequestMapping(value = "/role/list", method = RequestMethod.GET, produces = "application/json")
    public List<Role> getAllRoleInfo() {
    	List<Role> response = null;
    	response = roleDAO.getAllRole();
    	return response;
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public Users getUserById(@PathVariable String id) {
    	Long idL = null;
    	Users response = null;
    	
    	try {
    		idL = Long.parseLong(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if (idL != null) {
    		response = usersDAO.getUserById(idL);
    	}
    	
    	return response;
    }
    
    @RequestMapping(value = "/user/list", method = RequestMethod.GET, produces = "application/json")
    public List<Users> getAllUserInfo() {
    	List<Users> response = null;
    	response = usersDAO.getAllUser();
    	return response;
    }
    
    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET, produces = "application/json")
    public Groups getGroupById(@PathVariable String id) {
    	Long idL = null;
    	Groups response = null;
    	
    	try {
    		idL = Long.parseLong(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if (idL != null) {
    		response = groupsDAO.getGroupById(idL);
    	}
    	
    	return response;
    }
    
    @RequestMapping(value = "/group/list", method = RequestMethod.GET, produces = "application/json")
    public List<Groups> getAllGroupInfo() {
    	List<Groups> response = null;
    	response = groupsDAO.getAllGroup();
    	return response;
    }
    
    @RequestMapping(value = "/role_access/{id}", method = RequestMethod.GET, produces = "application/json")
    public RoleAccess getRoleAccessById(@PathVariable String id) {
    	Long idL = null;
    	RoleAccess response = null;
    	
    	try {
    		idL = Long.parseLong(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if (idL != null) {
    		response = roleAccessDAO.getRoleAccessById(idL);
    	}
    	
    	return response;
    }
    
    @RequestMapping(value = "/role_access/list", method = RequestMethod.GET, produces = "application/json")
    public List<RoleAccess> getAllRoleAccessInfo() {
    	List<RoleAccess> response = null;
    	response = roleAccessDAO.getAllRoleAccess();
    	return response;
    }
    
    @RequestMapping(value = "/user_role/{id}", method = RequestMethod.GET, produces = "application/json")
    public UserRole getUserRoleById(@PathVariable String id) {
    	Long idL = null;
    	UserRole response = null;
    	
    	try {
    		idL = Long.parseLong(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if (idL != null) {
    		response = userRoleDAO.getUserRoleById(idL);
    	}
    	
    	return response;
    }
    
    @RequestMapping(value = "/user_role/list", method = RequestMethod.GET, produces = "application/json")
    public List<UserRole> getAllUserRoleInfo() {
    	List<UserRole> response = null;
    	response = userRoleDAO.getAllUserRole();
    	return response;
    }
    
    @RequestMapping(value = "/user_group/{id}", method = RequestMethod.GET, produces = "application/json")
    public UserGroup getUserGroupById(@PathVariable String id) {
    	Long idL = null;
    	UserGroup response = null;
    	
    	try {
    		idL = Long.parseLong(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if (idL != null) {
    		response = userGroupDAO.getUserGroupById(idL);
    	}
    	
    	return response;
    }
    
    @RequestMapping(value = "/user_group/list", method = RequestMethod.GET, produces = "application/json")
    public List<UserGroup> getAllUserGroupInfo() {
    	List<UserGroup> response = null;
    	response = userGroupDAO.getAllUserGroup();
    	return response;
    }
    
    @RequestMapping(value = "/group_role/{id}", method = RequestMethod.GET, produces = "application/json")
    public GroupRole getGroupRoleById(@PathVariable String id) {
    	Long idL = null;
    	GroupRole response = null;
    	
    	try {
    		idL = Long.parseLong(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if (idL != null) {
    		response = groupRoleDAO.getGroupRoleById(idL);
    	}
    	
    	return response;
    }
    
    @RequestMapping(value = "/group_role/list", method = RequestMethod.GET, produces = "application/json")
    public List<GroupRole> getAllGroupRoleInfo() {
    	List<GroupRole> response = null;
    	response = groupRoleDAO.getAllGroupRole();
    	return response;
    }
    
    @RequestMapping(value = "/group_role_map/{id}", method = RequestMethod.GET, produces = "application/json")
    public GroupRoleMap getGroupRoleMapById(@PathVariable String id) {
    	Long idL = null;
    	GroupRoleMap response = null;
    	
    	try {
    		idL = Long.parseLong(id);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if (idL != null) {
    		response = groupRoleMapDAO.getGroupRoleMapById(idL);
    	}
    	
    	return response;
    }

    @RequestMapping(value = "/group_role_map/list", method = RequestMethod.GET, produces = "application/json")
    public List<GroupRoleMap> getAllGroupRoleMapInfo() {
    	List<GroupRoleMap> response = null;
    	response = groupRoleMapDAO.getAllGroupRoleMap();
    	return response;
    }
    
    @RequestMapping(value = "/access/{name}", method = RequestMethod.POST, produces = "application/json")
    public Access createAccess(@PathVariable String name){
        Access response = null;
        
        response = accessDAO.insertAccess(name);
        return response;
    }
    
    @RequestMapping(value = "/group/{name}", method = RequestMethod.POST, produces = "application/json")
    public Groups createGroup(@PathVariable String name){
        Groups response = null;
        
        response = groupsDAO.insertGroup(name);
        return response;
    }
    
    @RequestMapping(value = "/role/{name}", method = RequestMethod.POST, produces = "application/json")
    public Role createRole(@PathVariable String name){
        Role response = null;
        
        response = roleDAO.insertRole(name);
        return response;
    }
    
    @RequestMapping(value = "/user/{UserID}", method = RequestMethod.POST, produces = "application/json")
    public Users createUser(@PathVariable String UserID){
        Users response = null;
        
        response = usersDAO.insertUser(UserID);
        return response;
    }
    
    //TODO Add Controller Here
}
