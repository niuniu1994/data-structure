import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args){
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        /*
        for(int i = 0;i < 100;i++){
            bst.add(random.nextInt(1000));
        }
        System.out.println(bst);

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!bst.isEmpty()){
            arrayList.add(bst.removeMin());
        }

        System.out.println(arrayList);
         */

        for (int i = 0; i < 10; i++) {
            bst.add(random.nextInt(8));
        }
        System.out.println(bst);
        System.out.println(bst.feuille());
    }
}
