import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public void test(Map<String,Integer> map1, String file){
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile(file,words);
        System.out.println("Words Size : " + words.size());

        //Collections.sort(words);

        for(String word : words){
            if(!map1.contains(word)){
                map1.add(word,1);
            }else if(map1.contains(word)){
                map1.set(word,map1.get(word)+1);
            }
        }

        System.out.println(" before Words Size : " + map1.getSize());

        long start = System.nanoTime();

        for (String word : words){
            map1.contains(word);
            map1.remove(word);
        }

        long end = System.nanoTime();

        System.out.println(" After Words Size : " + map1.getSize());
        System.out.println("time = " + (end - start) / 1000000000.0);;
    }



    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();
        AVLTree<String,Integer> map1 = new AVLTree<>();
        BSTMap<String,Integer> map2 = new BSTMap<>();
        FileOperation.readFile("/Users/kainingxin/Desktop/life.txt",words);

        Main m = new Main();
        m.test(map1,"/Users/kainingxin/Desktop/life.txt");
        m.test(map2,"/Users/kainingxin/Desktop/life.txt");

    }

}
