package Hello.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // / : 루트 경로
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
