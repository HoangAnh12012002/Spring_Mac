package ProjectDemo.demo.service.Impl;


import ProjectDemo.demo.Exception.AppException;
import ProjectDemo.demo.Exception.ErrorCode;
import ProjectDemo.demo.dto.*;
import ProjectDemo.demo.entity.Profile;
import ProjectDemo.demo.entity.Role;
import ProjectDemo.demo.entity.User;
import ProjectDemo.demo.reponsitory.ProfileReponsitory;
import ProjectDemo.demo.reponsitory.RoleRepository;
import ProjectDemo.demo.reponsitory.UserReponsitory;
import ProjectDemo.demo.service.JWTService;
import ProjectDemo.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;
//    @Autowired
//    private CustomUserDetailImpl userDetailsService;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserReponsitory userReponsitory;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProfileReponsitory profileReponsitory;
    @Override
    public UserDetailsService userDetailsService(){
        return  new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userReponsitory.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public User signup(UserDto userDto){
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String creationDate = Date.format(formatter);
        String pass=passwordEncoder.encode(userDto.getPassword());
        if(checkEmail(userDto.getEmail())==false) {
            throw new AppException(ErrorCode.USER_EXISTED);
            //hoacj tra ve RuntimeException , deu dc , vd:  throw new RuntimeException("Mail existed");
        }
        if(checkName(userDto.getUserDisplayName())==false){
            throw  new AppException(ErrorCode.INVALID_NAME_FORMAT);
        }
        if (!userDto.getPassword().equals(userDto.getCheckPass())) {
            //   return ResponseEntity.badRequest().body("Passwords do not match");
            throw new AppException(ErrorCode.NOT_MATCH_PASS);
        }
        if(checkUserbyEmail(userDto.getEmail())==false){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        Role userRole=roleRepository.findByName("USER");

        User user = new User(userDto.getEmail(),
                userDto.getUserDisplayName(),
                ".",
                0,
                0,
                pass,
                //   passwordEncoder.encode(userDto.getPassword()),
                creationDate,
                userRole
        );
        return  userReponsitory.save(user);
    }
    @Override
    public JwtAuthenticationResponse signin(LoginRequest loginRequest){
      //  authenticationManager.authenticate(
            //      new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        var user = userReponsitory.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new AppException(ErrorCode.WRONG_PASS_OR_EMAIL));

        // Kiểm tra xem mật khẩu nhập vào có khớp với mật khẩu lưu trong cơ sở dữ liệu không
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new AppException(ErrorCode.WRONG_PASS_OR_EMAIL);
        }
        // Nếu mọi thứ đều đúng, tạo JWT token và trả về
        var jwt = jwtService.generateToken(new HashMap<>(), user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        jwtAuthenticationResponse.setUser(user);
        return jwtAuthenticationResponse;
    }
    @Override
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        User user = userReponsitory.findByEmail(userEmail).orElseThrow();
        if (jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
            var jwt = jwtService.generateToken(new HashMap<>(),user);
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }
//    @Override
//    public List<User> check() {
//        Specification<User> spec = Specification.where(UserSpecifications.activeUsers())
//                .and(UserSpecifications.emailEndsWithExample());
//        List<User> users = userReponsitory.findAll(spec, JpaSort.unsorted());
//        return users;
//    }

    @Override
    public void save(UserDto userDto) {
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String creationDate = Date.format(formatter);
     //   String password=passwordEncoder.encode(userDto.getPassword());
        Role userRole=roleRepository.findByName("USER");
        User user = new User(userDto.getEmail(),
                userDto.getUserDisplayName(),
                ".",
                0,
                0,
                userDto.getPassword(),
             //   passwordEncoder.encode(userDto.getPassword()),
                creationDate,
                userRole
        );
        Profile profile=new Profile(
                "First Name",
                "Last Name",
                creationDate,
                "null",
                "Gender",
                "Adress",
                user
        );
        userReponsitory.save(user);
        profileReponsitory.save(profile);
    }

//    @Override
//    public void update(UserUpdateDTO userUpdateDTO,Integer ID) {
//        if (userReponsitory.findById(ID).isPresent()) {
//            Role userRole=roleRepository.findByName("USER");
//            User user1 = userReponsitory.findById(ID).get();
//            user1.setAboutMe(userUpdateDTO.getAboutMe());
//            user1.setEmail(userUpdateDTO.getEmail());
//            user1.setUserDisplayName(userUpdateDTO.getUserDisplayName());
//user1.setRole();
//            user1.setRole(userUpdateDTO.getRole());
//
//            userReponsitory.save(user1);
//        }
//    }
//    @Override
//    public Boolean checkPasswordUser(String email, String password) {
//        //Optional<User> user = userReponsitory.findUserByEmail(email);
//       User user = userReponsitory.findByEmail(email);
//    //    User user1 = user.get();
//        if (user.getPassword().equals(password)) return true;
//        return false;
//    }
  /*  @Override
    public Boolean checkPasswordUser(String email, String password) {
        Optional<User> user = userReponsitory.findByEmail(email);
        return user.map(value -> passwordEncoder.matches(password, value.getPassword())).orElse(false);
    }*/

public Boolean checkPasswordUser(String email, String password) {
    User user = userReponsitory.findByEmail(email).orElse(null);
    if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
        return false;
    }
    return true;
}


    public Boolean checkUserbyEmail(String email) {
        return !userReponsitory.findByEmail(email).isPresent();
    }


    public Boolean checkEmail(String email) {
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$");
        return p.matcher(email).find();
    }


    public Boolean checkName(String name) {
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        return p.matcher(name).find();
    }

    @Override
    public User getUserbyEmail(String email) {
        return userReponsitory.getUserByEmail(email);
    }

    @Override
    public List<User> searchUserByName(String query){
    return userReponsitory.searchUserByName(query);
    }
    @Override
    public List<User> GetAllUser(){
        return userReponsitory.getAllUser();
    }

}
