package ProjectDemo.demo.controller.Authentication;

import ProjectDemo.demo.dto.ApiResponse;
import ProjectDemo.demo.dto.JwtAuthenticationResponse;
import ProjectDemo.demo.dto.LoginRequest;
import ProjectDemo.demo.dto.RefreshTokenRequest;
import ProjectDemo.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//test api
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserLoginController {
    @Autowired
    private  UserService userService;


//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
//            JwtAuthenticationResponse response = userService.signin(loginRequest);
//            return ResponseEntity.ok(response);  // Trả về đốitượng JwtAuthenticationResponse,baogoomfmf token và refreshtoken
//    }

    @PostMapping("/login")
   public ApiResponse<?> login(@RequestBody LoginRequest loginRequest){
        ApiResponse<JwtAuthenticationResponse> apiResponse= new ApiResponse<>();
        apiResponse.setResult(userService.signin(loginRequest));
        return apiResponse;
    }



//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        authenticationRequest.getUsername(),
//                        authenticationRequest.getPassword()
//                )
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtTokenProvider.createToken(authentication);
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }


    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return  ResponseEntity.ok(userService.refreshToken(refreshTokenRequest));
    }
}
