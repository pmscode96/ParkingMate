package com.app.parkingmate.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
public class PaymentHistoryVO {
//    결제 내역 고유 id
//    not null
    private Integer PaymentHistoryId;
//    결제 일
//    not null
    private Date PaymentHistoryDate;
//    결제 취소 일
    private Date PaymentHistoryCancelDate;
//    결제 상태
//    기본 값 : 0
//    옵션 : 0 - 신용 카드, 1 - 네이버 페이, 2 - 카카오 페이
//    not null
    private Integer PaymentHistoryStatus;
//    생성 날짜
    private LocalDateTime CreateDate;
//    업데이트 날짜
    private LocalDateTime UpdateDate;

//    ================================== FK
//    쿠폰 테이블 id
//    not null
    private Integer CouponId;
//    주차장 테이블 id
//    not null
    private Integer ParkingId;
//    회원 테이블 고유 번호
//    not null
    private Integer UserId;
//    예약 테이블 고유 번호
//    not null
    private Integer ReservationId;
    //    예약 테이블의 예약 날짜
//    not null
    private Date ReservationDate;
    //    이용내역 테이블 고유 번호
//    not null
    private  Integer UseHistoryId;

}
