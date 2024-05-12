package ProjectDemo.demo.controller;

import ProjectDemo.demo.dto.UserDto;
import ProjectDemo.demo.entity.Topic;
import ProjectDemo.demo.reponsitory.TopicReponsitory;
import ProjectDemo.demo.service.CommentService;
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
//@PreAuthorize("hasAuthority('USER')")
public class HomeController {
    private CommentService commentService;
    @Autowired
    private TopicReponsitory topicReponsitory;
    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }
    @GetMapping("/home")
    public String showHomeForm(@ModelAttribute("userdto") UserDto userDto,Model model){
        List<Topic> topics = topicReponsitory.findAll();
        model.addAttribute("topics",topics);
        model.addAttribute("commentcount",commentService);

        return "/home";
    }
}
