package ProjectDemo.demo.controller.admin;

import ProjectDemo.demo.entity.User;
import ProjectDemo.demo.reponsitory.CommentReponsitory;
import ProjectDemo.demo.reponsitory.TopicReponsitory;
import ProjectDemo.demo.reponsitory.UserReponsitory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@AllArgsConstructor
//@SessionAttributes("userdto")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TestQuery {
    @Autowired
    private TopicReponsitory topicReponsitory;

    @Autowired
    private CommentReponsitory commentReponsitory;

    @Autowired
    private UserReponsitory userReponsitory;

 /*   @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }
    @GetMapping("/table_usertest")
    public String showUserControl(@ModelAttribute("userdto") UserDto userDto, Model model,@Param("keyword") String keyword){
        List<User> users = userReponsitory.getAllUser();
        if(keyword != null){
            int keywordInt = Integer.parseInt(keyword);
          users = userReponsitory.searchAllUser2(keywordInt);
            model.addAttribute("keyword",keyword);
          //  model.addAttribute("users",users);
        }
    //    List<User> users = userReponsitory.getAllUser2(150);
        model.addAttribute("users",users);
        model.addAttribute("commentcount",commentReponsitory);
        model.addAttribute("topiccount",topicReponsitory);
        return "table_usertest";
    }*/

    @GetMapping("/table")
    public ResponseEntity<?> testUser(@RequestParam(value = "keyword", required = false) String keyword) {
        List<User> users;
        if (keyword != null ) {
                int keywordInt = Integer.parseInt(keyword);
                users = userReponsitory.searchAllUser2(keywordInt);
            } else {
            users = userReponsitory.getAllUser();
        }

        return ResponseEntity.ok(users);
    }

}
