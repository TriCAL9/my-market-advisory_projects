package api.my_market_advisory_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /**
     * @GetMapping("/home") public String home(ModelMap map) {
     * map.addAttribute("name", "Aryn");
     * return "home";
     * }
     */
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
