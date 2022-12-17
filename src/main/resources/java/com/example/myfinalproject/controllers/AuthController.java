package com.example.myfinalproject.controllers;

import com.example.myfinalproject.models.Person;
import com.example.myfinalproject.services.PersonService;
import com.example.myfinalproject.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;



@Controller
@RequestMapping("/auth")
public class AuthController {
    private final PersonValidator personValidator;

    private final PersonService personService;

    @Autowired
    public AuthController(PersonValidator personValidator, PersonService personService) {
        this.personValidator = personValidator;
        this.personService = personService;
    }

    @GetMapping("/index1")
    public String index1() {
        return "index";
    }


    @GetMapping("/about")
    public String about() {
        return "about";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("person", new Person());
        return "registration";
    }

    @PostMapping("/registration")
    public String resultRegistration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        personService.register(person);
        return "redirect:/index";
    }

//
//    ///***не работает***/////
//
//
//    @GetMapping("/updatePassword")
//    @PreAuthorize("hasRole('READ_PRIVILEGE')")
//    public String changeUserPassword(Model model) {
//        model.addAttribute("person", new Person());
//        return "renamePassword";
//    }
//    @PostMapping("/updatePassword")
//    @PreAuthorize("hasRole('READ_PRIVILEGE')")
//    public String updatePassword(@ModelAttribute("person")  Person person, BindingResult bindingResult){
//        Person person_db = personService.getPersonFindByLogin(person);
//        int id = person_db.getId();
//        String password= person.getPassword();
//
//        personService.updatePassword(id,password);
//        return "redirect:/index";
//    }


}
