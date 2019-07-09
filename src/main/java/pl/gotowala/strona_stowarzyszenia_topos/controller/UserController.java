package pl.gotowala.strona_stowarzyszenia_topos.controller;


import org.springframework.web.bind.annotation.*;
import pl.gotowala.strona_stowarzyszenia_topos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterForm(){
        return "userRegister";
    }

    @PostMapping("/register")
    public String submitRegisterForm(@RequestParam(name="username") String username,
                                     @RequestParam(name="password")String password,
                                     @RequestParam(name="password-confirm") String passwordConfirm){
       userService.registerUser(username,password,passwordConfirm);

        return "redirect:/login";
    }

}
