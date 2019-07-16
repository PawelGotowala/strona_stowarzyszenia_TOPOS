package pl.gotowala.strona_stowarzyszenia_topos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gotowala.strona_stowarzyszenia_topos.model.AppUser;
import pl.gotowala.strona_stowarzyszenia_topos.model.Memory;
import pl.gotowala.strona_stowarzyszenia_topos.service.MemoriesService;

@Controller
@RequestMapping("/memories")
public class MemoriesController {

    private MemoriesService memoriesService;

    @Autowired
    public MemoriesController(MemoriesService memoriesService) {
        this.memoriesService = memoriesService;
    }

    @GetMapping("/list")
    public String memoriesPage(@RequestParam( value ="pageNo", required = false, defaultValue = "0")String pageNo,
                                      Model model){
        model.addAttribute("membersMemories" , memoriesService.getAllMemoriesPageable(pageNo));
        model.addAttribute("pageNumberList", memoriesService.getPageNumberList(memoriesService.getListSize()));
        return "association_page/membersMemories";
    }


    @GetMapping("/add")
    public String memoryAddForm(Model model) {
        model.addAttribute("Memory", new Memory());
        return "addMemory";
    }

    @PostMapping("/add")
    public String memoryAddSubmit(Memory memory){
        memoriesService.saveAndAddMemoriesToLoggedUser(memory);
        return "redirect:/memories/list";
    }

}
