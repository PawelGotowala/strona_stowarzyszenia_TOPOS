package pl.gotowala.strona_stowarzyszenia_topos.controller;

import pl.gotowala.strona_stowarzyszenia_topos.model.Member;
import pl.gotowala.strona_stowarzyszenia_topos.model.Memory;
import pl.gotowala.strona_stowarzyszenia_topos.service.MemberService;
import pl.gotowala.strona_stowarzyszenia_topos.service.MemoriesService;
import pl.gotowala.strona_stowarzyszenia_topos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private MemberService memberService;
    private MemoriesService memoriesService;

    @Autowired
    public AdminController(UserService userService, MemberService memberService, MemoriesService memoriesService) {
        this.userService = userService;
        this.memberService = memberService;
        this.memoriesService = memoriesService;
    }

    @GetMapping("")
    private String adminStartWindow() {
        return "admin_page/adminStartWindow";
    }


    @GetMapping("/user/list")
    public String getUserList(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "admin_page/userList";
    }

    @GetMapping("/member/add/excel/list")
    public String addMembersOutExcelForm() {
        return "admin_page/addMembersOutExcel";
    }

    @PostMapping("/member/add/excel/list")
    public String submitAddMembersOutExcelForm(@RequestParam(name = "sciezka") String sciezka) throws IOException {
        memberService.addMembersListFromExcel(sciezka);

        return "redirect:/members/list/search";
    }

    @GetMapping("/member/add/one")
    public String addMemberForm(Model model) {
        model.addAttribute("Member", new Member());
        return "admin_page/addMember";
    }

    @PostMapping("/member/add/one")
    public String addMemberSubmit(Member member) {
        memberService.addMember(member);
        return "redirect:/admin/member/add/one";
    }

    @GetMapping(path = "/member/delete/one")
    public String deleteMemberForm() {
        return "admin_page/deleteMember";
    }

    @PostMapping(path = "/member/delete/one")
    public String deleteMember(@RequestParam(name = "albumNumber") int albumNumber) {
        memberService.removeMemberByAlbumNumber(albumNumber);
        return "redirect:/admin/member/delete/one";
    }

    @GetMapping("/member/update")
    public String update(Model model) {
        model.addAttribute("memberUpdate", new Member());
        return "admin_page/updateMember";
    }

    @PostMapping("/member/update")
    public String update(@RequestParam(name = "albumNumber") int albumNumber,
                         Member memberUpdate) {
        memberService.update(albumNumber, memberUpdate);
        return "redirect:/admin";
    }

    @GetMapping("/member/update/role")
    public String updateRoleForm() {
        return "admin_page/updateRole";
    }

    @PostMapping("/member/update/role")
    public String updateRole() {
        memberService.updateRole();
        return "redirect:/admin";
    }

/*
    @GetMapping("/memory/update")
    public String updateMemoryForm() {
        return "admin_page/updateMemory";
    }

    @PostMapping("/memory/update")
    public String updateMemory(@RequestParam(name = "idM") Long memoryId,
                               @RequestParam(name = "oneMemory") String oneMemoryUpdate,
                               @RequestParam(name = "signature") String signatureUpdate) {
        memoriesService.update(memoryId, oneMemoryUpdate, signatureUpdate);
        System.out.println("cos jest nie tak ale tutaj dochdoze");
        return "redirect:/admin";
    }
*/

    @GetMapping("/memory/delete")
    public String deleteMemoryForm() {
        return "admin_page/deleteMemory";
    }

    @PostMapping("/memory/delete")
    public String deleteMemory(@RequestParam(name = "idNumber") Long memoryId) {
        memoriesService.removeById(memoryId);
        return "redirect:/admin";
    }

}
