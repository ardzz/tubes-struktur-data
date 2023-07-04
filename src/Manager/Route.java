package Manager;

import Utilities.Routing.Graph;
import Utilities.Routing.Node;

public class Route extends AbstractManager implements InterfaceManager {
    Graph graph;
    public Route(Graph graph) {
        super("Route");
        this.graph = graph;
    }

    public void addRoute(String from, String to, int distance){
        try {
            Node city_from = graph.searchNodeByString(from);
            Node city_to = graph.searchNodeByString(to);
            if (city_to == null) {
                System.out.println(from + " not found!");
            } else if (city_from == null) {
                System.out.println(to + " not found!");
            } else {
                if (graph.isRouteExist(city_from, city_to)) {
                    System.out.println("Route already exist!");
                } else {
                    graph.addRoute(city_to, distance, city_from);
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void removeRoute(String from, String to){
        try {
            Node city_from = graph.searchNodeByString(from);
            Node city_to = graph.searchNodeByString(to);
            if (graph.searchNodeByString(from) == null) {
                System.out.println(from + " not found!");
            } else if (graph.searchNodeByString(to) == null) {
                System.out.println(to + " not found!");
            } else {
                graph.removeRoute(city_from, city_to);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showMenu() {
        String[] menu = {
                "Add route",
                "Remove route",
                "Show route",
                "Back"
        };

        showBanner();

        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }

        System.out.print("Choose menu: ");
        int menuIndex = input.nextInt();
        String from, to;

        switch (menuIndex) {
            case 1:
                System.out.print("Input city name from: ");
                from = input.next();
                System.out.print("Input city name to: ");
                to = input.next();
                System.out.print("Input distance: ");
                int distance = input.nextInt();
                addRoute(from, to, distance);
                break;
            case 2:
                System.out.print("Input city name from: ");
                from = input.next();
                System.out.print("Input city name to: ");
                to = input.next();
                removeRoute(from, to);
                break;
            case 3:
                graph.printGraph();
                break;
            case 4:
                break;
            default:
                System.out.println("Menu not found.");
                break;
        }
    }
}
