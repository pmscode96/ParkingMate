package com.app.parkingmate;

import com.app.parkingmate.domain.VO.ParkingVO;
import com.app.parkingmate.domain.VO.UserVO;
import com.app.parkingmate.mapper.ParkingMapper;
import com.app.parkingmate.mapper.UserMapper;
import com.app.parkingmate.service.ParkingService;
import com.app.parkingmate.service.UserService;
import com.app.parkingmate.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
@Slf4j
class ParkingmateApplicationTests {

	@Autowired
	private ParkingService parkingService;

	@Autowired
	private UserService userService;
	@Test
	void contextLoads() {
	}

	@Test
	public void ParkingUploadTest() {
		ParkingVO parkingVO = new ParkingVO();
		parkingVO.setParkingAddress("서울 강남구 역삼동 825-20");
//		parkingVO.setParkingCategory("강남구 서초동");

		parkingService.getParking(parkingVO).map(ParkingVO::toString).ifPresent(log::info);

	}

//	@Test
//	public void UserTest(){
//		UserVO userVO = new UserVO();
//		userVO.setUserName("김철수");
//		userVO.setUserPassword("7777");
//		userVO.setUserEmail("kim@gmail.com");
//		userVO.setUserNickName("김7777");
//		userVO.setUserPhoneNumber("010-1111-2222");
//		userVO.setUserStartDate(new Date());
//		userVO.setUserProfile("나는 철수");
//		userService.join(userVO);
//	}

}
