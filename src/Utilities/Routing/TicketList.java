package Utilities.Routing;

public class TicketList {
    public TicketNode head;
    public TicketNode tail;

    public TicketList() {
        head = null;
        tail = null;
    }

    public void addTicket(String name, String cityFrom, String cityTo, int distance, int price_per_km) {
        TicketNode ticket = new TicketNode();

        ticket.addTicket(name, cityFrom, cityTo, distance, price_per_km);

        if (head == null) {
            head = ticket;
            tail = ticket;
        } else {
            tail.next = ticket;
            tail = ticket;
        }
    }

    public void checkSoldTicket() {
        TicketNode current = head;

        while (current != null) {
            System.out.println("Ticket name: " + current.name);
            System.out.println("From: " + current.from);
            System.out.println("To: " + current.to);
            System.out.println("Price: " + current.price);
            System.out.println();

            current = current.next;
        }
    }

    public void getTotalPrice() {
        TicketNode current = head;
        int total = 0;

        while (current != null) {
            total += current.price;

            current = current.next;
        }

        System.out.println("Total price: " + total);
    }
}
