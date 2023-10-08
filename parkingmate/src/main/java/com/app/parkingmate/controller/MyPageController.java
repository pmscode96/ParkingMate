package com.app.parkingmate.controller;


import com.app.parkingmate.domain.VO.UserVO;
import com.app.parkingmate.service.CouponlistService;
import com.app.parkingmate.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/mypage/*")
public class MyPageController {
    private final UserService userService;
    private final CouponlistService couponlistService;

    @GetMapping("add-parking")
    public void goToAddParkingForm() {
        ;
    }

    @GetMapping("add-parking-cancel")
    public void goToAddParkingCancel() {
        ;
    }

    @GetMapping("add-parking-complete")
    public void goToAddParkingComplete() {
        ;
    }

    @GetMapping("caradd")
    public void goToCarAddForm() {
        ;
    }

    @GetMapping("caradd-cancel")
    public void goToCarAddCancel() {
        ;
    }

    @GetMapping("caraddlist")
    public void goToCarAddList() {
        ;
    }

    @GetMapping("caradd-no")
    public void goToCarAddNo() {
        ;
    }

    @GetMapping("cardadd")
    public void goToCardAddForm() {
        ;
    }

    @GetMapping("cardadd2")
    public void goToCardAdd2() {
        ;
    }

    @GetMapping("cardadd3")
    public void goToCardAdd3() {
        ;
    }

    @GetMapping("cardadd4")
    public void goToCardAdd4() {
        ;
    }

    @GetMapping("cardadd5")
    public void goToCardAdd5() {
        ;
    }

    @GetMapping("cardadd-cancel")
    public void goToCardAddCancel() {
        ;
    }

    @GetMapping("cardadddel")
    public void goToCardAddDel() {
        ;
    }

    @GetMapping("cardaddlist")
    public void goToCardAddList() {
        ;
    }

    @GetMapping("cardlist")
    public void goToCardList() {
        ;
    }

    @GetMapping("carlist")
    public void goToCarList() {
        ;
    }

    @GetMapping("change-profile")
    public void goToChangeProfileForm() {
        ;
    }

    @GetMapping("")
    public String goToMyPage(Model model, HttpSession session) {
        UserVO sessionVO = (UserVO) session.getAttribute("user");
        if (sessionVO != null) {
            model.addAttribute("enabledList", couponlistService.enabledList(sessionVO.getId()));
        }

        return "/mypage/mypage-mobile";
    }

    @GetMapping("mypage-mobile-logout")
    public void goToMyPageLogOut() {
        ;
    }

    @GetMapping("mypage-mobile-no-login")
    public void goToMyPageNoLogOut() {
        ;
    }

    @GetMapping("save")
    public void goToSave() {
        ;
    }

    @GetMapping("save-no-login")
    public void goToSaveNoLogin() {
        ;
    }

    @GetMapping("use-history")
    public void goToUseHistory() {
        ;
    }

    @GetMapping("use-history-detail")
    public void goToUseHistoryDetail() {
        ;
    }

    @GetMapping("userdel")
    public void goToUserDel() {
        ;
    }

    @GetMapping("usersetting-email-change")
    public void goToUserSettingEmailChange() {
        ;
    }

    @GetMapping("usersetting-phone-number-change")
    public void goToUserSettingPhoneNumberChange() {
        ;
    }

    @GetMapping("usersettings")
    public void goToUserSettingMobile() {
        ;
    }

    @PostMapping("profile-update")
    public RedirectView updateProfile(
            @RequestParam("userNickName") String userNickName,
            @RequestParam("userEmail") String userEmail,
            @RequestParam("userPhoneNumber") String userPhoneNumber,
            HttpSession session,
            RedirectAttributes redirectAttributes) {
        UserVO sessionVO = (UserVO) session.getAttribute("user");

        // 세션 변경 또한 즉각 이뤄져야 하므로 세션의 값을 수정하고 update에 세션을 넣어 수정하는 방식.
        sessionVO.setUserNickName(userNickName);
        sessionVO.setUserEmail(userEmail);
        sessionVO.setUserPhoneNumber(userPhoneNumber);

        userService.updateProfile(sessionVO);
        redirectAttributes.addFlashAttribute("update", true);

        return new RedirectView("/mypage/usersettings");
    }

    @PostMapping("img-upload")
    public RedirectView uploadProfileImg(@RequestParam("uuid") String uuid, @RequestParam("uploadFile") MultipartFile uploadFile, HttpSession session) throws IOException {
        UserVO sessionVO = (UserVO) session.getAttribute("user");

        sessionVO.setUserProfileName("t_" + uuid + "_" + uploadFile.getOriginalFilename());
        sessionVO.setUserProfilePath(getPath());
        session.setAttribute("user", sessionVO);

        userService.uploadProfileImg(sessionVO);

        return new RedirectView("/mypage/");
    }

    private String getPath() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    @GetMapping("delete-img")
    public RedirectView deleteProfileImg(HttpSession session){
        UserVO sessionVO = (UserVO) session.getAttribute("user");

        userService.deleteProfileImg(sessionVO.getId());

        sessionVO.setUserProfilePath(null);
        sessionVO.setUserProfileName(null);

        session.setAttribute("user", sessionVO);

        return new RedirectView("/mypage/");
    }
}