package top.yzlin.homework.filter;

import top.yzlin.homework.Context;
import top.yzlin.homework.doa.UserDAO;
import top.yzlin.homework.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    private UserDAO userDAO;

    @Override
    public void init(FilterConfig config) throws ServletException {
        userDAO = Context.getInstance().getComponent(UserDAO.class);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(req.getCharacterEncoding());
        PrintWriter writer = resp.getWriter();
        User user = userDAO.getUserInfo(req.getParameter("name"));
        if (user == null) {
            writer.write("<html><head><title>错误</title></head><body><p>无法找到该用户名</p></body></html>");
        } else if (Objects.equals(user.getPassword(), req.getParameter("password"))) {
            HttpServletRequest httpRequest = (HttpServletRequest) req;
            HttpSession session = httpRequest.getSession();
            session.setAttribute("isLogin", true);
            session.setAttribute("user", user);
            chain.doFilter(req, resp);
        } else {
            writer.write("<html><head><title>错误</title></head><body><p>密码错误</p></body></html>");
        }
    }
}
