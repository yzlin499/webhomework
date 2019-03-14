package top.yzlin.homework.doa;

import top.yzlin.homework.entity.Ticket;

import java.util.List;

public interface TicketDAO {
    List<Ticket> ticketList();

    void buyTicket(Ticket ticket);
}
