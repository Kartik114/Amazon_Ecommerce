package org.oril.controllers;

import lombok.AllArgsConstructor;
import org.oril.entities.AuthRequest;
import org.oril.entities.AuthResponse;
import org.oril.entities.Response;
import org.oril.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
//@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/register")
    public String register(@RequestBody AuthRequest request) {
        return authService.save(request);
    }
    @PostMapping("/login")
    public Response Login(@RequestBody AuthRequest request)
    {
        Response a =  authService.register(request);
        return  a;
    }

}
