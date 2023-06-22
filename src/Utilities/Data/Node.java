package Utilities.Data;

import Components.People;

public class Node {
    protected People data;
    protected Node next;
    protected Node prev;

    public Node(People data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public People getData() {
        return this.data;
    }
}
