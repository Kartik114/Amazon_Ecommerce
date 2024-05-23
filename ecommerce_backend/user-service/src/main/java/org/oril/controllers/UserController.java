package org.oril.controllers;

import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.oril.entities.UserVO;
import org.oril.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserVO save(@RequestBody AuthRequest userVO) {
        return userService.save(userVO);
    }

    @PostMapping("/secured")
    public UserVO check(@RequestBody AuthRequest u)
    {
        UserVO a =  userService.checks(u.getEmail());
        if(a==null)
        {
            a= new UserVO("f","","","");
        }
        return a;
    }

//    @PostMapping("/secured")
//    public ResponseEntity<String> securedEndpoint(@RequestBody AuthRequest a) {
//        return ResponseEntity.ok("Hello, from secured endpoint!");
//    }
}
