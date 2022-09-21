import java.util.Random;

/**
 * @program: lessson
 * @description: Main
 * @author: xin
 * @create: 2019-11-20 14:54
 **/
public class Main {
    public static void main(String[] args) {
        int var = 30000000;
        AVLTree<Integer,Integer> avlTree = new AVLTree<>();
        RBTree<Integer,Integer> rbTree = new RBTree<>();
        Random ra = new Random();

        long start = System.nanoTime();
        for (int i = 0; i < var; i ++){
            avlTree.add(i,null);
        }
        long end = System.nanoTime();

        double time1 = (end - start)/1000000000.0;
        System.out.println("avl " + time1 + "s");

        long start1 = System.nanoTime();
        for (int i = 0; i < var; i ++){
            rbTree.add(i,null);
        }
        long end1 = System.nanoTime();

        double time2 = (end1 - start1)/1000000000.0;
        System.out.println("Rb " + time2 + "s");

    }
}
