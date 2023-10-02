package com.app.parkingmate.repository;

import com.app.parkingmate.domain.VO.UserVO;
import com.app.parkingmate.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserDAO {
    private final UserMapper userMapper;


    public void save(UserVO userVO){
        userMapper.insert(userVO);
    }

//    find-id, find-password
    public Optional<UserVO> findByEmail(String UserEmail){
        return userMapper.select(UserEmail);
    }


//   카카오 이메일로 조회(login(카카오)부분)
    public Optional<UserVO> findByKakaoEmail(String KakaoEmail){
        return userMapper.kakaoSelect(KakaoEmail);
    }

//    회원정보조회
    public Optional<UserVO> findByMember(Integer Id){
        return userMapper.selectMember(Id);
    }

//    전달받은 카카오프사로 업데이트
    public void updateByKakaoProfile(UserVO userVO){
        userMapper.updateKaKaoProfile(userVO);
    }



//    로그인
    public Optional<UserVO> login(UserVO userVO){
        return userMapper.selectLogin(userVO);
    }

//    카카오 연동하기
    public void updateBySync(UserVO userVO){
        userMapper.updateBySync(userVO);
    }

//    회원 삭제
    public void delete(Integer Id){
        userMapper.delete(Id);
    }

////  회원 정보 조회
//    public Optional<UserVO> findByMember(Integer Id) {
////        Optional<UserVO> member = userMapper.select(Id);
//        return userMapper.select(Id);
//    };
}
