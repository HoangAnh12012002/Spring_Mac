package ProjectDemo.demo.controller.Authentication;

import ProjectDemo.demo.reponsitory.UserReponsitory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:5173")
//ví dụ angular chạy ở cổng 5173 , nhưng như này thì hơi mỏi tay , hãy tạo 1 config chung cho tất cả
@AllArgsConstructor
public class TestAuthorized {
    @Autowired
    private UserReponsitory userReponsitory;

    @GetMapping("teststring")
    public String te(){
      return("aaaaaa");
    }
}
