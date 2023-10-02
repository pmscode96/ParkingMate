package com.app.parkingmate.controller;


import com.app.parkingmate.domain.VO.ParkingVO;
import com.app.parkingmate.service.ParkingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/parking-upload/*")
public class ParkingUploadController {

    private final ParkingService parkingService;
    @GetMapping("parking-upload")
    public void goToUParkingUploadForm(ParkingVO parkingVO) {
        log.info(parkingService.getParking(parkingVO).toString());
    }
}
