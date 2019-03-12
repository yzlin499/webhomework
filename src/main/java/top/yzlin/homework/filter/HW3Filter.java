package top.yzlin.homework.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebFilter(filterName = "HW3Filter")
public class HW3Filter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if ("/hw3/index.html".equals(httpRequest.getRequestURI())) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = httpRequest.getSession();
            boolean isLogin = Optional.ofNullable(session.getAttribute("isLogin"))
                    .map(o -> (Boolean) o)
                    .orElse(false);
            if (isLogin) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.sendRedirect("/hw3/index.html");
            }
        }
    }
}
