package com.app.parkingmate.service;

import com.app.parkingmate.domain.VO.CouponVO;

import java.util.List;
import java.util.Optional;

public interface CouponService {
    // 쿠폰 작성
    public void create(CouponVO couponVO);

    //    쿠폰 리스트
    public List<CouponVO> list();

//    쿠폰 하나
    public Optional<CouponVO> select(Integer id);

    //    쿠폰 수정
    public void update(CouponVO couponVO);

    //    쿠폰 status 수정
    public void updateStatus(CouponVO couponVO);

    public List<CouponVO> selectByStatus();

    //    회원가입시 쿠폰 발급
    public void signUpCoupon(Integer userId);
}
