package linkedlist;

import linkedlist.entity.LinkNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author zhangliuyang
 * @Date 2025/8/22
 */
public class Merge {
    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);
        LinkNode node6 = new LinkNode(6);
        LinkNode node7 = new LinkNode(7);


        node1.setNext(node3);
        node3.setNext(node5);
        node5.setNext(node7);

        node2.setNext(node4);
        node4.setNext(node6);

        LinkNode node8 = new LinkNode(3);
        LinkNode node9 = new LinkNode(9);
        LinkNode node10 = new LinkNode(11);

        node8.setNext(node9);
        node9.setNext(node10);

//        LinkNode linkNode = mergeTwo(node1, node2);
//        LinkNode linkNode = mergeThree(node1, node2, node8);
        LinkNode linkNode = mergeThreeWithHeap(node1, node2, node8);
        PrintUtils.printLineNode(linkNode);


    }

    public static LinkNode mergeNLinks(LinkNode... nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        PriorityQueue<LinkNode> heap = new PriorityQueue<>(Comparator.comparingInt(LinkNode::getVal));

        for (LinkNode node : nodes) {
            if (node != null) {
                heap.offer(node);
            }
        }
        if (heap.isEmpty()){
            return null;
        }

        LinkNode dummy = new LinkNode(-1);
        LinkNode curr = dummy;

        while (!heap.isEmpty()) {
            LinkNode poll = heap.poll();
            curr.setNext(poll);
            curr = curr.getNext();
            if (poll.getNext() != null) {
                heap.offer(poll.getNext());
            }
        }

        return dummy.getNext();

    }

    public static LinkNode mergeThreeWithHeap(LinkNode node1, LinkNode node2, LinkNode node3) {
        PriorityQueue<LinkNode> queue = new PriorityQueue<>(Comparator.comparingInt(LinkNode::getVal));
        if (node1 != null) queue.offer(node1);
        if (node2 != null) queue.offer(node2);
        if (node3 != null) queue.offer(node3);
        LinkNode dummy = new LinkNode(-1);
        LinkNode curr = dummy;
        while (!queue.isEmpty()) {
            LinkNode element = queue.poll();
            curr.setNext(element);
            curr = curr.getNext();
            if (element.getNext() != null) {
                queue.offer(element.getNext());
            }
        }

        return dummy.getNext();

    }

    public static LinkNode mergeThree(LinkNode node1, LinkNode node2, LinkNode node3) {
        LinkNode linkNode = mergeTwo(node1, node2);
        return mergeTwo(linkNode, node3);
    }

    public static LinkNode mergeTwo(LinkNode node1, LinkNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        LinkNode dummy = new LinkNode(-1);
        LinkNode curr = dummy;

        while (node1 != null && node2 != null) {
            if (node1.getVal() < node2.getVal()) {
                curr.setNext(node1);
                node1 = node1.getNext();
            } else {
                curr.setNext(node2);
                node2 = node2.getNext();
            }
            curr = curr.getNext();
        }

        if (node1 != null) {
            curr.setNext(node1);
        }
        if (node2 != null) {
            curr.setNext(node2);
        }
        return dummy.getNext();
    }
}
