package ProjectDemo.demo.controller.admin;
import ProjectDemo.demo.dto.UserDto;
import ProjectDemo.demo.entity.Topic;
import ProjectDemo.demo.reponsitory.TopicReponsitory;
import ProjectDemo.demo.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.List;

@Controller
@AllArgsConstructor
@SessionAttributes("userdto")
public class AdminHomeController {
    private CommentService commentService;
    @Autowired
    private TopicReponsitory topicReponsitory;
    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }
    @GetMapping("/admin_home")
  //  @PreAuthorize("hasAuthority('ADMIN')")
    public String showHomeForm(@ModelAttribute("userdto") UserDto userDto, Model model, @Param("keyword") String keyword){
        List<Topic> topics = topicReponsitory.findAll();
        if(keyword != null){
            topics= topicReponsitory.SearchTopic(keyword);
            model.addAttribute("keyword",keyword);
        }

        model.addAttribute("topics",topics);
        model.addAttribute("commentcount",commentService);

        return "/admin_home";
    }
}
