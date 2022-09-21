package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution {

    String[] list = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    TreeSet<String> set = new TreeSet<>();
    public int uniqueMorseRepresentations(String[] words) {

        for(String word : words){

            StringBuilder res = new StringBuilder();
            for(int i = 0;i < word.length(); i++){
                res.append(list[word.charAt(i) - 'a']);
            }

            set.add(res.toString());
        }
        return set.size();
    }
}
