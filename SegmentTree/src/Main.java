import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {2, 3, 4, 5, 9, 20};
        SegementTree<Integer> segtree = new SegementTree<>(arr, (a,b) -> a + b);
        segtree.set(2,10);
        System.out.println(segtree.query(0,3));
    }
}
