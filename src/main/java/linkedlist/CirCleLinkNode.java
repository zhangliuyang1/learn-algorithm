package linkedlist;

import linkedlist.entity.LinkNode;

/**
 * @Author zhangliuyang
 * @Date 2025/8/20
 */
public class CirCleLinkNode {
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
        node6.setNext(node2);

//        boolean circle = isCircle(node1);
//        System.out.println(circle);
//        LinkNode entry = detectCircleEntry(node1);
//        System.out.println(entry.getVal());

        printLineNode(circleToSingly(node1));


    }

    public static void printLineNode(LinkNode head) {
        while (head != null) {
            System.out.println(head.getVal());
            head = head.getNext();
        }
    }

    /**
     * 判断链表是否是环形链表
     * 快慢指针
     *
     * @param head
     * @return
     */
    public static boolean isCircle(LinkNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        LinkNode slow = head;
        LinkNode fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 找到链表环的入口节点
     *
     * @param head
     * @return
     */
    public static LinkNode detectCircleEntry(LinkNode head) {
        if (head == null || head.getNext() == null) {
            return null;
        }
        LinkNode slow = head;
        LinkNode fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.getNext();
                    fast = fast.getNext();
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 链表环转换成单链表
     *
     * @param head
     * @return
     */
    public static LinkNode circleToSingly(LinkNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        LinkNode slow = head;
        LinkNode fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                // 有环，找到相遇节点的上个节点
                slow = head;
                while (slow != fast) {
                    slow = slow.getNext();
                    fast = fast.getNext();
                }
                LinkNode pre = fast;
                while (pre.getNext() != fast) {
                    pre = pre.getNext();
                }
                pre.setNext(null);
                break;
            }
        }
        return head;
    }
}
