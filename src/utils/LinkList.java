package utils;

import java.util.Objects;

public class LinkList<T> {

    private Node<T> head;
    public void addToEnd(T data){
        Node newNode = new Node(data);

        if (Objects.isNull(head)) {
            head = newNode;
            return;
        }

        Node temp = head;

        while(Objects.nonNull(temp.next)){
            temp = temp.next;
        }

        temp.next =  newNode;
    }

    public void reverseList(){
        //head--> 5 --> 3 --> 1
        //head --> 3 --> 5

        if (Objects.isNull(head)) {
            return;
        }

        Node revereList = new Node(head.data);
        Node temp = head;

        while(Objects.nonNull(temp.next)){
            Node tmp = revereList;
            revereList = new Node(temp.next.data);
            revereList.next = tmp;

            temp = temp.next;
        }

        head = revereList;
    }

    public void print(){
        if (Objects.isNull(head)) {
            return;
        }

        Node temp = head;

        while(Objects.nonNull(temp)){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args){
        LinkList<Integer> dummy = new LinkList<>();
        dummy.addToEnd(5);
        dummy.addToEnd(3);
        dummy.addToEnd(1);
        dummy.print();

        dummy.reverseList();
        dummy.print();
    }

}


class Node<T> {
    T data;

    Node next;

    public Node(T data) {
        this.data = data;
    }
}