package Manager;

import Utilities.Routing.Graph;

public class City extends AbstractManager implements InterfaceManager{
    Graph graph;
    public City(Graph graph) {
        super("City");
        this.graph = graph;
    }

    public void addCity(String cityName){
        try {
            if (graph.searchNodeByString(cityName) != null) {
                System.out.println(cityName + " already exist!");
            }
        }
        catch (Exception e){
            graph.addNode(cityName);
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

    public void showCity(){
        try {
            graph.printCity();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showMenu() {
        String[] menu = {
                "Add city",
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
                System.out.print("Input city name: ");
                String cityName2 = input.next();
                removeCity(cityName2);
                break;
            case 3:
                break;
            default:
                System.out.println("Menu not found.");
                break;
        }
    }
}
