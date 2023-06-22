package Utilities.Data;

import Components.People;

public class DoubleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public void addLast(People data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
        }
        this.tail = newNode;

        this.size++;
    }

    public void removeByName(String name) {
        Node current = this.head;

        while (current != null) {
            if (current.data.getName().equals(name)) {
                if (current == this.head) {
                    this.head = current.next;
                    this.head.prev = null;
                } else if (current == this.tail) {
                    this.tail = current.prev;
                    this.tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                this.size--;
                break;
            }
            current = current.next;
        }
    }

    public People searchByName(String name) {
        Node current = this.head;

        while (current != null) {
            if (current.data.getName().equals(name)) {
                return current.data;
            }
            current = current.next;
        }

        return null;
    }

    public void print() {
        Node current = this.head;

        while (current != null) {
            System.out.println(current.data.getName());
            current = current.next;
        }
    }
}
