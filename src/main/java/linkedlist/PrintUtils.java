package linkedlist;

import linkedlist.entity.LinkNode;

/**
 * @Author zhangliuyang
 * @Date 2025/8/22
 */
public class PrintUtils {
    public static void printLineNode(LinkNode head) {
        while (head != null) {
            System.out.println(head.getVal());
            head = head.getNext();
        }
    }
}
