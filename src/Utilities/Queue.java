package Utilities;

import Components.People;

public class Queue {

    private People first, last;
    private int next_queue_number;

    public Queue() {
        this.first = this.last = null;
        this.next_queue_number = 1;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void enqueue(String name) {
        People people = new People(name, next_queue_number);
        next_queue_number++;

        if (isEmpty()) {
            first = last = people;
        } else {
            last.next = people;
            last = people;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            String name = first.name;
            int queue_number = first.queue_number;
            first = first.next;

            if (first == null) {
                last = null;
            }

            System.out.println(name + " (Queue Number: " + queue_number + ") successfully dequeued.");
        }
    }

    public void dequeueByString(String name){
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            People current = first;
            People temp = null;
            boolean found = false;

            while (current != null && !found) {
                if (current.name.equals(name)) {
                    found = true;
                } else {
                    temp = current;
                    current = current.next;
                }
            }

            if (found) {
                if (temp == null) {
                    first = current.next;
                } else {
                    if (current.next == null) {
                        temp.next = null;
                    } else {
                        temp.next = current.next;
                        current.next = null;
                    }
                }

                System.out.println(name + " successfully dequeued.");
            } else {
                System.out.println("Name not found.");
            }
        }
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            People current = first;

            System.out.println("Queue List:");
            while (current != null) {
                System.out.println(current.name + " (Queue Number: " + current.queue_number + ")");
                current = current.next;
            }
        }
    }

    public void enqueueByList(String[] names) {
        for (String name : names) {
            enqueue(name);
        }
    }
}