package com.app.parkingmate.repository;

import com.app.parkingmate.domain.DTO.CouponDTO;
import com.app.parkingmate.domain.VO.CouponVO;
import com.app.parkingmate.domain.VO.CouponlistVO;
import com.app.parkingmate.mapper.CouponMapper;
import com.app.parkingmate.mapper.CouponlistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CouponlistDAO {
    private final CouponlistMapper couponlistMapper;
    //    쿠폰 생성
    public void save(CouponlistVO couponlistVO){couponlistMapper.insert(couponlistVO);}

    //    쿠폰 리스트
    public List<CouponlistVO> list(Integer userId){return couponlistMapper.selectAll(userId);}

//    쿠폰 리스트 join 쿠폰
    public List<CouponDTO> listWithCoupon(Integer userId){return couponlistMapper.selectMyCoupon(userId);}


    //    쿠폰 status 수정
    public void updateStatus(CouponlistVO couponlistVO){couponlistMapper.updateStatus(couponlistVO);}

//    활성화된 쿠폰 리스트
    public List<CouponDTO> enabledList(Integer userId){return couponlistMapper.selectEnabled(userId);}

}
