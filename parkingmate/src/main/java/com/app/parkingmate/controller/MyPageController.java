package com.app.parkingmate.controller;


import com.app.parkingmate.domain.VO.UserVO;
import com.app.parkingmate.service.CouponlistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/mypage/*")
public class MyPageController {
    private final CouponlistService couponlistService;

    @GetMapping("add-parking")
    public void goToAddParkingForm(){;}

    @GetMapping("add-parking-cancel")
    public void goToAddParkingCancel(){;}

    @GetMapping("add-parking-complete")
    public void goToAddParkingComplete(){;}

    @GetMapping("caradd")
    public void goToCarAddForm(){;}

    @GetMapping("caradd-cancel")
    public void goToCarAddCancel(){;}

    @GetMapping("caraddlist")
    public void goToCarAddList(){;}

    @GetMapping("caradd-no")
    public void goToCarAddNo(){;}

    @GetMapping("cardadd")
    public void goToCardAddForm(){;}

    @GetMapping("cardadd2")
    public void goToCardAdd2(){;}

    @GetMapping("cardadd3")
    public void goToCardAdd3(){;}

    @GetMapping("cardadd4")
    public void goToCardAdd4(){;}

    @GetMapping("cardadd5")
    public void goToCardAdd5(){;}

    @GetMapping("cardadd-cancel")
    public void goToCardAddCancel(){;}

    @GetMapping("cardadddel")
    public void goToCardAddDel(){;}

    @GetMapping("cardaddlist")
    public void goToCardAddList(){;}

    @GetMapping("cardlist")
    public void goToCardList(){;}

    @GetMapping("carlist")
    public void goToCarList(){;}

    @GetMapping("change-profile")
    public void goToChangeProfileForm(){;}

    @GetMapping("mypage-mobile")
    public void goToMyPage(Model model, HttpSession session){
        UserVO sessionVO = (UserVO) session.getAttribute("user");
        if (sessionVO != null) {
            model.addAttribute("enabledList", couponlistService.enabledList(sessionVO.getId()));
        }
    }

    @GetMapping("mypage-mobile-logout")
    public void goToMyPageLogOut(){;}

    @GetMapping("mypage-mobile-no-login")
    public void goToMyPageNoLogOut(){;}

    @GetMapping("save")
    public void goToSave(){;}

    @GetMapping("save-no-login")
    public void goToSaveNoLogin(){;}

    @GetMapping("use-history")
    public void goToUseHistory(){;}

    @GetMapping("use-history-detail")
    public void goToUseHistoryDetail(){;}

    @GetMapping("userdel")
    public void goToUserDel(){;}

    @GetMapping("usersetting-email-change")
    public void goToUserSettingEmailChange(){;}

    @GetMapping("usersetting-phone-number-change")
    public void goToUserSettingPhoneNumberChange(){;}

    @GetMapping("usersettings-mobile")
    public void goToUserSettingMobile(){;}




}
