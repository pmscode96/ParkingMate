package com.app.parkingmate.controller;


import com.app.parkingmate.domain.VO.ParkingVO;
import com.app.parkingmate.domain.VO.UserVO;
import com.app.parkingmate.service.ParkingService;
import com.app.parkingmate.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/*")
public class MainController {
    private final UserService userService;
    private final ParkingService parkingService;
    ParkingVO parkingVO = new ParkingVO();
    UserVO userVO = new UserVO();

     @GetMapping("/")
    public String goToHome(Model model, UserVO userVO, HttpSession session, RedirectAttributes attributes){
         List<ParkingVO> checkParkingName = parkingService.getParking(parkingVO);
         ArrayList<String> list = new ArrayList<>();

//         parkingService.getParking(parkingVO).stream().map(ParkingVO::toString).forEach(parkings ->list.add(parkings));
         parkingService.getParking(parkingVO).stream().map(ParkingVO::toString).forEach(parkings ->list.add(parkings));
//         map에서 string 변환 후 특정 문자열 제거
         String list1 = String.valueOf(list).replace("ParkingVO","");
         list1 = list1.replace("(","");
         list1 = list1.replace(")","");
         list1 = list1.replace("[","");
         list1 = list1.replace("]","");
         list1 = list1.replace(", ",",");

//        key, value 형식으로 main-page에 데이터 전달
         model.addAttribute("parkings",list);
//         db의 행 갯수를 main-page에 전달
         String.valueOf(model.addAttribute("parkingsCount",list.stream().count()));

       return "/main/main-page";
    }


    @PostMapping("/")
    public RedirectView login(UserVO userVO, HttpSession session, RedirectAttributes attributes){
        Optional<UserVO> foundMember = userService.login(userVO);

        if(foundMember.isPresent()){
            session.setAttribute("user", foundMember.get());
            return new RedirectView("/mypage/mypage-mobile");
        }
        return new RedirectView("/");
    }

}
