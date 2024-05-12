//package ProjectDemo.demo.controller.admin;
//
//import ProjectDemo.demo.dto.UserDto;
//import ProjectDemo.demo.dto.UserUpdateDTO;
//import ProjectDemo.demo.entity.User;
//import ProjectDemo.demo.reponsitory.UserReponsitory;
//import ProjectDemo.demo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@Controller
//@SessionAttributes("userdto")
//public class EditUserController {
//    @Autowired
//    private UserReponsitory userReponsitory;
//    @Autowired
//    private UserService userService;
//    @GetMapping("/edit_user/{ID}")
//    public String showEditUser(Model model, @PathVariable String ID,@ModelAttribute("userdto") UserDto userDto){
//
//        Optional<User> useraa =userReponsitory.findById(Integer.parseInt(ID));
//        User user = useraa.get();
//        model.addAttribute("user",user);
//        return "edit_user";
//    }
//    @PostMapping("/edit_user/{ID}")
//    public String updateTopic(Model model, @PathVariable String ID,   @ModelAttribute("user") UserUpdateDTO userUpdateDTO){
//
//       User useraa =userReponsitory.findById(Integer.parseInt(ID)).get();
//        //User usera = useraa.get();
//        useraa.setEmail(userUpdateDTO.getEmail());
//        useraa.setAboutMe(userUpdateDTO.getAboutMe());
//        useraa.setUserDisplayName(userUpdateDTO.getUserDisplayName());
//        useraa.setRole(userUpdateDTO.getRole());
//        userService.update(userUpdateDTO,Integer.parseInt(ID));
//        return "redirect:/table_user";
//    }
//}
