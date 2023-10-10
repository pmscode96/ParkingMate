package com.app.parkingmate.controller;


import com.app.parkingmate.domain.VO.CouponlistVO;
import com.app.parkingmate.domain.VO.UserVO;
import com.app.parkingmate.service.CouponService;
import com.app.parkingmate.service.CouponlistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/coupon/*")
public class CouponController {
    private final CouponService couponService;
    private final CouponlistService couponlistService;
//    private final UserService userService;

    @GetMapping("coupons")
    public void goToJoinCoupons(Model model, HttpSession session){
        UserVO user = (UserVO) session.getAttribute("user");
        model.addAttribute("coupons", couponlistService.listWithCoupon(user.getId()));
        model.addAttribute("enabledList" , couponlistService.enabledList(user.getId()));

    }

//    @GetMapping("couponlist")
//    public void goToJoinCouponList(Model model){
//        List<CouponVO> allCoupons = couponService.list();
//        List<CouponlistVO> myCoupons = couponlistService.list(1);
//        List<CouponVO> allCouponlist = allCoupons.stream()
//                .filter(_this ->
//                        myCoupons.stream().noneMatch(target -> _this.getId().equals(target.getCouponId())))
//                .collect(Collectors.toList());
//        List<CouponVO> myCouponlist = allCoupons.stream()
//                .filter(_this ->
//                        myCoupons.stream().anyMatch(target -> _this.getId().equals(target.getCouponId())))
//                .collect(Collectors.toList());
//        model.addAttribute("coupons", allCouponlist);
//        model.addAttribute("coupons2", myCouponlist);
//    }

    @GetMapping("couponlist")
    public void goToJoinCouponList(Model model, HttpSession session){
        UserVO user = (UserVO) session.getAttribute("user");
        model.addAttribute("coupons", couponlistService.listWithCoupon(user.getId()));
        model.addAttribute("enabledList" , couponlistService.enabledList(user.getId()));
    }


    @ResponseBody
    @RequestMapping(value = "couponlist/ajax", method = RequestMethod.POST, produces = "application/test; charset=UTF-8")
    public void insertCoupon(@RequestBody String json, HttpSession session ){
        JSONObject jsn = new JSONObject(json);
        UserVO user = (UserVO) session.getAttribute("user");

        String couponlistId = (String) jsn.get("couponlistId");
        Integer couponID = Integer.parseInt(couponlistId);
        CouponlistVO couponlistVO = new CouponlistVO();
        couponlistVO.setId(couponID);
        couponlistVO.setUserId(user.getId());
        couponlistVO.setCouponStatus(1);
        couponlistService.updateStatus(couponlistVO);
    }


}
