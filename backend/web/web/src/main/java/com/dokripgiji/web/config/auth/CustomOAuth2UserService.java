package com.dokripgiji.web.config.auth;

import com.dokripgiji.web.config.auth.dto.OAuthAttributes;
import com.dokripgiji.web.config.auth.dto.SessionUser;
import com.dokripgiji.web.domain.user.Role;
import com.dokripgiji.web.domain.user.User;
import com.dokripgiji.web.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    public final UserRepository userRepository;
    public final HttpSession httpSession;

    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        // 로그인 진행 시 키가 되는 필드값
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        User user = saveUser(attributes);

        // 세션에 유저 저장
        httpSession.setAttribute("user", new SessionUser(user));

        // 저장 됐는지 확인
        SessionUser user1 = (SessionUser) httpSession.getAttribute("user");
        System.out.println("--- This is the current User Info ---");
        System.out.println(user1.getUserId());
        System.out.println(user1.getEmail());
        System.out.println(user1.getName());
        System.out.println("--- This is the current User Info ---");

        String userRole = Role.USER.getKey();

        return new DefaultOAuth2User(
                Collections.singleton(
                        new SimpleGrantedAuthority(userRole)),
                        attributes.getAttributes(),
                        attributes.getNameAttributeKey()
                );
    }

    public User saveUser(OAuthAttributes attributes){
        User user = userRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName()))
                .orElse(attributes.toEntity());

        return userRepository.save(user);
    }

    public void logout(HttpSession session, HttpServletResponse response) throws Exception{
        session.invalidate();

    }

}
