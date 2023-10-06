package com.app.parkingmate.service;

import com.app.parkingmate.domain.VO.CouponVO;
import com.app.parkingmate.domain.VO.CouponlistVO;
import com.app.parkingmate.domain.VO.UserVO;
import com.app.parkingmate.mapper.UserMapper;
import com.app.parkingmate.repository.CouponDAO;
import com.app.parkingmate.repository.CouponlistDAO;
import com.app.parkingmate.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CouponServiceImpl implements CouponService {
    private final CouponDAO couponDAO;
    private final CouponlistDAO couponlistDAO;
    private final UserDAO userDAO;
    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    @Override
    public void create(CouponVO couponVO) {
        // 먼저 쿠폰을 저장
        couponDAO.save(couponVO);

        // 저장한 쿠폰의 ID를 가져옴
        Integer couponId = couponVO.getId();

        // 모든 사용자를 조회
        List<UserVO> userList = userDAO.selectAllUser();

        // 각 사용자에게 쿠폰을 할당
        for (UserVO user : userList) {
            CouponlistVO couponlistVO = new CouponlistVO();
            couponlistVO.setCouponId(couponId);
            couponlistVO.setUserId(user.getId());

            // 쿠폰 목록을 저장
            couponlistDAO.save(couponlistVO);
        }
    }

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
