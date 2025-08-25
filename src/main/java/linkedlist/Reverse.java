package linkedlist;

import linkedlist.entity.LinkNode;

/**
 * @Author zhangliuyang
 * @Date 2025/8/25
 */
public class Reverse {

    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);
        LinkNode node6 = new LinkNode(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
//        PrintUtils.printLineNode(node1);
//        LinkNode reverse = reverse(node1);
        LinkNode reverse = reverseWithRecursive(node1);
        PrintUtils.printLineNode(reverse);
    }


    public static LinkNode reverse(LinkNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        LinkNode pre = null;
        LinkNode curr = head;

        while (curr != null) {
            LinkNode next = curr.getNext();
            curr.setNext(pre);
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static LinkNode reverseWithRecursive(LinkNode head){
        if (head == null ||head.getNext() == null){
            return head;
        }

        LinkNode newHead = reverseWithRecursive(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }
}
