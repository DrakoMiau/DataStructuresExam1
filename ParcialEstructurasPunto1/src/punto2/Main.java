package punto2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nCases, nProductsAmount, nProducts;
        nCases = scan.nextInt(); //insert the number of cases
        scan.nextLine();
        LinkedList[] productList = new LinkedList[nCases];
        for (int i = 0; i < nCases; i++) {
            nProductsAmount = scan.nextInt(); //insert the amount of products
            scan.nextLine();
            String[] myArr = scan.nextLine().split(" ");
            productList[i] = new LinkedList();
            for (int j = 0; j < nProductsAmount; j++) {
                productList[i].insert(myArr[j]);
            }
            nProducts = scan.nextInt();
            scan.nextLine();
            String[] myArr2 = scan.nextLine().split(" ");
            for (int j = 0; j < myArr2.length; j++) {
                String storeProducts = "";
                System.out.print("[");
                for (int k = 0; k < Integer.parseInt(myArr2[j]); k++) {
                    try {
                        storeProducts = storeProducts + productList[i].popFront().getData() + " ";
                    } catch (Exception e) {
                    }
                }
                System.out.print(storeProducts.trim());
                if (j != myArr2.length-1 || i != nCases - 1) {
                    System.out.println("]");
                } else{
                System.out.print("]");
                }
            }
        }
    }
}

class Node {

    private Node next;
    private Node back;

    private String data;
    //Methods

    //Constructors
    public Node(String newData) {
        data = newData;
    }

    //Getters and Setters
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getBack() {
        return back;
    }

    public void setBack(Node back) {
        this.back = back;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

class LinkedList {

    Node head;
    Node queue;
    int size = 0;

    public void insert(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            queue = head;
        } else {
            Node prev = null;
            Node temp = head;
            while (temp.getNext() != null) {
                prev = temp;
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            if (temp.getBack() == null) {
                prev = temp;
            }
            temp.getNext().setBack(temp);
            queue = temp.getNext();

        }
        size++;

    }

    public void printList() {
        Node start = head;
        while (start != null) {
            System.out.print(start.getData() + " ");
            if (start == queue) {
                System.out.println("\n");
            }
            start = start.getNext();
        }
    }

    public Node popFront() {
        Node ptr = head;
        head = head.getNext();
        return ptr;
    }
}
