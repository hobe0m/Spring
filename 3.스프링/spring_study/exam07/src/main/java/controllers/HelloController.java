package controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "기본값") String nm, Model model) {
        model.addAttribute("name", nm);

        return "hello";
    }
    /*
    @GetMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        System.out.println("request : " + request);
        System.out.println("response : " + response);
        System.out.println("session : " + session);

        return "hello"; // / WEB-INF/templates/hello.jsp를 가르킨다.
    }
    */

    /*
    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        // ModelAndView : 데이터와 경로에 대한 정보가 담겨있는 객체

        // request.setAttribute("message", "안녕하세요."); 와 동일하다.
        mv.addObject("message", "안녕하세요.");
        mv.setViewName("hello"); // /WEB-INF/templates/hello.jsp

        return mv;
     */
    }

