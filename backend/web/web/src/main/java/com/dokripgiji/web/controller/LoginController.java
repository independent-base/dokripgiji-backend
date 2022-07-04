package com.dokripgiji.web.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.dokripgiji.web.controller.api.KakaoAPI;
import com.dokripgiji.web.domain.user.User;
import com.dokripgiji.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    KakaoAPI kakaoApi = new KakaoAPI();

    @RequestMapping(value="/login")
    public ModelAndView login(@RequestParam("code") String code, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        // 1번 인증코드 요청 전달
        String accessToken = kakaoApi.getAccessToken(code);
        // 2번 인증코드로 토큰 전달
        HashMap<String, Object> userInfo = kakaoApi.getUserInfo(accessToken);

        System.out.println("login info : " + userInfo.toString());

        if(userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("accessToken", accessToken);

            System.out.println("session = " + session.getId());

            User user=User.builder().email((String) userInfo.get("email")).nickname((String) userInfo.get("nickname")).build();
            userService.signup(user);
        }
        mav.addObject("userId", userInfo.get("email"));
        mav.setViewName("index");
        System.out.println("mav = " + mav);
        return mav;
    }

    @RequestMapping(value="/logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView mav = new ModelAndView();

        kakaoApi.kakaoLogout((String)session.getAttribute("accessToken"));
        session.removeAttribute("accessToken");
        session.removeAttribute("userId");
        mav.setViewName("index");
        return mav;
    }
}