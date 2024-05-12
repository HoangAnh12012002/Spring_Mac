package ProjectDemo.demo.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Data
public class UserDto implements Serializable {
    private String email;
    @Size(min=4,message = "USERNAME_INVALID")
    private String userDisplayName;
    @Size(min=4,message = "PASS_INVALID")
    private String password;
    private String checkPass;
    private String role;

    public UserDto() {
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUserDisplayName() {
//        return userDisplayName;
//    }
//
//    public void setUserDisplayName(String userDisplayName) {
//        this.userDisplayName = userDisplayName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getCheckPass() {
//        return checkPass;
//    }
//
//    public void setCheckPass(String checkPass) {
//        this.checkPass = checkPass;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public UserDto(String email, String userDisplayName, String password, String role) {
//        this.email = email;
//        this.userDisplayName = userDisplayName;
//        this.password = password;
//        this.role = role;
//    }
}
