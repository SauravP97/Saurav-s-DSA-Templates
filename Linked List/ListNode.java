package linkedlist;

public class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public void addNext(ListNode nextNode) {
        this.next = nextNode;
    }

    public ListNode getNext() {
        return this.next;
    }

    public int getValue() {
        return this.value;
    }
}