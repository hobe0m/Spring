package filters;

import jakarta.servlet.*;

import java.io.IOException;

public class FilterEx2 implements Filter {
    // alt + enter로 doFilter 메소드 생성
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("FilterEx2 - 요청 전");

        chain.doFilter(request, response);

        System.out.println("FilterEx2 - 응답 후");
    }
}
