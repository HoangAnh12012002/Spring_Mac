package ProjectDemo.demo.controller.Authentication;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class TestAdmin {

    @GetMapping("admin")
    public ResponseEntity<String> Testadmin(){
        return ResponseEntity.ok("trang danh cho admin");

    }
}
