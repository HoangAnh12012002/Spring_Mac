package ProjectDemo.demo.controller.Authentication;

import ProjectDemo.demo.dto.ApiResponse;
import ProjectDemo.demo.dto.UserDto;
import ProjectDemo.demo.entity.User;
import ProjectDemo.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserRegistrationController {
@Autowired
    private  UserService userService;
    public UserDto userResgistrationDto() {
        return new UserDto();
    }

    //thêm cái @Valid vi toi bo cai validation vao trong UserDto
    //trả về object ApiResponse chứ ko phải uSER NỮA
    @PostMapping("/registration")
    ApiResponse<User> registerUserAccount(@RequestBody @Valid UserDto userDto) {
        ApiResponse<User> apiResponse= new ApiResponse<>();

        apiResponse.setResult( userService.signup(userDto));
return apiResponse;
     /*   userService.signup(userDto);
        return ResponseEntity.ok("Registration successful");*/
    }
}
