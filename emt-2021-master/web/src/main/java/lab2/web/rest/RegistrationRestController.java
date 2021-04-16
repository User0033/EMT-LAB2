package lab2.web.rest;

import lab2.model.dto.RegisterDto;
import lab2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/register")
@AllArgsConstructor
public class RegistrationRestController {
    private final UserService userService;

    @PostMapping
    public void register(@RequestBody RegisterDto user) throws Exception {
        userService.register(user.getUsername(), user.getPassword(), user.getRepeatPassword(),
                user.getName(), user.getSurname());
    }
}
