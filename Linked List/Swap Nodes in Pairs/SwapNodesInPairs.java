package linkedlist.problems;

import linkedlist.LinkedList;
import linkedlist.ListNode;
import utils.Reader;
import utils.Helper;
import java.io.IOException;

public class SwapNodesInPairs {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int[] arr = Helper.getIntArray(n, reader);

        LinkedList linkedlist = new LinkedList();
        for (int i=0; i<n; i++) {
            System.out.println("Added Node: " + arr[i]);
            linkedlist.addNode(arr[i]);
        }

        SwapNodesInPairs obj = new SwapNodesInPairs();
        ListNode modHead = obj.swapPairs(linkedlist.getHead());

        linkedlist.setHead(modHead);
        linkedlist.traverse();
    }

    public ListNode swapPairs(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode headNode = head;

        while (cur != null && cur.getNext() != null) {
            System.out.println("Swapping nodes");
            ListNode swapNode1 = cur;
            ListNode swapNode2 = cur.getNext();
            swapNode1.addNext(swapNode2.getNext());
            swapNode2.addNext(swapNode1);
            if (prev != null) {
                prev.addNext(swapNode2);
            } else {
                headNode = swapNode2;
            }
            prev = swapNode1;
            cur = swapNode1.getNext();
        }

        return headNode;
    }
}