package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// @WebServlet("/member/login") // web.xml에 추가하지 않고, annotation에 추가하는 방법
// @WebServlet("/member/login")에 /를 쓰는 이유는 컨텍스트 패스를 기준으로 URL패턴을 지정해 그것을 기준으로 상대적인 경로
// 를 나타내기 때문이다. 상대적인 경로를 사용하면 웹 어플리케이션이 어떤 컨텍스트 패스에 배치되어 있더라도 일관된 방식으로 URL
// 패턴을 설정할 수 있고, 이는 웹 어플리케이션을 다른 환경으로 배포하거나 컨텍스트 패스를 변경할 때 편리하다.

public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // servlet은 컴파일 기반이기 때문에 수정 후 서버를 다시 실행시킨 뒤 확인해야 한다.

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/login.jsp");
        rd.forward(req, resp);
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init()!!!!");
        String key1 = config.getInitParameter("key1");
        String key2 = config.getInitParameter("key2");
        System.out.printf("key1=%s, key2=%s%n", key1, key2);
    }

    @Override
    public void destroy() {
        System.out.println("destory()!!!!");
    }

}
