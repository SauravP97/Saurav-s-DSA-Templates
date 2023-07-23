package linkedlist;

import linkedlist.ListNode;

public class LinkedList {
    private static ListNode head;
    private ListNode currentNode;

    public ListNode getHead() {
        return this.head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public ListNode addNode(int value) {
        if (this.head == null) {
            this.head = new ListNode(value);
            this.currentNode = this.head;
        } else {
            ListNode tempNode = new ListNode(value);
            this.currentNode.addNext(tempNode);
            this.currentNode = tempNode;
        }
        return this.currentNode;
    }

    public void traverse() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.println("Node: " + cur.getValue());
            cur = cur.getNext();
        }
    }
}