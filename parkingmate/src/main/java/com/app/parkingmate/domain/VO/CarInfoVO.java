package com.app.parkingmate.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
public class CarInfoVO {
//    차량정보 고유 id
//     not null
    private Integer CarInfoId;
//    차량 모델
//     not null
    private String CarModel;
//    차량 번호
//     not null
    private String CarNumber;
//    차량 등록일
//     not null
    private Date CarRegisterDate;
//    차량 등록 상태
//    기본 값 : 0
//    옵션 : 0 - 등록, 1 - 취소, 2 - 알 수 없음
//     not null
    private Integer CarRegisterStatus;
//    생성 날짜
    private LocalDateTime CreateDate;
//    업데이트 날짜
    private LocalDateTime UpdateDate;

//    ================================ FK
//    회원 테이블 회원 id
//     not null
    private Integer UserId;
}
