package Utilities.Routing;

public class Node {
    public String data;
    Node next;
    Route route;
    public Node(){
        data = null;
        next = null;
        route = null;
    }

    public Node(String data){
        this.data = data;
        next = null;
        route = null;
    }

    public Node(String data, Node next){
        this.data = data;
        this.next = next;
        route = null;
    }

    public Node(String data, Node next, Route route){
        this.data = data;
        this.next = next;
        this.route = route;
    }
}
