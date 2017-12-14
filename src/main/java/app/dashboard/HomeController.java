package app.dashboard;


import app.dao.entity.Access;
import app.dao.idao.IAccessDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {


    @Autowired
    private IAccessDAO accessDAO;

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
}
