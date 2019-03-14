<%@ page import="top.yzlin.homework.Context" %>
<%@ page import="top.yzlin.homework.doa.TicketDAO" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<jsp:useBean id="ticket" class="top.yzlin.homework.entity.Ticket"/>
<jsp:setProperty name="ticket" property="name"/>
<jsp:setProperty name="ticket" property="sex"/>
<jsp:setProperty name="ticket" property="destination"/>
<jsp:setProperty name="ticket" property="idCardNo"/>
<jsp:setProperty name="ticket" property="originating"/>
<%
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.CHINESE);
    try {
        ticket.setDate(simpleDateFormat.parse(request.getParameter("date")));
    } catch (ParseException e) {
        e.printStackTrace();
    }
    Context context = Context.getInstance();
    TicketDAO ticketDAO = context.getComponent(TicketDAO.class);
    ticketDAO.buyTicket(ticket);
    request.setAttribute("ticketList", ticketDAO.ticketList());
%>
<jsp:forward page="showTicketList.jsp"/>