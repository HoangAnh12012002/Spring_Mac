package ProjectDemo.demo.controller.Authentication;


import ProjectDemo.demo.entity.User;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@Controller
@AllArgsConstructor
@SessionAttributes("userdto")
public class LogoutController {
    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }
    @GetMapping("/logout")
    public String Logout(@ModelAttribute("userdto") UserDto userDto, WebRequest request, SessionStatus status){
//        Xóa session user ra khỏi vị trí
        status.setComplete();// đã hoàn thành
        request.removeAttribute("userdto",WebRequest.SCOPE_SESSION);//thực hiện xóa userdto ra khỏi tầm của session
        return "redirect:/login";
    }*/
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LogoutController {
    @GetMapping("/logout")
    public ResponseEntity<String> logout( HttpSession session) {
      //  session.invalidate();  // Xóa toàn bộ session
        session.removeAttribute("user");
        return new ResponseEntity<>("Logout successful", HttpStatus.OK);
    }
    @GetMapping("/test")
    public ResponseEntity<User> test(HttpSession session) {
        //  session.invalidate();  // Xóa toàn bộ session
        User user = (User) session.getAttribute("user");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
