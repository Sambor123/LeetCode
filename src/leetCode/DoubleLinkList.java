package leetCode;

public class DoubleLinkList {
	
	private int size;
	private Node head;
	private Node tail;
	
	public DoubleLinkList(int size, Node head, Node tail) {
		super();
		this.size = size;
		this.head = head;
		this.tail = tail;
	}
	
	//节点类
	private static class Node{
		Node perv;  //前节点
		Node next;  //后节点
		int data;    //数据
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public Node getTail() {
		return tail;
	}
	public void setTail(Node tail) {
		this.tail = tail;
	}
}
