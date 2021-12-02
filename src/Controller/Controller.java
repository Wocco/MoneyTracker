package Controller;

import Tickets.Ticket;
import Tickets.TicketFactory;

import java.util.Date;

public class Controller
{


    public Ticket createAirplaneTicket(TicketFactory ticketFactory,String description, int value, Date purchaseDate, boolean splitEvenly)
    {
        Ticket ticket = ticketFactory.makeTicket("AirplaneTicket",description,value,purchaseDate,splitEvenly);
        //Add the ticket to the database
        return ticket;
    }

}
