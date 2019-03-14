package top.yzlin.homework.servlet;

import top.yzlin.homework.Context;
import top.yzlin.homework.doa.TicketDAO;
import top.yzlin.homework.entity.Ticket;
import top.yzlin.homework.mvc.BaseViewParse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

@WebServlet(name = "HW4Servlet", value = {"/hw4", "/hw4/*"})
public class HW4Servlet extends BaseViewParse {
    private TicketDAO ticketDAO;

    @Override
    public void init() throws ServletException {
        ticketDAO = Context.getInstance().getComponent(TicketDAO.class);
    }

    /**
     * 写代码写傻了写出这种东西，但是也懒得改了
     *
     * @param req
     * @param model 模型啊
     * @return
     */
    @Override
    protected String doOperation(HttpServletRequest req, Map<String, Object> model) {
        switch (req.getRequestURI()) {
            case "/hw4/jspAndServletAndJavaBean":
                return jspAndServletAndJavaBean(model);
            case "/jspAndServletAndJavaBean/doBuy":
                return doOperate(req, model);
            case "/hw4/jspAndJavaBean":
                return jspAndJAVABean(model);
            case "/hw4/jspAndJavaBean/doBuy":
                return "/hw4/doBuy.jsp";
            default:
                return "/hw4/index.jsp";
        }

    }

    private String jspAndJAVABean(Map<String, Object> model) {
        model.put("url", "/jspAndJavaBean/doBuy");
        return "/hw4/buyTicket.jsp";
    }

    private String jspAndServletAndJavaBean(Map<String, Object> model) {
        model.put("url", "/jspAndServletAndJavaBean/doBuy");
        return "/hw4/buyTicket.jsp";
    }

    private String doOperate(HttpServletRequest req, Map<String, Object> model) {
        Ticket ticket = new Ticket();
        ticket.setName(req.getParameter("name"));
        ticket.setSex(req.getParameter("sex"));
        ticket.setDestination(req.getParameter("destination"));
        ticket.setIdCardNo(req.getParameter("idCardNo"));
        ticket.setOriginating(req.getParameter("originating"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.CHINESE);
        try {
            ticket.setDate(simpleDateFormat.parse(req.getParameter("date")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ticketDAO.buyTicket(ticket);
        model.put("ticketList", ticketDAO.ticketList());
        return "/hw4/showTicketList.jsp";

    }


}
