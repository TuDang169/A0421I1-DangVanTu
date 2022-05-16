package codegym.controller;

import codegym.entity.Music;
import codegym.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class MusicController {
    @Autowired
    MusicRepository musicRepository;

    @GetMapping("/music")
    public String list(Model model){
        model.addAttribute("music", musicRepository.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(name = "music") Music music){
        musicRepository.save(music);
        return "redirect:/music";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("music", musicRepository.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Music music){
        musicRepository.update(music);
        return "redirect:/music";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("music", musicRepository.findById(id));
        return "delete";
    }

    @PostMapping("/remove")
    public String remove(Music music){
        musicRepository.remove(music.getId());
        return "redirect:/music";
    }
}
