package com.app.parkingmate.event;

import com.app.parkingmate.domain.VO.CouponVO;
import com.app.parkingmate.domain.VO.CouponlistVO;
import com.app.parkingmate.domain.VO.EventVO;
import com.app.parkingmate.mapper.CouponMapper;
import com.app.parkingmate.mapper.CouponlistMapper;
import com.app.parkingmate.mapper.EventMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;


@SpringBootTest
@Slf4j
public class test {
    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private CouponlistMapper couponlistMapper;

    @Test
    public void insertTest(){
        EventVO eventVO = new EventVO();
        eventVO.setEventContent("테스트 내용1");
        eventVO.setEventTitle("테스트 제목1");
        eventVO.setEventStatus("0");
        eventVO.setEventStartDate(Date.valueOf("2023-10-01"));
        eventVO.setEventEndDate(Date.valueOf("2023-11-01"));
        eventMapper.insert(eventVO);
    }

    @Test
    public void updateTest(){
        EventVO eventVO = new EventVO();
        eventVO.setId(1);
        eventVO.setEventContent("수정 테스트 내용1");
        eventVO.setEventTitle("수정 테스트 제목1");
        eventVO.setEventStatus("0");
        eventVO.setEventStartDate(Date.valueOf("2023-10-01"));
        eventVO.setEventEndDate(Date.valueOf("2023-11-01"));

        eventMapper.update(eventVO);

    }

    @Test
    public void updateStatusTest(){
        CouponVO couponVO = new CouponVO();
        couponVO.setId(21);
        couponVO.setCouponStatus(0);

        couponMapper.updateStatus(couponVO);

    }

    @Test
    public void selectAllTest(){
        eventMapper.selectAll().stream().map(EventVO::toString).forEach(log::info);
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
        couponVO.setCouponName("테스트쿠폰");
        couponVO.setCouponContent("테스트내용");
        couponVO.setCouponDiscountPercent(30);
        couponVO.setCouponStartDate(Date.valueOf("2023-10-01"));
        couponVO.setCouponEndDate(Date.valueOf("2023-11-01"));
        couponVO.setCouponUseCondition("아무나");
        couponVO.setCouponCode("1234-1234-1234");
        couponVO.setEventId(41);

        couponMapper.insert(couponVO);

    }

    @Test
    public void updateCouponStatusTest(){
        CouponVO couponVO = new CouponVO();
        couponVO.setId(21);
        couponVO.setCouponStatus(1);

        couponMapper.updateStatus(couponVO);
    }

    @Test
    public void selectByStatus(){
        couponMapper.selectByCouponStatus();
    }

    @Test
    public void insertCouponTest(){
        List insertList = couponMapper.selectByCouponStatus();
        CouponlistVO couponlistVO = new CouponlistVO();
        couponlistVO.setUserId(3);
        for (int i = 0; i < insertList.size(); i++ ){
            couponlistVO.setCouponId((Integer) insertList.get(i));
            couponlistMapper.insert(couponlistVO);
        }
    }

}
