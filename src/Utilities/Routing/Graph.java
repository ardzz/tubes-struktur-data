package Utilities.Routing;

public class Graph {
    int NodeCount;
    Node firstNode;
    Route firstRoute;

    public Graph(){
        NodeCount = 0;
        firstNode = null;
        firstRoute = null;
    }

    public void addRoute(Node destination, int distance, Node from){
        Route edge = new Route(distance, null, destination);
        if(from.route == null){
            from.route = edge;
        } else {
            Route last = from.route;
            while(last.next != null){
                last = last.next;
            }
            last.next = edge;
        }
    }

    public void removeRouteByString(String RouteName){
        Node node = firstNode;
        if(node != null){
            Node temp = null;
            boolean found = false;
            while(node != null && !found){
                if(node.data.equals(RouteName)){
                    found = true;
                } else {
                    temp = node;
                    node = node.next;
                }
            }
            if(found){
                if(temp == null){
                    firstNode = node.next;
                } else {
                    if(node.next == null){
                        temp.next = null;
                    } else {
                        temp.next = node.next;
                        node.next = null;
                    }
                }
            } else {
                throw new IllegalArgumentException("Node not found");
            }
        } else {
            throw new IllegalArgumentException("Node not found");
        }
    }

    public boolean isRouteExist(Node from, Node to){
        Route route = from.route;
        if(route != null){
            while(route != null){
                if(route.node == to){
                    return true;
                }
                route = route.next;
            }
        }
        return false;
    }

    public int calculateDistanceByString(String from, String to){
       int distance = 0;
       Node start = searchNodeByString(from);
       Node end = searchNodeByString(to);
       Route route = start.route;

       while(route != null){
           if(route.node == end){
               distance = route.distance;
               break;
           }
           route = route.next;
       }
         return distance;
    }

    public void addNode(String data){
        Node node = new Node(data, null,  null);
        if(firstNode == null){
            firstNode = node;
        } else {
            Node last = firstNode;
            while(last.next != null){
                last = last.next;
            }
            last.next = node;
        }
    }

    public void removeNodeByString(String data) {
        Node current = firstNode;
        if (current != null) {
            Node temp = null;
            boolean found = false;
            while (current != null && !found) {
                if (current.data.equals(data)) {
                    found = true;
                } else {
                    temp = current;
                    current = current.next;
                }
            }
            if(found){
                if(temp == null){
                    firstNode = current.next;
                } else {
                    if(current.next == null){
                        temp.next = null;
                    } else {
                        temp.next = current.next;
                        current.next = null;
                    }
                }
            }else{
                throw new IllegalArgumentException("Node not found");
            }
        } else {
            throw new IllegalArgumentException("Node not found");
        }
    }
    public Node searchNodeByString(String data) {
        Node current = firstNode;
        if (current != null) {
            boolean found = false;
            while (current != null && !found) {
                if (current.data.equals(data)) {
                    found = true;
                } else {
                    current = current.next;
                }
            }
            if(found){
                return current;
            }else{
                throw new IllegalArgumentException("Node not found");
            }
        } else {
            throw new IllegalArgumentException("Node not found");
        }
    }

    public int calculateNodeCount(){
        Node current = firstNode;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void printGraph(){
        Node node = firstNode;
        if (node != null) {
            while (node != null) {
                NodeCount++;
                System.out.println("\nNode " + NodeCount + ": " + node.data);
                Route route = node.route;
                if (route != null) {
                    while (route != null) {
                        System.out.println("Route to " + route.node.data + " is " + route.distance);
                        route = route.next;
                    }
                    node = node.next;
                }else{
                    System.out.println("No routes");
                }
            }
        } else {
            throw new IllegalArgumentException("Node not found");
        }
    }
}
