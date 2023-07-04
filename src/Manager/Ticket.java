package Manager;

import Utilities.Routing.Graph;
import Utilities.Routing.Node;
import Utilities.Routing.TicketList;
import Utilities.Routing.TicketNode;

public class Ticket extends AbstractManager implements InterfaceManager{
    TicketList plane_ticket, train_ticket, bus_ticket;
    Graph graph;
    public Ticket(TicketList plane_ticket, TicketList train_ticket, TicketList bus_ticket, Graph graph) {
        super("Ticket");
        this.plane_ticket = plane_ticket;
        this.train_ticket = train_ticket;
        this.bus_ticket = bus_ticket;
        this.graph = graph;
    }

    @Override
    public void showMenu() {
        String[] menu = {
                "Buy ticket",
                "Show ticket",
                "Back"
        };

        showBanner();

        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }

        System.out.print("Choose menu: ");
    }

    public void buyTicket(String name, String from, String to, String transport, int price_per_km){
        try {
            transport = transport.toLowerCase();
            Node city_from = graph.searchNodeByString(from);
            Node city_to = graph.searchNodeByString(to);

            if(graph.isRouteExist(city_from, city_to)){
                int distance = graph.calculateDistanceByString(from, to);
                switch (transport) {
                    case "plane" -> plane_ticket.addTicket(name, from, to, distance, price_per_km);
                    case "train" -> train_ticket.addTicket(name, from, to, distance, price_per_km);
                    case "bus" -> bus_ticket.addTicket(name, from, to, distance, price_per_km);
                    default -> System.out.println("Transport not found!");
                }
            } else {
                System.out.println("Route not found!");
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
