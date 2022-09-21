import java.util.ArrayList;

public class Main  {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("/Users/kainingxin/Desktop/imooc-/lo.txt",words);
        System.out.println("words size : " + words.size());

        LinkedListSet<String> bsTset = new LinkedListSet<>();
        for(String s : words){
            bsTset.add(s);
        }
        System.out.println(bsTset.getSize());

    }
}
