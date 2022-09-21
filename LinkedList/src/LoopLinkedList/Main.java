package LoopLinkedList;

public class Main {
    public static void main(String[] args){
        LoopLinkedList<Integer> loopLinkedList = new LoopLinkedList<Integer>();

        for (int i = 0;i < 6;i++){
            loopLinkedList.addLast(i);
        }

        loopLinkedList.add(10,4);
        System.out.println(loopLinkedList.remove(2));
        System.out.println(loopLinkedList);
    }
}
