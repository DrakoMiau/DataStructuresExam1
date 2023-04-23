package punto1;

import java.util.Scanner;

class Node {

    Node next;
    private int data;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int newData) {
        this.data = newData;
    }

    public void setNext(Node newNext) {
        this.next = newNext;
    }

    public Node getNext() {
        return this.next;
    }
}

class OrderedList {

    Node head;
    int size = 0;

    public void insert(int item) {
        Node ptr = head;
        Node prev = null;
        while (ptr != null && ptr.getData() < item) {
            prev = ptr;
            ptr = ptr.next;
        }
        if (ptr == null || ptr.getData() != item) {
            Node newNode = new Node(item);
            newNode.next = ptr;
            if (prev == null) {
                head = newNode;
                size++;
            } else {
                prev.next = newNode;
                size++;
            }
        }
    }

    public void printOrderedList() {
        Node ptr = head;
        while (ptr != null) {
            System.out.println(ptr.getData());
            ptr = ptr.next;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nSkills = scan.nextInt();
        scan.nextLine();
        int admitedPeople = 0;
        String[] skillsNeeded = scan.nextLine().split(" ");
        int nPeople = scan.nextInt();
        scan.nextLine();
        OrderedList[] people = new OrderedList[nPeople]; //notice that each person is an ordered list        
        for (int i = 0; i < nPeople; i++) {
            String[] skillsPerPerson = scan.nextLine().split(" ");
            people[i] = new OrderedList();
            for (int j = 0; j < skillsPerPerson.length; j++) {
                people[i].insert(Integer.parseInt(skillsPerPerson[j]));
            }
        }
        int skillsCounter = 0;
        for (int i = 0; i < people.length; i++) {  //first loop walk through people
            for (int j = 0; j < skillsNeeded.length; j++) { //second loop walk through skills o each person
                Node ptr = people[i].head;
                while (ptr.next != null) {  // third loop compare each skill of each person until find an specifically skill
                    if (ptr.getData() == Integer.parseInt(skillsNeeded[j])) {  
                        break;
                    }
                    ptr = ptr.next;
                }
                if (ptr.getData() == Integer.parseInt(skillsNeeded[j])) {
                        skillsCounter++;
                    }
            }
            if (skillsCounter >= nSkills) {
                admitedPeople++;
            }
            skillsCounter = 0;
        }
        System.out.println(admitedPeople);
    }
}
