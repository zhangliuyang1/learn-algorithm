package linkedlist.entity;

/**
 * @Author zhangliuyang
 * @Date 2025/8/20
 */
public class LinkNode {
    private int val;
    private LinkNode next;
    private LinkNode pre;

    public LinkNode(int val) {
        this.val = val;
    }

    public LinkNode(int val, LinkNode next) {
        this.val = val;
        this.next = next;
    }

    public LinkNode(int val, LinkNode next, LinkNode pre) {
        this.val = val;
        this.next = next;
        this.pre = pre;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public LinkNode getPre() {
        return pre;
    }

    public void setPre(LinkNode pre) {
        this.pre = pre;
    }
}
