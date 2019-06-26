package pl.gotowala.strona_stowarzyszenia_topos.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class IndexController {

    @GetMapping(path = "/")
    public String index(){
        return "association_page/index";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "loginForm";
    }


    @GetMapping("/join")
    public String joinPage(){ return "association_page/join";}



}
