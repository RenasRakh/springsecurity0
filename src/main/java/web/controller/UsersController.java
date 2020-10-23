package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserService userService;

    @GetMapping()
    public String allUsers(Model model){
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam("id") int id){
        userService.delete(userService.getById(id));
        return "redirect:/users/";
    }


    @GetMapping(value = {"/new"})
    public String addNewUserForm(Model model) {
        model.addAttribute("user", new User());

        return "new_user";
    }

    @PostMapping()
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.add(user);

        return  "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.getById(id));
        return "edit_user";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User user){
        userService.edit(id, user);
        return  "redirect:/users";
    }




}
