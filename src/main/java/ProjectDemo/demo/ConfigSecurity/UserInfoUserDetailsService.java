//package ProjectDemo.demo.ConfigSecurity;
//
//import ProjectDemo.demo.entity.User;
//import ProjectDemo.demo.reponsitory.UserReponsitory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Optional;
//
//@Configuration
//public class UserInfoUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserReponsitory userReponsitory;
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> user = userReponsitory.findByEmail(email);
//        return user.map(UserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("User Does Not Exist"));
//    }
//}
