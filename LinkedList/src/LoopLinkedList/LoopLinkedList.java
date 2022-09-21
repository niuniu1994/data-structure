package LoopLinkedList;



public class LoopLinkedList<E> {
    private class Node{
        E val;
        Node next,pre;

        public Node(Node next,Node pre,E val){
            this.val = val;
            this.next = next;
            this.pre = pre;
        }

        public Node(E val){
            this.val = val;
            next = pre = null;
        }

        public Node(){
            this(null,null,null);
        }

        public String toString(){
            return val.toString();
        }
    }

    public Node dummyhead;
    int size;

    public LoopLinkedList(){
        dummyhead = new Node(null,null,null);
        dummyhead.pre = dummyhead.next = dummyhead;//在此处构造会更加方便，这样就不用在每个方法中讨论index=0 && size = 0的特殊情况；
        size = 0;
    }

   /* public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("the number of index is not correct");

        Node head = dummyhead;

        if(index == 0 && size ==0) {
            head.pre = head.next = new Node(head, head, e);
        }else {
            for (int i = 0; i < index; i++) {
                head = head.next;
            }
            Node newNode = new Node(head.next, head, e);
            head.next = newNode;
            newNode.next.pre = newNode;
        }
        size++;
    }*/

    public void add(E e, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException(
                    String.format("add failed; index illegal. SIZE=%d, INDEX=%d", size, index));

        Node prevNode = dummyhead;
        if (index > size / 2) {
            // 大于一半的长度,从dummyHead向前搜索(.prev), 要多搜索一位才能到达前驱节点
            for (int i = 0; i <= size - index; i ++)
                prevNode = prevNode.pre;
        } else {
            // 小等于一半长度,从dummyHead向后搜索,不用多搜索一位
            for (int i = 0; i < index; i ++)
                prevNode = prevNode.next;
        }
        Node newNode = new Node(prevNode.next,prevNode,e);
        prevNode.next = newNode;
        newNode.next.pre = newNode;
        size ++;
    }


    public void addFirst(E e){
        add(e,0);
    }

    public void addLast(E e){
       add(e,size);
    }

    public E remove(int index){
        if (index < 0 || index > size)
        throw new IllegalArgumentException(
                String.format("add failed; index illegal. SIZE=%d, INDEX=%d", size, index));

        Node rem = dummyhead;
        if(index <= size / 2){
            for(int i = 0; i < index; i++)
                rem = rem.next;
        }else {
            for(int i = 0; i <= size - index; i++)
                rem = rem.pre;
        }

        Node goal = rem.next;
        rem.next = goal.next;
        goal.next.pre = rem;
        size--;
        return goal.val;
    }


    public  String toString(){
        StringBuilder res = new StringBuilder();
        res.append("LoopLinkedList : ");
        Node ret = dummyhead;
        for(int i =0; i <= size +2; i++){
            res.append(ret.val + "->");
            ret = ret.next;
        }
        return res.toString();
    }
}
