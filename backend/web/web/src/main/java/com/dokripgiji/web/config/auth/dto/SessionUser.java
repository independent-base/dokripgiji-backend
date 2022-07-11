package com.dokripgiji.web.config.auth.dto;

import com.dokripgiji.web.domain.user.User;
import lombok.Getter;

import java.io.Serializable;


// 엔티티를 직렬화
// 직렬화 기는을 가진 세션 dto 생성
@Getter
public class SessionUser implements Serializable {

    private Long userId;
    private String name;
    private String email;

    public SessionUser(User user){
        this.userId = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

}
