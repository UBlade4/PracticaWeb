package com.dws.practicaweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/pcs")
public class PcController {
    @Autowired
    private PcService servicePc;


    @PostConstruct
    public void init() {
        servicePc.addPc(new Pc("12", "1080 GTX 4GB", "Intel I5 8va Gen"));
        servicePc.addPc(new Pc("4", "126 MB", "Intel I4 5va Gen"));


    }

    @GetMapping("/newPc")
    public String newPc(Model model, @RequestParam String ram, @RequestParam String graphicCard, @RequestParam String cpu){
        Pc aux = new Pc(ram, graphicCard, cpu);
        servicePc.addPc(aux);
        return "pcCreated";
    }

    @GetMapping("/showPcs")
    public String showPcs(Model model){
        model.addAttribute("pcs", servicePc.getPcs());
        return "showPcs";
    }

    @GetMapping("/{pcId}")
    public String showPc(Model model, @PathVariable long pcId){
        Pc pc = servicePc.getPc(pcId);
        if (pc==null){
            return "error";
        }
        model.addAttribute("pc", pc);
        return "showPc";
    }

    @GetMapping("/{pcId}/updatedPc")
    public String updatedPc(Model model, @PathVariable long pcId) {
        model.addAttribute("pcId", pcId);
        return "updatePc";
    }

    @GetMapping("/updatePc")
    public String updatePc(Model model,@RequestParam long pcId, @RequestParam String ram, @RequestParam String graphicCard, @RequestParam String cpu){
        Pc aux = new Pc(ram, graphicCard, cpu);
        servicePc.updatePc(pcId, aux);
        return "updatedPc";

    }

    @GetMapping ("/deletePc/{pcId}")
    public String deletePc(Model model, @PathVariable long pcId){
        model.addAttribute("pcId", pcId);
        servicePc.deletePc(pcId);
        return "/deletePc";
    }
}
