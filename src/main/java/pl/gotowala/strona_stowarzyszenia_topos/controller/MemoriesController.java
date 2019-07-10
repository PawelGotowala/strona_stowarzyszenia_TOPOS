package pl.gotowala.strona_stowarzyszenia_topos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping
    public String memoryAddForm(){
        return "addMemory";
    }

}
