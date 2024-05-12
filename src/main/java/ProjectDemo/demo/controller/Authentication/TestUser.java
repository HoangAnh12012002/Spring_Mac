package ProjectDemo.demo.controller.Authentication;

import ProjectDemo.demo.dto.ApiResponse;
import ProjectDemo.demo.entity.User;
import ProjectDemo.demo.reponsitory.UserReponsitory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
//@PreAuthorize("hasRole('USER')")
@PreAuthorize("hasAuthority('USER')")
public class TestUser {
    @Autowired
    private UserReponsitory userReponsitory;
    @GetMapping("user")
//    public ResponseEntity<User> Testuser(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//       User a = userReponsitory.findByEmail(authentication.getName()).get();
//
//        return ResponseEntity.ok(a);
//
//    }

    public ApiResponse<?> Testuser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
ApiResponse<User> apiResponse = new ApiResponse<>();
       apiResponse.setResult(userReponsitory.findByEmail(authentication.getName()).get());
    return apiResponse;
    /*
    Có thể truy cập vào thuôc tính Result để lấy thông tin
      User a = apiResponse.getResult();
       String role= a.getRole();
     */


    }


}


/*
Authentication trong Spring Security chứa các thông tin cơ bản của người dùng được xác thực. Đối tượng Authentication bao gồm một số thông tin như:

Principal: Đại diện cho người dùng được xác thực. Trong trường hợp của Spring Security, Principal thường là một đối tượng UserDetails.

Credentials: Thông tin xác thực của người dùng. Đối với một UsernamePasswordAuthenticationToken, Credentials thường chứa mật khẩu.

Authorities: Danh sách các quyền (roles) của người dùng.

Authenticated: Trạng thái xác thực của người dùng (đã xác thực hay chưa).
 */