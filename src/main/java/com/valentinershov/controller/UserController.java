package com.valentinershov.controller;

import com.valentinershov.model.User;
import com.valentinershov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = { "/", "/listUsers"}, method = RequestMethod.GET)
    public String listUsers(Model model, Integer offset, Integer maxResults) {
        model.addAttribute("user", new User());
        model.addAttribute("userList", userService.listUsers(offset, maxResults));
        model.addAttribute("count", userService.count());
        model.addAttribute("offset", offset);
        return "/user/listUsers";
    }

    @RequestMapping("/get/{userId}")
    public String getUser(@PathVariable Integer userId, Map<String, Object> map) {
        User user = userService.getUser(userId);
        map.put("user", user);
        return "/user/userForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, BindingResult result) {
        userService.saveUser(user);
        return "redirect:listUsers";
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer id) {
        userService.deleteUser(id);
        return "redirect:/user/listUsers";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", this.userService.getUser(id));
        return "/user/userdata";
    }

    @RequestMapping("searchUser")
    public String searchUser(@RequestParam("name") String name, Model model) throws Exception {
        model.addAttribute("user", this.userService.getUserByName(name));
        return "/user/userdata";
    }

}
