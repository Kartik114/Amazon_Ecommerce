package org.oril.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.oril.controllers.AuthRequest;
import org.oril.entities.UserVO;
import org.oril.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;
    public UserVO save(AuthRequest userVO) {
        //simulate save operation;
        UserVO user=new UserVO();

        String userId = String.valueOf(new Date().getTime());
        user.setId(userId);
        user.setRole("USER");
        user.setPassword(userVO.getPassword());
        user.setEmail(userVO.getEmail());
        //save user
        userRepository.save(user);
        return user;
    }
    public UserVO checks(String email)
    {
   List<UserVO> a =  userRepository.findByEmail(email);
        System.out.println(a);
   if(a.isEmpty())return null;
   return a.get(0);
    }

}
