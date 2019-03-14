package top.yzlin.homework.servlet;

import top.yzlin.homework.mvc.BaseViewParse;

import javax.servlet.annotation.WebServlet;
import java.util.Map;

@WebServlet(name = "HW4Servlet", value = {"/hw4", "/hw4/*"})
public class HW4Servlet extends BaseViewParse {

    @Override
    protected String doOperation(String requestURI, Map<String, Object> model) {
        switch (requestURI) {
            case "/hw4/jspAndJavaBean":
            default:
                return "/hw4/index.jsp";
        }

    }


}
