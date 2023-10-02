package com.app.parkingmate.controller;


import com.app.parkingmate.domain.VO.CouponVO;
import com.app.parkingmate.domain.VO.CouponlistVO;
import com.app.parkingmate.domain.VO.EventVO;
import com.app.parkingmate.service.CouponService;
import com.app.parkingmate.service.CouponlistService;
import com.app.parkingmate.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/coupon/*")
public class CouponController {
    private final CouponService couponService;
    private final CouponlistService couponlistService;
//    private final UserService userService;

    @GetMapping("coupons")
    public void goToJoinCoupons(Model model){
        model.addAttribute("coupons", couponlistService.listWithCoupon(1));

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
    public void goToJoinCouponList(Model model){
        model.addAttribute("coupons", couponService.list());
        model.addAttribute("couponlists", couponlistService.list(1));
    }

    @PostMapping("couponlist")
    public RedirectView insertCoupon(Model model , HttpSession session, Integer id){
        CouponlistVO couponlistVO = new CouponlistVO();
        couponlistVO.setCouponId(id);
        couponlistVO.setUserId(2);
//        couponlistVO.setUserId(session.getAttribute("user", userService.getId()));
        log.info("들어옴");
        log.info(String.valueOf(id));
        log.info(String.valueOf(session.getId()));
        couponlistService.create(couponlistVO);
//        if(session.getAttribute("coupon") != null){
//            couponId = ((CouponVO)session.getAttribute("coupon")).getId();
//        }
//        log.info(String.valueOf(couponId));
        return new RedirectView("/coupon/couponlist");

    }


}
