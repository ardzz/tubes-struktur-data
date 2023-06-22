package Manager;

import Utilities.Routing.Graph;

public class City extends AbstractManager implements InterfaceManager{
    Graph graph;
    public City() {
        super("City");
        graph = new Graph();
    }

    public void addCity(String cityName){
        try {
            if (graph.searchNodeByString(cityName) != null) {
                System.out.println(cityName + " already exist!");
            } else {
                graph.addNode(cityName);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addRoute(String from, String to, int distance){
        try {
            if (graph.searchNodeByString(from) == null) {
                System.out.println(from + " not found!");
            } else if (graph.searchNodeByString(to) == null) {
                System.out.println(to + " not found!");
            } else {
                graph.addRoute(graph.searchNodeByString(from), distance, graph.searchNodeByString(to));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void removeCity(String cityName){
        if (graph.searchNodeByString(cityName) == null){
            System.out.println(cityName + " not found!");
        } else {
            try {
                graph.removeNodeByString(cityName);
                graph.removeRouteByString(cityName);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void showMenu() {
        String[] menu = {
                "Add city",
                "Add route",
                "Remove city",
                "Back"
        };

        showBanner();

        for(int i = 0; i < menu.length; i++) {
            System.out.println((i+1) + ". " + menu[i]);
        }

        System.out.print("Choose menu: ");
        int menuIndex = input.nextInt();

        switch(menuIndex) {
            case 1:
                System.out.print("Input city name: ");
                String cityName = input.next();
                addCity(cityName);
                break;
            case 2:
                System.out.print("Input city name from: ");
                String from = input.next();
                System.out.print("Input city name to: ");
                String to = input.next();
                System.out.print("Input distance: ");
                int distance = input.nextInt();
                addRoute(from, to, distance);
                break;
            case 3:
                System.out.print("Input city name: ");
                String cityName2 = input.next();
                removeCity(cityName2);
                break;
            case 4:
                break;
            default:
                System.out.println("Menu not found.");
                break;
        }
    }

    @Override
    public void showBanner() {

    }
}
