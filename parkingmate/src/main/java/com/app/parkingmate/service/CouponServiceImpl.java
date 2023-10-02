package com.app.parkingmate.service;

import com.app.parkingmate.domain.VO.CouponVO;
import com.app.parkingmate.domain.VO.CouponlistVO;
import com.app.parkingmate.repository.CouponDAO;
import com.app.parkingmate.repository.CouponlistDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {
    private final CouponDAO couponDAO;
    private final CouponlistDAO couponlistDAO;
    @Override
    public void create(CouponVO couponVO) {couponDAO.save(couponVO);}

    @Override
    public List<CouponVO> list() {
        return couponDAO.list();
    }

    @Override
    public Optional<CouponVO> select(Integer id) {
        return couponDAO.select(id);
    }

    @Override
    public void update(CouponVO couponVO) { couponDAO.update(couponVO);}

    @Override
    public void updateStatus(CouponVO couponVO) {couponDAO.updateStatus(couponVO);}

    @Override
    public List<CouponVO> selectByStatus() {
        return couponDAO.listByStatus();
    }

    @Override
    public void signUpCoupon(Integer userId) {
        List insertList = couponDAO.listByStatus();
        CouponlistVO couponlistVO = new CouponlistVO();
        couponlistVO.setUserId(userId);
        for (int i = 0; i < insertList.size(); i++ ){
            couponlistVO.setCouponId((Integer) insertList.get(i));
            couponlistDAO.save(couponlistVO);
        }
    }
}
