package com.app.parkingmate.domain.VO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class ParkingVO {
//    주차장 고유 id
//    not null
    private Integer Id;
//    주차장 주소
//    3000자
//    not null
    private String ParkingAddress;
//    주차장 카테고리
//    1000자
//    도시(시),(구)를 나타냄
    private String ParkingCategory;
//    주차장 명
//    1000자
//    not null
    private String ParkingName;
//    주차장내용(세부정보)
//    3000자
    private String ParkingContent;
//    주차장 평점
//    기본 값 : 5
    private Integer ParkingGrade;
//    주차장 이용 수
//    기본 값 : 0
    private  Integer ParkingUseCount;
//    주차장 대여 금액(시간당)
//    기본 값 : 1000
    private Integer ParkingPrice;
//    주차 면수
//    기본 값 : 5
//    not null
    private Integer ParkingSpaceNumber;
//    주차 찜 상태
//    기본 값 : 0
//    옵션 : 0 - false(찜 상태 x), 1 - ture(찜 상태)
    private Integer ParkingDibsStatus;
//    생성 날짜
    private Date CreateDate;
//    업데이트 날짜
    private Date UpdateDate;

//    =================================== FK
//    회원 테이블 회원 번호
//    not null
    private Integer UserId;
}
