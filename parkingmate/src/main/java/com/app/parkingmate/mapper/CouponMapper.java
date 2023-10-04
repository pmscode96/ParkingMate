package com.app.parkingmate.mapper;

import com.app.parkingmate.domain.VO.CouponVO;
import com.app.parkingmate.domain.VO.EventVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CouponMapper {
    //    쿠폰 생성
    public void insert(CouponVO couponVO);

    //    쿠폰 수정
    public void update(CouponVO couponVO);

    //    쿠폰 status 수정
    public void updateStatus(CouponVO couponVO);

    //    쿠폰 list
    public List<CouponVO> selectAll();

//    쿠폰 하나? 선택
    public Optional<CouponVO> select(Integer id);

    public List<CouponVO> selectByCouponStatus();
}
