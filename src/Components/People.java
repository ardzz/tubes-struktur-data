package Components;

public class People {
    public String name;
    public int queue_number;
    public People next;

    public People(String name, int queue_number){
        this.name = name;
        this.queue_number = queue_number;
        this.next = null;
    }

    public String getName() {
        return this.name;
    }
}
