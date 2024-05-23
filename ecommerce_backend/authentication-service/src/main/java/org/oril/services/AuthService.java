package org.oril.services;

import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.mindrot.jbcrypt.BCrypt;
import org.oril.entities.AuthRequest;
import org.oril.entities.AuthResponse;
import org.oril.entities.Response;
import org.oril.entities.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthService {

    private  RestTemplate restTemplate;
    private  JwtUtil jwtUtil;
//    @Autowired
//    private  WebClient.Builder webClient;
//    public AuthService( ) {
//        this.webClient.baseUrl("http://localhost:8060/cart").build();
//    }

    public Response register(AuthRequest request) {


        Response registeredUser = new Response();
        String userId = String.valueOf(new Date().getTime());
        registeredUser.setId(userId);
        request.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));

        registeredUser.setPassword(request.getPassword());
        registeredUser.setRole("ADMIN");
        registeredUser.setName(request.getName());
        registeredUser.setEmail(request.getEmail());
        System.out.println(registeredUser);

        // Assuming this is the correct object to send to the check endpoint
        UserVO userToCheck = new UserVO();
        userToCheck.setEmail(request.getEmail());

        // Sending the correct object to the check endpoint
        if(restTemplate.postForObject("http://user-service/users/secured",request, String.class)==null)
        {
            return new Response();
        }
        // Handle the response from the check endpoint
        String email = request.getEmail();

        String accessToken = jwtUtil.generate(registeredUser.getId(), registeredUser.getRole(), "ACCESS");
        String refreshToken = jwtUtil.generate(registeredUser.getId(), registeredUser.getRole(), "REFRESH");
        registeredUser.setAccessToken(accessToken);
        registeredUser.setRefreshToken(refreshToken);
        return registeredUser;
    }
    public String save(AuthRequest request)
    {

        request.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        UserVO registeredUser = restTemplate.postForObject("http://user-service/users", request, UserVO.class);
        System.out.println(registeredUser);
        return "Registered successfully";
    }
}
