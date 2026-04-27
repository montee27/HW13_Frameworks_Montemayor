package edu.sandiego.comp305.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }


    @GetMapping("/bio")
    public String showBio(Model model) {
        LocalTime now = LocalTime.now();
        String timeGreeting;

        if (now.getHour() < 12) {
            timeGreeting = "Good Morning";
        } else if (now.getHour() < 17) {
            timeGreeting = "Good Afternoon";
        } else {
            timeGreeting = "Good Evening";
        }

        model.addAttribute("timeGreeting", timeGreeting);
        model.addAttribute("currentTime", String.format("%02d:%02d", now.getHour(), now.getMinute()));
        return "bio"; // This tells Spring to look for bio.html in templates [cite: 141, 148]
    }

}
