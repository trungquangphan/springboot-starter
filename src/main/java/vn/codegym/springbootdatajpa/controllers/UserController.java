package vn.codegym.springbootdatajpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.springbootdatajpa.dao.Dao;
import vn.codegym.springbootdatajpa.entities.User;
import vn.codegym.springbootdatajpa.repositories.UserRepository;
import vn.codegym.springbootdatajpa.utils.JsonUtil;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class UserController {

    @Autowired MessageSource messageSource;

    private final UserRepository userRepository;
    @Autowired
    private Dao<User> userDao;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("")
    public String getUsers(Model model) {
//        String text = messageSource.getMessage("greeting",new String[]{"Codegym"}, Locale.forLanguageTag("hghg"));
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("name", "Trinh");
        model.addAttribute("name2", "Nhut");
        return "index";
    }

    @GetMapping("/users")
    @ResponseBody
    public Iterable<User> getUsers() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    @PutMapping("/users")
    @ResponseBody
    public Iterable<User> editUser(@RequestBody @Valid User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }
    
    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            result.getFieldErrors();
            return "add-user";
        }
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    private boolean validateUser(@Valid User user, Model model) {
        String name = user.getName();
        if (name.length() < 3 || name.length() > 10) {
            model.addAttribute("errMessage", "Error message here");
            return false;
        }

        String email = user.getEmail();
        return true;
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "update-user";
    }
    
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }
        
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
}
