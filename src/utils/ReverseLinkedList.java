package utils;


import java.util.List;

/**
 *
 * Input: 1->2->3->4->5->6->7->8->NULL, K = 5
 * Output: 5->4->3->2->1->8->7->6->NULL
 */
public class ReverseLinkedList {

    /**
     * public static void main(String[] args){
     *     reverseList(head, null, head, 0, k)
     * }
     */
    /**
     *  Input: 1->2->3->4->5->6->7->8->NULL, K = 3
     *  * Output: 3->2->1->6->5->4->8->7->NULL
     *  head --> 1 prev --> 1, curr -> 2 , 1, k = 3, next = 3 , 2-->1--> null
     * public static List reverseList(Node head, Node prev, Node current, int itr, int k){
     * if(head == null){
     *     return;
     * }
     *    if(itr >= k){
     *        head.next = current;
     *        prev.next = null;
     *        return;
     *    }
     *    Node next = current.next;
     *
     *    if(current == head ){
     *        current.next == null;
     *    }else{
     *        current.next = prev;
     *    }
     *
     *    reverseList(head, current, next, itr++, k);
     * }
     */
}
