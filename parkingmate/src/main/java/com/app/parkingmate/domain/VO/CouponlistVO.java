package com.app.parkingmate.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
public class CouponlistVO {
//    쿠폰 고유 id
//     not null
    private int id;

    private int couponId;

    private int userId;

    private int couponStatus;

}
