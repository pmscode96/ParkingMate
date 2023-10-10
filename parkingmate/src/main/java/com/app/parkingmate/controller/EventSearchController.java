package com.app.parkingmate.controller;


import com.app.parkingmate.domain.EventSearch;
import com.app.parkingmate.domain.EventSearchDTO;
import com.app.parkingmate.domain.Pagination;
import com.app.parkingmate.domain.VO.EventVO;
import com.app.parkingmate.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EventSearchController {
    public final EventService eventService;

    @GetMapping("results/search")
    public EventSearchDTO getResult(EventSearch eventSearch, Pagination pagination, Model model){
        pagination.setTotal(eventService.selectTotal(eventSearch));
        pagination.progress();
        model.addAttribute("pagination", pagination);
        return eventService.searchEvent(eventSearch);
    }


}
