//package ProjectDemo.demo.ConfigSecurity;
//
//import ProjectDemo.demo.entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class UserInfoDetails implements UserDetails {
//    private String email;
//    private String Password;
//    private List<GrantedAuthority> Role;
//
//    public UserInfoDetails(User user){
//        this.email = user.getEmail();
//        this.Password = user.getPassword();
//        this.Role = Arrays.stream(user.getRole().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.Role;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.Password;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
