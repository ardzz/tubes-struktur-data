package Utilities.Routing;

public class Route {
    int distance;
    Route next;
    Node node;

    public Route(){
        distance = 0;
        next = null;
        node = null;
    }

    public Route(int distance){
        this.distance = distance;
        next = null;
        node = null;
    }

    public Route(int distance, Route next){
        this.distance = distance;
        this.next = next;
        node = null;
    }

    public Route(int distance, Route next, Node node){
        this.distance = distance;
        this.next = next;
        this.node = node;
    }
}
