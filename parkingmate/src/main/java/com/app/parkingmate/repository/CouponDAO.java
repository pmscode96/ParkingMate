package com.app.parkingmate.repository;

import com.app.parkingmate.domain.VO.CouponVO;
import com.app.parkingmate.domain.VO.EventVO;
import com.app.parkingmate.mapper.CouponMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CouponDAO {
    private final CouponMapper couponMapper;
    //    쿠폰 생성
    public void save(CouponVO couponVO){couponMapper.insert(couponVO);}

    //    쿠폰 리스트
    public List<CouponVO> list(){return couponMapper.selectAll();}

//    쿠폰 하나
    public Optional<CouponVO> select(Integer id){return couponMapper.select(id);}


    //    쿠폰 수정
    public void update(CouponVO couponVO){couponMapper.update(couponVO);}

    //    쿠폰 status 수정
    public void updateStatus(CouponVO couponVO){couponMapper.updateStatus(couponVO);}

    public List<CouponVO> listByStatus(){return couponMapper.selectByCouponStatus();}

}
