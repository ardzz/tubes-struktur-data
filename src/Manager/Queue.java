package Manager;

public class Queue extends AbstractManager implements InterfaceManager{

    protected Utilities.Queue queue;
    public Queue(String object_name) {
        super(object_name);
        queue = new Utilities.Queue();
    }

    @Override
    public void showMenu() {
        String[] menu = {
            "Book a queue",
            "Show queue",
            "Cancel queue",
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
                book();
                break;
            case 2:
                show();
                break;
            case 3:
                cancel();
                break;
            case 4:
                break;
            default:
                System.out.println("Menu not found.");
                break;
        }

    }

    public void book(){
        System.out.print("Input your name: ");
        String name = input.next();
        queue.enqueue(name);
        System.out.println("Successfully booked.");
    }

    public void show(){
        queue.show();
    }

    public void cancel(){
        System.out.print("Input your name: ");
        String name = input.next();
        queue.dequeueByString(name);
    }

    public void queueByList(String[] names){
        queue.enqueueByList(names);
    }

    public void dequeue(String name){
        queue.dequeueByString(name);
    }
}
