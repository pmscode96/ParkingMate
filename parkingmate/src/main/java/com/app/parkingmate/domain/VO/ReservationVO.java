package com.app.parkingmate.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
public class ReservationVO {
//    예약 고유 id
//    not null
    private Integer ReservationId;
//    예약 날짜 (PK)
//    not null
    private Date ReservationDate;
//    예약 요청 사항
//    1000자
    private String ReservationRequest;
//    예약 번호
//    1000자
//    not null
    private String ReservationNumber;
//    예약 상태
//    기본 값 : 0
//    옵션 : 0 - 결제 중
//          1 - 결제 완료 
//          2 - 결제 취소 
//    not null
    private Integer ReservationStatus;
//    생성 날짜
    private LocalDateTime CreateDate;
//    업데이트 날짜
    private LocalDateTime UpdateDate;
//    ===================================== FK
//    회원 테이블 회원 id
//    not null
    private Integer UserId;
//    주차장 테이블 주차장 id
//    not null
    private Integer ParkingId;
}
