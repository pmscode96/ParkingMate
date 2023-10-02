package com.app.parkingmate.domain.VO;

import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
public class UseHistoryVO {
//    이용내역 고유 id
//    not null
    private Integer UseHistoryId;
//    이용내역 카테고리
//    기본 값 : 0
//    옵션 : 0 - 이용 중, 1 - 이용 완료, 2 - 취소
//    not null
    private Integer UseHistoryCategory;
//    이용내역 제목
//    1000자
//    not null
    private String UseHistoryTitle;
//    이용내역 본문
//    3000자
//    not null
    private  String UseHistoryContent;
//    이용날짜
//    not null
    private Date UseDate;
//    이용 시간
//    기본 값 : 30(분)
//    not null
    private Date UseTime;
//    생성 날짜
    private LocalDateTime CreateDate;
//    업데이트 날짜
    private LocalDateTime UpdateDate;

//    ================================ FK
//    예약 테이블 고유 id
//    not null
    private Integer ReservationId;
//    예약 테이블 예약 날짜
//    not null
    private Date ReservationDate;
//    회원 테이블 회원 id
//    not null
    private Integer UserId;
//    주차장 테이블 주차장 id
//    not null
    private Integer ParkingId;
}
