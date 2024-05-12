package ProjectDemo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO  implements Serializable {
    private String Email;
    private String UserDisplayName;
    private String AboutMe;
    private String Role;

    public UserUpdateDTO(String email, String userDisplayName, String aboutMe, String password,String role) {
        Email = email;
        UserDisplayName = userDisplayName;
        AboutMe = aboutMe;
        Role=role;
    }


    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserDisplayName() {
        return UserDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        UserDisplayName = userDisplayName;
    }

    public String getAboutMe() {
        return AboutMe;
    }

    public void setAboutMe(String aboutMe) {
        AboutMe = aboutMe;
    }
}
