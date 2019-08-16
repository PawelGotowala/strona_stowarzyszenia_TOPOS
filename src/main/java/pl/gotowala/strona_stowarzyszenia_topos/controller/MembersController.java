package pl.gotowala.strona_stowarzyszenia_topos.controller;

import pl.gotowala.strona_stowarzyszenia_topos.model.SearchParams;
import pl.gotowala.strona_stowarzyszenia_topos.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.gotowala.strona_stowarzyszenia_topos.utility.MemberSpecification;


@Controller
@RequestMapping("/members")
public class MembersController {

    private MemberService memberService;

    @Autowired
    public MembersController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/list/default")
    public String membersPage(@RequestParam(value = "pageNo", required = false, defaultValue = "0") String pageNo,
                              Model model) {

        model.addAttribute("memberList1", memberService.getAllMembersPageable(pageNo));
        model.addAttribute("pageNumberList", memberService.getPageNumberList(memberService.getListSize()));
        return "association_page/members";
    }

    @GetMapping("/list/search")
    public String getSearchMemberList(@RequestParam(value = "pageNo", required = false, defaultValue = "0") String pageNo,
                                      Model model,
                                      @RequestParam(name = "searchName", required = false, defaultValue = "") String searchName,
                                      @RequestParam(name = "searchSecondName", required = false, defaultValue = "") String searchSecondName,
                                      @RequestParam(name = "searchLastName", required = false, defaultValue = "") String searchLastName,
                                      @RequestParam(name = "searchFamilyName", required = false, defaultValue = "") String searchFamilyName,
                                      @RequestParam(name = "searchBirthDate", required = false, defaultValue = "opcja") String searchBirthDate,
                                      @RequestParam(name = "searchBirthPlace", required = false, defaultValue = "") String searchBirthPlace,
                                      @RequestParam(name = "searchFamilyAddress", required = false, defaultValue = "") String searchFamilyAddress) {

        SearchParams searchParams = new SearchParams();
        searchParams.setFirstName(searchName);
        searchParams.setSecondName(searchSecondName);
        searchParams.setLastName(searchLastName);
        searchParams.setFamilyName(searchFamilyName);
        searchParams.setBirthDate(searchBirthDate);
        searchParams.setBirthPlace(searchBirthPlace);
        searchParams.setFamilyAddress(searchFamilyAddress);
        MemberSpecification memberSpecification = new MemberSpecification(searchParams);
        int listSize = (int) memberService.find(memberSpecification, pageNo).getTotalElements();

        model.addAttribute("listSize", listSize);
        model.addAttribute("pageNumberList", memberService.getPageNumberList(listSize));
        model.addAttribute("searchParam", searchParams);
        model.addAttribute("memberList", memberService.find(memberSpecification, pageNo));
        return "association_page/listMembers";
    }


}
