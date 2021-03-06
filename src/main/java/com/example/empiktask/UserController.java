package com.example.empiktask;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{login}")
    public ResponseEntity<GithubUserInfo> registerGameAction(@PathVariable String login) {
        GithubUserInfo githubUserInfo = userService.fetchUserInfo(login);
        return new ResponseEntity<>(githubUserInfo, HttpStatus.OK);
    }
}
