import Manager.City;
import Manager.Queue;
import Manager.Ticket;
import Utilities.Routing.Graph;
import Utilities.Routing.Node;
import Utilities.Routing.TicketList;

import java.util.Scanner;

public class Main {
    public static void load_dummy_queue(Queue[] queues){
        String[] names = {
          "kaka", "kiki", "kuku", "koko", "keke"
        };

        for (Queue queue : queues) {
            queue.queueByList(names);
        }
    }

    public static void load_dummy_city(Graph graph){
        // London - Edinburgh - 50KM
        String[][] cities = {
                {"London", "Edinburgh", "50"},
                {"London", "Manchester", "65"},
                {"London", "Sheffield", "78"},
                {"London", "Birmingham", "185"},
                {"Edinburgh", "Manchester", "70"},
                {"Edinburgh", "Sheffield", "80"},
                {"Edinburgh", "Birmingham", "190"},
                {"Edinburgh", "London", "50"},
                {"Manchester", "Sheffield", "40"},
                {"Manchester", "Birmingham", "90"},
                {"Manchester", "London", "65"},
                {"Manchester", "Edinburgh", "70"},
                {"Sheffield", "Birmingham", "70"},
                {"Sheffield", "London", "78"},
                {"Sheffield", "Edinburgh", "80"},
                {"Sheffield", "Manchester", "40"},
                {"Birmingham", "London", "185"},
                {"Birmingham", "Edinburgh", "190"},
                {"Birmingham", "Manchester", "90"},
                {"Birmingham", "Sheffield", "70"},
        };

        for (String[] city : cities) {
            Node from = null;
            Node to = null;
            try {
                from = graph.searchNodeByString(city[0]);
                to = graph.searchNodeByString(city[1]);
            } catch (Exception e) {
                if (from == null) graph.addNode(city[0]);
                if (to == null) graph.addNode(city[1]);
            }
            graph.addRoute(graph.searchNodeByString(city[0]), Integer.parseInt(city[2]), graph.searchNodeByString(city[1]));
        }
    }
    public static void main(String[] args) {
        Queue bus = new Queue("Bus");
        Queue train = new Queue("Train");
        Queue plane = new Queue("Plane");
        Graph graph = new Graph();
        City city = new City(graph);

        load_dummy_queue(new Queue[]{bus, train, plane});
        load_dummy_city(graph);

        TicketList ticket_bus = new TicketList();
        TicketList ticket_train = new TicketList();
        TicketList ticket_plane = new TicketList();

        int bus_price = 100000;
        int train_price = 200000;
        int plane_price = 500000;

        Ticket ticket = new Ticket(ticket_plane, ticket_train, ticket_bus, graph);

        Scanner input = new Scanner(System.in);

        int menuIndex;
        do {
            String[] menu = {
                    "Queue Management",
                    "City Management",
                    "Route Management",
                    "Buy Ticket",
                    "Check Sold Ticket",
                    "Exit"
            };

            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i]);
            }

            System.out.print("Choose menu: ");

            menuIndex = input.nextInt();

            switch (menuIndex) {
                case 1 -> {
                    String[] transportMenu = {
                            "Bus",
                            "Train",
                            "Plane",
                            "Back"
                    };

                    for (int i = 0; i < transportMenu.length; i++) {
                        System.out.println((i + 1) + ". " + transportMenu[i]);
                    }

                    System.out.print("Choose menu: ");

                    int transportMenuIndex = input.nextInt();

                    switch (transportMenuIndex) {
                        case 1 -> bus.showMenu();
                        case 2 -> train.showMenu();
                        case 3 -> plane.showMenu();
                        case 4 -> main(args);
                        default -> System.out.println("Menu not found!");
                    }
                }
                case 2 -> {
                    String[] cityMenu = {
                            "Add city",
                            "Remove city",
                            "Show city",
                            "Back"
                    };

                    for (int i = 0; i < cityMenu.length; i++) {
                        System.out.println((i + 1) + ". " + cityMenu[i]);
                    }

                    System.out.print("Choose menu: ");

                    int cityMenuIndex = input.nextInt();

                    switch (cityMenuIndex) {
                        case 1 -> {
                            city.showCity();
                            System.out.print("Input city name: ");
                            String cityName = input.next();
                            city.addCity(cityName);
                        }
                        case 2 -> {
                            city.showCity();
                            System.out.print("Input city name: ");
                            String cityName = input.next();
                            city.removeCity(cityName);
                        }
                        case 3 -> city.showCity();
                        case 4 -> main(args);
                    }
                }
                case 3 -> {
                    String[] routeMenu = {
                            "Add route",
                            "Remove route",
                            "Show route",
                            "Back"
                    };

                    for (int i = 0; i < routeMenu.length; i++) {
                        System.out.println((i + 1) + ". " + routeMenu[i]);
                    }

                    System.out.print("Choose menu: ");

                    int routeMenuIndex = input.nextInt();

                    switch (routeMenuIndex) {
                        case 1 -> {
                            graph.printGraph();
                            System.out.print("Input source city name: ");
                            String sourceCityName = input.next();
                            System.out.print("Input destination city name: ");
                            String destinationCityName = input.next();
                            System.out.print("Input distance: ");
                            int distance = input.nextInt();
                            try {
                                Node sourceCity = graph.searchNodeByString(sourceCityName);
                                Node destinationCity = graph.searchNodeByString(destinationCityName);
                                graph.addRoute(destinationCity, distance, sourceCity);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        case 2 -> {
                            graph.printGraph();
                            try {
                                System.out.print("Input source city name: ");
                                String sourceCityName = input.next();
                                graph.removeRouteByString(sourceCityName);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        case 3 -> graph.printGraph();
                        case 4 -> main(args);
                    }
                }
                case 4 -> {
                    String[] buyTicketMenu = {
                            "Buy Bus Ticket",
                            "Buy Train Ticket",
                            "Buy Plane Ticket",
                            "Back"
                    };

                    for (int i = 0; i < buyTicketMenu.length; i++) {
                        System.out.println((i + 1) + ". " + buyTicketMenu[i]);
                    }

                    System.out.print("Choose menu: ");
                    int buyTicketMenuIndex = input.nextInt();

                    switch (buyTicketMenuIndex) {
                        case 1 -> {
                            city.showCity();
                            bus.show();
                            System.out.print("Input your name: ");
                            String name = input.next();
                            System.out.print("Input source city name: ");
                            String sourceCityName = input.next();
                            System.out.print("Input destination city name: ");
                            String destinationCityName = input.next();
                            try {
                                bus.dequeue(name);
                                ticket.buyTicket(name, sourceCityName, destinationCityName, "Bus", bus_price);
                            }
                            catch (Exception e) {
                                System.out.println("Your name is not in the queue!");
                            }
                        }
                        case 2 -> {
                            city.showCity();
                            train.show();
                            System.out.print("Input your name: ");
                            String name = input.next();
                            System.out.print("Input source city name: ");
                            String sourceCityName = input.next();
                            System.out.print("Input destination city name: ");
                            String destinationCityName = input.next();

                            try {
                                train.dequeue(name);
                                ticket.buyTicket(name, sourceCityName, destinationCityName, "Train", train_price);
                            }
                            catch (Exception e) {
                                System.out.println("Your name is not in the queue!");
                            }
                        }
                        case 3 -> {
                            city.showCity();
                            plane.show();
                            System.out.print("Input your name: ");
                            String name = input.next();
                            System.out.print("Input source city name: ");
                            String sourceCityName = input.next();
                            System.out.print("Input destination city name: ");
                            String destinationCityName = input.next();

                            try {
                                plane.dequeue(name);
                                ticket.buyTicket(name, sourceCityName, destinationCityName, "Plane", plane_price);
                            }
                            catch (Exception e) {
                                System.out.println("Your name is not in the queue!");
                            }
                        }
                        case 4 -> main(args);
                    }
                }
                case 5 -> {
                    String[] checkSoldTicketMenu = {
                            "Check Bus Ticket",
                            "Check Train Ticket",
                            "Check Plane Ticket",
                            "Back"
                    };

                    for (int i = 0; i < checkSoldTicketMenu.length; i++) {
                        System.out.println((i + 1) + ". " + checkSoldTicketMenu[i]);
                    }

                    System.out.print("Choose menu: ");
                    int checkSoldTicketMenuIndex = input.nextInt();

                    switch (checkSoldTicketMenuIndex) {
                        case 1 -> {
                            ticket_bus.checkSoldTicket();
                        }
                        case 2 -> {
                            ticket_train.checkSoldTicket();
                        }
                        case 3 -> {
                            ticket_plane.checkSoldTicket();
                        }
                        case 4 -> main(args);
                    }
                }
            }
        } while (menuIndex != 6);
    }
}
