/**
 * @program: lessson
 * @description:
 * @author: xin
 * @create: 2020-02-24 10:11
 **/
public class LinkedLlist2<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            next = null;
        }

        public Node(){
            this(null,null);
        }

        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedLlist2() {
        this.head = null;
        size = 0;
    }

    /*public void add(int index,E e){

        if (index < 0 || index > size){
            throw new IllegalArgumentException();
        }
        if (index == 0){
            Node node = new Node(e,head);
            head = node;
            size++;
        }else {
            Node prev = head;
            for (int i = 1; i < index; i ++){
                prev= prev.next;
            }
            prev.next = new Node(e,prev.next);
            size++;
        }
    }

     */

    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException();
        }
        head = add(index,e,head);
        size++;
    }

    private Node add(int index, E e, Node node){
        if (index == 0){
            return new Node(e,node);
        }else{
         node.next = add(index - 1,e,node.next);
         return node;
        }
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }


    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("index is not correct");

        Node cur = head;
        for (int i = 0; i < index; i ++){
            cur = cur.next;
        }

        return cur.e;
    }

    public void reverse(){
        head = reverse(head);
    }

    private Node reverse(Node node) {
      if (node.next == null || node == null){
          return node;
      }else {
          Node newHead = null;
          newHead = reverse(node.next);
          node.next.next = node;
          node.next = null;
          return newHead;
      }
    }

    public int getSize() {
        return size;
    }
}
