package ProjectDemo.demo.service;

import ProjectDemo.demo.dto.*;
import ProjectDemo.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void save(UserDto userDto);

//    Boolean checkPasswordUser(String email,String password);
//    Boolean checkUserbyEmail(String email);
    void update(UserUpdateDTO userUpdateDTO,Integer ID);
   User getUserbyEmail(String email);

  //  List<User> check();
//    Boolean checkEmail(String email);
//     Boolean checkName(String name);

    UserDetailsService userDetailsService();
    User signup(UserDto userDto);
    JwtAuthenticationResponse signin(LoginRequest loginRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    List<User> GetAllUser();
  List<User> searchUserByName(String query);
}
