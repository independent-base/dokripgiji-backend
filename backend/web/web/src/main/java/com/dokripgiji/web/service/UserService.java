package com.dokripgiji.web.service;

import com.dokripgiji.web.domain.user.User;
import com.dokripgiji.web.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    public final UserRepository userRepository;

    @Transactional
    public void signup(User user){
        try {
            if(userRepository.findByEmail(user.getEmail()).isEmpty()){
                userRepository.save(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
