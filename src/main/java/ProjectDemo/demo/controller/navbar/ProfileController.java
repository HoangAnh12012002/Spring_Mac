package ProjectDemo.demo.controller.navbar;

import ProjectDemo.demo.dto.ProfileDto;
import ProjectDemo.demo.dto.UserDto;
import ProjectDemo.demo.entity.Profile;
import ProjectDemo.demo.entity.User;
import ProjectDemo.demo.reponsitory.ProfileReponsitory;
import ProjectDemo.demo.service.ProfileService;
import ProjectDemo.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@NoArgsConstructor
@AllArgsConstructor
@SessionAttributes("userdto")
public class ProfileController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileReponsitory profileReponsitory;
    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }

    @ModelAttribute("profileuser")
    public ProfileDto profileDto(){
        return new ProfileDto();
    }
    @GetMapping("/profile")
    public String showprofile(@ModelAttribute("userdto")UserDto userDto,
                              Model model){
        User user = userService.getUserbyEmail(userDto.getEmail());
        if(user ==null){
            return "redirect:/login";
        }
        model.addAttribute("user",user);
        Profile profile = profileReponsitory.findProfileByUser(user);
        model.addAttribute("profile",profile);
        return "profile";
    }

    @PostMapping("/profile/{id}")
    public String getprofile(@SessionAttribute("userdto")UserDto userDto,
                             @PathVariable String id ,
                             Model model,
                             @ModelAttribute("profile") ProfileDto profileDto){
        Profile profileupdate = profileReponsitory.findProfileById(Integer.parseInt(id));
        profileupdate.setAdress(profileDto.getAdress());
        profileupdate.setDateofBirth(profileDto.getDateofBirth());
        profileupdate.setGender(profileDto.getGender());
        profileupdate.setFirstName(profileDto.getFirstName());
        profileupdate.setLastName(profileDto.getLastName());
        profileService.update(profileupdate);
        return "redirect:/profile";
    }
}
