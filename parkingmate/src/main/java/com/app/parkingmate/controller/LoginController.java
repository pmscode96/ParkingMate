package com.app.parkingmate.controller;


import com.app.parkingmate.domain.VO.CouponVO;
import com.app.parkingmate.domain.VO.CouponlistVO;
import com.app.parkingmate.domain.VO.UserVO;
import com.app.parkingmate.repository.UserDAO;
import com.app.parkingmate.service.CouponService;
import com.app.parkingmate.service.CouponlistService;
import com.app.parkingmate.service.ParkingService;
import com.app.parkingmate.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/login/*")
public class LoginController {
    private final UserService userService;
    private final CouponService couponService;
    private final CouponlistService couponlistService;

    @GetMapping("login")
    public void goToLoginForm(UserVO userVO){

    }
    @PostMapping("login")
    public RedirectView login(UserVO userVO, HttpSession session, RedirectAttributes attributes){
        Optional<UserVO> foundMember = userService.login(userVO);
        if(foundMember.isPresent()){
            session.setAttribute("user", foundMember.get());
            attributes.addFlashAttribute("loginCheck", true);
            return new RedirectView("/");
        }else{
            attributes.addFlashAttribute("loginCheck", false);
            return new RedirectView("/login/login");
        }

    }


    @GetMapping("sign-up")
    public void goToSignUpForm(UserVO userVO){
        ;}

    @PostMapping("sign-up")
    public RedirectView signUp(UserVO userVO, RedirectAttributes attributes){
//        userVO.setUserNickName("iu");
//        userVO.setUserPhoneNumber("010-2424-2424");
//        userVO.setUserStartDate(new Date());
//        userVO.setUserProfile("나는qwer");

        Optional<UserVO> foundDualEmail = userService.getEmail(userVO.getUserEmail());
        if(foundDualEmail.isPresent()){
            attributes.addFlashAttribute("dualEmail", false);
            return new RedirectView("/login/sign-up");
        }else{
            if(userVO.getUserPassword().equals(userVO.getUserPasswordCheck())){
                userService.join(userVO, null);
                log.info(userVO.toString());
                couponService.signUpCoupon(userVO.getId());
                return new RedirectView("/login/sign-up-complete");
            }
            attributes.addFlashAttribute("passwordCheck", false);
            return new RedirectView("/login/sign-up");
        }

    }

    @GetMapping("sign-up-complete")
    public void goToSignUpComplete(){
        ;}

//    @PostMapping("sign-up-complete")
//    public RedirectView signUpComplete(){
//        return new RedirectView("/login/login");
//    }

    @GetMapping("find-id")
    public void goToFindIdForm(UserVO userVO){;}

    @PostMapping("find-id")
    public RedirectView checkEmail(String UserEmail){
        Optional<UserVO> checkEmail = userService.getEmail(UserEmail);
        log.info(checkEmail.toString());
        if(checkEmail.isPresent()){
            return new RedirectView("/login/login");
        }
        return new RedirectView("/login/sign-up");
    }

    @GetMapping("find-password")
    public void goToFindPasswordForm(UserVO userVO){;}

    @PostMapping("find-password")
    public RedirectView findEmail(String UserEmail){
        Optional<UserVO> foundEmail = userService.getEmail(UserEmail);
        log.info(foundEmail.toString());
        if(foundEmail.isPresent()){
            return new RedirectView("/login/login");
        }
        return new RedirectView("/login/sign-up");
    }

//    로그아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/mypage/mypage-mobile-logout");
    }
}
