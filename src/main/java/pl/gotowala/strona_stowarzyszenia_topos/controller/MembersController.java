package pl.gotowala.strona_stowarzyszenia_topos.controller;

import pl.gotowala.strona_stowarzyszenia_topos.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/members")
public class MembersController {
    @Autowired
    private MemberService memberService;


/*
    @GetMapping("/list/default")
    public String membersPage(Model model){
        model.addAttribute("memberList1" , memberService.getAllMembers());
        return "association_page/members";}
*/

    @GetMapping("/list/default")
    public String membersPage(@RequestParam( value ="pageNo", required = false, defaultValue = "0")String pageNo,
                              Model model){
        model.addAttribute("memberList1" , memberService.getAllMembersPageable(pageNo));
        model.addAttribute("pageNumberList", memberService.getPageNumberList());
        return "association_page/members";
    }


    @GetMapping("/list/search")
    public String getMemberList(Model model){
                model.addAttribute("memberList", memberService.getAllMembers());
        return "association_page/listMembers";
    }




}
