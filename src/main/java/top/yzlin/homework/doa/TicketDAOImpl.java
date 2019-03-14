package top.yzlin.homework.doa;

import top.yzlin.homework.database.ConnectionManager;
import top.yzlin.homework.database.SQLTools;
import top.yzlin.homework.entity.Ticket;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {
    private ConnectionManager cm;
    private SQLTools sqlTools;

    @Resource
    public void setCm(ConnectionManager cm) {
        this.cm = cm;
    }

    @Resource
    public void setSqlTools(SQLTools sqlTools) {
        this.sqlTools = sqlTools;
    }


    @Override
    public List<Ticket> ticketList() {
        return cm.getPreparedStatement("select * from ticket_info", ps -> {
            try {
                ResultSet resultSet = ps.executeQuery();
                List<Ticket> tickets = new LinkedList<>();
                while (resultSet.next()) {
                    tickets.add(sqlTools.resultSetToObject(Ticket.class, resultSet));
                }
                return tickets;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    @Override
    public void buyTicket(Ticket ticket) {
        cm.getPreparedStatement("insert into ticket_info values(?,?,?,?,?,?)", ps -> {
            try {
                ps.setString(1, ticket.getName());
                ps.setString(2, ticket.getSex());
                ps.setString(3, ticket.getOriginating());
                ps.setString(4, ticket.getDestination());
                ps.setDate(5, ticket.getDate() instanceof Date ?
                        (Date) ticket.getDate() :
                        new Date(ticket.getDate().getTime()));
                ps.setString(6, ticket.getIdCardNo());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
