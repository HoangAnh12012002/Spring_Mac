package ProjectDemo.demo.controller.Authentication;

import ProjectDemo.demo.entity.User;
import ProjectDemo.demo.reponsitory.UserReponsitory;
import ProjectDemo.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TestSearch_Filter {
    @Autowired
    private UserService userService;
    @Autowired
    private UserReponsitory userReponsitory;
    @GetMapping("Search")
    public ResponseEntity<List<User>> Search(@RequestParam("query") String query) {
        return ResponseEntity.ok(userService.searchUserByName(query));
    }

    @GetMapping("GetAllUser")
    public ResponseEntity<List<User>> GetAll() {
        return ResponseEntity.ok(userService.GetAllUser());
    }

    @GetMapping("Filter")
    public ResponseEntity<List<User>> FilterByRole(@RequestParam("query") String query) {
        return ResponseEntity.ok(userReponsitory.filterByRole(query));
    }

    @GetMapping("GetById/{ID}")
    public ResponseEntity<User> GetUserByIdUsingPathVariable(@PathVariable int ID) {
        return ResponseEntity.ok(userReponsitory.findById(ID));
        
    }
    @GetMapping("/GetById")
    public ResponseEntity<User> GetUserByIdUsingParam(@RequestParam(value = "ID", required = true) int ID) {
        return ResponseEntity.ok(userReponsitory.findById(ID));
    }

    }

