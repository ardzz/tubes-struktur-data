package Utilities.Routing;

import Manager.Ticket;

public class TicketNode {
    public String name;
    public String from;
    public String to;
    public int price;
    public int price_per_km;
    public TicketNode next;

    public TicketNode() {
        name = null;
        from = null;
        to = null;
        price = 0;
        next = null;
    }

    public void addTicket(String name, String cityFrom, String cityTo, int distance, int price_per_km) {
        this.name = name;
        this.from = cityFrom;
        this.to = cityTo;
        this.price = distance * price_per_km;
    }
}
