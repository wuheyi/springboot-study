package com.zyhy.disposal.controller;

import com.zyhy.disposal.model.User;
import com.zyhy.disposal.repository.UserRepository;
import com.zyhy.disposal.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wuheyi on 2019/5/22.
 */

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path="/add", method = RequestMethod.POST)
    @ApiOperation(
            value = "add user"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(name = "email", value = "邮箱", dataType = "String")
    })
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @RequestMapping(path="/all", method = RequestMethod.GET)
    @ApiOperation(
            value = "get all users"
    )
    @ApiImplicitParams({
    })
    public @ResponseBody List<User> getAllUsers() {

        return userService.findAll();
    }

    @RequestMapping(path="/search", method = RequestMethod.GET)
    @ApiOperation(
            value = "find user by name and email"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(name = "email", value = "邮箱", dataType = "String")
    })
    public @ResponseBody List<User> search(String name, String email) {

        return userRepository.findByNameAndEmail(name, email);
    }
}
