import Manager.Queue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue bus = new Queue("Bus");
        Queue train = new Queue("Train");
        Queue plane = new Queue("Plane");

        Scanner input = new Scanner(System.in);
        int menuIndex = 0;
        while(menuIndex != 4) {
            String[] menu = {
                "Bus",
                "Train",
                "Plane",
                "Exit"
            };

            for(int i = 0; i < menu.length; i++) {
                System.out.println((i+1) + ". " + menu[i]);
            }

            System.out.print("Choose menu: ");
            menuIndex = input.nextInt();

            switch(menuIndex) {
                case 1:
                    bus.showMenu();
                    break;
                case 2:
                    train.showMenu();
                    break;
                case 3:
                    plane.showMenu();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Menu not found.");
                    break;
            }
        }
    }
}
