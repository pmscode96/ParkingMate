package com.app.parkingmate.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
public class CouponVO {
//    쿠폰 고유 id
//     not null
    private Integer id;
//    쿠폰 명
//     not null
    private String couponName;
//    쿠폰 내용
//    3000자
//     not null
    private String couponContent;
//    쿠폰 할인률
//    기본 값 : 10
//     not null
    private Integer couponDiscountPercent;
//    쿠폰 발급 날짜
//    not null
    private Date couponStartDate;
//    쿠폰 종료 날짜
//     not null
    private Date couponEndDate;
//    쿠폰 사용 조건
//    3000자
    private String couponUseCondition;
//    쿠폰 코드
//     not null
//    500자

    private String CouponCode;
//    쿠폰 상태
//    기본 값 : 0
//    옵션 : 0 - 사용 가능, 1 - 사용 불가
    private Integer CouponStatus;

//    생성 날짜
    private LocalDateTime createDate;
//    업데이트 날짜
    private LocalDateTime updateDate;

    private Integer couponStatus;

//    ================================ FK
//    이벤트 테이블의 이벤트 고유 id
//     not null
    private Integer eventId;


}
