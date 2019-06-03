package vn.codegym.springbootdatajpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.springbootdatajpa.dto.EventRegistration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("eventRegistrations")
public class EventController {

    @GetMapping("/events/register")
    public String showSubmission(HttpServletRequest httpServletRequest, @CookieValue(value = "color", defaultValue = "") String color,  Model model){
        model.addAttribute("eventRegistration", new EventRegistration());
        model.addAttribute("color", color);
        return "event-register";
    }

    @PostMapping("/events/register")
    public String register(HttpServletResponse httpServletResponse, @SessionAttribute("eventRegistrations") List<EventRegistration> eventRegistrations, @ModelAttribute EventRegistration eventRegistration, Model model){
        Cookie cookie = new Cookie("color", eventRegistration.getColor());
        httpServletResponse.addCookie(cookie);

        eventRegistrations.add(eventRegistration);
        return "event-register-success";
    }

    @GetMapping("/events/list-participant")
    public String listParticipant(HttpServletRequest httpServletRequest, Model model){
        httpServletRequest.getCookies();
        //This will always create a session if it does not exist, or re-use the existing one.
        HttpSession httpSession = httpServletRequest.getSession();
        Object eventRegistrations = httpSession.getAttribute("eventRegistrations");
        if (eventRegistrations == null) {
            httpSession.setAttribute("eventRegistrations", new ArrayList<>());
        }
        model.addAttribute("eventRegistrations", eventRegistrations);
        return "event-register-list";
    }

    @ModelAttribute("eventRegistrations")
    public List<EventRegistration> getEventRegistrations(){
        return new ArrayList<>();
    }
}
