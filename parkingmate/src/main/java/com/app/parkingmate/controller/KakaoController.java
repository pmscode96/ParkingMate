package com.app.parkingmate.controller;


import com.app.parkingmate.domain.VO.UserVO;
import com.app.parkingmate.service.KakaoService;
import com.app.parkingmate.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class KakaoController {
    private final KakaoService kakaoService;
    private final UserService userService;

    @GetMapping("/kakao/login")
    public RedirectView login(String code, HttpSession session, RedirectAttributes redirectAttributes) {
        Integer Id = null;
        String token = kakaoService.getKaKaoAccessToken(code);
        Optional<UserVO> foundInfo = kakaoService.getKaKaoInfo(token);

        if (foundInfo.isPresent()){
            if(session.getAttribute("user") != null){
                Id = ((UserVO)session.getAttribute("user")).getId();
            }
            userService.join(foundInfo.get(), Id);
            UserVO userVO = userService.getKakaoEmail(foundInfo.get().getKakaoEmail()).get();
            session.setAttribute("user", userVO);
            return new RedirectView("/mypage/mypage-mobile");
        }
        return new RedirectView("/login/login");

    }


}