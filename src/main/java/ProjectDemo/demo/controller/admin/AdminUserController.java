package ProjectDemo.demo.controller.admin;


import ProjectDemo.demo.dto.UserDto;
import ProjectDemo.demo.entity.User;
import ProjectDemo.demo.reponsitory.CommentReponsitory;
import ProjectDemo.demo.reponsitory.TopicReponsitory;
import ProjectDemo.demo.reponsitory.UserReponsitory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
@SessionAttributes("userdto")
public class AdminUserController {

    @Autowired
    private TopicReponsitory topicReponsitory;

    @Autowired
    private CommentReponsitory commentReponsitory;

    @Autowired
    private UserReponsitory userReponsitory;


    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }
   //@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/table_user")
    public String showUserControl(@ModelAttribute("userdto") UserDto userDto, Model model){
        List<User> users = userReponsitory.getAllUser();
        model.addAttribute("users",users);
        model.addAttribute("commentcount",commentReponsitory);
        model.addAttribute("topiccount",topicReponsitory);
        return "table_user";
    }
}
