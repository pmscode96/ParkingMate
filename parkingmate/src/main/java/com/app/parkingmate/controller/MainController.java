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

     @GetMapping("/")
    public String goToHome(Model model, UserVO userVO){
         List<ParkingVO> checkParkingName = parkingService.getParking(parkingVO);
         ArrayList<String> list = new ArrayList<>();
//         parkingService.getParking(parkingVO).stream().map(ParkingVO::toString).forEach(parkings ->list.add(parkings));
         parkingService.getParking(parkingVO).stream().map(ParkingVO::toString).forEach(parkings ->list.add(parkings));

//         그냥 여기서 가져오자...젠장...
//         map에서 string 변환 후 특정 문자열 제거
         String list1 = String.valueOf(list).replace("ParkingVO","");
         list1 = list1.replace("(","");
         list1 = list1.replace(")","");
         list1 = list1.replace("[","");
         list1 = list1.replace("]","");
         list1 = list1.replace(", ",",");
//         log.info(list1);
//        map으로 변환 후 key와value로 변경
//         String pairSepartor = ",";
//         String keyValueSeaparator = "=";
//         String[] pairs = list1.split(pairSepartor);
////         log.info(Arrays.toString(pairs));
//
////            key, value로 매핑
//         Map<String, String> map = new HashMap<>();
//         ArrayList AllList = new ArrayList<Object>();
//         for (String pair : pairs){
//             String[] keyValue = pair.split(keyValueSeaparator);
////                log.info(Arrays.toString(keyValue));
//             if(keyValue.length == 2){
//                 map.put(keyValue[0], keyValue[1]);
//                AllList.add(String.valueOf(map));
//             }
////             AllList.add(map);//map 데이터가 배열로 여러개가 들어가야됨 찾아봐라!!
//         }
////         log.info(String.valueOf(AllList));
////         중복 요소 제거 용 ArrayList추가
//         ArrayList NewAllList = new ArrayList<Object>();
////         새로운 ArrayList에 요소 추가
//         for(Object strValue : AllList ){
////             중복 요소가 없는 경우 요소 추가
//             if(!NewAllList.contains((strValue))){
//                 NewAllList.add(strValue);
//             }
//         }
////         중복 요소가 제거된 새로운 ArrayList -> List내부에 중복 값이 있어 해당 부분 제거필요!
//         log.info(String.valueOf(NewAllList));
////            log.info(String.valueOf(NewAllList.get(0)));
////         log.info(String.valueOf(NewAllList.stream().count()));
//         ArrayList CompareList = new ArrayList<Object>();
//         int j = 0;
//
//         for(Object i : NewAllList){
//             CompareList.add(i);
//         }
//         for(var i = 0; i < NewAllList.stream().count(); i++){
//
//         }
//         log.info(CompareList.toString());
//         log.info(map[0].toString());
//        key, value 형식으로 main-page에 데이터 전달
         model.addAttribute("parkings",list);
//         db의 행 갯수를 main-page에 전달
         String.valueOf(model.addAttribute("parkingsCount",list.stream().count()));

       return "/main/main-page";
    }


//
//    @GetMapping("/main-page")
//    public String goToMain(UserVO userVO){
//        return "/main/main-page";
//    }

//    @PostMapping("/")
//    public String login(UserVO userVO, HttpSession session, RedirectAttributes attributes){
//        Optional<UserVO> foundMember = userService.login(userVO);
//        if(foundMember.isPresent()){
//            session.setAttribute("user", foundMember.get());
//            return "/mypage/mypage-mobile";
//        }
//        return "/";
//    }

    @GetMapping("/main-page")
    public String goToMain(){
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
