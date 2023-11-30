package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.launchcode.techjobs.persistent.models.Skill;
import org.springframework.validation.Errors;
import java.util.Optional;
//import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("/")
    public  String index(Model model)   {
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model)  {
        model.addAttribute("title", "Add Skill");
        model.addAttribute(new Skill());
        return "skills/add";
    }
    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute Skill newSkill, Errors errors, Model model)    {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Skill");
            return "skills/add";
        }

        skillRepository.save(newSkill);
        return "redirect:";
        }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(@PathVariable int skillId, Model model) {
        Optional<Skill> optSkill = skillRepository.findById(skillId);

        if (optSkill.isPresent()) {
            model.addAttribute("skill", optSkill.get());
            return "skills/view";
        } else {
            return "redirect:/skills";
        }
    }
        public String displayViewSkill(Model model, @PathVariable int skillId) {
            return displayViewSkill(skillId, model);
        }

    }

