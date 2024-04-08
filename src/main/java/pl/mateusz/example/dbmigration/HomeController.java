package pl.mateusz.example.dbmigration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/form")
    public String add(UserDto userDto) {
        userService.add(userDto);
        return "success";
    }

    @GetMapping("/list")
    public String displayUsers(Model model) {
        List<UserDto> allUsers = userService.displayAll();
        model.addAttribute("users", allUsers);
        return "list";
    }
}
