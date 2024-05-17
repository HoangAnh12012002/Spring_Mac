package ProjectDemo.demo.controller.Authentication;

import ProjectDemo.demo.Exception.AppException;
import ProjectDemo.demo.Exception.ErrorCode;
import ProjectDemo.demo.dto.ChangePassword;
import ProjectDemo.demo.dto.MailBody;
import ProjectDemo.demo.entity.ForgotPassword;
import ProjectDemo.demo.entity.User;
import ProjectDemo.demo.reponsitory.ForgotPasswordRepository;
import ProjectDemo.demo.reponsitory.UserReponsitory;
import ProjectDemo.demo.JwtConfig.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

@RestController()
@RequestMapping("/api/forgotPassword")
public class ForgotPasswordController {

    @Autowired
    private  UserReponsitory userReponsitory;
    @Autowired
    private  EmailService emailService;
    @Autowired
    private ForgotPasswordRepository forgotPasswordRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //send mail for email verification
    @PostMapping("/verifyMail/{email}")
    public ResponseEntity<String> verifyEmail(@PathVariable String email){
        User user = userReponsitory.findByEmail(email).orElseThrow(()->new AppException(ErrorCode.WRONG_PASS_OR_EMAIL));
        int otp= otpGenerator();
        MailBody mailBody= MailBody.builder()
                .to(email)
                .text("This is OTP for your ForgotPass request:" +otp)
                .subject("OTP for ForgotPass request")
                .build();

        ForgotPassword fp= ForgotPassword.builder()
                .otp(otp)
                .expirationTime(new Date(System.currentTimeMillis()+70*1000))
                .user(user)
                .build();

        emailService.sendSimpleMessage(mailBody);
        forgotPasswordRepository.save(fp);

        return ResponseEntity.ok("Email sent for verification!");

    }
@PostMapping("/verifyOtp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp, @PathVariable String email){
    User user = userReponsitory.findByEmail(email).orElseThrow(()->new AppException(ErrorCode.WRONG_PASS_OR_EMAIL));
    ForgotPassword fp= forgotPasswordRepository.findByOtpAndUser(otp,user).orElseThrow(()->new AppException(ErrorCode.INVALID_OTP));
    if(fp.getExpirationTime().before(Date.from(Instant.now()))){
        forgotPasswordRepository.deleteById(fp.getFpid());
        return new ResponseEntity<>("OTP has expired!", HttpStatus.EXPECTATION_FAILED);
    }
    return ResponseEntity.ok("OTP verify!");

    }

    @PostMapping("/changePassword/{email}")
    public ResponseEntity<String> changePasswordHandler(@RequestBody ChangePassword changePassword,
                                                        @PathVariable String email){
        if(!Objects.equals(changePassword.password(),changePassword.repeatPassword())){
            return new ResponseEntity<>("Please enter the pass again",HttpStatus.EXPECTATION_FAILED);

        }
        String encodedPassword = passwordEncoder.encode(changePassword.password());
        userReponsitory.updatePassword(email,encodedPassword);
        return  ResponseEntity.ok("Password has been changed!");

    }

    private Integer otpGenerator(){
        Random random= new Random();
        return random.nextInt(100_000,999_999);

    }
}
