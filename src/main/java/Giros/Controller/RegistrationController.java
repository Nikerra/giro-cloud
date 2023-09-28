package Giros.Controller;

import Giros.dao.Entity.RegistrationForm;
import Giros.dao.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    public RegistrationController(
            UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registerForm() {
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistration(RegistrationForm registerForm) {
        System.out.println("Registration=" + registerForm);
        userRepository.save(registerForm.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
