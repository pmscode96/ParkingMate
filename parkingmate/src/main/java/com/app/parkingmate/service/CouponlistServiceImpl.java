package com.app.parkingmate.service;

import com.app.parkingmate.domain.DTO.CouponDTO;
import com.app.parkingmate.domain.VO.CouponlistVO;
import com.app.parkingmate.repository.CouponlistDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CouponlistServiceImpl implements CouponlistService {
    private final CouponlistDAO couponlistDAO;

    @Override
    public void create(CouponlistVO couponlistVO) {
        couponlistDAO.save(couponlistVO);
    }

    @Override
    public List<CouponlistVO> list(Integer userId) {
        return couponlistDAO.list(userId);
    }

    @Override
    public List<CouponDTO> listWithCoupon(Integer userId) {
        return couponlistDAO.listWithCoupon(userId);
    }

    @Override
    public void updateStatus(CouponlistVO couponlistVO) {
        couponlistDAO.updateStatus(couponlistVO);
    }
}
