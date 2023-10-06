package com.app.parkingmate.event;

import com.app.parkingmate.domain.EventSearch;
import com.app.parkingmate.domain.Pagination;
import com.app.parkingmate.domain.VO.CouponVO;
import com.app.parkingmate.domain.VO.CouponlistVO;
import com.app.parkingmate.domain.VO.EventVO;
import com.app.parkingmate.domain.VO.UserVO;
import com.app.parkingmate.mapper.CouponMapper;
import com.app.parkingmate.mapper.CouponlistMapper;
import com.app.parkingmate.mapper.EventMapper;
import com.app.parkingmate.mapper.UserMapper;
import com.app.parkingmate.service.CouponServiceImpl;
import com.app.parkingmate.service.CouponlistService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.Random;


@SpringBootTest
@Slf4j
public class test {
    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private CouponlistMapper couponlistMapper;

    @Autowired
    private CouponServiceImpl couponService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CouponlistService couponlistService;

    @Test
    public void insertTest(){
        Random random = new Random();
        EventVO eventVO = null;
        int idx = 0;
        for (int i=0; i<30; i++){
            eventVO = new EventVO();
            idx = random.nextInt(30) + 1;
            eventVO.setEventContent("테스트 내용" +idx);
            eventVO.setEventTitle("테스트 제목" +idx);
            eventVO.setEventStatus(0);
            eventVO.setEventStartDate(Date.valueOf("2023-10-01"));
            eventVO.setEventEndDate(Date.valueOf("2023-11-01"));
            eventMapper.insert(eventVO);
        }
    }

    @Test
    public void updateTest(){
        EventVO eventVO = new EventVO();
        eventVO.setId(1);
        eventVO.setEventContent("수정 테스트 내용1");
        eventVO.setEventTitle("수정 테스트 제목1");
//        eventVO.setEventStatus("0");
        eventVO.setEventStartDate(Date.valueOf("2023-10-01"));
        eventVO.setEventEndDate(Date.valueOf("2023-11-01"));

        eventMapper.update(eventVO);

    }

    @Test
    public void updateStatusTest(){
        CouponVO couponVO = new CouponVO();
        couponVO.setId(21);
//        couponVO.setCouponStatus(0);

        couponMapper.updateStatus(couponVO);

    }

    @Test
    public void selectAllTest(Pagination pagination, EventSearch eventSearch){
        pagination.setTotal(eventMapper.selectTotal(eventSearch));
        eventMapper.selectAll(pagination).stream().map(EventVO::toString).forEach(log::info);
    }

    @Test
    public void couponSelectAllTest(){
        couponMapper.selectAll().stream().map(CouponVO::toString).forEach(log::info);
    }

    @Test
    public void selectTest(){
        CouponVO couponVO =new CouponVO();
        couponVO.setId(21);
        log.info(couponMapper.select(couponVO.getId()).toString());

    }

    @Test
    public void couponInsertTest(){
        CouponVO couponVO = new CouponVO();
        couponVO.setCouponName("전체회원 들어가는지 테스트");
        couponVO.setCouponContent("전체회원 들어가는지 테스트");
        couponVO.setCouponDiscountPercent(10);
        couponVO.setCouponStartDate(Date.valueOf("2023-10-01"));
        couponVO.setCouponEndDate(Date.valueOf("2023-11-01"));
        couponVO.setCouponUseCondition("전체회원");
        couponVO.setCouponCode("55555");
        couponVO.setEventId(41);

        couponService.create(couponVO);

    }

    @Test
    public void updateCouponStatusTest(){
        CouponlistVO couponlistVO = new CouponlistVO();
        couponlistVO.setId(29);
        couponlistVO.setCouponStatus(0);

        couponlistMapper.updateStatus(couponlistVO);
    }

    @Test
    public void selectByStatus(){
        couponMapper.selectByCouponStatus();
    }

//    회원가입 시 모든 쿠폰들 해당유저 쿠폰list에 인서트
    @Test
    public void insertCouponTest(){
        List<CouponVO> insertList = couponService.list();
        CouponlistVO couponlistVO = new CouponlistVO();
        couponlistVO.setUserId(1); // userId값만 받아오면됨
        for (int i = 0; i < insertList.size(); i++ ){
            couponlistVO.setCouponId(insertList.get(i).getId());
            couponlistService.create(couponlistVO);
        }
    }

    @Test
    public void selectAllUserTest(){
        log.info("==========================");
        userMapper.selectAll().stream().map(UserVO::toString).forEach(log::info);
    }



}
